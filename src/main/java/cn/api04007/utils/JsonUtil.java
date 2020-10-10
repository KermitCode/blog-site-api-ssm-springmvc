package cn.api04007.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SuppressWarnings("unchecked")
public class JsonUtil {

    public static ObjectMapper mapper;
    public static Date nowDate;

    static{
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        nowDate = new Date();
    }

    //取得当前时间，格式 yyyy-MM-dd HH:mm:ss.SS
    public static String getDateString(){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate= sdf.format(nowDate);
        return strDate;
    }

    //返回json字符串
    public static String getJson(HashMap hashMap) {

        String string = null;

        String uuid = UUID.randomUUID().toString().replace("-","");
        hashMap.put("requestId", uuid);
        hashMap.put("requestTime", getDateString());

        try {
            string = mapper.writeValueAsString(hashMap);
        }catch (JsonProcessingException e) {
            System.out.println("json write failed.");
            e.printStackTrace();
        }

        return string;
    }

    //响应一个成功的json结果
    public static String jsonOk(HashMap hashMap) {

        HashMap result = new HashMap<>();
        result.put("code", 200 );
        result.put("msg", "ok");
        result.put("data", hashMap);

        return getJson(result);
    }

    //重载响应一个失败的json结果，可设置code码
    public static String jsonError(String msg){
        return jsonError(msg, 500);
    }

    //实现一个响应失败的json结果
    public static String jsonError(String msg, Integer code){
        HashMap result = new HashMap<>();
        result.put("code", code );
        result.put("msg", msg);
        result.put("data", new HashMap<>());
        return getJson(result);
    }
}
