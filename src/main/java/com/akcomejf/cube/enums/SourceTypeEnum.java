package com.akcomejf.cube.enums;

/**
 * 活动来源
 * @author wn
 *
 */
public enum SourceTypeEnum {
	
    TRAFFIC("01","送流量"),
    
    DWJ("02","端午节"),
    
    BACK("03","返现"),
    
    COUPON("04","优惠券"),
    
    EUROCUP("05","欧洲杯"),
    
    TRAFFIC_LINKS("06","楼宇框架"),
    
    SC_AK_TEN("AkTen", "爱康10周年庆"),
    
    SC_AK_TEN_LQ("10", "爱康10周年庆活动领券"),
    
    SC_AK_NATIONAL_DAY("13", "2016国庆节活动领券"),
    
    CASH_ZJG("07","现金券"), //注意打印城市
    
    DDD("08","点点点"),
    
    QA_CINEMA("O1","电影院"),
    
    QA_FM("O2","听广播"),
    
    QA_LIFT("O3","电梯中"),
    
    QA_FRIEND("O4","朋友圈"),
    
    QA_STREET("O5","步行街"),
    
    QA_OTHER("O6","其他"),
    
    L_2016_QI("09", "2016七夕活动"),
    
    L_AKTEN_JRTT("11", "爱康十周年-今日头条"),
    
    L_ACTIVE_AK2016_ZQ("12", "2016年中秋节现金券"),
    
    L_ACTIVITY_RUN("14", "爱在金秋，健康同行"),
    
    L_ACTIVITY_BILLIONAIRE("17", "大富翁活动"),
    
    A_DAIYAN("18", "带盐大使"),
    
    A_AK_CASH("16", "体验金"),
    
    A_AK_COUNT_MONEY("20", "数钱活动"),
    
    A_AK_WXJX_SH("21", "无锡江西商会"),
    A_AK_WXJX_22("22", "江西商会"),
    
    ;
	
    private String code;

    private String desc;

    private SourceTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static SourceTypeEnum getByCode(String code) {
        for (SourceTypeEnum enumObj : SourceTypeEnum.values()) {
            if (enumObj.getCode().equals(code)) {
                return enumObj;
            }
        }
        return null;
    }
    
    
    public static String getDescByCode(String code){
    	for (SourceTypeEnum enumObj : SourceTypeEnum.values()) {
            if (enumObj.getCode().equals(code)) {
                return enumObj.getDesc();
            }
        }
    	return null;
    }
    

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
    
}
