package com.kennycason.kumo.examples;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kennycason.kumo.WordFrequency;
import com.kennycason.kumo.nlp.FrequencyAnalyzer;
import com.weein.bigdata.core.utils.JdbcUtils;
import com.weein.bigdata.utils.WordCloudUtils;

public class TestMyWord {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestMyWord.class);
	@Test
    public void getImage() throws IOException {
		
		LOGGER.info("[返回礼品卡列表结果]");
		String driver = "com.datapps.linkoopdb.jdbc.JdbcDriver";
        String url = "jdbc:linkoopdb:tcp://localhost:9105/ldb";
        String user = "admin";
        String password = "123456";
       /* String url = "jdbc:mysql://47.95.119.35:3307/act?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true";
        String user = "root";
        String password = "123456";*/
        Properties properties = new Properties();
        properties.setProperty("driver", driver);
        properties.setProperty("url", url);
        properties.setProperty("user", user);
        properties.setProperty("password", password);

        String sql = "SELECT * FROM DATAZHX.T_USER_PROFILE where phone ="+"13001699052";
        List<List<String>> resultAll = JdbcUtils.readFirstRows(driver, url, properties, sql, 1000);
        sql = "SELECT * FROM TESTD.CLEAN where phone ="+"18601107610";
        List<List<String>> resultSome = JdbcUtils.readFirstRows(driver, url, properties, sql, 1000);
        List<List<String>> toword = resultSome;;
        
       /*for (String list : resultArr) {
    	   toword.get(0).add(list);
       }*/
        
        
        
        
        toword.addAll(resultSome);
        toword.addAll(resultSome);
        toword.addAll(resultSome);
        
        
        String word1 = "是,指,根据,用户,属性,用户偏好,生活习惯,用户行为,等,信息,而,抽象,出来,标签化,用户模型,通俗,说,就是,给,打标签,标签,通过,对,用户信息,分析,而来,高度精炼,特征标识,打,可以,利用,一些,高度概括,容易理解,特征,来,描述,让人,更容易,理解用户,并且,方便,计算机,处理,作用,可以看出,使用场景,较多,用来,挖掘,用户兴趣,偏好,人口,统计学,主要目的,提升,营销,精准度,推荐,匹配度,终极目的,产品服务,起到,企业利润,适合于,各个,产品周期,从,新用户,引流,到,潜在用户,老用户,培养,流失用户,回流,首先,介绍,人物,基本,情况,要,写,姓名,性别,出生,时间,出生地,或,籍贯,受,教育,现在,所在单位,所在地,其次,身形,特点,身高,长相,喜好,再其次,个性特点,憨厚,还是,奸诈,乐于助人,小气,吝啬,敢作敢当,推诿,责任,心理学家,按照,一定,原则,性格,所,做,分类,人格,重要,组成部分,个体,在,社会,条件,下,表现,习惯化,了,行为,反应,与,情感,形成,相对,稳定,心理特征,空间,结构,上,讲,人性,要素,包含,形体,精神,认知,目的,历史,未来,多面,和,多变,十个,层面,决定,关系,造就,影响,态度,成就,气质,左右,能力,计划,带来,经验,设定,理想,从而,内容,概括,为,多维,多态,十大类,各类,之间,有,过渡,因而,产生,新,性质,总共,十八,大,类";
        String[] arr = word1.split(",");
        
        for (String string : arr) {
        	toword.get(0).add(string);
		}
        
		
		
		final FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
        frequencyAnalyzer.setWordFrequenciesToReturn(300);
        frequencyAnalyzer.setMinWordLength(0);
        frequencyAnalyzer.setStopWords(loadStopWords());
		List<WordFrequency> wordFrequencies = frequencyAnalyzer.load(toword.get(0));
		//WordCloudUtils.buildWordCouldByWordFrequencies(510, 950, 0, 10, 1, wordFrequencies, new Color(0x000000FF, true), new FileOutputStream("output/image.png") , new Color(7,153,61));
		
		WordCloudUtils.buildWordCouldByWordFrequencies(510, 950, 5, 10, 1, wordFrequencies, new Color(0x000000FF, true), new FileOutputStream("output/image.png") , new Color(7,153,61));
		
	}
	private static Set<String> loadStopWords() throws IOException {
        return new HashSet<>(IOUtils.readLines(getInputStream("text/stop_words.txt")));
    }
	private static InputStream getInputStream(final String path) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
    }
}
