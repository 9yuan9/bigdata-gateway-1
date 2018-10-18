package com.weein.bigdata.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

@Configuration
@ConditionalOnClass({ JSON.class })
public class FastJsonHttpMessageConvertersConfiguration {
	
	
	
	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverters() {
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();// 2
		fastConverter.setFeatures(SerializerFeature.WriteDateUseDateFormat);
		List<MediaType> supportedMediaTypes = new ArrayList<MediaType>();
		supportedMediaTypes.add(MediaType.TEXT_HTML);//如果不加，则无法识别 
		supportedMediaTypes.add(MediaType.APPLICATION_JSON);
		fastConverter.setSupportedMediaTypes(supportedMediaTypes );
		return new HttpMessageConverters(fastConverter);
	}
}
