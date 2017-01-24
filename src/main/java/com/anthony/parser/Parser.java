package com.anthony.parser;

import com.anthony.resource.Resource;

import java.util.ArrayList;

/**
 * Created by CHENDONG239 on 2017-01-23.
 */
public abstract class Parser {
    public Parser(ArrayList<String> content)
    {
        this.content=content;
    }

    public Parser(String content)
    {
        this.content=new ArrayList<>();
        this.content.add(content);
    }

    protected ArrayList<String> getContent() {
        return content;
    }

    private ArrayList<String> content;
    public abstract Object parse();


}
