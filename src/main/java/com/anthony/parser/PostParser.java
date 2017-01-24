package com.anthony.parser;

/**
 * Created by CHENDONG239 on 2017-01-24.
 */
public class PostParser extends Parser {

    private static final String prefix="http://www.rmdown.com/link.php?hash=";
    private static final int HASH_LENGTH=43;

    public PostParser(String content)
    {
        super(content);
    }

    @Override
    public Object parse() {
        String content=getContent().get(0);
        int index=content.indexOf(prefix);
        content=content.substring(index,index+prefix.length()+HASH_LENGTH);
        return content;
    }
}
