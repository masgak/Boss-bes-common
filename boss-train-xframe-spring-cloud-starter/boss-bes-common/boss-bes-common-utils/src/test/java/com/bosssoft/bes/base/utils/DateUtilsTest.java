package com.bosssoft.bes.base.utils;

import org.junit.Test;

public class DateUtilsTest {

    @Test
    public void testDateTime() {
        System.out.println(DateUtils.getDate());
        System.out.println(DateUtils.getTime());
        System.out.println(DateUtils.getDateToString());
        System.out.println(DateUtils.getDateFromString("2019-08-15 23:51:36"));
    }
}
