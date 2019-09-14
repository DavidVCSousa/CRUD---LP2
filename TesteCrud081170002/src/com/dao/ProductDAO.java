package com.dao;

import com.business.Product;
import com.commons.Util.Json.JSONObject;
import com.commons.enums.FilePath;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ProductDAO {

    public static List<Product> products    = new LinkedList<Product>();



    public static void LoadProducts() {
        try {
            FileManager manager = new FileManager();
            products = new LinkedList<Product>();
            String[] allProducts = manager.readLines(FilePath.Product.getPath());
            for (String s : allProducts) {
                
                var json = new JSONObject(s);
                products.add(new Product(json.getString("Identifier"),json.getDouble("Price"),json.getString("Name")));
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
    
    public void registerProduct(Product product) throws IOException {
        FileManager manager = new FileManager();
        manager.writeFile(
                FilePath.Product.getPath(),
                product.ToJson().toString()
        );
        System.out.println("Product successfully saved!");
    }

    public boolean idfyIsAlreadyRegistered(String idtfy) throws IOException {

        return FindProduct(idtfy) == null;
    }

    public  static Product FindProduct(String Product){
        for (com.business.Product u: products) {
            if(u.getIdentifier().equals(Product)){
                return u;
            }
        }
        return  null;
    }

}
