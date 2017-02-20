package com.anthony.util;

import org.junit.Test;

/**
 * Created by CHENDONG239 on 2017-02-20.
 */
public class ConfigTest {
    @Test
    public void test()
    {
        Config config=new Config();
        System.out.println("test:");
        System.out.println(config.getProperties("baseurl"));
    }

}