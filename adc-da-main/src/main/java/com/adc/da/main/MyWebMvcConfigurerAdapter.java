package com.adc.da.main;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Auther: XWB
 * @Date: 2018/11/12 14:29
 * @Description:
 */

@Configuration
public class MyWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        //指向外部目录
        registry.addResourceHandler("File//**").addResourceLocations("file:///E:/CodeFarmer/adc-da-main/target/classes/File/");
        super.addResourceHandlers(registry);
    }
}
