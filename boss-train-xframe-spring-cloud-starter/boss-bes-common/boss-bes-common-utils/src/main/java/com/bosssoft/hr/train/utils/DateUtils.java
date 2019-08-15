package com.bosssoft.hr.train.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 用于与日期转换有关的接口
 * @author : wukeqiang
 * @date : 2019/8/15
 * @version : 1.0.0
 */
public class DateUtils {

    /**
     * 获取当前时间
     * @return
     */
    public static Date getDate() {
        Date currentTime = new Date();
        return currentTime;
    }

    /**
     * 获取当前时间
     * @return 返回字符串形式的当前时间
     */
    public static synchronized String getDateToString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-DD HH:MM:SS");
        return sdf.format(new Date());
    }


    /**
     * 将字符串转为date形式
     * @param '需要转化的字符串'str
     * @return '返回date格式'
     */
    public static Date getDateFromString(String str){
         SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-DD HH:MM:SS");
         if ("".equals(str) || str == null) {
             return null;
         }
         try {
             return sdf.parse(str);
         } catch (ParseException e) {
             e.printStackTrace();
         }
         return null;
    }



}
