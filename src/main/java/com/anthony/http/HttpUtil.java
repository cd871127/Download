package com.anthony.http;

import com.anthony.util.FileIO;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.SocketTimeoutException;

/**
 * Created by Anthony on 2017/1/23.
 */
public class HttpUtil {

    // www.rmdown.com/download.php?ref=1715931aacbb8a0dd9a190d3b699b894ae9e7dc9a4e&reff=MTQ4NjM3MjkwNA==

    public void post(String url)
    {
        int retryTime=0;
        boolean flag=false;
        do {
            try {
                flag=doPost(url);
            } catch (IOException e) {
                e.printStackTrace();
                ++retryTime;
                System.out.println("重试");
            }

        }while(retryTime<3&&!flag);
        if(!flag)
            System.out.println("下载失败");
    }

    public boolean doPost(String url) throws IOException {

        CloseableHttpClient client = setProxyInfo();
        HttpPost httpPost = new HttpPost(url);
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(10000).setConnectTimeout(5000).build();
        httpPost.setConfig(requestConfig);
        CloseableHttpResponse response;

        response = client.execute(httpPost);

        System.out.println(response.getStatusLine().toString());
        Header[] headers = response.getAllHeaders();
        for (Header h : headers)
            System.out.println(h.getName() + ": " + h.getValue());
        HttpEntity entity = response.getEntity();
        FileIO.download("D:\\a\\1.torrent", entity.getContent());
//        System.out.println(EntityUtils.toString(entity, "utf8"));
        EntityUtils.consume(entity);

        response.close();
        client.close();
        return true;
    }

    //http://bbs.csdn.net/topics/391844932?list=lz
    //http://mercymessi.iteye.com/blog/2250161

    public String get(String url){
        return doGet(url);
    }

    public String doGet(String url) {
        CloseableHttpClient client = setProxyInfo();
        HttpEntity entity = null;
        CloseableHttpResponse response = null;
        HttpGet httpGet = new HttpGet(url);
        String res = null;
        try {
            response = client.execute(httpGet);
            System.out.println(response.getStatusLine().toString());
            Header[] headers = response.getAllHeaders();
            for (Header h : headers)
                System.out.println(h.getName() + ": " + h.getValue());
            entity = response.getEntity();
            res = EntityUtils.toString(entity, "GBK");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                EntityUtils.consume(entity);
                if (null != response) {
                    response.close();
                }
                client.close();
            } catch (IOException e) {
            }
        }
        return res;
    }

    private CloseableHttpClient setProxyInfo() {
//        HttpHost proxy = new HttpHost("10.17.171.11", 8080);
//        DefaultProxyRoutePlanner routePlanner = new DefaultProxyRoutePlanner(proxy);
//        return HttpClients.custom().setRoutePlanner(routePlanner).build();
        return HttpClients.createDefault();

    }
}
