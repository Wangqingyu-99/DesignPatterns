package com.wqy.ufq;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class HttpClientTest {
    public static void main(String[] args) throws IOException, URISyntaxException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost("http://localhost:8081/test/wqy");
        CloseableHttpResponse response = httpClient.execute(httpPost);
        HttpEntity responseEntity = response.getEntity();
        String str = EntityUtils.toString(responseEntity);
        System.out.println(str);


        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("cusId", "402881bb747c45af01747c4dd4620000"));
        URI uri = new URIBuilder().setScheme("http").setHost("localhost")
                .setPort(8081).setPath("/api/cus/findByCusId")
                .setParameters(params).build();
//        HttpGet httpGet = new HttpGet(uri);
        HttpPost httpPost1 = new HttpPost(uri);
        CloseableHttpResponse response1 = httpClient.execute(httpPost1);
        System.out.println(EntityUtils.toString(response1.getEntity()));

    }
}
