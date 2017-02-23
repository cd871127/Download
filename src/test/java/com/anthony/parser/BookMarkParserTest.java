package com.anthony.parser;

import com.anthony.component.parser.BookMarkParser;
import com.anthony.component.resource.Resource;
import org.junit.Test;

/**
 * Created by CHENDONG239 on 2017-02-23.
 */
public class BookMarkParserTest {
    @Test
    public void test() {
        BookMarkParser bookMarkParser = new BookMarkParser();
        bookMarkParser.execute();
        System.out.println(Resource.resourceMap.get("postUrl").getSingleResource());
    }


}