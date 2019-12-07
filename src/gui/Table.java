package gui;

import model.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;


public class Table extends JPanel{

    private JTable table;
    private ClientTableModel tableModel;
    private JPopupMenu popup;
    private ClientTableListener clientTableListener;

    public Table(){
        tableModel = new ClientTableModel();
        table = new JTable(tableModel);
        popup = new JPopupMenu();

        JMenuItem remove = new JMenuItem("Delete");
        popup.add(remove);

        table.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {

                int row = table.rowAtPoint(e.getPoint());

                table.getSelectionModel().setSelectionInterval(row, row);

                System.out.println(row);
              if (e.getButton() == MouseEvent.BUTTON3){
                  popup.show(table, e.getX(), e.getY());
              }
            }
        });

        remove.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
               int row = table.getSelectedRow();

               if (clientTableListener != null){
                   clientTableListener.rowDeleted(row);
                   tableModel.fireTableRowsDeleted(row, row);
               }
            }
        });

        setLayout(new BorderLayout());

        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public void setData(List<Client> db){
        tableModel.setData(db);
    }

    public void refresh(){
        tableModel.fireTableDataChanged();
    }

    public void setClientTableListener(ClientTableListener listener){
        this.clientTableListener = listener;
    }
}
