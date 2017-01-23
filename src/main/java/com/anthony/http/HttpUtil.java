package com.anthony.http;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by Anthony on 2017/1/23.
 */
public class HttpUtil {
    public void post(String url) throws IOException {
        CloseableHttpClient client= HttpClients.createDefault();

        HttpPost httpPost=new HttpPost(url);
//        httpPost.setHeader();
        CloseableHttpResponse response=client.execute(httpPost);

        System.out.println(response.getStatusLine().toString());
        Header[] headers=response.getAllHeaders();
        for(Header h:headers)
            System.out.println(h.getName()+": "+h.getValue());
        HttpEntity entity=response.getEntity();
        System.out.println(EntityUtils.toString(entity,"utf8"));
        EntityUtils.consume(entity);

        response.close();
        client.close();
    }

    public void get(String url) throws IOException {
        CloseableHttpClient client= HttpClients.createDefault();

        HttpGet httpGet=new HttpGet(url);
        CloseableHttpResponse response=client.execute(httpGet);

        System.out.println(response.getStatusLine().toString());
        Header[] headers=response.getAllHeaders();
        for(Header h:headers)
            System.out.println(h.getName()+": "+h.getValue());
        HttpEntity entity=response.getEntity();
        System.out.println(EntityUtils.toString(entity,"utf8"));

        EntityUtils.consume(entity);
        response.close();
        client.close();
    }

    private void setProxy(CloseableHttpClient httpClient)
    {
    }
}
