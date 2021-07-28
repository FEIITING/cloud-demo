package cn.feiit.cloud.interfaces.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/consumer")
@FeignClient(name = "service-consumer")
public interface IConsumerService {

    @GetMapping("/echo/{str}")
    String echo(@PathVariable("str") String str);

}
