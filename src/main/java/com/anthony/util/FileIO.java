package com.anthony.util;

import java.io.*;

/**
 * Created by CHENDONG239 on 2017-02-06.
 */
public class FileIO {
    public static boolean download(String localFilePath, InputStream in) {
        File file = new File(localFilePath);
        FileOutputStream fout = null;
        try {
            fout = new FileOutputStream(file);

            int l = -1;
            byte[] tmp = new byte[1024];
            while ((l = in.read(tmp)) != -1) {
                fout.write(tmp, 0, l);
                // 注意这里如果用OutputStream.write(buff)的话，图片会失真
            }
            // 将文件输出到本地
            fout.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    static public void writeLine(String fileName,String line)
    {
        try {
            FileWriter fw=new FileWriter(fileName,true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(line);
            pw.flush();
            fw.flush();
            pw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
