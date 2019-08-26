package com.bosssoft.bes.base.utils;

import org.junit.Test;

public class SnowFlakeTest {
    @Test
    public void test() {
        SnowFlake snowFlake = new SnowFlake(2,3);
        for (int i=0;i<2;i++){
            System.out.println(snowFlake.nextId());
        }
    }
}
