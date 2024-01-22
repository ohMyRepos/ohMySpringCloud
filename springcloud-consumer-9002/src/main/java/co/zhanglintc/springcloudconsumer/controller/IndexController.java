package co.zhanglintc.springcloudconsumer.controller;

import co.zhanglintc.springcloudconsumer.openfeign.OpenFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class IndexController {
    @Autowired
    OpenFeignService openFeignService;

    @RequestMapping("/")
    public Object index() {
        Map<String, Object> restResult = new LinkedHashMap<>();

        restResult.put("type", "openfeign");
        restResult.put("port", 9002);

        Object provider = openFeignService.openFeignIndex();
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
