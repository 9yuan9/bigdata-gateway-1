package com.weein.bigdata.core.service.impl;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.websocket.server.ServerEndpoint;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.kennycason.kumo.CollisionMode;
import com.kennycason.kumo.LayeredWordCloud;
import com.kennycason.kumo.WordFrequency;
import com.kennycason.kumo.bg.PixelBoundryBackground;
import com.kennycason.kumo.font.FontWeight;
import com.kennycason.kumo.font.KumoFont;
import com.kennycason.kumo.font.scale.SqrtFontScalar;
import com.kennycason.kumo.nlp.FrequencyAnalyzer;
import com.kennycason.kumo.palette.ColorPalette;
import com.weein.bigdata.core.service.DataRankWordService;
import com.weein.bigdata.core.utils.JdbcUtils;
@Service
public class DataRankWordServiceImpl implements DataRankWordService {
	private static final Logger LOG = LoggerFactory.getLogger(DataRankWordServiceImpl.class);
	@Override
	public BufferedImage getDataRankWordImg(String phone) {
		LOG.info("[开始从大数据平台获取数据]");
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
        List<List<String>> resultAll;
        
        
        
		try {
			resultAll = JdbcUtils.readFirstRows(driver, url, properties, sql, 1000);
        sql = "SELECT * FROM TESTD.CLEAN where phone ="+phone;
        List<List<String>> resultSome = JdbcUtils.readFirstRows(driver, url, properties, sql, 1000);
        List<List<String>> toword = resultAll;;
        
        
        
        
        toword.addAll(resultSome);
        
        String word1 = "是,指,根据,用户,属性,用户偏好,生活习惯,用户行为,等,信息,而,抽象,出来,标签化,用户模型,通俗,说,就是,给,打标签,标签,通过,对,用户信息,分析,而来,高度精炼,特征标识,打,可以,利用,一些,高度概括,容易理解,特征,来,描述,让人,更容易,理解用户,并且,方便,计算机,处理,作用,可以看出,使用场景,较多,用来,挖掘,用户兴趣,偏好,人口,统计学,主要目的,提升,营销,精准度,推荐,匹配度,终极目的,产品服务,起到,企业利润,适合于,各个,产品周期,从,新用户,引流,到,潜在用户,老用户,培养,流失用户,回流,首先,介绍,人物,基本,情况,要,写,姓名,性别,出生,时间,出生地,或,籍贯,受,教育,现在,所在单位,所在地,其次,身形,特点,身高,长相,喜好,再其次,个性特点,憨厚,还是,奸诈,乐于助人,小气,吝啬,敢作敢当,推诿,责任,心理学家,按照,一定,原则,性格,所,做,分类,人格,重要,组成部分,个体,在,社会,条件,下,表现,习惯化,了,行为,反应,与,情感,形成,相对,稳定,心理特征,空间,结构,上,讲,人性,要素,包含,形体,精神,认知,目的,历史,未来,多面,和,多变,十个,层面,决定,关系,造就,影响,态度,成就,气质,左右,能力,计划,带来,经验,设定,理想,从而,内容,概括,为,多维,多态,十大类,各类,之间,有,过渡,因而,产生,新,性质,总共,十八,大,类";
        String[] arr = word1.split(",");
        
        for (String string : arr) {
        	toword.get(0).add(string);
		}
        toword.get(0).add(resultAll.get(0).get(3));
        toword.get(0).add(resultAll.get(0).get(3));
        
        
        
        final FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
        frequencyAnalyzer.setWordFrequenciesToReturn(300);
        frequencyAnalyzer.setMinWordLength(2);
        frequencyAnalyzer.setStopWords(loadStopWords());

        final List<WordFrequency> wordFrequencies = frequencyAnalyzer.load(toword.get(0));

        final Dimension dimension = new Dimension(800,1490);//203, 459,510,950
        final LayeredWordCloud layeredWordCloud = new LayeredWordCloud(5, dimension, CollisionMode.PIXEL_PERFECT);
        layeredWordCloud.setBackgroundColor(new Color(0,0,0));

        layeredWordCloud.setPadding(0, 0);
        layeredWordCloud.setPadding(0, 0);
        layeredWordCloud.setPadding(0, 0);
        layeredWordCloud.setPadding(0, 0);
        layeredWordCloud.setPadding(0, 1);

        layeredWordCloud.setKumoFont(1, new KumoFont("Microsoft Yahei", FontWeight.BOLD));//Microsoft Yahei   Sans Serif和Serif
        layeredWordCloud.setKumoFont(1, new KumoFont("Microsoft Yahei", FontWeight.BOLD));
        layeredWordCloud.setKumoFont(1, new KumoFont("Microsoft Yahei", FontWeight.BOLD));
        layeredWordCloud.setKumoFont(1, new KumoFont("Microsoft Yahei", FontWeight.BOLD));
        layeredWordCloud.setKumoFont(1, new KumoFont("Microsoft Yahei", FontWeight.BOLD));

        layeredWordCloud.setBackground(0, new PixelBoundryBackground(getInputStream("backgrounds/none.png")));
        layeredWordCloud.setBackground(0, new PixelBoundryBackground(getInputStream("backgrounds/none.png")));
        layeredWordCloud.setBackground(0, new PixelBoundryBackground(getInputStream("backgrounds/none.png")));
        layeredWordCloud.setBackground(0, new PixelBoundryBackground(getInputStream("backgrounds/none.png")));
        layeredWordCloud.setBackground(1, new PixelBoundryBackground(getInputStream("backgrounds/u99.png")));

        layeredWordCloud.setColorPalette(0, new ColorPalette(new Color(0x0891d1)));
        layeredWordCloud.setColorPalette(0, new ColorPalette(new Color(0x0FC25F)));
        layeredWordCloud.setColorPalette(0, new ColorPalette(new Color(0x56bdea)));
        layeredWordCloud.setColorPalette(0, new ColorPalette(new Color(0x7876EA)));
        layeredWordCloud.setColorPalette(0, new ColorPalette(new Color(0x7876EA)));

        layeredWordCloud.setFontScalar(1, new SqrtFontScalar(10, 30));

        //final long startTime = System.currentTimeMillis();
        layeredWordCloud.build(1, wordFrequencies);
        //layeredWordCloud.build(1, wordFrequencies);

        //LOGGER.info("Took {}ms to build", System.currentTimeMillis() - startTime);
        //layeredWordCloud.writeToFile("output/datarank.png");
        return layeredWordCloud.getBufferedImage();
       
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	 private static Set<String> loadStopWords() throws IOException {
	        return new HashSet<>(IOUtils.readLines(getInputStream("text/stop_words.txt")));
	    }

	    private static InputStream getInputStream(final String path) {
	        return Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
	    }

}
