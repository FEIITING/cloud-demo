package cn.feiit.cloud.consumer.service;

import cn.feiit.cloud.interfaces.consumer.service.IConsumerService;
import cn.feiit.cloud.interfaces.provider.service.IProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ConsumerService implements IConsumerService {

    @Autowired
    private IProviderService providerService;


    @Override
    public String echo(@PathVariable String str) {
        return providerService.echo(str);
//        return restTemplate.getForObject("http://service-provider/provider/echo/" + str, String.class);
    }

}
