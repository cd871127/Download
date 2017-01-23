package com.anthony.resource;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by CHENDONG239 on 2017-01-23.
 */
public class FileResource implements Resource {

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
            InputStream is = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(is, "utf8");
            reader = new BufferedReader(isr);
            String tempStr;
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
