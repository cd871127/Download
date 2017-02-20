package com.anthony.parser;

import com.anthony.beans.Torrent;
import com.anthony.resource.Resource;

/**
 * Created by CHENDONG239 on 2017-01-24.
 */
public class PostParser extends Parser {

    private static final String prefix = "http://www.rmdown.com/link.php?hash=";
    private static final int HASH_LENGTH = 43;

    public PostParser(Resource in,Resource out) {
        super(in,out);
    }

    @Override
    public void parse() {
        Resource in=getIn();
        Torrent torrent=null;
        try {
            torrent=in.getSingleResource();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String content = torrent.getPostPage();
        int index = content.indexOf(prefix);
        content = content.substring(index, index + prefix.length() + HASH_LENGTH);
        torrent.getDownloadUrl();
        Resource out=getOut();
        try {
            out.putSingleResource(torrent);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
