package com.anthony;


import com.anthony.http.HttpUtil;
import com.anthony.parser.BookMarkParser;
import com.anthony.parser.Parser;
import com.anthony.parser.PostParser;
import com.anthony.parser.RmdownParser;
import com.anthony.resource.FileResource;
import com.anthony.resource.Resource;
import javafx.util.Pair;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by CHENDONG239 on 2017-01-23.
 */
public class Main {
    public static void main(String[] args) {
        FileResource r=new FileResource("src\\main\\resources\\2.html");
        List<String> l=r.getResourceContent();
        String content="";
        for(String tmp:l)
        {
            content+=tmp;
        }
        System.out.println(content);
//        Parser p= new PostParser(content);
        Parser p= new RmdownParser(content);
        System.out.println(p.parse());
    }


}


