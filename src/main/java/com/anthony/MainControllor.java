package com.anthony;

import com.anthony.component.parser.BookMarkParser;
import com.anthony.component.resource.Resource;
import com.anthony.util.BookMarkFile;

/**
 * Created by CHENDONG239 on 2017-02-20.
 */
public class MainControllor {
    public static void main(String[] args) {
        BookMarkParser bookMarkParser=new BookMarkParser();
        bookMarkParser.execute();
        if(Resource.resourceMap.get("postUrl").size()<1)
            return ;
        System.out.println(Resource.resourceMap.get("postUrl").size());
    }
}
