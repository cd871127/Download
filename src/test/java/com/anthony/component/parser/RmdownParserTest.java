package com.anthony.component.parser;

import com.anthony.beans.Torrent;
import com.anthony.component.resource.Resource;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by CHENDONG239 on 2017-02-23.
 */
public class RmdownParserTest {
    @Before
    public void before() throws IOException {
        Torrent t=new Torrent();
        File file=new File("D:\\Users\\chendong239\\IdeaProjects\\Download\\src\\main\\resources\\2.html");
        BufferedReader reader = null;

        reader = new BufferedReader(new FileReader(file));
        String content="";
        String tmp;
        while ((tmp = reader.readLine()) != null) {
            content+=tmp;
        }
        reader.close();
        t.setPostPage(content);
        Resource.resourceMap.get("downloadContent").putSingleResource(t);
    }

    @Test
    public void test()
    {
        RmdownParser postParser=new RmdownParser();
        postParser.execute();
        Torrent t=Resource.resourceMap.get("downloadUrl").getSingleResource();
        System.out.println(t);
    }

}