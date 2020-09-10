package com.wqy.ufq;

public class Test {
    public static void main(String[] args) {
        String sp = "";
        String cs = "";
        int i = 0;
        while (i<20){
            if (!"".equals(sp)) {
                sp += ",";
            }
            sp += "'" + i++ + "'";

            if (!"".equals(cs)) {
                cs += ",";
            }
            cs += "'" + i++ + "'";
        }
        System.out.println(sp);
        System.out.println(cs);
    }
}
