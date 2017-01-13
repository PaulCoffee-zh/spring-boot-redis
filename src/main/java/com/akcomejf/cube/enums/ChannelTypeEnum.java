package com.akcomejf.cube.enums;

/**
 * 渠道来源
 * @author admin
 *
 */
public enum ChannelTypeEnum {

	C_C1_FIRETOU("C1","火投网"),
	
	C_C2_WANGDAI("C2","网贷天眼"),
    
	C_C3_HUIXIANGYOU("C3","惠享游"),
	
	Q_ACTIVITY_C4("C4", "趣米ASO"),
	
    Q_CHANNEL_LOYU_K1("K1", "201612框架张家港"),
    Q_CHANNEL_LOYU_K2("K2", "201612框架赣州"),
    Q_CHANNEL_K3("K3", "201612月江西老乡会"),
    Q_CHANNEL_K4("K4", "无锡江西商会"),
    Q_CHANNEL_K5("K5", "江西商会"),
    
    Q_CHANNEL_S1("S1", "搜狗PC"),
    Q_CHANNEL_S2("S2", "搜狗手机"),
    Q_CHANNEL_Q1("Q1", "360PC"),
    Q_CHANNEL_Q2("Q2", "360手机"),
    Q_CHANNEL_D1("D1", "百度飞标PC端"),
    Q_CHANNEL_D2("D2", "百度飞标移动端"),
    OTHER("", "其他")
    
	
	;
	
	private String code;
	private String name;
	
	private ChannelTypeEnum(String code, String name) {
	    this.code = code;
	    this.name = name;
	}
	
    public static String getNameByCode(String code){
    	for (ChannelTypeEnum enumObj : ChannelTypeEnum.values()) {
            if (enumObj.getCode().equals(code)) {
                return enumObj.getName();
            }
        }
    	return null;
    }


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
    
}
