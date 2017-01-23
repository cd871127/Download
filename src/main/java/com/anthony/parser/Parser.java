package com.anthony.parser;

import com.anthony.resource.Resource;

import java.util.ArrayList;

/**
 * Created by CHENDONG239 on 2017-01-23.
 */
public abstract class Parser {
    public Parser(Resource resource)
    {
        this.resource=resource;
    }

    protected Resource getResource() {
        return resource;
    }

    private Resource resource;
    public abstract ArrayList<String> parse();


}
