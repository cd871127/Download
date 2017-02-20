package com.anthony.parser;


import com.anthony.beans.Torrent;
import com.anthony.resource.Resource;
import com.anthony.util.BookMarkFile;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by CHENDONG239 on 2017-01-23.
 */
public class BookMarkParser extends Parser {

    private ArrayList<String> content;
    private String dirName;


    public BookMarkParser(Resource in, Resource out, String bookMarkName, String dirname) {
        super(in, out);
        this.dirName = dirname;
        BookMarkFile bookMarkFile = new BookMarkFile(bookMarkName);
        content = bookMarkFile.getResourceContent();
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

    private Torrent findUrl(String line) {
        int index = line.indexOf("<DT><A");
        if (-1 == index)
            return null;
        Torrent torrent = new Torrent();
        String url = subStr(line, "HREF=\"", "\" ADD_DATE");
        url = url.substring(url.indexOf("htm_data"));

        String title = subStr(line, "\">", "</A>");
        title = filteTitle(title);
        torrent.setTitle(title);
        torrent.setPostPageUrl(url);
        return torrent;
    }

    private String filteTitle(String title) {
        String regEx = "[\\/:*?\"<>|]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(title);
        return m.replaceAll("").trim();
    }

    private String subStr(String src, String begin, String end) {
        return src.substring(src.indexOf(begin) + begin.length(), src.indexOf(end));
    }

    public void parse() {
        Resource out = getOut();
        boolean isFindDir = false;
        int nullCount = 0;
        for (String line : content) {
            if (2 == nullCount)
                break;
            if (!isFindDir) {
                isFindDir = findDir(line);
                continue;
            }
            Torrent torrent = findUrl(line);
            if (null == torrent) {
                ++nullCount;
                continue;
            }
            out.putSingleResource(torrent);
        }

    }


}
