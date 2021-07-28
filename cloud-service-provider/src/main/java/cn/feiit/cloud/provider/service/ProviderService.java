package cn.feiit.cloud.provider.service;

import cn.feiit.cloud.interfaces.consumer.service.IConsumerService;
import cn.feiit.cloud.interfaces.provider.service.IProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ProviderService implements IProviderService {

    @Autowired
    private IConsumerService consumerService;

    @Override
    public String echo(String str) {
        return "service-provider: ".concat(str);
    }

    @Override
    public String get(String str) {
        return consumerService.echo(str);
    }
}
