package com.anthony.resource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by CHENDONG239 on 2017-01-23.
 */
public class FileResource extends Resource {

    private File file;

    public FileResource(String fileName) {
        openFile(fileName);
    }

    private void openFile(String fileName) {
        if (null == fileName && !"".equals(""))
            return;//error
        file = new File(fileName);
    }

    @Override
    public ArrayList<String> getResourceContent() {
        BufferedReader reader = null;
        ArrayList<String> res = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempStr = null;
            while ((tempStr = reader.readLine()) != null) {
                res.add(tempStr);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return res;
    }
}
