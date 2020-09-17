package com.wqy.ufq.json;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class JsonUtil {
    public static String  tojosnStr(String jsonStr,Object obj){
        JSONObject jsonObject = JSONUtil.parseObj(jsonStr);
        BeanUtil.copyProperties(jsonObject,obj);
        String json = JSONUtil.toJsonStr(jsonObject);
        return json;
    }

    public static String tojsonStrByKey(String jsonStr,String key){
        if (jsonStr.startsWith("[")){
            JSONArray json = JSONUtil.parseArray(jsonStr);
            for(Object js:json){
                //把里面的对象转化为JSONObject
                JSONObject job = JSONUtil.parseObj(js);
                return tojsonStrByKey(job.toString(),key);
            }
        }
        JSONObject jsonObject = JSONUtil.parseObj(jsonStr);
        Iterator<Map.Entry<String, Object>> iterator = jsonObject.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            if (entry.getKey().toString().equals(key)){
                if (!entry.getValue().toString().equals("")){
                    return "{"+key+":"+entry.getValue().toString()+"}";
                }
            }
            if (entry.getValue() instanceof JSONArray){
                if (((JSONArray) entry.getValue()).size()>0){
                   return tojsonStrByKey(JSONUtil.toJsonStr(entry.getValue()),key);
                }
            }
        }
        return "";
    }

    public static String mergeJsonStr(String js1,String js2){
        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObject1 = JSONUtil.parseObj(js1);
        JSONObject jsonObject2 = JSONUtil.parseObj(js2);
        jsonObject.putAll(jsonObject1);
        jsonObject.putAll(jsonObject2);
        return jsonObject.toString();
    }
}
