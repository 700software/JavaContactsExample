package com.sample;

import java.util.LinkedHashMap;
import java.util.Map;

public class OurData {
    public static final Map<Integer, Contact> THE_MAP = new LinkedHashMap<>();

    /** This is a bad way to do it. Not thread safe. */
    static int autoinc = 0;

    static {
        THE_MAP.put(++autoinc, new Contact(autoinc, "John", "Smith", "john@example.com"));
    }

    public static class Contact {
        public final int id;
        public final String nameFirst, nameLast, email;

        public Contact(int id, String nameFirst, String nameLast, String email) {
            this.id = id;
            this.nameFirst = nameFirst;
            this.nameLast = nameLast;
            this.email = email;
        }

        /** Default values */
        public Contact() {
            this.id = 0;
            this.nameFirst = "";
            this.nameLast = "";
            this.email = "";
        }
    }
}
