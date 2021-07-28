package cn.feiit.cloud.nacos.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class NacosConfigService {

    @GetMapping("/get")
    public String get(@Value("${test.name}") String name) {
        return name;
    }
}
