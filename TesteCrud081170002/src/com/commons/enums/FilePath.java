package com.commons.enums;

import java.io.File;

public enum FilePath {
    Product      (System.getProperty("user.dir")+"\\Texts\\products.txt"),
    Order        (System.getProperty("user.dir")+"\\Texts\\orders.txt"),
    User         (System.getProperty("user.dir")+"\\Texts\\users.txt"),
    Client       (System.getProperty("user.dir")+"\\Texts\\clients.txt"),
    Log          (System.getProperty("user.dir")+"\\Texts\\logs.txt"),
    ;

    private final String path;
    FilePath(String path) {
        this.path = path;
    }

    public String getPath() {
        return new File(path).getAbsolutePath();
    }
}
