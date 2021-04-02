package com.java.se.package1;

public class ConnectionManager {

    private ConnectionManager() {}

    private static Connection[] connections  = {Connection.get(), Connection.get(),Connection.get()};
    private static int i = 0;
    public static Connection getConnection() {
        if (i < connections.length) {
            return connections[i++];
        } else {
            return null;
        }
    }

}
