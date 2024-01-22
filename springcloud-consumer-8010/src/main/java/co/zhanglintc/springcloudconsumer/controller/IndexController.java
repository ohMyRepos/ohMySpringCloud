package co.zhanglintc.springcloudconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class IndexController {

    // private static final String PROVIDER_BASE_URL = "http://localhost:8001";
    private static final String PROVIDER_BASE_URL = "http://SPRING-CLOUD-PROVIDER-8001";

    @Autowired
    private RestTemplate restTemplateLB;

    @RequestMapping("/")
    public Object index() {
        Map<String, Object> restResult = new LinkedHashMap<>();

        Object provider = restTemplateLB.getForObject(PROVIDER_BASE_URL + "/", Object.class);
        restResult.put("provider", provider);

        RestTemplate mmrzTemplate = new RestTemplate();
        Object randomWords = mmrzTemplate.getForObject(
                "https://mmrz.zhanglintc.co/api/v1/misc/random_words?limit=3",
                Object.class
        );
        restResult.put("randomWords", randomWords);

        return  restResult;
    }
}
