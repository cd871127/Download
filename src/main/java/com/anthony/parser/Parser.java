package com.anthony.parser;

import java.util.ArrayList;

/**
 * Created by CHENDONG239 on 2017-01-23.
 */
public abstract class Parser {
    private ArrayList<String> result;
    private String source;

    public ArrayList<String> getResult() {
        return result;
    }

    public void setResult(ArrayList<String> result) {
        this.result = result;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public abstract void parse();
}
