package com.anthony.component.resource;

import com.anthony.beans.Torrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by CHENDONG239 on 2017-01-23.
 */
public class Resource {
    public static Map<String,Resource> resourceMap;
    static{
        resourceMap=new HashMap<>();
        resourceMap.put("postUrl",new Resource());
        resourceMap.put("postContent",new Resource());
        resourceMap.put("rmdownUrl",new Resource());
        resourceMap.put("rmdownContent",new Resource());
        resourceMap.put("downloadUrl",new Resource());
    }

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

    public int size()
    {
        return resourceQueue.size();
    }

}
