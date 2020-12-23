package com.wqy.代理模式.动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        JDKProxy();
    }

    /**
     * JDK 的动态代理
     */
    public static void JDKProxy() {
        UserServiceImpl userService = new UserServiceImpl();
        ClassLoader classLoader = userService.getClass().getClassLoader();
        Class<?>[] interfaces = userService.getClass().getInterfaces();
        Object o = Proxy.newProxyInstance(classLoader, interfaces, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                before();
                Object invoke = method.invoke(userService, args);
                after();
                return invoke;
            }

            public void before() {
                System.out.println("============before==========");
            }

            public void after() {
                System.out.println("============after==========");
            }
        });
        UserService u = (UserService) o;
        u.test();
    }

    /**
     * CGLIB的动态代理
     */
    public static void CGLIBProxy() {
        //todo
    }
}
