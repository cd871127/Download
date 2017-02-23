package com.anthony.component.parser;

import com.anthony.beans.Torrent;
import com.anthony.component.Component;
import com.anthony.component.resource.Resource;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CHENDONG239 on 2017-01-24.
 */
public class RmdownParser extends Component {
    public RmdownParser() {
        setIn(Resource.resourceMap.get("rmdownContent"));
        setOut(Resource.resourceMap.get("downloadUrl"));
    }

    private String setUrl(String ref,String reff)
    {
        String url="http://www.rmdown.com/download.php?ref="+ref+"&reff="+reff;
        return url;
    }

    @Override
    public void execute() {
        Torrent torrent =getIn().getSingleResource();
        String content = torrent.getRmdownPage();

        String ref = getValue("=\"ref\"", "=\"",content);
        String reff = getValue("=\"reff\"", "=\"",content);
        if (null == ref || null == reff)
            return;

        torrent.setDownloadUrl(setUrl(ref,reff));
        getOut().putSingleResource(torrent);
    }

    private String getValue(String posStr, String attr,String content) {

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
