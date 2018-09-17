package com.newt.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Name: PaymentUtil
 * @Description:
 * @Version 1.0
 * @Author: mz
 * @Modified By:
 * @Date: 2018/3/20 8:48
 */
public class HttpRequestUtil {

    // 康宁益生公司id
    public static final String KNYS = "911101083443327541";

    // 默认接口编码格式
    public static final String UTF8 = "UTF-8";

    /**
     * @Description: java模拟request请求
     * @param: url 请求地址
     * @param: map 请求参数
     * @Return: java.lang.String 返回结果（json字串）
     * @Author: mz
     * @Date: 2018/3/20 9:05
     */
    public static String sendRequest(String url, String data) throws Exception {
    	return sendRequest(url, UTF8, data);
    }

    /**
     * @Description: java模拟request请求
     * @param: url 请求地址
     * @param: charset 编码格式
     * @param: map 请求参数
     * @Return: java.lang.String 返回结果（json字串）
     * @Author: mz
     * @Date: 2018/3/20 9:04
     */
    public static String sendRequest(String url, String charset, String data) throws Exception {
        URL httpUrl = new URL(url);
        HttpURLConnection httpURLConnection = (HttpURLConnection) httpUrl.openConnection();
        httpURLConnection.setRequestProperty("Content-Type", "application/Json; charset=UTF-8");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setConnectTimeout(8000);
        httpURLConnection.setReadTimeout(6000);
        httpURLConnection.connect();
        OutputStream outputStream = httpURLConnection.getOutputStream();
        outputStream.write(data.getBytes(charset));

        InputStream inputStream = httpURLConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, charset));
        final StringBuffer stringBuffer = new StringBuffer();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuffer.append(line);
        }
        String form = stringBuffer.toString();
        if (stringBuffer!=null) {
            bufferedReader.close();
        }
        if (inputStream!=null) {
            inputStream.close();
        }
        if (outputStream!=null) {
            outputStream.close();
        }
        return form;
    }
}
