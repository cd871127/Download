package com.anthony.util;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by CHENDONG239 on 2017-02-23.
 */
public class ThreadPool<T> {
    private int threadCount;
    private List<T> threadList;

    public ThreadPool(int threadCount)
    {
        this.threadCount=threadCount;
        threadList=new LinkedList<>();

    }
}
