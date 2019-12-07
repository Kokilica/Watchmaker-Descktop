package model;

import java.io.*;
import java.util.*;

public class Database {

    private List<Client> clients;

    public Database(){
        clients = new LinkedList<Client>();
    }

    public void addClient(Client client){
        clients.add(client);
    }

    public void removeClient(int index){
        clients.remove(index);
    }

    public List<Client> getClient(){
        return Collections.unmodifiableList(clients);
    }

    public void sateToFile(File file) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        Client[] people = clients.toArray(new Client[clients.size()]);

        oos.writeObject(people);

        oos.close();
    }

    public void loadFromFile(File file) throws IOException{
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        try {
            Client[] people = (Client[]) ois.readObject();

            clients.clear();

            clients.addAll(Arrays.asList(people));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ois.close();
    }
}
