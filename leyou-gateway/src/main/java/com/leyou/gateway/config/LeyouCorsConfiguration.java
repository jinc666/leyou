package com.leyou.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class LeyouCorsConfiguration {

    @Bean
    public CorsFilter corsFilter() {
        //初始化cors配置对象
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //1) 允许的域,不要写*，否则cookie就无法使用了
        corsConfiguration.addAllowedOrigin("http://manage.leyou.com");
        //2) 是否发送Cookie信息
        corsConfiguration.setAllowCredentials(true);
        //3) 允许的请求方式
/*        corsConfiguration.addAllowedMethod("OPTIONS");
        corsConfiguration.addAllowedMethod("HEAD");
        corsConfiguration.addAllowedMethod("GET");
        corsConfiguration.addAllowedMethod("PUT");
        corsConfiguration.addAllowedMethod("POST");
        corsConfiguration.addAllowedMethod("DELETE");
        corsConfiguration.addAllowedMethod("PATCH");*/
        corsConfiguration.addAllowedMethod("*");
        // 4）允许的头信息
        corsConfiguration.addAllowedHeader("*");

        String hhh = null;
        //初始化cors配置源
        UrlBasedCorsConfigurationSource urlBase = new UrlBasedCorsConfigurationSource();
        urlBase.registerCorsConfiguration("/**", corsConfiguration);
        //返回corsFilters实例，参数；cors配置源对象
        return new CorsFilter(urlBase);

    }
}
