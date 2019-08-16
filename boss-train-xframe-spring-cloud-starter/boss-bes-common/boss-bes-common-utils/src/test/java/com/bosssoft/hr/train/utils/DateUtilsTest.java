package com.bosssoft.hr.train.utils;

import org.junit.Test;

import java.util.List;

public class DateUtilsTest {

    @Test
    public void testDateUtils() {
        System.out.println(DateUtils.getDateToString());
    }

    @Test
    public void testDateFromString(){
        System.out.println(DateUtils.getDateFromString("2019-08-15 23:51:36"));
    }
}
