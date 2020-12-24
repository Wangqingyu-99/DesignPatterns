package com.wqy.httpclient;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import org.apache.http.HttpEntity;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.*;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HttpclientUtil {

    /**
     * 同时支持RequestParam和RequestBody
     *
     * @param url
     * @param requestParams
     * @param requestBodyJson
     * @return
     * @throws Exception
     */
    public static String postMapHybrid(String url, String host,Map<String, Object> requestParams, String requestBodyJson)
            throws Exception {
        CookieStore cookieStore = null;
        // 构造URL
        url += "?1=1";
        if (requestParams!=null){
            Iterator<?> iterator = requestParams.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Object> elem = (Map.Entry<String, Object>) iterator.next();
                if (elem.getValue() != null) {
                    url += "&" + elem.getKey() + "=" + elem.getValue();
                }
            }
        }
        // 对url进行encoding转码
        url = HttpUtil.encodeParams(url, Charset.forName("UTF-8"));
//        String host = apolloConfig.getConfig().getProperty("report_url", "http://192.168.1.215:98");
        // 构建HTTPS的请求连接
        if (cookieStore == null || "".equals(cookieStore)) {
            cookieStore = new BasicCookieStore();
        }
        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy())
                .setRedirectStrategy(new DefaultRedirectStrategy()).setDefaultCookieStore(cookieStore).build();
        HttpPost httpPost = new HttpPost(host + url);
        // 设置参数(构造RequestBody参数,强制content-type通过application/json提交)
        StringEntity stringEntity = new StringEntity(requestBodyJson==null?"":requestBodyJson, "UTF-8");
        stringEntity.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString()));
        httpPost.setEntity(stringEntity);
        // 设置请求参数
        httpPost.setHeader("Content-type", ContentType.APPLICATION_JSON.toString());
        // 设置超时时间
        RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(60 * 10 * 1000)
                .setSocketTimeout(60 * 10 * 60).setConnectTimeout(60 * 10 * 1000).build();
        httpPost.setConfig(requestConfig);
        CloseableHttpResponse resp = httpClient.execute(httpPost);
        // 判断状态
        switch (resp.getStatusLine().getStatusCode()) {
            case 404:
                throw new RuntimeException("xx系统404");
            case 500:
                throw new RuntimeException("xx系统500");
            case 502:
                throw new RuntimeException("xx系统502");
            case 503:
                throw new RuntimeException("xx系统503");
            case 504:
                throw new RuntimeException("xx系统504");

        }
        HttpEntity entity = resp.getEntity();
        return EntityUtils.toString(entity);
    }

    public static void main(String[] args) throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        map.put("type","yunda");
        map.put("postid",4311068022773l);
        map.put("temp",0.34836353144395504);
        String jsonStr = JSONUtil.toJsonStr(map);
        System.out.println(jsonStr);
        String result = HttpclientUtil.postMapHybrid("/query", "https://www.kuaidi100.com", map, jsonStr);
        System.out.println(result);
    }
}
