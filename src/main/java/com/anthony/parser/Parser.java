package com.anthony.parser;

import com.anthony.resource.Resource;

import java.util.ArrayList;

/**
 * Created by CHENDONG239 on 2017-01-23.
 */
public abstract class Parser implements Runnable{
    private Resource in;

    public Resource getIn() {
        return in;
    }

    public void setIn(Resource in) {
        this.in = in;
    }

    public Resource getOut() {
        return out;
    }

    public void setOut(Resource out) {
        this.out = out;
    }

    private Resource out;

    public Parser(Resource in,Resource out)
    {
        this.in=in;
        this.out=out;
    }

    public abstract void parse();

    @Override
    public void run() {
        parse();
    }
}
