package cn.feiit.cloud.interfaces.config.feign;


import com.netflix.hystrix.exception.HystrixBadRequestException;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;

import java.io.IOException;

/**
 * 自定义异常解析
 */
public class UserErrorDecoder implements ErrorDecoder {

    private static final int HTTP_STATUS_400 = 400;

    /**
     * 异常解析 在 SynchronousMethodHandler 类 134 号调用
     *
     * @param methodKey 方法key
     * @param response  返回对象
     * @return 返回异常
     */
    public Exception decode(String methodKey, Response response) {

        Exception exception = null;
        try {
            String json = Util.toString(response.body().asReader());
            exception = new RuntimeException(json);
            // 这里只封装4开头的请求异常 && response.status() < 500
            if (HTTP_STATUS_400 <= response.status()) {
                exception = new HystrixBadRequestException("请求参数错误：" + Util.toString(response.body().asReader()), exception);
            }
        } catch (IOException ex) {

        }

        return exception;
    }
}
