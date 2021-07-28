package cn.feiit.cloud.interfaces.config.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

/**
 * @ClassName FeignRequestInterceptor
 * @Description TODO feign 调用拦截器
 * @Author wuxw
 * @Date 2020/7/5 22:44
 * @Version 1.0
 * add by wuxw 2020/7/5
 **/
@Configuration
public class FeignRequestInterceptor implements RequestInterceptor {


    /**
     * 传入事务ID
     *
     * @param requestTemplate
     */
    @Override
    public void apply(RequestTemplate requestTemplate) {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        //logger.info("feign 拦截器header设置：" + JSON.toJSONString(ReactiveRequestContextHolder.entries()));
        if (attributes == null) {
            requestTemplate.header("APP-ID", "APP-ID");
            return;
        }
        HttpServletRequest request = attributes.getRequest();
        Enumeration<String> headerNames = request.getHeaderNames();
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String name = headerNames.nextElement();
                String values = request.getHeader(name);
                requestTemplate.header(name, values);
            }
        }
    }


    private static String DATE_FORMAT = "yyyyMMddHHmmss";

    public static String getCurrentDatetime() {
        return new SimpleDateFormat(DATE_FORMAT).format(new Date());
    }
}
