package com.future.framework.receive;

import java.io.UnsupportedEncodingException;

import org.apache.http.entity.StringEntity;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

import com.future.framework.config.Configs;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

public class PushServer {
	public final static String requestUrl = "http://push.gizwitsapi.com/gizwits_clound_push/push/clients";

	public  static final void sendDeviceInfos(Context context, String token, String cid, AsyncHttpResponseHandler handler){
		Log.d("haha", "token="+token);
		AsyncHttpClient client = new AsyncHttpClient();
		client.addHeader("Content-Type","application/json");
		client.addHeader("X-Gizwits-Application-Id", Configs.APPID);
		client.addHeader("X-Gizwits-User-Token",token);
		
		JSONObject jsonParams = new JSONObject();
        StringEntity entity = null;
        
		try {
			jsonParams.put("type", "jiguang-android");
			jsonParams.put("cid", cid);
			jsonParams.put("cid_type", 2);
			
			entity = new StringEntity(jsonParams.toString(),"UTF-8");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Log.e("json", "" + jsonParams.toString());
		
		client.post(context, requestUrl, entity, "", handler);
	}
	
	public static final void  deletePush(Context context, String token, String cid, AsyncHttpResponseHandler handler) {
		AsyncHttpClient client = new AsyncHttpClient();
		client.addHeader("X-Gizwits-Application-Id", Configs.APPID);
		client.addHeader("X-Gizwits-User-Token",token);

		client.delete(context, requestUrl+"/"+cid, handler);
	}
}
