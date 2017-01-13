package com.akcomejf.cube.domain;

import java.io.Serializable;

import com.akcomejf.cube.enums.ChannelTypeEnum;

public class ChartRegEntity implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1361590364161382144L;

	/** 按天汇总 */
	private String yearMonDay;

	/** 渠道代码 */
	private String channelType;

	/** 注册总数 */
	private long regCount;
	
	/***/
	private String rowKey;

	public String getRowKey() {
		return rowKey;
	}

	public void setRowKey(String rowKey) {
		this.rowKey = rowKey;
	}

	public String getYearMonDay() {
		return "sxq";
	}

	public void setYearMonDay(String yearMonDay) {
		this.yearMonDay = yearMonDay;
	}

	public String getChannelType() {
		return channelType;
	}

	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}

	public long getRegCount() {
		return regCount;
	}

	public void setRegCount(long regCount) {
		this.regCount = regCount;
	}

	@Override
	public String toString() {
		return "ChartRegEntity [yearMonDay=" + yearMonDay + ", channelType=" + channelType + ", regCount=" + regCount
				+ ", rowKey=" + rowKey + "]";
	}

}
