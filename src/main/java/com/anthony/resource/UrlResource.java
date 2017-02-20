package com.anthony.resource;

/**
 * Created by CHENDONG239 on 2017-02-20.
 */
public class UrlResource extends Resource {

    private static UrlResource urlResource =null;

    public UrlResource getInstance()
    {
        if(null== urlResource)
            urlResource =new UrlResource();
        return urlResource;
    }

    private UrlResource(){

    }

}
