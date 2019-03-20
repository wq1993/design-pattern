package com.proxy.pattern.dbroute.staticproxy;

/**
 * Created by wq on 2019/3/19
 */
public class DataSourceContextHolder {

    private final static String DEFAULT = null;

    private static final ThreadLocal<String> LOCAL = new ThreadLocal<String>();

    private DataSourceContextHolder() {
    }

    public static String get() {
        return LOCAL.get();
    }

    public static void setLocal(String source) {
        LOCAL.set(source);
    }

    public static void setLocal(Integer year) {
        LOCAL.set("DB_" + year);
    }

    public static void reStore() {
        LOCAL.set(DEFAULT);
    }
}
