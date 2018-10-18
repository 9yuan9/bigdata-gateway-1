package com.weein.common.base;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.weein.common.annotation.TablePrefix;
import com.weein.common.constants.CommonConstants;
import com.weein.wcommon.utils.DateUtils;

/**
 * 类 名: BaseEntry<br/>
 * 描 述: 基础实体类<br/>
 * 作 者: 郭昕<br/>
 * 创 建： 2014-9-3<br/>
 * 
 * 历 史: (版本) 作者 时间 注释 <br/>
 */
public abstract class BaseEntry {
	/**
	 * 查询几个月的数据,当前月之前的月数,包含当月
	 */
	public static final Integer DB_TABLE_MONTH_DATA = 3 ;
	/**
	 * 分页起始页
	 */
	private static final Long FINAL_PAGESTART = 0L;

	/**
	 * 分页大小
	 */
	private static final Integer FINAL_PAGESIZE = 20;
	
	
	/**
	 * 分页大小(账户明细和购买记录的分页大小为10)
	 */
	public static final Integer FINAL_PAGESIZE_TEN = 10;

	/**
	 * 分页大小
	 */
	protected Integer pageSize = FINAL_PAGESIZE;

	/**
	 * 分页索引
	 */
	protected Long index = FINAL_PAGESTART;
	/**
	 * 表名字
	 */
	protected String[] tbNames;

	public String[] getTbNames() {
		if(tbNames==null || tbNames.length==0){
			this.setTbNames(getMultiTableName());
		}
		return tbNames;
	}

	public void setTbNames(String[] tbNames) {
		this.tbNames = tbNames;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Long getIndex() {
		return index;
	}

	public void setIndex(Long index) {
		this.index = index;
	}
	protected String[] getMultiTableName(){
		String [] result = new  String[DB_TABLE_MONTH_DATA];
		TablePrefix annotation = this.getClass().getAnnotation(TablePrefix.class);
		for(int i =DB_TABLE_MONTH_DATA-1;i>=0;--i){
			StringBuffer tbBuf = new StringBuffer();
			tbBuf.append(annotation.value()).append(DateUtils.format(DateUtils.getBeforeMonth(new Date(), -i), DateUtils.FORMAT_YEAR_MONTH));
			result[i]=tbBuf.toString();
		}
		return result;
	} 
	/**
	 * 
	 * 描 述：获取流水号中的年月,然后指定分区查询DB<br/>
	 * 作 者：郭昕<br/>
	 * 历 史: (版本) 作者 时间 注释 <br/>
	 * @param sid
	 * @return
	 */
	public String[] getTableName(String sid){
		String [] result = new  String[1];
		TablePrefix annotation = this.getClass().getAnnotation(TablePrefix.class);
		StringBuffer tbBuf = new StringBuffer();
		tbBuf.append(annotation.value()).append(getYM(sid));
		result[0]= tbBuf.toString();

		return result;
	}
	/**
	 * 
	 * 描 述：获取流水号中的年月,然后指定分区查询DB<br/>
	 * 作 者：郭昕<br/>
	 * 历 史: (版本) 作者 时间 注释 <br/>
	 * @param tradeNo 流水号
	 * @return yyyyMM
	 */
	private static String getYM(String tradeNo){
		if(StringUtils.isNotBlank(tradeNo)){
			tradeNo = tradeNo.trim();
			String res=  StringUtils.substring(tradeNo,0,CommonConstants.RANDOM_YM_LEN);
			return res;
		}
		return null;
	}
}
