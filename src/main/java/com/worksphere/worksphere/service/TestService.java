package com.worksphere.worksphere.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    public TestService() {
        System.out.println("1. Constructor called");
    }

    @PostConstruct
    public void init() {
        System.out.println("2. Bean initialized");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("3. Bean destroyed");
    }
    public String test() {
        return "TestService is working!";
    }
}