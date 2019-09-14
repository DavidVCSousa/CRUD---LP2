package com.commons.enums;

public enum UserFunciton {
    Salesman(new Permissions[] {Permissions.Order, Permissions.Product, Permissions.Customer}),
    Manager(new Permissions[] {Permissions.Salesman, Permissions.Order.Manager, Permissions.Order, Permissions.Product, Permissions.Customer});

    public Permissions[] getPermisions() {
        return actions;
    }

    private Permissions[] actions;
    UserFunciton(Permissions[] actions) {
        this.actions = actions;
    }
}
