package com.akcomejf.cube.domain;

import java.io.Serializable;

/**
 * 
 * @author admin
 *  DaChartTableEnums.CHART_TABLE_INVES_INFO (t_chart_inves_info)
 *  Hbase主键规则： YYYYMMDD-渠道code-活动code-手机号码
 */
public class ChartDataEntity implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -608983150244260394L;

	/** 按天汇总 */
	private String yearMonDay;
	
	/** 渠道代码 */
	private String channelType;
	
	/** 活动代码  */
	private String activitySource;
	
	/** 用户Id **/
	private String userId;
	
	/** 用户手机 */
	private String mobile;
	
	/** 是否注册 */
	private long isReg;
	
	/** 注册时间 */
	private long regTime;
	
	/** 是否绑卡 */
	private long isBindCard;
	
	/** 绑卡时间  */
	private long bindTime;
	
	/** 是否首次投资 */
	private long isFirstInves;
	
	/** 首次投资金额  */
	private double firstInvesAmout;
	
	/** 首次购买时间  */
	private long firstInvesTime;
	
	/** 是否 复投 */
	private long isRepeatInves;
	
	/** 复投金额  */
	private double repeatInvesAmout;
	
	/** 复投时间  */
	private long repeatInvesTime;
	
	/** 复投次数  */
	private long repeatInvesCount;
	
	private String rowKey;

	public String getRowKey() {
		return rowKey;
	}

	public void setRowKey(String rowKey) {
		this.rowKey = rowKey;
	}

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

	public long getIsBindCard() {
		return isBindCard;
	}

	public void setIsBindCard(long isBindCard) {
		this.isBindCard = isBindCard;
	}

	public void setActivitySource(String activitySource) {
		this.activitySource = activitySource;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public long getBindTime() {
		return bindTime;
	}

	public void setBindTime(long bindTime) {
		this.bindTime = bindTime;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public long getIsReg() {
		return isReg;
	}

	public void setIsReg(long isReg) {
		this.isReg = isReg;
	}
	
	public long getRegTime() {
		return regTime;
	}

	public void setRegTime(long regTime) {
		this.regTime = regTime;
	}

	public long getIsFirstInves() {
		return isFirstInves;
	}

	public void setIsFirstInves(long isFirstInves) {
		this.isFirstInves = isFirstInves;
	}

	public double getFirstInvesAmout() {
		return firstInvesAmout;
	}

	public void setFirstInvesAmout(double firstInvesAmout) {
		this.firstInvesAmout = firstInvesAmout;
	}

	public long getFirstInvesTime() {
		return firstInvesTime;
	}

	public void setFirstInvesTime(long firstInvesTime) {
		this.firstInvesTime = firstInvesTime;
	}

	public long getIsRepeatInves() {
		return isRepeatInves;
	}

	public void setIsRepeatInves(long isRepeatInves) {
		this.isRepeatInves = isRepeatInves;
	}

	public double getRepeatInvesAmout() {
		return repeatInvesAmout;
	}

	public void setRepeatInvesAmout(double repeatInvesAmout) {
		this.repeatInvesAmout = repeatInvesAmout;
	}

	public long getRepeatInvesTime() {
		return repeatInvesTime;
	}

	public void setRepeatInvesTime(long repeatInvesTime) {
		this.repeatInvesTime = repeatInvesTime;
	}

	public long getRepeatInvesCount() {
		return repeatInvesCount;
	}

	public void setRepeatInvesCount(long repeatInvesCount) {
		this.repeatInvesCount = repeatInvesCount;
	}

	@Override
	public String toString() {
		return "ChartDataEntity [yearMonDay=" + yearMonDay + ",\n channelType=" + channelType + ",\n activitySource="
				+ activitySource + ",\n userId=" + userId + ",\n mobile=" + mobile + ",\n isReg=" + isReg + ",\n regTime="
				+ regTime + ",\n isBindCard=" + isBindCard + ",\n bindTime=" + bindTime + ",\n isFirstInves=" + isFirstInves
				+ ",\n firstInvesAmout=" + firstInvesAmout + ",\n firstInvesTime=" + firstInvesTime + ",\n isRepeatInves="
				+ isRepeatInves + ",\n repeatInvesAmout=" + repeatInvesAmout + ",\n repeatInvesTime=" + repeatInvesTime
				+ ",\n repeatInvesCount=" + repeatInvesCount + ",\n rowKey=" + rowKey + "]";
	}
	
}
