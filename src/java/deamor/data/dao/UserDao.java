/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package deamor.data.dao;

import deamor.model.user;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface UserDao {
    public List<user> FinAll();
    public user findUser(String emailphone);
    public user findUser(String emailphone ,String password);
    public void insertUser(String name, String email, String phone, String password);
    
}
