package com.wqy.适配器模式.对象适配器模式;

import com.wqy.适配器模式.类适配器模式.Adaptee;
import com.wqy.适配器模式.类适配器模式.Target;

public class ObjectAdapter implements Target {
    private Adaptee adaptee;
    public ObjectAdapter(Adaptee adaptee){
        this.adaptee=adaptee;
    }
    @Override
    public void request() {
        adaptee.specificRequest();
    }
}
