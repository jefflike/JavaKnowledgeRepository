package com.jeffcode.consumerdept8002;

import com.jeffcode.common.MyLoadBalanceConfig;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RibbonClient(name="ribbonClient",configuration= MyLoadBalanceConfig.class)
@EnableFeignClients("com.jeffcode.consumerdept8002.service")
@EnableHystrixDashboard
@EnableTurbine
public class ConsumerDept8002Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerDept8002Application.class, args);
    }

    @Bean
    public ServletRegistrationBean getServlet(){

        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);  //系统启动时加载顺序
        registrationBean.addUrlMappings("/hystrix.stream", "/actuator/hystrix.stream");//路径
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
