package com.akcomejf.cube.domain;

import java.io.Serializable;

public class CharInvesEntity implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3532137266053451098L;

	/** 按天汇总 */
	private String yearMonDay;
	
	/** 渠道代码 */
	private String channelType;
	
	/** 活动代码  */
	private String activitySource;
	
	/** 投资金额  */
	private double invesAmout;

	public String getYearMonDay() {
		return yearMonDay;
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

	public String getActivitySource() {
		return activitySource;
	}

	public void setActivitySource(String activitySource) {
		this.activitySource = activitySource;
	}

	public double getInvesAmout() {
		return invesAmout;
	}

	public void setInvesAmout(double invesAmout) {
		this.invesAmout = invesAmout;
	}
	
}
