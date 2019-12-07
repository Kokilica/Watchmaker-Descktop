package model;

import java.io.Serializable;

public class Client implements Serializable {

    private static final long serialVersionUID = -8219218627533074108L;

    private static int count = 0;

    private int id;
    private String fullName;
    private String brend;
    private String phone;
    private String dateIn;
    private String price;
    private String dateOut;

    public Client(String fullName, String brend, String phone, String dateIn, String price, String dateOut) {
        this.fullName = fullName;
        this.brend = brend;
        this.phone = phone;
        this.dateIn = dateIn;
        this.price = price;
        this.dateOut = dateOut;

        this.id = count;
        count++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBrend() {
        return brend;
    }

    public void setBrend(String brend) {
        this.brend = brend;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDateIn() {
        return dateIn;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDateOut() {
        return dateOut;
    }

    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }
}
