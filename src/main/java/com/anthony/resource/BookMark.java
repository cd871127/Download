package com.anthony.resource;

import com.anthony.beans.Torrent;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by CHENDONG239 on 2017-02-20.
 */
public class BookMark implements Resource {

    private static BookMark bookMark=null;

    public BookMark getInstance()
    {
        if(null==bookMark)
            bookMark=new BookMark();
        return bookMark;
    }

    private BookMark(){

    }

    private LinkedBlockingQueue<Torrent> bookMarkQueue=new LinkedBlockingQueue<>();


    @Override
    public Torrent getSingleResource() throws InterruptedException {

        return bookMarkQueue.take();
    }

    @Override
    public void putSingleResource(Torrent torrent) throws InterruptedException {
        bookMarkQueue.put(torrent);
    }


}
