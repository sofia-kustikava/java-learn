//Show that protected methods have package access but are not public

package com.java.se;

import static com.java.se.package1.Test.*;

public class Main {
    public static void main(String[] args) {
        str();
        str2();
    }
}
