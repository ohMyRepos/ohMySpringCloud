package co.zhanglintc.springcloudconsumer.hystrix;

import co.zhanglintc.springcloudconsumer.openfeign.OpenFeignService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class HystirxFallbackFactory implements FallbackFactory {
    @Override
    public Object create(Throwable throwable) {
        return new OpenFeignService() {
            @Override
            public Object openFeignIndex() {
                Map<String, Object> restResult = new LinkedHashMap<>();
                restResult.put("type", "all provider down, hystrix-fallback");
                restResult.put("port", 9002);
                return restResult;
            }
        };
    }
}
