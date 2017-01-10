package com.akcomejf.cube.domain;

import java.io.Serializable;

/**
 * 推广行为到获利的实体  (表 t_camp_behavior_cus)
 * 
 * @author admin
 *
 */
public class CampaignBehaviorCustomer implements Serializable{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4943535404056577999L;
	/**
	 * 技术入口
	 */
	private String entrance;
	/**
	 * 注册来源(注册阶段-必选)
	 */
	private String activitySource;
	/**
	 * 渠道来源(注册阶段-必选)
	 */
	private String channelType; 
	/**
	 * 来源方式
	 */
	private String sourceType;
	/**
	 * 购买人数
	 */
	private long buyCount;
	/**
	 * 购买量
	 */
	private double buySum;
	/**
	 * 
	 * 购买省
	 */
	private String prov;

	/**
	 * 客户购买分析-男士
	 */
	private long male;
	/**
	 * 客户购买分析-女士
	 */
	private long female;
	/**
	 * 客户购买分析-爱康员工数
	 * 
	 * @return
	 */
	private long akEmp;
	/**
	 * 客户购买分析-非爱康员工数
	 * 
	 * @return
	 */
	private long notAkEmp;
	/**
	 * 客户购买分析-只买了一次人数
	 */
	private long buyOnce;
	/**
	 * 客户购买分析-只买了一次人数 购买了多次
	 * 
	 * @return
	 */
	private long buyMore;

	/**
	 * 客户购买分析-时段购买量
	 */
	private double buyTimeH3;
	private double buyTimeH6;
	private double buyTimeH9;
	private double buyTimeH12;
	private double buyTimeH15;
	private double buyTimeH18;
	private double buyTimeH21;
	private double buyTimeH24;
	/**
	 * 客户购买分析-区域购买量-上海
	 */
	private double buyAreaSH;
	/**
	 * 客户购买分析-区域购买量-江苏
	 */
	private double buyAreaJS;
	/**
	 * 客户购买分析-区域购买量-江西
	 */
	private double buyAreaJX;
	/**
	 * 客户购买分析-区域购买量-其他
	 */
	private double buyAreaOT;
	/**
	 * 客户购买分析-年龄购买量[0~20)
	 */
	private double buyAge20;
	/**
	 * 客户购买分析-年龄购买量[20~30)
	 */
	private double buyAge30;
	/**
	 * 客户购买分析-年龄购买量[30~40)
	 */
	private double buyAge40;
	/**
	 * 客户购买分析-年龄购买量[40~50)
	 */
	private double buyAge50;
	/**
	 * 客户购买分析-年龄购买量[50以上
	 */
	private double buyAgeHig;

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

	public String getProv() {
		return prov;
	}

	public void setProv(String prov) {
		this.prov = prov;
	}

	public long getMale() {
		return male;
	}

	public void setMale(long male) {
		this.male = male;
	}

	public long getFemale() {
		return female;
	}

	public void setFemale(long female) {
		this.female = female;
	}

	public long getAkEmp() {
		return akEmp;
	}

	public void setAkEmp(long akEmp) {
		this.akEmp = akEmp;
	}

	public long getNotAkEmp() {
		return notAkEmp;
	}

	public void setNotAkEmp(long notAkEmp) {
		this.notAkEmp = notAkEmp;
	}

	public long getBuyOnce() {
		return buyOnce;
	}

	public void setBuyOnce(long buyOnce) {
		this.buyOnce = buyOnce;
	}

	public long getBuyMore() {
		return buyMore;
	}

	public void setBuyMore(long buyMore) {
		this.buyMore = buyMore;
	}

	public double getBuyTimeH3() {
		return buyTimeH3;
	}

	public void setBuyTimeH3(double buyTimeH3) {
		this.buyTimeH3 = buyTimeH3;
	}

	public double getBuyTimeH6() {
		return buyTimeH6;
	}

	public void setBuyTimeH6(double buyTimeH6) {
		this.buyTimeH6 = buyTimeH6;
	}

	public double getBuyTimeH9() {
		return buyTimeH9;
	}

	public void setBuyTimeH9(double buyTimeH9) {
		this.buyTimeH9 = buyTimeH9;
	}

	public double getBuyTimeH12() {
		return buyTimeH12;
	}

	public void setBuyTimeH12(double buyTimeH12) {
		this.buyTimeH12 = buyTimeH12;
	}

	public double getBuyTimeH15() {
		return buyTimeH15;
	}

	public void setBuyTimeH15(double buyTimeH15) {
		this.buyTimeH15 = buyTimeH15;
	}

	public double getBuyTimeH18() {
		return buyTimeH18;
	}

	public void setBuyTimeH18(double buyTimeH18) {
		this.buyTimeH18 = buyTimeH18;
	}

	public double getBuyTimeH21() {
		return buyTimeH21;
	}

	public void setBuyTimeH21(double buyTimeH21) {
		this.buyTimeH21 = buyTimeH21;
	}

	public double getBuyTimeH24() {
		return buyTimeH24;
	}

	public void setBuyTimeH24(double buyTimeH24) {
		this.buyTimeH24 = buyTimeH24;
	}

	public double getBuyAreaSH() {
		return buyAreaSH;
	}

	public void setBuyAreaSH(double buyAreaSH) {
		this.buyAreaSH = buyAreaSH;
	}

	public double getBuyAreaJS() {
		return buyAreaJS;
	}

	public void setBuyAreaJS(double buyAreaJS) {
		this.buyAreaJS = buyAreaJS;
	}

	public double getBuyAreaJX() {
		return buyAreaJX;
	}

	public void setBuyAreaJX(double buyAreaJX) {
		this.buyAreaJX = buyAreaJX;
	}

	public double getBuyAreaOT() {
		return buyAreaOT;
	}

	public void setBuyAreaOT(double buyAreaOT) {
		this.buyAreaOT = buyAreaOT;
	}

	public double getBuyAge20() {
		return buyAge20;
	}

	public void setBuyAge20(double buyAge20) {
		this.buyAge20 = buyAge20;
	}

	public double getBuyAge30() {
		return buyAge30;
	}

	public void setBuyAge30(double buyAge30) {
		this.buyAge30 = buyAge30;
	}

	public double getBuyAge40() {
		return buyAge40;
	}

	public void setBuyAge40(double buyAge40) {
		this.buyAge40 = buyAge40;
	}

	public double getBuyAge50() {
		return buyAge50;
	}

	public void setBuyAge50(double buyAge50) {
		this.buyAge50 = buyAge50;
	}

	public double getBuyAgeHig() {
		return buyAgeHig;
	}

	public void setBuyAgeHig(double buyAgeHig) {
		this.buyAgeHig = buyAgeHig;
	}

	public String getActivitySource() {
		return activitySource;
	}

	public void setActivitySource(String activitySource) {
		this.activitySource = activitySource;
	}

	public String getChannelType() {
		return channelType;
	}

	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}

}
