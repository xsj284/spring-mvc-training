package com.xsj284.training.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xsj284
 * created date: <p>2022/5/25<p>
 */
public class DateUtil {

    public static long dateStringToLong(String yyyyMMdd) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = simpleDateFormat.parse(yyyyMMdd);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return date.getTime();
    }

}
