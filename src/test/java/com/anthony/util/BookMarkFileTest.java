package com.anthony.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by CHENDONG239 on 2017-02-23.
 */
public class BookMarkFileTest {
    @Test
    public void test()
    {
        BookMarkFile bookMarkFile=new BookMarkFile();
        System.out.println(bookMarkFile.getResourceContent());
    }

}