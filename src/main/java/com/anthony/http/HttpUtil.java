package com.anthony.http;

import com.anthony.util.FileIO;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Anthony on 2017/1/23.
 */
public class HttpUtil {

   // www.rmdown.com/download.php?ref=1715931aacbb8a0dd9a190d3b699b894ae9e7dc9a4e&reff=MTQ4NjM3MjkwNA==

    public void post(String url) throws IOException {
        CloseableHttpClient client=setProxyInfo();
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = client.execute(httpPost);

        System.out.println(response.getStatusLine().toString());
        Header[] headers = response.getAllHeaders();
        for (Header h : headers)
            System.out.println(h.getName() + ": " + h.getValue());
        HttpEntity entity = response.getEntity();
        FileIO.download("D:\\a\\1.torrent",entity.getContent());
//        System.out.println(EntityUtils.toString(entity, "utf8"));
        EntityUtils.consume(entity);

        response.close();
        client.close();
    }

    //http://bbs.csdn.net/topics/391844932?list=lz
    //http://mercymessi.iteye.com/blog/2250161

    public String get(String url) {
        CloseableHttpClient client=setProxyInfo();
        HttpEntity entity = null;
        CloseableHttpResponse response = null;
        HttpGet httpGet = new HttpGet(url);
        String res=null;
        try {
            response = client.execute(httpGet);
            System.out.println(response.getStatusLine().toString());
            Header[] headers = response.getAllHeaders();
            for (Header h : headers)
                System.out.println(h.getName() + ": " + h.getValue());
            entity = response.getEntity();
            res=EntityUtils.toString(entity, "utf8");
        } catch (IOException e) {
        } finally {
            try {
                EntityUtils.consume(entity);
                if(null!=response) {
                    response.close();
                }
                client.close();
            } catch (IOException e) {
            }
        }
        return res;
    }

    private CloseableHttpClient setProxyInfo() {
        HttpHost proxy = new HttpHost("10.17.171.11", 8080);
        DefaultProxyRoutePlanner routePlanner = new DefaultProxyRoutePlanner(proxy);
        return HttpClients.custom().setRoutePlanner(routePlanner).build();
    }
}
