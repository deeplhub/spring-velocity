package com.xh.spring.velocity.model;

import java.util.Date;

/**
 * <b>Title: </b>
 * <p>Description: </p>
 * 
 * @author H.Yang
 * @email xhaimail@163.com
 * @date 2019年2月28日
 */
public class WebLog {

	private Integer id;
	// 客户姓名
	private String holderName;
	// 创建时间
	private Date createTime;

	public WebLog() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "WebLog [id=" + id + ", holderName=" + holderName + ", createTime=" + createTime + "]";
	}

}
