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
        testPost();
    }

    private static void testPost()
    {
        HttpUtil u=new HttpUtil();
        u.get("http://www.rmdown.com/link.php?hash=1715931aacbb8a0dd9a190d3b699b894ae9e7dc9a4e");
    }

    private static void testParse1()
    {
        FileResource r=new FileResource("src\\main\\resources\\2.html");
        List<String> l=r.getResourceContent();
        String content="";
        for(String tmp:l)
        {
            content+=tmp;
        }
    }

    private static void testParse2()
    {
        FileResource r=new FileResource("D:\\Users\\chendong239\\Desktop\\Bookmark.html");
        Parser p=new BookMarkParser(r.getResourceContent(),"Gradle");
        System.out.println(p.parse());
    }


}


