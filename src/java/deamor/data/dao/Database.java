/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deamor.data.dao;

import deamor.data.dao.implement.CartImpl;
import deamor.data.dao.implement.CategoryImpl;

import deamor.data.dao.implement.ProductImpl;
import deamor.data.dao.implement.UserImpl;

/**
 *
 * @author ADMIN
 */
public class Database {
    public static CategoryDao getCategoryDao(){
    return new CategoryImpl();
    }
    
    public static ProductDao getProductDao(){
    return new ProductImpl();
    }
    
    public static UserDao getUserDao(){
    return new UserImpl();
    }
    
    
    public static CartDao getCartDao(){
    return new CartImpl();
    }
    
    
}
