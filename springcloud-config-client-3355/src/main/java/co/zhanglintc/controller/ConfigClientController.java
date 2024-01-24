package co.zhanglintc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RefreshScope
@RestController
public class ConfigClientController {
    @Value("${server.port}")
    private String serverPort;

    @Value("${spring.application.name}")
    private String applicationName;

    @Autowired
    private Environment env;

    @RequestMapping("/")
    public Object index() {
        Map<String, Object> restResult = new LinkedHashMap<>();

        restResult.put("serverPort", serverPort);
        restResult.put("applicationName", applicationName);
        restResult.put("spring.cloud.config.uri", env.getProperty("spring.cloud.config.uri"));
        restResult.put("defaultValue", env.getProperty("notExist", "someDefaultValue"));

        return restResult;
    }
}