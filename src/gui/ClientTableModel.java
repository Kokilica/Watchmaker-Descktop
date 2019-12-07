package gui;

import model.Client;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ClientTableModel extends AbstractTableModel {

    private List<Client> db;

    private String[] colNames = {"ID", "FULLNAME", "BREND", "PHONE", "PRICE", "DATE IN", "DATE OUT"};

    public ClientTableModel(){
    }

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    public void setData(List<Client> db){
        this.db = db;
    }
    @Override
    public int getRowCount() {
        return db.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int row, int col) {
       Client client = db.get(row);

       switch (col){
           case 0:
               return client.getId();
           case 1:
               return client.getFullName();
           case 2:
               return client.getPhone();
           case 3:
               return client.getBrend();
           case 4:
               return client.getPrice();
           case 5:
               return client.getDateIn();
           case 6:
               return client.getDateOut();
       }
       return null;
    }
}
