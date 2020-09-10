package com.wqy.适配器模式.类适配器模式;

//类适配器类
class ClassAdapter extends Adaptee implements Target{
    @Override
    public void request() {
        specificRequest();
    }
}