package com.weein.bigdata.core.utils;
//package com.weein.wxxcl.core.utils;
//
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.net.SocketTimeoutException;
//import java.security.KeyManagementException;
//import java.security.KeyStore;
//import java.security.KeyStoreException;
//import java.security.NoSuchAlgorithmException;
//import java.security.UnrecoverableKeyException;
//import java.security.cert.CertificateException;
//
//import javax.net.ssl.SSLContext;
//
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.config.RequestConfig;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.conn.ConnectTimeoutException;
//import org.apache.http.conn.ConnectionPoolTimeoutException;
//import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
//import org.apache.http.conn.ssl.SSLContexts;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.util.EntityUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.gxcode.mp.account.base.contants.MpAccountContants;
//import com.gxcode.mp.account.base.entity.MpAccountDO;
//import com.weein.common.utils.Des3Util;
//
//
//public class HttpWxPayUtils {
//	private static final Logger LOG = LoggerFactory.getLogger(HttpWxPayUtils.class);
//
////    public interface ResultListener {
////
////
////        public void onConnectionPoolTimeoutError();
////
////    }
//
//
//    //表示请求器是否已经做了初始化工作
//    private static boolean hasInit = false;
//
//    //连接超时时间，默认10秒
//    private static int socketTimeout = 10000;
//
//    //传输超时时间，默认30秒
//    private static int connectTimeout = 30000;
//
//    //请求器的配置
//    private static RequestConfig requestConfig;
//
//    //HTTP请求器
//    private static CloseableHttpClient httpClient;
//
//
//    private static void init(){
//
//        KeyStore keyStore;
//		try {
//			keyStore = KeyStore.getInstance("PKCS12");
//		
//	        FileInputStream instream = new FileInputStream(new File("/data/project/pass/apiclient_cert.p12"));//加载本地的证书进行https加密传输
//	        try {
//	            keyStore.load(instream, Des3Util.decryptDES(mpAccountDO.getMchIdDes(), MpAccountContants.MP_DES_KEY).toCharArray()/*Configure.getCertPassword().toCharArray()*/);//设置证书密码
//	        } catch (CertificateException e) {
//	            e.printStackTrace();
//	        } catch (NoSuchAlgorithmException e) {
//	            e.printStackTrace();
//	        } finally {
//	            instream.close();
//	        }
//	
//	        // Trust own CA and all self-signed certs
//	        SSLContext sslcontext = SSLContexts.custom()
//	                .loadKeyMaterial(keyStore, Des3Util.decryptDES(mpAccountDO.getMchIdDes(), MpAccountContants.MP_DES_KEY).toCharArray()/*Configure.getCertPassword().toCharArray()*/)
//	                .build();
//	        // Allow TLSv1 protocol only
//	        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
//	                sslcontext,
//	                new String[]{"TLSv1"},
//	                null,
//	                SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
//	
//	        httpClient = HttpClients.custom()
//	                .setSSLSocketFactory(sslsf)
//	                .build();
//	
//	        //根据默认超时限制初始化requestConfig
//	        requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectTimeout).build();
//	
//	        hasInit = true;
//		} catch (KeyStoreException  | IOException | KeyManagementException | UnrecoverableKeyException | NoSuchAlgorithmException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//    }
//
//    /**
//     * 通过Https往API post xml数据
//     *
//     * @param url    API地址
//     * @param xmlObj 要提交的XML数据对象
//     * @return API回包的实际数据
//     * @throws IOException
//     * @throws KeyStoreException
//     * @throws UnrecoverableKeyException
//     * @throws NoSuchAlgorithmException
//     * @throws KeyManagementException
//     */
//
//    public static String sendPost(String url, String postDataXML) {
//
//        if (!hasInit) {
//            init();
//        }
//
//        String result = null;
//
//        HttpPost httpPost = new HttpPost(url);
//
//        //得指明使用UTF-8编码，否则到API服务器XML的中文不能被成功识别
//        StringEntity postEntity = new StringEntity(postDataXML, "UTF-8");
//        httpPost.addHeader("Content-Type", "text/xml");
//        httpPost.setEntity(postEntity);
//
//        //设置请求器的配置
//        httpPost.setConfig(requestConfig);
//
//
//        try {
//            HttpResponse response = httpClient.execute(httpPost);
//
//            HttpEntity entity = response.getEntity();
//
//            result = EntityUtils.toString(entity, "UTF-8");
//
//        } catch (ConnectionPoolTimeoutException e) {
//        	e.printStackTrace();
//        } catch (ConnectTimeoutException e) {
//        	e.printStackTrace();
//        } catch (SocketTimeoutException e) {
//        	e.printStackTrace();
//        } catch (Exception e) {
//        	e.printStackTrace();
//        } finally {
//            httpPost.abort();
//        }
//
//        return result;
//    }
//
//    /**
//     * 设置连接超时时间
//     *
//     * @param socketTimeout 连接时长，默认10秒
//     */
//    public void setSocketTimeout(int socketTimeout) {
//        socketTimeout = socketTimeout;
//        resetRequestConfig();
//    }
//
//    /**
//     * 设置传输超时时间
//     *
//     * @param connectTimeout 传输时长，默认30秒
//     */
//    public void setConnectTimeout(int connectTimeout) {
//        connectTimeout = connectTimeout;
//        resetRequestConfig();
//    }
//
//    private void resetRequestConfig(){
//        requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectTimeout).build();
//    }
//
//    /**
//     * 允许商户自己做更高级更复杂的请求器配置
//     *
//     * @param requestConfig 设置HttpsRequest的请求器配置
//     */
//    public void setRequestConfig(RequestConfig requestConfig) {
//        requestConfig = requestConfig;
//    }
//}
