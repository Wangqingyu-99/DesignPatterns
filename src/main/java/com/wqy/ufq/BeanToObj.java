package com.wqy.ufq;

import cn.hutool.core.bean.BeanUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class BeanToObj {
    public static void main(String[] args) throws Exception {
        A a = new A();
        a.setCusId("sdadasdsadas");
        Map<String, String> stringMap = BeanUtils.describe(a);
        System.out.println(stringMap);

        //hutool
        Map<String, Object> map = BeanUtil.beanToMap(a);
        System.out.println(map);
    }
}
