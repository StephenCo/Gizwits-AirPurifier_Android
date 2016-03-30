/**
 * Project Name:XPGSdkV4AppBase
 * File Name:XpgApplication.java
 * Package Name:com.gizwits.framework
 * Date:2015-1-22 18:16:04
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
package com.future.framework;

import android.app.Application;

import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.LocationClientOption.LocationMode;
import com.future.framework.config.Configs;
import com.future.framework.listeners.MyLocationListener;
import com.xpg.common.useful.NetworkUtils;
import com.xtremeprog.xpgconnect.XPGWifiSDK;

/**
 * 
 * The Class WApplication.
 * 
 * Application类
 * 
 * @author Lien
 */
public class XpgApplication extends Application {
	
	public LocationClient mLocationClient = null;
	public BDLocationListener myListener= new MyLocationListener();

	/* (non-Javadoc)
	 * @see android.app.Application#onCreate()
	 */
	public void onCreate() {
		super.onCreate();
		// 初始化sdk,传入appId,登录机智云官方网站查看产品信息获得 AppID
		XPGWifiSDK.sharedInstance().startWithAppID(getApplicationContext(),
				Configs.APPID);
		// 设定日志打印级别,日志保存文件名，是否在后台打印数据.
		XPGWifiSDK.sharedInstance().setLogLevel(Configs.LOG_LEVEL,
				"BassApp.log", Configs.DEBUG);
		
		if (NetworkUtils.isNetworkConnected(getApplicationContext())) {
			mLocationClient = new LocationClient(getApplicationContext()); // 声明LocationClient类
			mLocationClient.registerLocationListener(myListener); // 注册监听函数
			initLocation();
			mLocationClient.start();
		}
	}
	
	private void initLocation() {
		LocationClientOption option = new LocationClientOption();
		option.setLocationMode(LocationMode.Hight_Accuracy);// 可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
		option.setCoorType("bd09ll");// 可选，默认gcj02，设置返回的定位结果坐标系
		option.setIsNeedAddress(true);// 可选，设置是否需要地址信息，默认不需要
		option.setOpenGps(true);// 可选，默认false,设置是否使用gps
		mLocationClient.setLocOption(option);
	}
}
