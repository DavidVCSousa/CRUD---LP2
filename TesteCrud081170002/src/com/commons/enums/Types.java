package com.commons.enums;

public enum Types {
    Client("Client"),
    Manager("Manager"),
    Salesman("Salesman"),
    Order("Order"),
    Product("Product"),
    OrderItem("OrderItem");

    private final String types;

    Types(String state) {
        this.types = state;
    }

    public String getTypeName() {  return types; }
}
