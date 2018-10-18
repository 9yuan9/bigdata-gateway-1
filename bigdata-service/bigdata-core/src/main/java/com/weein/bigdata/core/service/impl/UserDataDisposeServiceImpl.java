package com.weein.bigdata.core.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.weein.bigdata.core.configuration.BigDataJDBCProperties;
import com.weein.bigdata.core.service.UserDataDisposeService;
import com.weein.bigdata.core.utils.JdbcUtils;

@Service
public class UserDataDisposeServiceImpl implements UserDataDisposeService{
	private static final Logger LOG = LoggerFactory.getLogger(UserDataDisposeServiceImpl.class);
	
	@Resource
	private BigDataJDBCProperties bigDataJDBCProperties;
	
	@Override
	public List<List<String>> getUserData1(String phone) {
		String driver = bigDataJDBCProperties.getDriver();
        String url = bigDataJDBCProperties.getUrl();
        String user = bigDataJDBCProperties.getUser();
        String password = bigDataJDBCProperties.getPassword();
        String sql = "SELECT * FROM WEEINTEST.T_USER_TEST where phone ='"+phone+"'";
         
        int timeout = 5; //秒.  
        ExecutorService executor = Executors.newSingleThreadExecutor();  
        List<List<String>> result = null;     
        Future<List<List<String>>> future = executor.submit(new MyJob(driver,url,user,password,sql));// 将任务提交到线程池中     
        try {     
            result = future.get(timeout*1000, TimeUnit.MILLISECONDS);// 设定在200毫秒的时间内完成   
            System.out.println(result);  
            LOG.info("[查询用户数据结果:{}", new Object[] { result });
            return result;
        } catch (InterruptedException e) {  
            System.out.println("线程中断出错。");  
            future.cancel(true);// 中断执行此任务的线程    
            LOG.error("[发生线程中断出错异常:{}", new Object[] { e });
            return null;
        } catch (ExecutionException e) {     
            System.out.println("线程服务出错。");  
            future.cancel(true);// 中断执行此任务的线程 
            LOG.error("[发生线程服务出错异常:{}", new Object[] { e });
            return null;
        } catch (TimeoutException e) {// 超时异常     
            System.out.println("超时。");     
            future.cancel(true);// 中断执行此任务的线程 
            LOG.error("[发生超时异常:{}", new Object[] { e });
            return null;
        }finally{  
            System.out.println("线程服务关闭。");  
            LOG.error("[线程服务关闭");
            executor.shutdown();  
        }  
        
        
        /*String driver = bigDataJDBCProperties.getDriver();
        String url = bigDataJDBCProperties.getUrl();
        String user = bigDataJDBCProperties.getUser();
        String password = bigDataJDBCProperties.getPassword();
		Properties properties = new Properties();
        properties.setProperty("driver", driver);
        properties.setProperty("url", url);
        properties.setProperty("user", user);
        properties.setProperty("password", password);
        List<List<String>> resultList = null;
        String sql = "SELECT * FROM WEEINTEST.T_USER_TEST where phone ='"+phone+"'";
        
        try {
        	resultList = JdbcUtils.readFirstRows(driver, url, properties, sql, 5);
        	LOG.info("[查询用户数据结果:{}", new Object[] { resultList });
        	return resultList;
        }catch (Exception e) {
        	LOG.error("[发生异常:{}", new Object[] { e });
        	return null;
		}*/
	}
	
	@Override
	public List<List<String>> getUserData2(String openId) {
		String driver = bigDataJDBCProperties.getDriver();
        String url = bigDataJDBCProperties.getUrl();
        String user = bigDataJDBCProperties.getUser();
        String password = bigDataJDBCProperties.getPassword();
        String sql = "SELECT * FROM WEEINTEST.T_USER_TEST where open_id ='"+openId+"'";
        
        int timeout = 5; //秒.  
        ExecutorService executor = Executors.newSingleThreadExecutor();  
        List<List<String>> result = null;     
        Future<List<List<String>>> future = executor.submit(new MyJob(driver,url,user,password,sql));// 将任务提交到线程池中     
        try {     
            result = future.get(timeout*1000, TimeUnit.MILLISECONDS);// 设定在200毫秒的时间内完成   
            System.out.println(result);  
            LOG.info("[查询用户数据结果:{}", new Object[] { result });
            return result;
        } catch (InterruptedException e) {  
            System.out.println("线程中断出错。");  
            future.cancel(true);// 中断执行此任务的线程    
            LOG.error("[发生线程中断出错异常:{}", new Object[] { e });
            return null;
        } catch (ExecutionException e) {     
            System.out.println("线程服务出错。");  
            future.cancel(true);// 中断执行此任务的线程 
            LOG.error("[发生线程服务出错异常:{}", new Object[] { e });
            return null;
        } catch (TimeoutException e) {// 超时异常     
            System.out.println("超时。");     
            future.cancel(true);// 中断执行此任务的线程 
            LOG.error("[发生超时异常:{}", new Object[] { e });
            return null;
        }finally{  
            System.out.println("线程服务关闭。");  
            LOG.error("[线程服务关闭");
            executor.shutdown();  
        } 
        
		
		/*String driver = bigDataJDBCProperties.getDriver();
        String url = bigDataJDBCProperties.getUrl();
        String user = bigDataJDBCProperties.getUser();
        String password = bigDataJDBCProperties.getPassword();
		Properties properties = new Properties();
        properties.setProperty("driver", driver);
        properties.setProperty("url", url);
        properties.setProperty("user", user);
        properties.setProperty("password", password);
        List<List<String>> resultList = null;
        String sql = "SELECT * FROM WEEINTEST.T_USER_TEST where open_id ='"+openId+"'";
        
        try {
        	resultList = JdbcUtils.readFirstRows(driver, url, properties, sql, 5);
        	LOG.info("[查询用户数据结果:{}", new Object[] { resultList });
        	return resultList;
        }catch (Exception e) {
        	LOG.error("[发生异常:{}", new Object[] { e });
        	return null;
		}*/
        
        
        
	}
	
	
	static class MyJob implements Callable<List<List<String>>> {   
		private String driver;
		private String url;
		private String user;
		private String password;
        private String sql;  
        public MyJob(String driver,String url,String user,String password,String sql){  
        	this.driver= driver;
        	this.url= url;
        	this.user= user;
        	this.password= password;
            this.sql= sql;  
        }  
        public List<List<String>> call() { 
        	List<List<String>> result = null;
        	if (Thread.interrupted()){ //很重要  
                return null;     
            } 
        	if (Thread.currentThread().isInterrupted()){ //很重要  
        		System.out.println("线程被打断");
                return null;     
            }  
        	Properties properties = new Properties();
        	properties.setProperty("driver", driver);
            properties.setProperty("url", url);
            properties.setProperty("user", user);
            properties.setProperty("password", password);
            List<List<String>> resultList = null;
            try {
				resultList = JdbcUtils.readFirstRows(driver, url, properties, sql, 5);
				return resultList;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
                 
        }     
    }   
	

}
