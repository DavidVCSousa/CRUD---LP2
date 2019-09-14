package com.dao;

import com.business.Order;
import com.business.OrderItem;
import com.commons.Util.Json.JSONObject;
import com.commons.enums.FilePath;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class OrderDAO {
    public static List<Order> Orders    = new LinkedList<Order>();
    public static void LoadOrders() {
        try {
            FileManager manager = new FileManager();
            Orders = new LinkedList<Order>();
            String[] allClients = manager.readLines(FilePath.Order.getPath());
            ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();
            for (String s : allClients) {

                var json = new JSONObject(s);
                for (Object p:
                        json.getJSONArray("Products")) {

                    var obj = new JSONObject(p.toString());

                    orderItems.add( new OrderItem( obj.getString("id"), obj.getInt("qtd")));
                }


                Orders.add(new Order(orderItems,json.getString("Customer"),json.getString("Key")));
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void registerOrder(Order order) throws IOException {
        FileManager actions = new FileManager();
        actions.writeFile(
                FilePath.Order.getPath(),
                order.ToJson().toString()
        );
        System.out.println("Order successfully saved!");
    }

    public  static Order FindOrder(String Product){
        for (Order u: Orders) {
            if(u.getKey().equals(Product)){
                return u;
            }
        }
        return  null;
    }
}
