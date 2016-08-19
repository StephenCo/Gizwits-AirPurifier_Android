/**
 * Project Name:GizSdkV4AppBase
 * File Name:CmdCenter.java
 * Package Name:com.gizwits.framework.sdk
 * Date:2015-1-27 14:47:19
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
package com.future.framework.sdk;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

import com.future.framework.config.Configs;
import com.future.framework.config.JsonKeys;
import com.gizwits.gizwifisdk.api.GizWifiDevice;
import com.gizwits.gizwifisdk.api.GizWifiSDK;
import com.gizwits.gizwifisdk.enumration.GizWifiGAgentType;
import com.gizwits.gizwifisdk.enumration.XPGWifiConfigureMode;
import com.gizwits.gizwifisdk.enumration.XPGWifiGAgentType;

// TODO: Auto-generated Javadoc

/**
 * ClassName: Class CmdCenter. <br/>
 * 控制指令类 <br/>
 * date: 2014-12-15 12:09:02 <br/>
 * 
 * @author Lien
 */
public class CmdCenter {

	/** The Constant TAG. */
	private static final String TAG = "CmdCenter";

	/**
	 * The Giz wifi sdk.
	 */
	private static GizWifiSDK GizWifiGCC;

	/**
	 * The m center.
	 */
	private static CmdCenter mCenter;

	/**
	 * The m setting manager.
	 */
	private SettingManager mSettingManager;

	/**
	 * Instantiates a new cmd center.
	 * 
	 * @param c
	 *            the c
	 */
	private CmdCenter(Context c) {
		if (mCenter == null) {
			init(c);
		}
	}

	/**
	 * Gets the single instance of CmdCenter.
	 * 
	 * @param c
	 *            the c
	 * @return single instance of CmdCenter
	 */
	public static CmdCenter getInstance(Context c) {
		if (mCenter == null) {
			mCenter = new CmdCenter(c);
		}
		return mCenter;
	}

	/**
	 * Inits the.
	 * 
	 * @param c
	 *            the c
	 */
	private void init(Context c) {
		mSettingManager = new SettingManager(c);

		GizWifiGCC = GizWifiSDK.sharedInstance();

	}

	/**
	 * Gets the Giz wifi sdk.
	 * 
	 * @return the Giz wifi sdk
	 */
	public GizWifiSDK getGizWifiSDK() {
		return GizWifiGCC;
	}

	// =================================================================
	//
	// 关于账号的指令
	//
	// =================================================================

	/**
	 * 注册账号.
	 * 
	 * @param phone
	 *            注册手机号
	 * @param code
	 *            验证码
	 * @param password
	 *            注册密码
	 */
	public void cRegisterPhoneUser(String phone, String code, String password) {
		GizWifiGCC.registerUserByPhoneAndCode(phone, password, code);
	}

	/**
	 * C register mail user.
	 *
	 * @param mailAddr
	 *            the mail addr
	 * @param password
	 *            the password
	 */
	public void cRegisterMailUser(String mailAddr, String password) {
		GizWifiGCC.registerUserByEmail(mailAddr, password);
	}

	/**
	 * 匿名登录
	 * <p/>
	 * 如果一开始不需要直接注册账号，则需要进行匿名登录.
	 */
	public void cLoginAnonymousUser() {
		GizWifiGCC.userLoginAnonymous();
	}

	/**
	 * 账号注销.
	 */
	public void cLogout() {
		Log.e(TAG, "cLogout:uesrid=" + mSettingManager.getUid());
		GizWifiGCC.userLogout(mSettingManager.getUid());
	}

	/**
	 * 账号登陆.
	 * 
	 * @param name
	 *            用户名
	 * @param psw
	 *            密码
	 */
	public void cLogin(String name, String psw) {
		GizWifiGCC.userLoginWithUserName(name, psw);
	}

	/**
	 * 忘记密码.
	 * 
	 * @param phone
	 *            手机号
	 * @param code
	 *            验证码
	 * @param newPassword
	 *            the new password
	 */
	public void cChangeUserPasswordWithCode(String phone, String code, String newPassword) {
		GizWifiGCC.changeUserPasswordByCode(phone, code, newPassword);
	}

	/**
	 * 修改密码.
	 * 
	 * @param token
	 *            令牌
	 * @param oldPsw
	 *            旧密码
	 * @param newPsw
	 *            新密码
	 */
	public void cChangeUserPassword(String token, String oldPsw, String newPsw) {
		GizWifiGCC.changeUserPassword(token, oldPsw, newPsw);
	}

	/**
	 * 根据邮箱修改密码.
	 *
	 * @param email
	 *            邮箱地址
	 */
	public void cChangePassworfByEmail(String email) {
		GizWifiGCC.changeUserPasswordByEmail(email);
	}

	/**
	 * 请求向手机发送验证码.
	 * 
	 * @param phone
	 *            手机号
	 */
	public void cRequestSendVerifyCode(String token, String captchaId, String captchaCode, String phone) {
		// GizWifiGCC.requestSendVerifyCode(phone);
		GizWifiGCC.requestSendPhoneSMSCode(token, captchaId, captchaCode, phone);
	}

	/**
	 * 发送airlink广播，把需要连接的wifi的ssid和password发给模块。.
	 * 
	 * @param wifi
	 *            wifi名字
	 * @param password
	 *            wifi密码
	 */
	public void cSetAirLink(String wifi, String password, List<XPGWifiGAgentType> types) {
		/*
		 * GizWifiGCC.setDeviceWifi(wifi, password,
		 * GizWifiConfigureMode.GizWifiConfigureModeAirLink, 60);
		 */
		GizWifiGCC.setDeviceWifi(wifi, password, XPGWifiConfigureMode.XPGWifiConfigureModeAirLink, null, 60, types);
	}

	/**
	 * softap，把需要连接的wifi的ssid和password发给模块。.
	 * 
	 * @param wifi
	 *            wifi名字
	 * @param password
	 *            wifi密码
	 */
	public void cSetSoftAp(String wifi, String password, String ssidAP) {
		/*
		 * GizWifiGCC.setDeviceWifi(wifi, password,
		 * GizWifiConfigureMode.GizWifiConfigureModeSoftAP, 30);
		 */
		GizWifiGCC.setDeviceWifi(wifi, password, XPGWifiConfigureMode.XPGWifiConfigureModeSoftAP, ssidAP, 60, null);
	}

	/**
	 * 绑定后刷新设备列表，该方法会同时获取本地设备以及远程设备列表.
	 * 
	 * @param uid
	 *            用户名
	 * @param token
	 *            令牌
	 */
	public void cGetBoundDevices(String uid, String token) {
		List<String> product_key = new ArrayList<String>();
		product_key.add(Configs.PRODUCT_KEY);
		GizWifiGCC.getBoundDevices(uid, token, product_key);
		// GizWifiSdk.getBoundDevices(uid, token);
	}

	/**
	 * 绑定设备.
	 * 
	 * @param uid
	 *            用户名
	 * @param token
	 *            密码
	 * @param did
	 *            did
	 * @param passcode
	 *            passcode
	 * @param remark
	 *            备注
	 */
	public void cBindDevice(String uid, String token, String did, String passcode, String remark) {

		GizWifiGCC.bindDevice(uid, token, did, passcode, remark);
	}

	// =================================================================
	//
	// 关于控制设备的指令
	//
	// =================================================================

	/**
	 * 发送指令.
	 *
	 * @param GizWifiDevice
	 *            the Giz wifi device
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 */
	public void cWrite(GizWifiDevice GizWifiDevice, String key, Object value) {

		try {
			final JSONObject jsonsend = new JSONObject();
			JSONObject jsonparam = new JSONObject();
			jsonsend.put("cmd", 1);
			jsonparam.put(key, value);
			jsonsend.put(JsonKeys.KEY_ACTION, jsonparam);
			Log.i("sendjson", jsonsend.toString());
			GizWifiDevice.write(jsonsend.toString());
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 获取设备状态.
	 *
	 * @param GizWifiDevice
	 *            the Giz wifi device
	 */
	public void cGetStatus(GizWifiDevice GizWifiDevice) {
		JSONObject json = new JSONObject();
		try {
			json.put("cmd", 2);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		GizWifiDevice.write(json.toString());
	}

	/**
	 * 断开连接.
	 * 
	 * @param GizWifiDevice
	 *            the Giz wifi device
	 */
	public void cDisconnect(GizWifiDevice GizWifiDevice) {
		GizWifiDevice.disconnect();
	}

	/**
	 * 解除绑定.
	 * 
	 * @param uid
	 *            the uid
	 * @param token
	 *            the token
	 * @param did
	 *            the did
	 * @param passCode
	 *            the pass code
	 */
	public void cUnbindDevice(String uid, String token, String did, String passCode) {
		GizWifiGCC.unbindDevice(uid, token, did, passCode);
	}

	/**
	 * 更新备注.
	 * 
	 * @param uid
	 *            the uid
	 * @param token
	 *            the token
	 * @param did
	 *            the did
	 * @param passCode
	 *            the pass code
	 * @param remark
	 *            the remark
	 */
	public void cUpdateRemark(String uid, String token, String did, String passCode, String remark) {
		GizWifiGCC.bindDevice(uid, token, did, passCode, remark);
	}

	// =================================================================
	//
	// 智能云净化器控制相关
	//
	// =================================================================
	/**
	 * 净化器开关
	 * 
	 * @param GizWifiDevice
	 * @param isOn
	 */
	public void cSwitchOn(final GizWifiDevice GizWifiDevice, boolean isOn) {
		cWrite(GizWifiDevice, JsonKeys.ON_OFF, isOn);
	}

	/**
	 * 倒计时开机
	 * 
	 * @param GizWifiDevice
	 * @param isOn
	 */
	public void cCountDownOn(GizWifiDevice GizWifiDevice, int min) {
		cWrite(GizWifiDevice, JsonKeys.TIME_ON, min);
	}

	/**
	 * 倒计时关机
	 * 
	 * @param GizWifiDevice
	 * @param isOn
	 */
	public void cCountDownOff(GizWifiDevice GizWifiDevice, int min) {
		cWrite(GizWifiDevice, JsonKeys.TIME_OFF, min);
	}

	/**
	 * 风速
	 * 
	 * @param GizWifiDevice
	 * @param isOn
	 */
	public void cSetSpeed(GizWifiDevice GizWifiDevice, int lv) {
		cWrite(GizWifiDevice, JsonKeys.Mode, lv);
	}

	/**
	 * 等离子开关
	 * 
	 * @param GizWifiDevice
	 * @param isOn
	 */
	public void cSwitchPlasma(GizWifiDevice GizWifiDevice, boolean isOn) {
		cWrite(GizWifiDevice, JsonKeys.Plasma, isOn);
	}

	/**
	 * 空气质量指示灯(修改为空气阀门)
	 * 
	 * @param GizWifiDevice
	 * @param isOn
	 */
	public void cTap(GizWifiDevice GizWifiDevice, boolean isOn) {
		cWrite(GizWifiDevice, JsonKeys.TAP, isOn);
	}

	/**
	 * 儿童安全锁
	 * 
	 * @param GizWifiDevice
	 * @param isOn
	 */
	public void cChildLock(GizWifiDevice GizWifiDevice, boolean isOn) {
		cWrite(GizWifiDevice, JsonKeys.Child_Lock, isOn);
		getStatus(GizWifiDevice);
	}

	/**
	 * 重置滤网寿命
	 * 
	 * @param GizWifiDevice
	 * @param isOn
	 */
	public void cResetLife(GizWifiDevice GizWifiDevice) {
		cWrite(GizWifiDevice, JsonKeys.Filter_Life, 100);
	}
	
	/**
	 * 重置滤网寿命
	 * 
	 * @param GizWifiDevice
	 * @param isOn
	 */
	public void cResetLifeSec(GizWifiDevice GizWifiDevice) {
		cWrite(GizWifiDevice, JsonKeys.Filter_Life2, 100);
	}

	/**
	 * 空气检测灵敏度
	 * 
	 * @param GizWifiDevice
	 * @param isOn
	 */
	public void cAirSensitivity(GizWifiDevice GizWifiDevice, int lv) {
		cWrite(GizWifiDevice, JsonKeys.Air_Sensitivity, lv);
	}
	
	public void cDustOutdoor(GizWifiDevice GizWifiDevice, int dust) {
		cWrite(GizWifiDevice, JsonKeys.Dust_Outdoor, dust);
	}

	/**
	 * 延时查询数据
	 * 
	 * @param GizWifiDevice
	 */
	public void getStatus(final GizWifiDevice GizWifiDevice) {
		// try {
		// Thread.sleep(100);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		cGetStatus(GizWifiDevice);
	}
}
