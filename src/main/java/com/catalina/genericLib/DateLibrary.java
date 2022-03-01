package com.catalina.genericLib;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateLibrary {

    public static String getDateDDMMYYYY() {
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
        Date date = new Date();
        String datePattern = formatter.format(date);
        return datePattern;
    }

}
