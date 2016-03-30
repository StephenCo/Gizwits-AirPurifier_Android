package com.future.framework.webservice;

import org.json.JSONObject;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

/**
 * 天气服务，通过百度的lbs 的ip定位服务，获取当前用户的所在城市的天气
 * 
 * @link 
 *       http://api.map.baidu.com/telematics/v3/weather
 * @author StephenC
 * 
 */
public abstract class WeatherService {

	private final String requestUrl = "http://api.map.baidu.com/telematics/v3/weather?output=json&ak=DV1mGK81DZqAAbF4jro2LA33hcDYI3Qm&location=";

	
	public abstract void onSuccess(JSONObject data);
	public abstract void onFailed();
	
	/**
	 * 获取天气状态
	 */
	public void startLocation(String city){
		AsyncHttpClient client = new AsyncHttpClient();
		client.get(requestUrl+city, new JsonHttpResponseHandler(){
			
			@Override
			public void onFailure(Throwable arg0, JSONObject arg1) {
				super.onFailure(arg0, arg1);
				onFailed();
			}
			
			@Override
			public void onSuccess(JSONObject json) {
				WeatherService.this.onSuccess(json);
			}
		});
	}
	
}
