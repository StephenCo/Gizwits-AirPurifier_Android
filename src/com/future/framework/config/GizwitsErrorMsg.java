/**
 * Project Name:XPGSdkV4AppBase
 * File Name:GizwitsErrorMsg.java
 * Package Name:com.gizwits.framework.config
 * Date:2015-1-27 14:47:07
 * Copyright (c) 2014~2015 Xtreme Programming Group, Inc.
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), 
 * to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, 
 * and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.future.framework.config;

// TODO: Auto-generated Javadoc
/**
 * 错误码枚举类.
 *
 * @author Lien
 */
public enum GizwitsErrorMsg {
	
	E0(0000, "unknow error", "未知错误"),

	/** The E1. */
	E1(9001, "mac already registered!", "mac已经注册"),

	/** The E2. */
	E2(9002, "product_key invalid", "product key无效"),

	/** The E3. */
	E3(9003, "appid invalid", "appid无效"),

	/** The E4. */
	E4(9004, "token invalid", "token无效"),

	/** The E5. */
	E5(9005, "user not exist", "用户名不存在"),

	/** The E6. */
	E6(9006, "token expired", "token已过期"),

	/** The E7. */
	E7(9007, "m2m_id invalid", "m2m_id无效"),

	/** The E8. */
	E8(9008, "server error", "服务器错误"),

	/** The E9. */
	E9(9009, "code expired", "验证码已过期"),

	/** The E10. */
	E10(9010, "code invalid", "验证码无效"),

	/** The E11. */
	E11(9011, "sandbox scale quota exhausted!", "沙箱环境配额用尽"),

	/** The E12. */
	E12(9012, "production scale quota exhausted!", "生产环境配额用尽"),

	/** The E13. */
	E13(9013, "product has no request scale!", "产品未设置配额"),

	/** The E14. */
	E14(9014, "device not found!", "设备找不到"),

	/** The E15. */
	E15(9015, "form invalid!", "表单无效"),

	/** The E16. */
	E16(9016, "did or passcode invalid!", "did或者passcode无效"),

	/** The E17. */
	E17(9017, "device not bound!", "设备未绑定"),

	/** The E18. */
	E18(9018, "phone unavailable!", "手机不可用"),

	/** The E19. */
	E19(9019, "username unavailable!", "用户名不可用"),

	/** The E20. */
	E20(9020, "username or password error!", "用户名或者密码错误"),
	
	E21(9021, "send commond failed!", "指令发送失败"),
	E22(9022, "email unavailable!", "邮箱不可用"),
	E23(9023, "device is disabled!", "设备是禁用的"),
	E24(9024, "fail to notify m2m!", "无法通知m2m"),
	E25(9025, "attr invalid!", "attr无效"),
	E26(9026, "user invalid!", "用户无效"),
	E27(9027, "firmware not found!", "固件没有找到"),
	E28(9028, "JD product info not found!", "JD产品信息未找到"),
	E29(9029, "datapoint data not found!", "数据点的数据没有找到"),
	E30(9030, "scheduler not found!", "调度程序没有找到"),
	E31(9031, "qq oauth key invalid!", "qq oauth密钥无效"),
	E32(9032, "ota upgrade service OK, but in idle or disable!", "ota升级服务可用,但是在空闲或禁用"),
	E33(9033, "bt firmware unverified, except verify device!", "bt固件未经证实的,除了验证设备"),
	E34(9034, "bt firmware is OK, but nothing to upgrade!", "bt固件就可以了,但没有升级"),
	E35(9035, "Save kairosdb error!", "保存kairosdb错误"),
	E36(9036, "event not defined!", "事件没有定义"),
	E37(9037, "send sms failed!", "发送短信失败"),
	E38(9038, "application-auth invalid!", "application-auth无效"),
	E39(9039, "not allowed to call deprecated api!", "不允许弃用api的调用"),
	E40(9040, "bad qrcode content", "错误的二维码"),
	E41(9041, "request was throttled", "请求被扼杀了"),
	E42(9042, "device offline", "设备离线"),
	E43(9043, "timestamp invalid", "时间戳无效"),
	E44(9044, "signature invalid", "签名无效"),
	E45(9045, "api deprecated", "api弃用"),

	EH1(8001, "GIZ SDK PARAM FORM INVALID", "json 格式错误"),
	EH2(8002, "GIZ SDK CLIENT NOT AUTHEN", "未通过验证"),
	EH3(8003, "GIZ SDK CLIENT VERSION INVALID", "版本无效"),
	EH4(8004, "GIZ SDK UDP PORT BIND FAILED", "udp端口绑定失败"),
	EH5(8005, "GIZ SDK DAEMON EXCEPTION", "系统错误"),
	EH6(8006, "GIZ SDK PARAM INVALID", "参数无效"),
	EH7(8007, "GIZ SDK APPID LENGTH ERROR", "appid长度错误"),
//	EH8(8008, "GIZ SDK LOG PATH INVALID", ""),
//	EH9(8009, "GIZ SDK LOG LEVEL INVALID", ""),
//	EH21(8021, "GIZ SDK DEVICE CONFIG SEND FAILED", ""),
//	EH22(8022, "GIZ SDK DEVICE CONFIG IS RUNNING", ""),
	EH23(8023, "GIZ SDK DEVICE CONFIG TIMEOUT", "设备配置超时"),
	EH24(8024, "GIZ SDK DEVICE DID INVALID", "设备did无效"),
	EH25(8025, "GIZ SDK DEVICE MAC INVALID", "设备mac无效"),
	EH26(8026, "GIZ SDK SUBDEVICE DID INVALID", "子设备did无效"),
	EH27(8027, "GIZ SDK DEVICE PASSCODE INVALID", "设备passcode无效"),
//	EH28(8028, "GIZ SDK DEVICE NOT CENTERCONTROL", ""),
	EH29(8029, "GIZ SDK DEVICE NOT SUBSCRIBED", "设备未订阅"),
	EH30(8030, "GIZ SDK DEVICE NO PESPONSE", "设备未响应"),
	EH31(8031, "GIZ SDK DEVICE NOT READY", "设备未就绪"),
	EH32(8032, "GIZ SDK DEVICE NOT BINDED", "设备未绑定"),
	EH33(8033, "GIZ SDK DEVICE CONTROL WITH INVALID COMMAND", "控制指令包含无效指令"),
	EH34(8034, "GIZ SDK DEVICE CONTROL FAILED", "控制指令执行失败"),
	EH35(8035, "GIZ SDK DEVICE GET STATUS FAILED", "状态查询失败"),
//	EH36(8036, "GIZ SDK DEVICE CONTROL VALUE TYPE ERROR", ""),
//	EH37(8037, "GIZ SDK DEVICE CONTROL VALUE OUT OF RANGE", ""),
//	EH38(8038, "GIZ SDK DEVICE CONTROL NOT WRITABLE COMMAND", ""),
	EH39(8039, "GIZ SDK BIND DEVICE FAILED", "设备绑定失败"),
	EH40(8040, "GIZ SDK UNBIND DEVICE FAILED", "设备解绑失败"),
	EH41(8041, "GIZ SDK DNS FAILED", "域名解析失败"),
	EH42(8042, "GIZ SDK M2M CONNECTION SUCCESS", "m2m连接成功"),
	EH43(8043, "GIZ SDK SET SOCKET NON BLOCK FAILED", ""),
	EH44(8044, "GIZ SDK CONNECION TIMEOUT", "连接超时"),
	EH45(8045, "GIZ SDK CONNECTION REFUSED", "连接被拒绝"),
	EH46(8046, "GIZ SDK CONNECTION ERROR", "连接错误"),
	EH47(8047, "GIZ SDK CONNECTION CLOSED", "连接被关闭"),
	EH48(8048, "GIZ SDK SSL HANDSHAKE FAILED", "握手失败"),
	EH49(8049, "GIZ SDK DEVICE LOGIN VERIFY FAILED", "设备登陆验证失败"),
//	EH50(8050, "GIZ SDK INTERNET NOT REACHABLE", ""),
//	EH96(8096, "GIZ SDK HTTP ANSWER FORMAT ERROR", ""),
	EH97(8097, "GIZ SDK HTTP ANSWER PARAM ERROR", "http应答参数错误"),
	EH98(8098, "GIZ SDK HTTP SERVER NO ANSWER", "http服务无响应"),
	EH99(8099, "GIZ SDK HTTP REQUEST FAILED", "http请求失败"),
//	EH100(8100, "GIZ SDK OTHERWISE", ""),
//	EH101(8101, "GIZ SDK MEMORY MALLOC FAILED", ""),
//	EH102(8102, "GIZ SDK THREAD CREATE FAILED", ""),
	EH150(8150, "GIZ SDK USER ID INVALID", "用户ID无效"),
//	EH151(8151, "GIZ SDK TOEN INVALID", ""),
//	EH152(8152, "GIZ SDK GROUP ID INVALID", ""),
//	EH153(8153, "GIZ SDK GROUPNAME INVALID", ""),
//	EH154(8154, "GIZ SDK GROUP PRODUCTKEY INVALID", ""),
//	EH155(8155, "GIZ SDK GROUP FAILED DELETE DEVICE", ""),
//	EH156(8156, "GIZ SDK GROUP FAILED ADD DEVICE", ""),
//	EH157(8157, "GIZ SDK GROUP GET DEVICE FAILED", ""),
//	EH201(8201, "GIZ SDK DATAPOINT NOT DOWNLOAD", ""),
//	EH202(8202, "GIZ SDK DATAPOINT SERVICE UNAVAILABLE", ""),
//	EH203(8203, "GIZ SDK DATAPOINT PARSE FAILED", ""),
//	EH300(8300, "GIZ SDK SDK NOT INITIALIZED", ""),
//	EH301(8301, "GIZ SDK APK CONTEXT IS NULL", ""),
//	EH302(8302, "GIZ SDK APK PERMISSION NOT SET", ""),
//	EH303(8303, "GIZ SDK CHMOD DAEMON REFUSED", ""),
//	EH304(8304, "GIZ SDK EXEC DAEMON FAILED", ""),
//	EH305(8305, "GIZ SDK EXEC CATCH EXCEPTION", ""),
	EH306(8306, "GIZ SDK APPID IS EMPTY", "APPID为空");
//	EH307(8307, "GIZ SDK UNSUPPORTED API", ""),
//	EH308(8308, "GIZ SDK REQUEST TIMEOUT", ""),
//	EH309(8309, "GIZ SDK DAEMON VERSION INVALID", ""),
//	EH310(8310, "GIZ SDK PHONE NOT CONNECT TO SOFTAP SSID", ""),
//	EH311(8311, "GIZ SDK DEVICE CONFIG SSID NOT MATCHED", ""),
//	EH312(8312, "GIZ SDK NOT IN SOFTAPMODE", ""),
//	EH313(8313, "GIZ SDK CONFIG NO AVAILABLE WIFI", ""),
//	EH314(8314, "GIZ SDK RAW DATA TRANSMIT", ""),
//	EH315(8315, "GIZ SDK PRODUCT IS DOWNLOADING", "");

	/**  错误描述. */
	private String EngDescript, CHNDescript;

	/**  错误码. */
	private int num;

	/**
	 * 错误码枚举类构造方法.
	 *
	 * @param num            错误码
	 * @param EngDescript            错误英文描述
	 * @param CHNDescript            错误中文描述
	 */
	private GizwitsErrorMsg(int num, String EngDescript, String CHNDescript) {
		this.num = num;
		this.EngDescript = EngDescript;
		this.CHNDescript = CHNDescript;
	}

	/**
	 * 获取错误码英文描述.
	 *
	 * @return 英文描述
	 */
	public String getEngDescript() {
		return EngDescript;
	}

	/**
	 * 获取错误码中文描述.
	 *
	 * @return 中文描述
	 */
	public String getCHNDescript() {
		return CHNDescript;
	}

	/**
	 * 获取错误码.
	 *
	 * @return 错误码
	 */
	public int getNum() {
		return num;
	}

	/**
	 * 根据错误码返回枚举类.
	 *
	 * @param num            错误码
	 * @return 枚举对象
	 */
	public static GizwitsErrorMsg getEqual(int num) {
		for (GizwitsErrorMsg GEM : GizwitsErrorMsg.values()) {
			if (GEM.getNum() == num)
				return GEM;
		}
		return E0;
	}

}
