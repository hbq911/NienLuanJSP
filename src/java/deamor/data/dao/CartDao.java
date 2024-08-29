/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package deamor.data.dao;

import deamor.model.Cart;
import java.io.InputStream;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface CartDao {
    public List<Cart> FindAll(int IDuser);
    public void insertCart(InputStream is, int IDproduct, String Image, String Name, double Price, int Quantity, double total, int IDuser);
    public void updateCart(int IDuser, int IDproduct, int Quantity);
    public void deleteCart(int IDuser, int IDproduct);
    public boolean checkCartExist(int idUser, int idProduct);
}
