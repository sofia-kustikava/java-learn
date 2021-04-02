package com.java.se.package1;

public class Connection {
    private Connection() {}

    public static Connection get() {
        return new Connection();
    }
}
