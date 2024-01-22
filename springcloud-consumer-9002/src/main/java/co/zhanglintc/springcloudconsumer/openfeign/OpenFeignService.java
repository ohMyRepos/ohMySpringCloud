package co.zhanglintc.springcloudconsumer.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "SPRING-CLOUD-PROVIDER")
public interface OpenFeignService {
    @RequestMapping("/")
    Object openFeignIndex();
}
