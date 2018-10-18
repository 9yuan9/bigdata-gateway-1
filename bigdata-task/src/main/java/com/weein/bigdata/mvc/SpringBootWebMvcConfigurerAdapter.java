package com.weein.bigdata.mvc;

import java.nio.charset.Charset;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableConfigurationProperties(ServerProperties.class)
public class SpringBootWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {

	@Resource
	private ServerProperties serverProperties;
	
	@Override
	public void configureMessageConverters(
			List<HttpMessageConverter<?>> converters) {
		converters.add(0,new StringHttpMessageConverter(Charset.forName("UTF-8")));
		super.configureMessageConverters(converters);
	}
	
//	@Bean
//	public CustomMultipartResolver customMultipartResolver(MultipartConfigElement multipartConfigElement) {
//		CustomMultipartResolver customMultipartResolver = new CustomMultipartResolver();
//		customMultipartResolver.setMaxUploadSize(multipartConfigElement.getMaxFileSize());
//		customMultipartResolver.setMaxInMemorySize((int)multipartConfigElement.getMaxRequestSize());
//		return customMultipartResolver;
//	}
	
	
	

	@Override
	public void addInterceptors(InterceptorRegistry registry) {


		super.addInterceptors(registry);
	}
	

	@Bean
	public ServletRegistrationBean dispatcherRegistration(
			DispatcherServlet dispatcherServlet) {
		ServletRegistrationBean registration = new ServletRegistrationBean(
				dispatcherServlet);
//		 registration.addUrlMappings("*.do");
		return registration;
	}
}
