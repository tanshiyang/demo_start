package com.example.logging;

import com.example.model.ZGH_User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {

    @RequestMapping("/logging/test")
    public String test_log(){
        log.info("#########  info  #########");

        ZGH_User user = new ZGH_User();
        user.setUserId("PCITTSY");
        user.setUserName("谭世阳");

        return user.toString();
    }
}
