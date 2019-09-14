package com.business;

import com.commons.Util.Json.JSONObject;

public class OrderItem {
    private String indentifier;
    private int amount;

    public OrderItem(String indentifier, int amount) {
        if(indentifier.isEmpty())
            throw new IllegalArgumentException();
        this.indentifier = indentifier;
        this.amount = amount;
    }

    @Override
    public String toString() {
        var obj = new JSONObject();
        obj.put("id",indentifier);
        obj.put("qtd",amount);
        return obj.toString();
    }


}
