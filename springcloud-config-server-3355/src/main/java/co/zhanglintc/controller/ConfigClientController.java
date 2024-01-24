package co.zhanglintc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class ConfigClientController {
    // @Value("${spring.application.name}")
    // private String applicationName;

    @RequestMapping("/")
    public Object index() {
        Map<String, Object> restResult = new LinkedHashMap<>();

        restResult.put("applicationName", "applicationName");

        return restResult;
    }
}
