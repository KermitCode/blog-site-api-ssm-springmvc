package cn.api04007.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    // 时间戳转换日期
    public static String toDatetime(int timestamp){

        String sd = "";

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sd = sdf.format(new Date(Long.parseLong(String.valueOf(timestamp) + "000")));

        return sd;

    }
}
