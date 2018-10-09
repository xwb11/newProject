package com.adc.da;

import java.util.concurrent.TimeUnit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

//import com.codahale.metrics.CsvReporter;

@SpringBootApplication
@ServletComponentScan
public class AdcDaApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(AdcDaApplication.class, args);

		// 启动Metrics 性能监控报表
//		CsvReporter reporter = applicationContext.getBean(CsvReporter.class);
//		reporter.start(1, TimeUnit.MINUTES);
	}

	/**
	 * 设定容器的session失效时间，默认30分
	 */
	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer(){
		return new EmbeddedServletContainerCustomizer() {
			@Override
			public void customize(ConfigurableEmbeddedServletContainer container) {
				container.setSessionTimeout(1800);//单位为S
                //container.setPort(9999);
			}
		};
	}
}