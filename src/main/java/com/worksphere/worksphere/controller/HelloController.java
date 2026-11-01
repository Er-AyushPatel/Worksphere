package com.worksphere.worksphere.controller;

import com.worksphere.worksphere.config.AppMessage;
import com.worksphere.worksphere.service.AppInfoService;
import com.worksphere.worksphere.service.HelloService;
import com.worksphere.worksphere.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final HelloService helloService;
    private final TestService testService;
    private final AppMessage appMessage;
    private final AppInfoService appInfoService;

    public HelloController(
            HelloService helloService,
            TestService testService,
            AppMessage appMessage,
            AppInfoService appInfoService) {

        this.helloService = helloService;
        this.testService = testService;
        this.appMessage = appMessage;
        this.appInfoService = appInfoService;
    }

    @GetMapping("/hello")
    public String bye() {
        return helloService.byeMessage();
    }
    @GetMapping("/test-Service")
    public String testService(){
        return testService.test();
    }
    @GetMapping("/app")
    public String app(){
        return appMessage.getMessage();
    }
    @GetMapping("info")
    public String info(){
        return appInfoService.getInfo();
    }
}