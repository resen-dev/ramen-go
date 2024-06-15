package com.redventures.ramengo.config.security;

import com.redventures.ramengo.config.security.interceptor.ApiKeyFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    @Value("${api.key.value}")
    private String API_KEY_VALUE;
    @Value("${api.key.header}")
    private String API_KEY_HEADER;

    @Bean
    public FilterRegistrationBean<ApiKeyFilter> apiKeyFilter() {
        FilterRegistrationBean<ApiKeyFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new ApiKeyFilter(API_KEY_VALUE, API_KEY_HEADER));
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
}
