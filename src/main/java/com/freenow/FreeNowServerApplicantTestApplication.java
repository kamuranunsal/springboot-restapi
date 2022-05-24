package com.freenow;

import com.freenow.util.LoggingInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class FreeNowServerApplicantTestApplication implements WebMvcConfigurer
{

    public static void main(String[] args)
    {
        SpringApplication.run(FreeNowServerApplicantTestApplication.class, args);
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        registry.addInterceptor(new LoggingInterceptor()).addPathPatterns("/**");
    }
}
