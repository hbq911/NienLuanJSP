/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package deamor.data.dao;

import deamor.model.Product;
import java.io.InputStream;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface ProductDao {
    
    public List<Product> FinAll();
    public void insertProduct(InputStream is,String id_category,String name,String image,String price,String quantity) ;
    public Product getProductByName(String name);
    public Product findProduct(int id_product);
    public boolean deleteProductById(int id);
    public void updateProduct(InputStream is, String id, String id_category, String name, String price, String quantity);
    
    
}
