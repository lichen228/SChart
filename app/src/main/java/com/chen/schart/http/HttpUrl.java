package com.chen.schart.http;

import com.chen.schart.BuildConfig;

/**
 * Created by lichen on 2017/11/29.
 */

public class HttpUrl {
    public static final String DEBUG_URL = "http://stock.api51.cn";
    public static final String RELEASE_URL = "http://stock.api51.cn";

    public static String getBaseUrl() {
        if (BuildConfig.BUILD_TYPE.equals("debug")) {
            return DEBUG_URL;
        }
        return RELEASE_URL;
    }
}
