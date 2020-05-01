package com.page.ssm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    // 日期转换成字符串
    public static String dataToString(Date date,String pattern){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String format = sdf.format(date);
        return format ;
    }
    //字符串转换成日期
    public static Date stringToDate(String str,String pattern) throws ParseException {
        SimpleDateFormat sdf  = new SimpleDateFormat(pattern);
        Date date = sdf.parse(str);
        return date;
    }




}
