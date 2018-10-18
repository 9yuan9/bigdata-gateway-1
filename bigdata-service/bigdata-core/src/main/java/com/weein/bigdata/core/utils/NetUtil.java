package com.weein.bigdata.core.utils;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;
@Service
public class NetUtil {
	/**
	 * 想外网发送get请求
	 * 返回字符串类型
	 * @param url
	 * @return
	 */
	public static String get(String url){
		//获得http客户端访问
		HttpClient client = HttpClients.createDefault();
		//发送get请求
		HttpGet get = new HttpGet(url);
		//用response接收返回结果
		HttpResponse response = null;
		//用entity接收返回结果的实体
		HttpEntity entity = null;
		try {
			//执行get 并且获取到response
			response = client.execute(get);
			//将实体接收到并转成string类型返回
			entity = response.getEntity();
			return EntityUtils.toString(entity);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 向外网发送post请求
	 * 返回字符串类型
	 * @param url
	 * @param stringEntity
	 * @return
	 */
	public static String post(String url,String stringEntity){
		HttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		HttpResponse response = null;
		HttpEntity entity = null;
		post.addHeader("content-type","application/json");
		
		try {
			post.setEntity(new StringEntity(stringEntity));
			response = client.execute(post);
			entity = response.getEntity();
			return EntityUtils.toString(entity);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
