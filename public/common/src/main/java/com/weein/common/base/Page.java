package com.weein.common.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author larry 2013-08-11 desc：分页对象
 */
public class Page implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5112219754884245181L;
	// 分页查询开始记录位置
	@JsonIgnore
	private int begin;
	// 分页查看结束位置
	@JsonIgnore
	private int end;
	// 每页显示记录数
	@JsonIgnore
	private int length;
	// 查询结果总记录数
	@JsonIgnore
	private int count;
	// 当前页码
	@JsonIgnore
	private int current;
	// 总共页数
	@JsonIgnore
	private int total;

	public Page() {
		this.begin = 0;
		this.length = 10;
		this.end = 10;
		this.current = 0;
	}

	/**
	 * 构造函数
	 * 
	 * @param begin
	 * @param length
	 */
	public Page(int begin, int length) {
		this.begin = begin;
		this.length = length;
		this.end = this.begin + this.length;
		this.current = (int) Math.floor((this.begin * 1.0d) / this.length);
	}

	/**
	 * @param begin
	 * @param length
	 * @param count
	 */
	public Page(int begin, int length, int count) {
		this(begin, length);
		this.count = count;
	}

	/**
	 * @return the begin
	 */
	@JsonIgnore
	public int getBegin() {
		return begin;
	}

	/**
	 * @return the end
	 */
	/**
	 * @return the end
	 */
	@JsonIgnore
	public int getEnd() {
		return end;
	}

	/**
	 * @param end
	 *            the end to set
	 */
	public void setEnd(int end) {
		this.end = end;
	}

	/**
	 * @param begin
	 *            the begin to set
	 */
	public void setBegin(int begin) {
		this.begin = begin;
		if (this.length != 0) {
			this.current = (int) Math.floor((this.begin * 1.0d) / this.length);
		}
	}

	/**
	 * @return the length
	 */
	@JsonIgnore
	public int getLength() {
		return length;
	}

	/**
	 * @param length
	 *            the length to set
	 */
	public void setLength(int length) {
		this.length = length;
		if (this.begin != 0) {
			this.current = (int) Math.floor((this.begin * 1.0d) / this.length);
		}
	}

	/**
	 * @return the count
	 */
	@JsonIgnore
	public int getCount() {
		return count;
	}

	/**
	 * @param count
	 *            the count to set
	 */
	public void setCount(int count) {
		this.count = count;
		this.total = (int) Math.floor((this.count * 1.0d) / this.length);
		if (this.count % this.length != 0) {
			this.total++;
		}
	}

	/**
	 * @return the current
	 */
	@JsonIgnore
	public int getCurrent() {
		return current;
	}

	/**
	 * @param current
	 *            the current to set
	 */
	@JsonIgnore
	public int getTotal() {
		if (total == 0) {
			return 1;
		}
		return total;
	}

	/**
	 * @param total
	 *            the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}

	public int toNextPage() {
		int page = current+1 + 1;
		if (page >= this.getTotal()) {
			page = this.getTotal();
		}
		return page;
	}

	public int toPreviousPage() {
		int page = current+1 - 1;
		if (page <= 1) {
			return 1;
		}
		return page;
	}

	@JsonIgnore
	public List<String> getSlider() {
		List<String> slider = new ArrayList<String>();
		if (this.getTotal() < 8) {
			for (int i = 1; i <= this.getTotal(); i++) {
				slider.add("" + i);
			}
		} else if (this.current > this.getTotal() - 3) {
			slider.add("...");
			for (int i = this.getTotal() - 5; i <= this.getTotal(); i++) {
				slider.add("" + i);
			}
		} else if (this.current < 4) {
			for (int i = 1; i < 6; i++) {
				slider.add("" + i);
			}
			slider.add("...");
		} else {
			slider.add("...");
			for (int i = this.current - 2; i <= this.current + 2; i++) {
				slider.add("" + i);
			}
			slider.add("...");
		}
		return slider;
	}
}
