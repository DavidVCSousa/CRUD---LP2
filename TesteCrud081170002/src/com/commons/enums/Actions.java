package com.commons.enums;

public enum Actions {

    Create      ("Create"),
    Read        ("Read"),
    Update      ("Update"),
    Delete      ("Delete")
    ;

    private final String path;
    Actions(String path) {
        this.path = path;
    }

    public String getAction() {
        return path;
    }

}
