package com.anthony.component.parser;


import com.anthony.beans.Torrent;
import com.anthony.component.Component;
import com.anthony.component.resource.Resource;
import com.anthony.util.BookMarkFile;
import com.anthony.util.Config;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by CHENDONG239 on 2017-01-23.
 */
public class BookMarkParser extends Component {

    private ArrayList<String> content;
    private String dirName;

    public BookMarkParser() {
        this.dirName = Config.getInstance().getProperties("BOOKMARK_DIR");
        BookMarkFile bookMarkFile = new BookMarkFile();
        content = bookMarkFile.getResourceContent();
        setOut(Resource.resourceMap.get("postUrl"));
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
        int urlStartIndex=url.indexOf("htm_data");
        if(-1==urlStartIndex)
            return null;
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

    public void execute() {
        Resource out = getOut();
        boolean isFindDir = false;
        for (String line : content) {
            if (!isFindDir) {
                isFindDir = findDir(line);
                continue;
            }
            if(-1!=line.indexOf("</DL><P>"))
                break;
            Torrent torrent = findUrl(line);
            if (null == torrent) {
                continue;
            }
            out.putSingleResource(torrent);
        }

    }

}
