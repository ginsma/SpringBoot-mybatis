package com.gin.controller;

import com.gin.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Jean on 2018/8/1.
 */
@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @Value("${cupSize}")
    private  String cupSize;

    @Value("${age}")
    private Integer age;

    @Value(("{content}"))
    private String content;

    @Autowired
    private GirlProperties grilProperties;

    //这边是使用http://localhost:8081/hello/hello/3
    @RequestMapping(value = {"/hello/{id}", "/hi"}, method = RequestMethod.GET)
    public String say(@PathVariable("id") Integer id) {
       String cupSize = grilProperties.getCupSize();
       String idString = String.valueOf(id);
       return "sss";
    }

    //这边是使用http://localhost:8081/hello/hello?id=1
    @RequestMapping(value = {"/hello1/{id}", "/hi1"}, method = RequestMethod.GET)
    public String say1(@RequestParam("id") Integer id) {
        String cupSize = grilProperties.getCupSize();
        String idString = String.valueOf(id);
        return "sss";
    }

    //这边是表示非必需，默认值为0
    @RequestMapping(value = {"/hello2/{id}", "/hi2"}, method = RequestMethod.GET)
    public String say2(@RequestParam(value = "id", required = false , defaultValue = "0") Integer id) {
        String cupSize = grilProperties.getCupSize();
        String idString = String.valueOf(id);
        return "sss";
    }

    //这边是表示简化写法
    @GetMapping(value = {"/hello3/{id}", "/hi3"})
    public String say3(@RequestParam(value = "id", required = false , defaultValue = "0") Integer id) {
        String cupSize = grilProperties.getCupSize();
        String idString = String.valueOf(id);
        return "sss";
    }

}

