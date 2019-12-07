package gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class FormPanel extends JPanel {

    private JLabel fullName;
    private JLabel brend;
    private JLabel phone;
    private JLabel dateIn;
    private JLabel price;
    private JLabel dateOut;
    private JTextField fullNameField;
    private JTextField brendField;
    private JTextField phoneField;
    private JTextField dateInField;
    private JTextField priceField;
    private JTextField dateOutField;
    private FormListener formListener;
    private JButton okBtn;

    public FormPanel(){
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);

        fullName = new JLabel("Full Name: ");
        brend = new JLabel("Brend: ");
        phone = new JLabel("Phone: ");
        dateIn = new JLabel("Date In: ");
        price = new JLabel("Price: ");
        dateOut = new JLabel("Date Out: ");
        fullNameField = new JTextField(10);
        brendField = new JTextField(10);
        phoneField = new JTextField(10);
        dateInField = new JTextField(10);
        priceField = new JTextField(10);
        dateOutField = new JTextField(10);
        okBtn = new JButton("Save");

        //set up mnemomics
        okBtn.setMnemonic(KeyEvent.VK_S);

        okBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fullName = fullNameField.getText();
                String brend = brendField.getText();
                String phone = phoneField.getText();
                String dateIn = dateInField.getText();
                String price = priceField.getText();
                String dateOut = dateOutField.getText();

                FormEvent ev = new FormEvent(this, fullName, brend, phone, dateIn, price, dateOut);

                if (formListener != null){
                    formListener.formEventOccurred(ev);
                }
            }
        });

        Border innerBorder = BorderFactory.createTitledBorder("Add Clients");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        //first row
        gc.weightx = 0;
        gc.weighty = 0.3;

        gc.gridx = 0;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 10);
        add(fullName, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(fullNameField, gc);

        //second row
        gc.weightx = 1;
        gc.weighty = 0.3;

        gc.gridy = 1;
        gc.gridx = 0;
        gc.insets = new Insets(0, 0, 0, 10);
        gc.anchor = GridBagConstraints.LINE_END;
        add(brend, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(brendField, gc);

        //three row
        gc.weightx = 1;
        gc.weighty = 0.3;

        gc.gridy = 2;
        gc.gridx = 0;
        gc.insets = new Insets(0, 0, 0, 10);
        gc.anchor = GridBagConstraints.LINE_END;
        add(phone, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(phoneField, gc);

        //four row
        gc.weightx = 1;
        gc.weighty = 0.3;

        gc.gridy = 3;
        gc.gridx = 0;
        gc.insets = new Insets(0, 0, 0, 10);
        gc.anchor = GridBagConstraints.LINE_END;
        add(price, gc);

        gc.gridx = 1;
        gc.gridy = 3;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(priceField, gc);

        //five row
        gc.weightx = 1;
        gc.weighty = 0.3;

        gc.gridy = 4;
        gc.gridx = 0;
        gc.insets = new Insets(0, 0, 0, 10);
        gc.anchor = GridBagConstraints.LINE_END;
        add(dateIn, gc);

        gc.gridx = 1;
        gc.gridy = 4;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(dateInField, gc);

        //six row
        gc.weightx = 1;
        gc.weighty = 0.3;

        gc.gridy = 5;
        gc.gridx = 0;
        gc.insets = new Insets(0, 0, 0, 10);
        gc.anchor = GridBagConstraints.LINE_END;
        add(dateOut, gc);

        gc.gridx = 1;
        gc.gridy = 5;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(dateOutField, gc);

        //last row
        gc.weightx = 1;
        gc.weighty = 2.0;

        gc.gridy = 6;
        gc.gridx = 1;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(okBtn, gc);
    }

    public void setFormListener(FormListener listener){
        this.formListener = listener;
    }
}