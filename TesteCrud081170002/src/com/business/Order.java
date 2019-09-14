package com.business;

import com.commons.Util.Json.JSONArray;
import com.commons.Util.Json.JSONObject;
import com.commons.enums.Types;
import com.dao.OrderDAO;

import java.io.IOException;
import java.util.ArrayList;

public class Order extends RegistrableObject {

    private ArrayList<OrderItem> products;
    private String customerCpf;
    private  String Key;

    public String getKey() {
        return Key;
    }

    public Order(ArrayList<OrderItem> products, String customerCpf, String key) {
        if(products.isEmpty() || customerCpf.isEmpty()||key.isEmpty())
            throw new IllegalArgumentException();
        this.products = products;
        this.customerCpf = customerCpf;
        this.Key = key;
    }

    @Override
    public void register(RegistrableObject obj) throws IOException {
        OrderDAO repository = new OrderDAO();
        repository.registerOrder((Order) obj);
    }

    @Override
    public Types Type() {
        return Types.Order;
    }

    @Override
    public JSONObject ToJson() {
        JSONObject obj =  new JSONObject();
        obj.put("Type",Type().getTypeName());
        JSONArray jsonArray = new JSONArray();
        for (OrderItem i: products
             ) {
            jsonArray.put(i.toString());
        }
        obj.put("Products",jsonArray);
        obj.put("Customer",customerCpf);
        obj.put("Key",Key);
        return obj;
    }

    @Override
    public String toString() {
        StringBuilder initial = new StringBuilder(System.identityHashCode(this) + "|" + customerCpf);
        for (OrderItem item : products) {
            initial.append("|").append(item.toString());
        }
        return initial.toString();
    }


}
