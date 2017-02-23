package com.anthony.component.parser;

import com.anthony.beans.Torrent;
import com.anthony.component.resource.Resource;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

/**
 * Created by CHENDONG239 on 2017-02-23.
 */
public class PostParserTest {
    @Before
    public void before() throws IOException {
        Torrent t=new Torrent();
        File file=new File("D:\\Users\\chendong239\\IdeaProjects\\Download\\src\\main\\resources\\1.html");
        BufferedReader reader = null;

        reader = new BufferedReader(new FileReader(file));
        String content="";
        String tmp;
        while ((tmp = reader.readLine()) != null) {
            content+=tmp;
        }
        reader.close();
        t.setPostPage(content);
        Resource.resourceMap.get("postContent").putSingleResource(t);
    }

    @Test
    public void test()
    {
        PostParser postParser=new PostParser();
        postParser.execute();
        Torrent t=Resource.resourceMap.get("downloadUrl").getSingleResource();
        System.out.println(t);
    }

}