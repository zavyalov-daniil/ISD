package com.notes.isd.services;


public class CurrentExceptionKeeper {
    private static boolean hasException = false;
    private static String description = "";

    public static void setDescription(String incommingDescription) {
        description = incommingDescription;
        hasException = true;
    }

    public static Boolean hasexception() {
        return hasException;
    }

    public static String getDescription() {
        return description;
    }
}
