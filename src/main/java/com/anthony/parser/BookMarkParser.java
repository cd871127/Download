package com.anthony.parser;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by CHENDONG239 on 2017-01-23.
 */
public class BookMarkParser{
    private File file;
    private String dirName;

    public BookMarkParser(String dirName)
    {
        this.dirName=dirName;
    }

    private boolean findDir(String line)
    {
        int index = line.indexOf("FOLDED");
        if (-1 == index)
            return false;
        index = line.indexOf(dirName, index);
        if (-1 == index)
            return false;
        return true;
    }

    public void parse() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            // 一次读入一行，直到读入null为文件结束
            boolean flag ;
            while ((tempString = reader.readLine()) != null) {
                //判断文件夹
                if(flag=findDir(tempString))
                {
                    System.out.println("find dir");
                }else
                {
                    continue;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }
}
