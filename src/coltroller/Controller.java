package coltroller;

import gui.FormEvent;
import model.Client;
import model.Database;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Controller {
    Database db = new Database();

    public List<Client> getClient(){
       return db.getClient();
    }

    public void removeClient(int index){
        db.removeClient(index);
    }

    public void addClient(FormEvent e){
        String fullName = e.getFullName();
        String brend = e.getBrend();
        String phone = e.getPhone();
        String dateIn = e.getDateIn();
        String price = e.getPrice();
        String dateOut = e.getDateOut();

        Client client = new Client(fullName, brend, phone, dateIn, price, dateOut);

        db.addClient(client);
    }

    public void sateToFile(File file) throws IOException {
        db.sateToFile(file);
    }

    public void loadFromFile(File file) throws IOException {
        db.loadFromFile(file);
    }
}
