package com.wqy.代理模式;

/**
 * 代理对象
 */
public class Proxy implements Specialty {
    private Specialty ms = new MsSpecialty();

    @Override
    public void display() {
        pro();
        ms.display();
        post();
    }

    public void pro() {
        System.out.println("代理开始《《《《《《");
    }

    public void post() {
        System.out.println("》》》》》》代理结束");
    }
}
