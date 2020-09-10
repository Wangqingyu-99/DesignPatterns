package com.wqy.桥接模式;

/**
 * 理解： 两个不同维度的类需要联合 不通过继承的方式联系起来
 *        而是通过组合（类似对象适配器）的方式联系起来
 */
public class Test {
    public static void main(String[] args) {
        RefinedAbstraction refinedAbstraction =
                new RefinedAbstraction(new ConcreteImplementorA());
        refinedAbstraction.Operation();
    }
}
