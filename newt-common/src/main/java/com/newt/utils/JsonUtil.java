package com.newt.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.converter.json.MappingJacksonValue;

import java.util.List;

/**
 * @Description: JsonUtil
 * @Author: zcc
 * @Date: 18/09/13
 */
public class JsonUtil {

    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 将对象转换成json字符串。
     */
    public static String objectToJson(Object data) {
        try {
            String string = JSON.toJSONString(data, SerializerFeature.WriteNullListAsEmpty,
                    SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteMapNullValue,
                    SerializerFeature.WriteNullNumberAsZero,
                    SerializerFeature.DisableCircularReferenceDetect);
            return string;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String objectToJsonNonNull(Object data) {
        try {
            String string = JSON.toJSONString(data, SerializerFeature.WriteNullListAsEmpty,
                    SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteMapNullValue,
                    SerializerFeature.WriteNullNumberAsZero);
            return string;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 将json结果集转化为对象
     */
    public static <T> T jsonToPojo(String jsonData, Class<T> beanType) {
        try {
            T t = JSON.parseObject(jsonData, beanType);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将json数据转换成pojo对象list
     */
    public static <T> List<T> jsonToList(String jsonData, Class<T> beanType) {
        JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
        try {

            List<T> list = JSONArray.parseArray(jsonData, beanType);

            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static MappingJacksonValue jsonp(Object value, String callback) {
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(value);
        mappingJacksonValue.setJsonpFunction(callback);
        return mappingJacksonValue;
    }

}
