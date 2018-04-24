package com.feign.test.feigntest.feign.controller;

import com.feign.test.feigntest.feign.dto.HeaderReply;
import com.feign.test.feigntest.feign.service.FeignTestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 客户端 class
 *
 * @author junqiang.xiao@hand-china.com
 * @date 2018/4/24
 */
@RestController
public class FeignController {
    @Autowired
    FeignTestClient feignTestClient;

    @RequestMapping("/test")
    public ResponseEntity test() {
        HeaderReply headerReply;
        Date beginDate = new Date();
        System.out.println("begin:" + beginDate);

        for (int i = 0; i < 100000; i++) {
            headerReply = feignTestClient.requestMessage("world:" + i);
            System.out.println("name:" + headerReply.getField3());
        }


        Date endDate = new Date();
        System.out.println("end:" + endDate);

        System.out.println("time:" + (endDate.getTime() - beginDate.getTime()) / 1000 + " s");
        return ResponseEntity.ok().build();
    }
}
