package gui;

import java.util.EventObject;

public class FormEvent extends EventObject {

    private String fullName;
    private String brend;
    private String phone;
    private String dateIn;
    private String price;
    private String dateOut;

    public FormEvent(Object source){
        super(source);
    }

    public FormEvent(Object source, String fullName, String brend, String phone,
                     String dateIn, String price, String dateOut) {
        super(source);

        this.fullName = fullName;
        this.brend = brend;
        this.phone = phone;
        this.dateIn = dateIn;
        this.price = price;
        this.dateOut = dateOut;
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
