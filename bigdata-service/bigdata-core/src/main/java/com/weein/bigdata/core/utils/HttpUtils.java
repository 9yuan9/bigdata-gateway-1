package com.weein.bigdata.core.utils;

import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.weein.bigdata.base.vo.result.Result;


public class HttpUtils {
	
	private static final Logger LOG = LoggerFactory.getLogger(HttpUtils.class);
	private static RequestConfig requestConfig;
	static {
		requestConfig = RequestConfig.custom().setConnectTimeout(20000).setSocketTimeout(20000)
				.setConnectionRequestTimeout(20000).build();
		// {
		// this.staleConnectionCheckEnabled = false;
		// this.redirectsEnabled = true;
		// this.maxRedirects = 50;
		// this.relativeRedirectsAllowed = true;
		// this.authenticationEnabled = true;
		// this.connectionRequestTimeout = -1;
		// this.connectTimeout = -1;
		// this.socketTimeout = -1;
		// this.contentCompressionEnabled = true;
		// }
	}
	public static Result<String> sendUnicomPost(String url,Header[] headers,String body){
		Result<String>  result = new Result<String>();
		CloseableHttpClient httpClient = createHttpClient();
		HttpPost httpPost = new HttpPost(url);
		httpPost.setConfig(requestConfig);
		httpPost.setHeaders(headers);
		StringEntity entity = new StringEntity(body, "utf-8");
    	entity.setContentEncoding("UTF-8");
    	entity.setContentType("application/json");
		httpPost.setEntity(entity);
		try {
			CloseableHttpResponse response = httpClient.execute(httpPost);
			try {
				//System.out.println(response.getStatusLine());
				if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
					HttpEntity responseEntity = response.getEntity();
					if (responseEntity != null) {
						String responseString = EntityUtils.toString(responseEntity,"UTF-8");
						EntityUtils.consume(responseEntity);
						result.setBody(responseString);
						result.setSuccess(true);
						return result;
					}
				}else{
					result.setErrCode(response.getStatusLine().getStatusCode()+"");
					LOG.error("post 错误 url:"+url+",body:"+body+",status:"+response.getStatusLine().getStatusCode() );
				}
			}
			catch (Exception e) {
				result.setErrCode("500");
				LOG.error("post 错误 url:"+url+",body:"+body,e);
			}
			finally {
				response.close();
			}
		} catch (IOException e) {
			LOG.error("post 错误 url:"+url+",body:"+body,e);
			result.setErrCode("500");
		}finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				LOG.error("httpClient.close 错误 url:"+url+",body:"+body,e);
			}
		}
		return result;
	}
	
	private static CloseableHttpClient createHttpClient(){
    	CloseableHttpClient httpClient = HttpClients.createDefault();
//    	httpclient.getParams().setIntParameter(CoreConnectionPNames.SO_TIMEOUT, 20000);  
//    	httpclient.getParams().setIntParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 20000); 
    	return httpClient;
    }
}
