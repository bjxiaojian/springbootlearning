package com.example.myFirstProject.test;


import com.example.myFirstProject.util.JacksonUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import org.joda.time.DateTime;

import java.io.IOException;



/**
 * Created by bjxiaojian on 2016/9/12.
 */
public class Test {
//    public static void main(String[] args) {
//        ObjectMapper mapper = new ObjectMapper();
////        String str = "[{\"label\":\"不投保\",\"value\":-1},{\"label\":\"投保\",\"value\":0}]";
//        String str = "{\"label\":\"不投保\",\"value\":-1}";
//
//        try {
////            JsonNode node = mapper.readValue(str, JsonNode.class);
//            JsonNode node = mapper.readTree(str);
////            ArrayNode arrayNode = mapper.readValue(str, new TypeReference<ArrayNode>(){});
//
////            for(int i=0; i<arrayNode.size(); i++){
////                JsonNode node = arrayNode.get(i);
////                System.out.println(node.get("label").asText());
////
////            }
//            System.out.println(node);
//
//            DateTime d = DateTime.now();
//            System.out.println(JacksonUtil.encode(d));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//    }



}
