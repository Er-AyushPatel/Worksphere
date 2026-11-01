package com.worksphere.worksphere.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AppInfoService {
    @Value("${app.name}")
    private String appName;

    @Value("${app.environment}")
    private String environment;

    @Value("${app.version}")
    private String appVersion;

    public String getInfo() {
        return appName + " - Version "
                + appVersion
                + " - Environment: "
                + environment;
    }
}
