package com.anthony.parser;

import com.anthony.beans.Torrent;
import com.anthony.resource.Resource;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CHENDONG239 on 2017-01-24.
 */
public class RmdownParser extends Parser {
    public RmdownParser(Resource in, Resource out) {
        super(in, out);
    }

    @Override
    public void parse() {
        String ref = getValue("=\"ref\"", "=\"");
        String reff = getValue("=\"reff\"", "=\"");
        if (null == ref || null == reff)
            return;
        Map<String, String> paraMap = new HashMap<>();
        paraMap.put("ref", ref);
        paraMap.put("reff", reff);
        Torrent torrent=null;
        torrent.setDownloadUrl("");
        try {
            getOut().putSingleResource(torrent);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String getValue(String posStr, String attr) {
        Torrent torrent = null;
        try {
            torrent = getIn().getSingleResource();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String content = torrent.getDownloadPage();
        int index = content.indexOf(posStr) + posStr.length();
        if (-1 == index)
            return null;
        String subContent = content.substring(index);
        index = subContent.indexOf(attr) + attr.length();
        subContent = subContent.substring(index);
        index = subContent.indexOf("\"");
        return subContent.substring(0, index);
    }
}
