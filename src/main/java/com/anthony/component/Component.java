package com.anthony.component;

import com.anthony.beans.Torrent;
import com.anthony.component.resource.Resource;
import com.anthony.util.Config;
import com.anthony.util.FileIO;

/**
 * Created by CHENDONG239 on 2017-02-23.
 */
public abstract class Component implements Runnable{
    private Resource in;
    private Resource out;

    public abstract void execute();
    @Override
    public void run() {
        execute();
    }

    public Resource getIn() {
        return in;
    }

    public void setIn(Resource in) {
        this.in = in;
    }

    public Resource getOut() {
        return out;
    }

    public void setOut(Resource out) {
        this.out = out;
    }

    public static void logError(Torrent torrent){
        String message="download failed:"+torrent.toString();
        FileIO.writeLine(Config.getInstance().getProperties("ERROR_FILE"),message);
    }
}
