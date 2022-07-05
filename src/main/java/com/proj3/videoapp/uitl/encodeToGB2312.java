package com.proj3.videoapp.uitl;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class encodeToGB2312 {

    public String ToGB2312(String url) throws UnsupportedEncodingException {
        url = URLEncoder.encode(url, "UTF-8");
        System.out.println("编码后：" + url);
        return  url;
    }


}
