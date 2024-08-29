/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deamor.model;

/**
 *
 * @author ADMIN
 */
public class Cart {
    int ID;
    int IDproduct;
    String Image;
    String Name;
    double Price;
    int Quantity;
    double total;
    int Status;
    int IDuser;

    public Cart() {
    }

    public Cart(int ID, int IDproduct, String Image, String Name, double Price, int Quantity, double total, int Status, int IDuser) {
        this.ID = ID;
        this.IDproduct = IDproduct;
        this.Image = Image;
        this.Name = Name;
        this.Price = Price;
        this.Quantity = Quantity;
        this.total = total;
        this.Status = Status;
        this.IDuser = IDuser;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getIDproduct() {
        return IDproduct;
    }

    public void setIDproduct(int IDproduct) {
        this.IDproduct = IDproduct;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public int getQUanttity() {
        return Quantity;
    }

    public void setQUanttity(int QUanttity) {
        this.Quantity = Quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public int getIDuser() {
        return IDuser;
    }

    public void setIDuser(int IDuser) {
        this.IDuser = IDuser;
    }
    
    
    
    
}
