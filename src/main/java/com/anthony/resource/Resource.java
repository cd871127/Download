package com.anthony.resource;

import com.anthony.beans.Torrent;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by CHENDONG239 on 2017-01-23.
 */
public abstract class Resource {

    private LinkedBlockingQueue<Torrent> resourceQueue = new LinkedBlockingQueue<>();

    public Torrent getSingleResource() {
        Torrent torrent = null;
        try {
            torrent = resourceQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return torrent;
    }

    public void putSingleResource(Torrent torrent) {
        try {
            resourceQueue.put(torrent);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
