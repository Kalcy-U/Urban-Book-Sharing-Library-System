package com.example.project.utils;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class utils {

    public static int getUint(String str) {
        int d;
        try {
             d = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return -1;
        }
        return d;
    }
}
