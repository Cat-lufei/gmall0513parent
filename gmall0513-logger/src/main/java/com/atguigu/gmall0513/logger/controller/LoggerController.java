package com.atguigu.gmall0513.logger.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.atguigu.gmall0513.common.constant.GmallConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by LuFei on 2019/10/18
 * Author: LuFei
 */
@Controller
@Slf4j
public class LoggerController {


    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;


   @PostMapping  ("/log")
    public String log(@RequestParam("logString")String logString){


       JSONObject jsonObject = JSON.parseObject(logString);
       jsonObject.put("ts",System.currentTimeMillis());
       log.info(logString);
       if("startup".equals(jsonObject.get("type"))){

           kafkaTemplate.send(GmallConstant.KAFKA_STARTUP,jsonObject.toJSONString());
       }else{
           kafkaTemplate.send(GmallConstant.KAFKA_EVENT,jsonObject.toJSONString());
       }
      // System.out.println(logString);
       return "success";
   }

}
