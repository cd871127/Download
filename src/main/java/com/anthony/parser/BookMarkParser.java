package com.anthony.parser;


import com.anthony.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by CHENDONG239 on 2017-01-23.
 */
public class BookMarkParser extends Parser {

    private String dirName;


    public BookMarkParser(ArrayList<String> content, String dirname) {
        super(content);
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

    private Pair<String,String> findUrl(String line)
    {

        int index=line.indexOf("<DT><A");
        if(-1==index)
            return null;
        Pair<String,String> urlTitle=new Pair<>();
        String url=subStr(line,"HREF=\"","\" ADD_DATE");
        url=url.substring(url.indexOf("htm_data"));

        String title=subStr(line,"\">","</A>");
        title=filteTitle(title);
        urlTitle.setKV(url,title);
        return urlTitle;
    }

    private String filteTitle(String title)
    {
        String regEx="[\\/:*?\"<>|]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(title);
        return m.replaceAll("").trim();
    }

    private String subStr(String src,String begin,String end)
    {
        return src.substring(src.indexOf(begin)+begin.length(),src.indexOf(end));
    }

    @Override
    public Object parse() {
        Map<String,String> result = new HashMap<>();
        ArrayList<String> content = getContent();
        boolean isFindDir = false;
        int nullCount=0;
        for (String line : content) {
            if(2==nullCount)
                break;
            if (!isFindDir) {
                isFindDir = findDir(line);
                continue;
            }
            Pair<String,String> urlTitle=findUrl(line);
            if(null==urlTitle) {
                ++nullCount;
                continue;
            }
            urlTitle.addToMap(result);
            System.out.println(urlTitle);
        }
        return result;
    }

}
