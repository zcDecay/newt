package com.newt.pojo.alibaba;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 允许上传的文件类型 及对应的魔数
 * @Author zcc
 * @Date 18/10/22
 */
public class FileTypeMap {
    public static final Map<String, String> map = new HashMap<String, String>(9);

    static {
        map.put("jpeg", "FFD8FF");
        map.put("jpg", "FFD8FFE0");
        map.put("png", "89504E47");
        map.put("wav", "57415645");
        map.put("avi", "41564920");
        map.put("mp4", "00000020667479706D70");
        map.put("mp3", "49443303000000002176");
    }
}
