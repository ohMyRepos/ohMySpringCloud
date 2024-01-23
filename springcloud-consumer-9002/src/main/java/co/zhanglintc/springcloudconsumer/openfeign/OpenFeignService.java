package co.zhanglintc.springcloudconsumer.openfeign;

import co.zhanglintc.springcloudconsumer.hystrix.HystirxFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "SPRING-CLOUD-PROVIDER", fallbackFactory = HystirxFallbackFactory.class)
public interface OpenFeignService {
    @RequestMapping("/")
    Object openFeignIndex();
}
