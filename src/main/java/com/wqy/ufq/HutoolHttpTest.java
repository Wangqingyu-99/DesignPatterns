package com.wqy.ufq;

import cn.hutool.http.HttpUtil;

import java.util.HashMap;

public class HutoolHttpTest {
    public static void main(String[] args) {
        HashMap<String, Object> paramMap = new HashMap<>();
//        paramMap.put("cusId", "402881bb747c45af01747c4dd4620000");
        paramMap.put("cusId", "string");

//        String result= HttpUtil.post("http://localhost:8081//api/cus/findByCusId", paramMap);
        String result= HttpUtil.get("http://localhost:8081/api/cus/findAttByCusId", paramMap);
//        String result= HttpUtil.post("http://localhost:8081/test/wqy","");
        System.out.println(result);
    }
}
