package com.feign.test.feigntest.feign.service;

import com.feign.test.feigntest.feign.dto.HeaderReply;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * feign class
 *
 * @author junqiang.xiao@hand-china.com
 * @date 2018/4/24
 */

@FeignClient("FEIGN-SERVICE2-TEST")
public interface FeignTestClient {
    @RequestMapping(value = "/reply", method = POST)
    HeaderReply requestMessage(@RequestParam("name") String name);
}
