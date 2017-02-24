package com.anthony.component.parser;

import com.anthony.beans.Torrent;
import com.anthony.component.Component;
import com.anthony.component.resource.Resource;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by CHENDONG239 on 2017-01-24.
 */
public class PostParser extends Component {

    private static final String prefix = "http://www.rmdown.com/link.php?hash=";
    private static final int HASH_LENGTH = 43;

    public PostParser() {
        setIn(Resource.resourceMap.get("postContent"));
        setOut(Resource.resourceMap.get("rmdownUrl"));
    }

    @Override
    public void execute() {
        Resource in=getIn();
        Torrent torrent=in.getSingleResource();
        String content = torrent.getPostPage();
        int index = content.indexOf(prefix);
        content = content.substring(index, index + prefix.length() + HASH_LENGTH);
        torrent.setRmdownUrl(content);
        Resource out=getOut();
        out.putSingleResource(torrent);
    }
}
