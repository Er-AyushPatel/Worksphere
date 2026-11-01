package com.worksphere.worksphere.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public HelloService() {
        System.out.println("HelloService object created");
    }
    public String byeMessage() {
        return "BYE from WorkSphere Service!";
    }
}