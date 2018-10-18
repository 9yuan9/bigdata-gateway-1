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

import com.weein.bigdata.interceptor.InterfaceInterceptor;
import com.weein.bigdata.interceptor.MyInterfaceInterceptor;
import com.weein.bigdata.interceptor.ThirdPartyBindInterfaceInterceptor;

@Configuration
@EnableConfigurationProperties(ServerProperties.class)
public class SpringBootWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {

	@Resource
	private ServerProperties serverProperties;
	@Resource
	private InterfaceInterceptor interfaceInterceptor;
	/*@Resource
	private MyInterfaceInterceptor myInterfaceInterceptor;
	@Resource
	private ThirdPartyBindInterfaceInterceptor thirdPartyBindInterfaceInterceptor;*/
	
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
	
	@Bean
	public InterfaceInterceptor interfaceInterceptor(){
		return new InterfaceInterceptor();
	}
	@Bean
	public MyInterfaceInterceptor myInterfaceInterceptor(){
		return new MyInterfaceInterceptor();
	}
	@Bean
	public ThirdPartyBindInterfaceInterceptor thirdPartyBindInterfaceInterceptor(){
		return new ThirdPartyBindInterfaceInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(interfaceInterceptor).addPathPatterns("/**").excludePathPatterns("/v1/user/login.do").excludePathPatterns("/v1/user/login2.do").excludePathPatterns("/").excludePathPatterns("/wxxcl/api/*").excludePathPatterns("/v1/ptest/*").excludePathPatterns("/v1/group/getCaptainPic.do").excludePathPatterns("/v1/group/setBanner.do").excludePathPatterns("/v1/group/getActivityRule.do")
		.excludePathPatterns("/v1/record/*").excludePathPatterns("/v1/heartcard/*").excludePathPatterns("/v1/activityRule/*").excludePathPatterns("/v1/directcharge/*").excludePathPatterns("/v1/template/newformid.do")
		.excludePathPatterns("/v1/group/getBannerRecord.do").excludePathPatterns("/v1/mp/*").excludePathPatterns("/v1/group/updateClickStatus.do").excludePathPatterns("/v1/view/*").excludePathPatterns("/billRecord/*").excludePathPatterns("/v2/user/getVersion.do").excludePathPatterns("/v1/customerservice/*").excludePathPatterns("/v1/myuser/*").excludePathPatterns("/v1/integral/*").excludePathPatterns("/v1/WxBook/*")
		.excludePathPatterns("/v1/product/*").excludePathPatterns("/v1/order/*")
		.excludePathPatterns("/v1/preferential/*").excludePathPatterns("/v1/UserPortrait/*");
		
		/*registry.addInterceptor(myInterfaceInterceptor).addPathPatterns("/v1/preferential/*").addPathPatterns("/v1/gift/*").addPathPatterns("/v1/mycoupon/*").addPathPatterns("/v1/customerservice/*").addPathPatterns("/v1/order/*").addPathPatterns("/v1/product/*").addPathPatterns("/v1/myuser/*").addPathPatterns("/v1/template/newformid.do")
		.addPathPatterns("/v1/wxcard/*")
		.excludePathPatterns("/v1/myuser/login.do")
		.excludePathPatterns("/v1/myuser/isShow.do").excludePathPatterns("/v1/myuser/thirdPartyBinding.do").excludePathPatterns("/v1/WxBook/importCodeList.do").excludePathPatterns("/v1/WxBook/wxBookCodeSettingCache.do").excludePathPatterns("/v1/product/payNotify.do").excludePathPatterns("/v1/product/recharge3Notify.do").excludePathPatterns("/v1/product/telAttribution.do");
		
		registry.addInterceptor(thirdPartyBindInterfaceInterceptor).addPathPatterns("/v1/integral/*").addPathPatterns("/v1/myuser/thirdPartyBinding.do").addPathPatterns("/v1/WxBook/*").excludePathPatterns("/v1/integral/getExchaneReward.do").excludePathPatterns("/v1/integral/getWheelIndex.do").excludePathPatterns("/v1/WxBook/importCodeList.do").excludePathPatterns("/v1/WxBook/wxBookCodeSettingCache.do").excludePathPatterns("/v1/WxBook/getWxBookCodeByThird.do");
		*/
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
