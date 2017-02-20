package com.anthony.resource;

import com.anthony.beans.Torrent;

import java.util.ArrayList;

/**
 * Created by CHENDONG239 on 2017-01-23.
 */
public interface Resource {

    Torrent getSingleResource() throws InterruptedException;

    void putSingleResource(Torrent torrent) throws InterruptedException;

}
