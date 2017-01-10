package com.akcomejf.cube.domain;

import java.io.Serializable;

/**
 * 推广行为到获利的数据 实体 ( 表 t_camp_behavior)
 * 
 * @author admin
 *
 */
public class CampaignBehaviorProfit implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5496695608458015485L;
	/**
	 * 入口
	 */
	private String entrance;
	/**
	 * 来源方式
	 */
	private String sourceType;
	/**
	 * 城市
	 */
	private String city;
	/**
	 * 注册页(活动页)展示量
	 */
	private long regShowCount;
	/**
	 * 注册数
	 */
	private long regCount;
	/**
	 * 绑卡人数
	 */
	private long bindCount;
	/**
	 * 购买人量
	 */
	private long buyCount;
	/**
	 * 购买量
	 */
	private double buySum;
	/**
	 * 公司毛利
	 */
	private double sumRate;
	
	/**
	 * 本次活动购买人数
	 */
	private long currBuyCount;
	/**
	 * 
	 * 本次活动购买量
	 */
	private double currBuySum;
	
	/**
	 * 购买总量
	 */
	private long totalBuyCount;
	
	/**
	 * 购买量 总量
	 */
	private double totalBuySum;
	/**
	 * 注册来源(注册阶段-必选)
	 */
	private String activitySource;
	/**
	 * 渠道来源(注册阶段-必选)
	 */
	private String channelType;
	
	

	public String getEntrance() {
		return entrance;
	}

	public void setEntrance(String entrance) {
		this.entrance = entrance;
	}

	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getRegShowCount() {
		return regShowCount;
	}

	public void setRegShowCount(long regShowCount) {
		this.regShowCount = regShowCount;
	}

	public long getRegCount() {
		return regCount;
	}

	public void setRegCount(long regCount) {
		this.regCount = regCount;
	}

	public long getBindCount() {
		return bindCount;
	}

	public void setBindCount(long bindCount) {
		this.bindCount = bindCount;
	}

	public long getBuyCount() {
		return buyCount;
	}

	public void setBuyCount(long buyCount) {
		this.buyCount = buyCount;
	}

	public double getBuySum() {
		return buySum;
	}

	public void setBuySum(double buySum) {
		this.buySum = buySum;
	}

	public double getSumRate() {
		return sumRate;
	}

	public void setSumRate(double sumRate) {
		this.sumRate = sumRate;
	}

	public long getCurrBuyCount() {
		return currBuyCount;
	}

	public void setCurrBuyCount(long currBuyCount) {
		this.currBuyCount = currBuyCount;
	}

	public double getCurrBuySum() {
		return currBuySum;
	}

	public void setCurrBuySum(double currBuySum) {
		this.currBuySum = currBuySum;
	}

	public long getTotalBuyCount() {
		return totalBuyCount;
	}

	public void setTotalBuyCount(long totalBuyCount) {
		this.totalBuyCount = totalBuyCount;
	}

	public double getTotalBuySum() {
		return totalBuySum;
	}

	public void setTotalBuySum(double totalBuySum) {
		this.totalBuySum = totalBuySum;
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

	@Override
	public String toString() {
		return "CampaignBehaviorProfit [entrance=" + entrance + ", sourceType=" + sourceType + ", city=" + city
				+ ", regShowCount=" + regShowCount + ", regCount=" + regCount + ", bindCount=" + bindCount
				+ ", buyCount=" + buyCount + ", buySum=" + buySum + ", sumRate=" + sumRate + ", currBuyCount="
				+ currBuyCount + ", currBuySum=" + currBuySum + ", totalBuyCount=" + totalBuyCount + ", totalBuySum="
				+ totalBuySum + ", activitySource=" + activitySource + ", channelType=" + channelType + "]";
	}

}
