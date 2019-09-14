package com.business;

import com.commons.Util.Json.JSONObject;
import com.commons.enums.Types;
import com.dao.ProductDAO;

import java.io.IOException;

public class Product extends RegistrableObject {
    @Override
    public void register(RegistrableObject obj) throws IOException {
        ProductDAO repository = new ProductDAO();
        repository.registerProduct((Product) obj);
    }

    @Override
    public Types Type() {
        return Types.Product;
    }

    @Override
    public JSONObject ToJson() {
        JSONObject obj =  new JSONObject();
        obj.put("Type",Type().getTypeName());
        obj.put("Identifier",identifier);
        obj.put("Name",name);
        obj.put("Price",price);
        return obj;
    }

    public Product(String identifier, double price, String name) {
        if(identifier.isEmpty() || name.isEmpty())
            throw new IllegalArgumentException();
        this.identifier = identifier;
        this.name = name;
        this.price = price;
    }

    public String getIdentifier() {
        return identifier;
    }

    private String name;
    private String identifier;
    private double price;
}
