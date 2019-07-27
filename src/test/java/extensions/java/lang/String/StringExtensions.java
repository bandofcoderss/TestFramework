package extensions.java.lang.String;

import manifold.ext.api.*;

@Extension
public class StringExtensions {

    public static void print(@This String thiz) {
        System.out.println(thiz);
    }

    @Extension
    public static String lineSeparator() {
        return System.lineSeparator();
    }
}