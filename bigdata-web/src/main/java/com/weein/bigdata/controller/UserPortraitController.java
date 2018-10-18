package com.weein.bigdata.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.weein.bigdata.base.entity.CouponInfoDO;
import com.weein.bigdata.base.vo.result.Result;
import com.weein.bigdata.core.configuration.BigDataJDBCProperties;
import com.weein.bigdata.core.service.DataRankWordService;
import com.weein.bigdata.core.service.ICouponInfoService;
import com.weein.bigdata.core.utils.JdbcUtils;
import com.weein.common.base.Page;
import com.weein.wcommon.cache.RedisClient;

@RestController
@RequestMapping("/v1/UserPortrait")
public class UserPortraitController {
	
	private static final Logger LOG = LoggerFactory.getLogger(UserPortraitController.class);
	
	
	@Resource
	private RedisClient redisClient;
	@Resource
	private ICouponInfoService couponInfoService;
	@Resource
	private DataRankWordService dataRankWordService;
	@Resource
	private BigDataJDBCProperties bigDataJDBCProperties;
	
	@RequestMapping(value = "/getGiftList.do", method = RequestMethod.GET)
	public Object getGroupInformation(HttpServletRequest request, HttpServletResponse response,@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit) {
		
		LOG.info("[返回礼品卡列表结果]");
		CouponInfoDO d = new CouponInfoDO();
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", 0);
		result.put("msg", "ok");
		int count = couponInfoService.selectCount(null);
		result.put("count", count);
		Map<String, Object> map = new HashMap<String, Object>();
		Page pageData = new Page();
		pageData.setCount(couponInfoService.selectCount(null));
		pageData.setBegin(page);
		pageData.setLength(limit);
		int total = (count - limit*(count%limit)>0)?count%limit+1:count%limit;
		pageData.setTotal(total);
		map.put("page", pageData);
		result.put("data", couponInfoService.selectPageList(map));
		
		return result;
	}
	
	
	
	@RequestMapping(value = "/getUserPortrait.do", method = RequestMethod.GET)
	public List<List<String>> getUserProfile(HttpServletRequest request, HttpServletResponse response,String phone) throws IOException {
		
		LOG.info("[返回用户数据列表结果]");
		String driver = bigDataJDBCProperties.getDriver();
        String url = bigDataJDBCProperties.getUrl();
        String user = bigDataJDBCProperties.getUser();
        String password = bigDataJDBCProperties.getPassword();
       /* String url = "jdbc:mysql://47.95.119.35:3307/act?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true";
        String user = "root";
        String password = "123456";*/
        Properties properties = new Properties();
        properties.setProperty("driver", driver);
        properties.setProperty("url", url);
        properties.setProperty("user", user);
        properties.setProperty("password", password);


        System.out.println(phone);
        //String sql = "SELECT * FROM DATAZHX.T_USER_PROFILE where phone ="+phone; //无索引的表
        String sql = "SELECT * FROM WEEINTEST.T_USER_TEST where phone ="+phone;  //有索引的表
        List<List<String>> result = JdbcUtils.readFirstRows(driver, url, properties, sql, 1000);
        System.out.println(result);
        LOG.info("[大数据用户画像数据获取]  结果：{}"+ new Object[] {result.toString()});
		return result;
	}
	
	@RequestMapping(value = "/getUserAll.do", method = RequestMethod.GET)
	public Object getUserAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		LOG.info("[返回礼所有用户列表结果]");
		String driver = bigDataJDBCProperties.getDriver();
        String url = bigDataJDBCProperties.getUrl();
        String user = bigDataJDBCProperties.getUser();
        String password = bigDataJDBCProperties.getPassword();
       /* String url = "jdbc:mysql://47.95.119.35:3307/act?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true";
        String user = "root";
        String password = "123456";*/
        Properties properties = new Properties();
        properties.setProperty("driver", driver);
        properties.setProperty("url", url);
        properties.setProperty("user", user);
        properties.setProperty("password", password);


        String sql = "SELECT * FROM DATAZHX.T_USER_PROFILE";
        List<List<String>> resultArry = JdbcUtils.readFirstRows(driver, url, properties, sql, 1000);
        Result<List<List<String>>> result = new Result<>();
        result.setBody(resultArry);
        result.setSuccess(true);
        System.out.println(JSON.toJSONString(result));
        LOG.info("[大数据用户画像数据获取]  参数phone：{}"+new Object[] {result});
        
		return result;
	}
	
	
	@RequestMapping(value = "/getDataRankWordImg.do", method = RequestMethod.GET)
    public Result<String> getDataRankWordImg(HttpServletRequest request, HttpServletResponse response,String phone) throws IOException {
		/*设置返回头信息，内容类型为图片*/      
        response.setDateHeader("Expires", 0);  
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");  
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");  
        response.setHeader("Pragma", "no-cache");  
        response.setContentType("image/png");  
        ServletOutputStream out = response.getOutputStream(); 
        ImageIO.write(dataRankWordService.getDataRankWordImg(phone), "png", out);  
        try {
        out.flush(); 
        
		} catch (IOException e) {
			e.printStackTrace();
		}finally {  
            out.close();  
        }  
		
        return null;
    }
	
}
