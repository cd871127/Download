package com.anthony.parser;


import com.anthony.resource.Resource;

import java.util.ArrayList;

/**
 * Created by CHENDONG239 on 2017-01-23.
 */
public class BookMarkParser extends Parser {

    private String dirName;

    //    BookMarkParser(BookMarkParserBuilder builder)
//    {}
    public BookMarkParser(Resource resource, String dirname) {
        super(resource);
        this.dirName = dirname;
    }

    private boolean findDir(String line) {
        int index = line.indexOf("FOLDED");
        if (-1 == index)
            return false;
        index = line.indexOf(dirName, index);
        if (-1 == index)
            return false;
        return true;
    }

    private String findUrl(String line)
    {
        int index=line.indexOf("</DL><P>");
        if(-1==index)
            return null;

        return "";
    }

    public ArrayList<String> parse() {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> content = getResource().getResourceContent();
        boolean isFindDir = false;
        int bCount=0;
        for (String line : content) {
            if(2==bCount)
                break;
            if (!isFindDir) {
                isFindDir = findDir(line);
                continue;
            }
            System.out.println(line);
            String url=findUrl(line);
            if(null==url)
                ++bCount;
        }
        return result;
    }

}
