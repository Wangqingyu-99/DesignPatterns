package com.wqy.适配器模式.对象适配器模式;

import com.wqy.适配器模式.类适配器模式.Adaptee;
import com.wqy.适配器模式.类适配器模式.Target;

/**
 * 类适配器模式和对象适配器模式的区别：
 * 类适配器是继承适配者，而对象适配器是引用适配者
 * 两者都会实现目标接口，保证目标接口的规范
 */
public class ObjectAdapterTest {
    public static void main(String[] args) {
        Target objectAdapter = new ObjectAdapter(new Adaptee());
        objectAdapter.request();
    }
}
