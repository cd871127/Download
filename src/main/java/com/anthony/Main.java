package com.anthony;


import com.anthony.parser.BookMarkParser;
import com.anthony.parser.Parser;
import com.anthony.resource.FileResource;
import com.anthony.resource.Resource;

/**
 * Created by CHENDONG239 on 2017-01-23.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("start:");
       // "D:\\Users\\chendong239\\Desktop\\Bookmark.html"
        Resource r=new FileResource("D:\\Users\\chendong239\\Desktop\\Bookmark.html");
        System.out.println(r.getResourceContent());
    }
}


