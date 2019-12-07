package gui;

import coltroller.Controller;

import javax.security.auth.kerberos.KerberosTicket;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class MainFrame extends JFrame {

    //components
    private TextPanel textPanel;
    private FormPanel formPanel;
    private JFileChooser fileChooser;
    private Controller controller;
    private Table table;

    public MainFrame(){
        super("Watchmaker");

        setLayout(new BorderLayout());

        //build object
        textPanel = new TextPanel();
        formPanel = new FormPanel();
        table = new Table();

        controller = new Controller();

        table.setData(controller.getClient());

        table.setClientTableListener(new ClientTableListener(){
           public void rowDeleted(int row){
                controller.removeClient(row);
            }
        });

        fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(new ClientFileFilter());

        setJMenuBar(createMenuBar());

        formPanel.setFormListener(new FormListener(){
            public void formEventOccurred(FormEvent e){
               controller.addClient(e);
               table.refresh();
            }
        });

        //add components on board
        add(formPanel, BorderLayout.WEST);
        add(table, BorderLayout.CENTER);

        //size of board
        setMinimumSize(new Dimension(1000, 400));
        setSize(1500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JMenuBar createMenuBar(){
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem saveData = new JMenuItem("Save...");
        JMenuItem loadData = new JMenuItem("Load...");
        JMenuItem exit = new JMenuItem("Exit");

        fileMenu.add(saveData);
        fileMenu.add(loadData);
        fileMenu.addSeparator();
        fileMenu.add(exit);

        menuBar.add(fileMenu);

        fileMenu.setMnemonic(KeyEvent.VK_F);
        saveData.setMnemonic(KeyEvent.VK_S);
        loadData.setMnemonic(KeyEvent.VK_L);
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));

        loadData.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));

         loadData.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {

                if (fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION){
                    try {
                        controller.loadFromFile(fileChooser.getSelectedFile());
                        table.refresh();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(MainFrame.this,
                                "Could not load data from file", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        saveData.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {

                if (fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION){
                    try {
                        controller.sateToFile(fileChooser.getSelectedFile());
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(MainFrame.this,
                                "Could not save data to file", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int action = JOptionPane.showConfirmDialog(MainFrame.this,
                        "Did you save your file?",
                        "Confirm Exit", JOptionPane.OK_CANCEL_OPTION);

                if (action == JOptionPane.OK_OPTION){
                    System.exit(0);
                }
            }
        });

        return menuBar;
    }
}
