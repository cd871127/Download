package com.anthony.resource;

import com.anthony.beans.Torrent;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by CHENDONG239 on 2017-02-20.
 */
public class BookMark extends Resource {

    private static BookMark bookMark=null;

    public BookMark getInstance()
    {
        if(null==bookMark)
            bookMark=new BookMark();
        return bookMark;
    }

    private BookMark(){

    }

}
