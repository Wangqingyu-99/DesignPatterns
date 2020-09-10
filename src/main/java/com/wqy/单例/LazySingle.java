package com.wqy.单例;

public class LazySingle {
    private static volatile LazySingle lazySingle = null;

    private LazySingle() {
    }

    public static synchronized LazySingle getInstance() {
        if (lazySingle == null) {
            lazySingle = new LazySingle();
            return lazySingle;
        }
        return lazySingle;
    }
}
