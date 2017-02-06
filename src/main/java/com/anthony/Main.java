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
import java.util.HashMap;
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
        String content=u.get("http://www.rmdown.com/link.php?hash=1715931aacbb8a0dd9a190d3b699b894ae9e7dc9a4e");
//        System.out.println(content);
        Parser p=new RmdownParser(content);
        Map paraMap=(HashMap<String,String>)p.parse();
        String url="http://www.rmdown.com/download.php?";
        url+="ref="+paraMap.get("ref")+"&reff="+paraMap.get("reff");
        System.out.println(url);
        try {
            u.post(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

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
        Parser p=new RmdownParser(content);
        System.out.println(p.parse());
    }

    private static void testParse2()
    {
        FileResource r=new FileResource("D:\\Users\\chendong239\\Desktop\\Bookmark.html");
        Parser p=new BookMarkParser(r.getResourceContent(),"Gradle");
        System.out.println(p.parse());
    }


}


