package com.anthony.parser;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CHENDONG239 on 2017-01-24.
 */
public class RmdownParser extends Parser {
    public RmdownParser(String content)
    {
        super(content);
    }

    @Override
    public Object parse() {
        String ref=getValue("=\"ref\"","=\"");
        String reff=getValue("=\"reff\"","=\"");
        if(null==ref||null==reff)
            return null;
        Map<String,String> paraMap=new HashMap<>();
        paraMap.put("ref",ref);
        paraMap.put("reff",reff);
        return paraMap;
    }

    private String getValue(String posStr,String attr)
    {
        String content=getContent().get(0);
        int index=content.indexOf(posStr)+posStr.length();
        if(-1==index)
            return null;
        String subContent=content.substring(index);
        index=subContent.indexOf(attr)+attr.length();
        subContent=subContent.substring(index);
        index=subContent.indexOf("\"");
        return subContent.substring(0,index);
    }
}
