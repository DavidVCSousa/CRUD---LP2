package com.commons.Util.Other;

import com.business.Client;
import com.business.Order;
import com.business.OrderItem;
import com.business.Product;
import com.business.Users.Manager;
import com.business.Users.Salesman;
import com.business.Users.UserBase;
import com.commons.enums.FilePath;
import com.dao.ClientDAO;
import com.dao.OrderDAO;
import com.dao.ProductDAO;
import com.dao.UserDAO;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Builder {
    
    static public void Build() throws IOException {
        try {
            File directory = new File(System.getProperty("user.dir") + "\\Texts\\");
            File User = new File(FilePath.User.getPath());
            File Products = new File(FilePath.Product.getPath());
            File Orders = new File(FilePath.Order.getPath());
            File Clients = new File(FilePath.Client.getPath());
            File log = new File(FilePath.Log.getPath());


            if (!directory.exists()) {
                directory.mkdir();
            }
            if (!User.exists()) {

                User.createNewFile();
            }
            if (!Products.exists()) {

                Products.createNewFile();
            }
            if (!Orders.exists()) {

                Orders.createNewFile();
            }
            if (!Clients.exists()) {

                Clients.createNewFile();
            }
            if (!log.exists()) {

                log.createNewFile();
            }
            UserDAO.LoadUsers();
            ClientDAO.LoadClients();
            ProductDAO.LoadProducts();
            OrderDAO.LoadOrders();

            if(UserDAO.users.size() == 0) {

                UserDAO.users.add(new Manager("MASTER","MASTER","MASTER"));
                UserDAO.users.add(new Salesman("SALESMAN","SALESMAN","SALESMAN"));
                ClientDAO.Clients.add(new Client("0","CLIENT"));
                ProductDAO.products.add(new Product("PRODUTO",100,"PRODUTO"));
                ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();
                orderItems.add(new OrderItem("PRODUTO",5));
                OrderDAO.Orders.add(new Order(orderItems,"0","cd"));
                SaveStatus();
            }
        }catch (IOException ex) {
            UserDAO.users.add(new Manager("MASTER","MASTER","MASTER"));
            UserDAO.users.add(new Salesman("SALESMAN","SALESMAN","SALESMAN"));
            ClientDAO.Clients.add(new Client("0","CLIENT"));
            ProductDAO.products.add(new Product("PRODUTO",100,"PRODUTO"));
            ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();
            orderItems.add(new OrderItem("PRODUTO",5));
            OrderDAO.Orders.add(new Order(orderItems,"0","cd"));
            SaveStatus();
        }
    }


    static public void  SaveStatus() throws IOException {
        SaveAllUsers();
        SaveAllProducts();
        SaveAllOrders();
        SaveAllClients();
    }

    static public  void SaveAllUsers() throws IOException {
        List<String> ls = new LinkedList<>();
        for (UserBase c:
                UserDAO.users ) {
            ls.add(c.ToJson().toString());
        }
        WriteFile(FilePath.User.getPath(),ls);
    }
    static public  void SaveAllOrders() throws IOException {
        List<String> ls = new LinkedList<>();
        for (Order c:
                OrderDAO.Orders ) {
            ls.add(c.ToJson().toString());
        }
        WriteFile(FilePath.Order.getPath(),ls);
    }
    static public  void SaveAllClients() throws IOException {
        List<String> ls = new LinkedList<>();
        for (Client c:
                ClientDAO.Clients ) {
            ls.add(c.ToJson().toString());
        }
        WriteFile(FilePath.Client.getPath(),ls);
    }
    static public  void SaveAllProducts() throws IOException {
        List<String> ls = new LinkedList<>();
        for (Product c:
                ProductDAO.products ) {
            ls.add(c.ToJson().toString());
        }
        WriteFile(FilePath.Product.getPath(),ls);
    }

    private static void WriteFile(String path,List ls) throws IOException {

        File fout = new File(path);
        FileOutputStream fos = new FileOutputStream(fout);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

        for (int i = 0; i < ls.size(); i++) {
            bw.write(ls.get(i).toString());
            bw.newLine();
        }

        bw.close();
    }




    
    
}
