package cn.feiit.cloud.interfaces.provider.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient(name = "service-provider")
@RequestMapping("/provider")
public interface IProviderService {

    @GetMapping("/echo/{str}")
    String echo(@PathVariable("str") String str);

    @GetMapping("/get/{str}")
    String get(@PathVariable("str") String str);

}
