package com.example.myFirstProject.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JacksonUtil {

//    private static final Logger logger = LoggerFactory.getLogger(JacksonUtil.class);

    private final static ObjectMapper objectMapper = new ObjectMapper();

    static {
        SimpleModule simpleModule = new SimpleModule("SimpleJodaModule", new Version(1, 0, 0, null, null, null));
        simpleModule.addSerializer(new JodaDateSerializer(DateTime.class));
        objectMapper.registerModule(simpleModule);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //是否允许解析使用Java/C++ 样式的注释（包括'/'+'*' 和'//' 变量）
        objectMapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        //设置为true时，属性名称可以不带双引号
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        //是否允许单引号来包住属性名称和字符串值
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        //是否允许JSON字符串包含非引号控制字符（值小于32的ASCII字符，包含制表符和换行符）
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        //是否允许JSON整数以多个0开始
        objectMapper.configure(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS, true);
        objectMapper.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    public static String encode(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
//            logger.error("jackson encode error:", e); //$NON-NLS-1$
        }
        return null;
    }

    /**
     * 将json string反序列化成对象
     *
     * @param json
     * @param valueType
     * @return
     */
    public static <T> T decode(String json, Class<T> valueType) {
        try {
            return objectMapper.readValue(json, valueType);
        } catch (Exception e) {
//            logger.error("jackson decode(String, Class<T>) error: ", e);
        }
        return null;
    }
}
