package io.microsamples.ws.cxfstarter.config;

import com.holidaywebservice.holidayservice_v2.HolidayService2Soap;
import org.apache.cxf.ext.logging.LoggingInInterceptor;
import org.apache.cxf.ext.logging.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class ClientConfiguration {

    @Bean(name = "holidayServiceProxy")
    public HolidayService2Soap holidayService2Proxy(
            @Value("${client.holidays.address}") String address
    ) {

        JaxWsProxyFactoryBean jaxWsProxyFactoryBean =
                new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setServiceClass(HolidayService2Soap.class);
        jaxWsProxyFactoryBean.setAddress(address);

        jaxWsProxyFactoryBean.getOutInterceptors()
                .add(new LoggingOutInterceptor());

        jaxWsProxyFactoryBean.getOutInterceptors()
                .add(new SoapActionInterceptor());

        jaxWsProxyFactoryBean.getInInterceptors()
                .add(new LoggingInInterceptor());

        jaxWsProxyFactoryBean.setFeatures(Arrays.asList(new PrettyLoggingFeature()));

        return (HolidayService2Soap) jaxWsProxyFactoryBean.create();
    }
}
