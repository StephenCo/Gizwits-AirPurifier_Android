/**
 * Project Name:XPGSdkV4AppBase
 * File Name:DeviceManageDetailActivity.java
 * Package Name:com.wits.framework.activity.device
 * Date:2015-1-27 14:45:23
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
package com.future.framework.activity.device;

import java.util.List;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.future.airpurifier.R;
import com.future.framework.activity.BaseActivity;
import com.future.framework.config.GizwitsErrorMsg;
import com.future.framework.utils.DialogManager;
import com.future.framework.utils.StringUtils;
import com.xpg.common.useful.NetworkUtils;
import com.xpg.ui.utils.ToastUtils;
import com.xtremeprog.xpgconnect.XPGWifiDevice;

//TODO: Auto-generated Javadoc
/**
 * 
 * ClassName: Class DeviceManageDetailActivity. <br/>
 * 设备详细信息，该类主要有以下功能：1、修改当前设备名称；2、删除与当前设备的绑定关系<br/>
 * date: 2014-12-09 17:27:10 <br/>
 * 
 * @author StephenC
 */
public class DeviceManageDetailActivity extends BaseActivity implements
		OnClickListener {

	/** The iv back. */
	private ImageView ivBack;
	
	/** The iv tick. */
	private ImageView ivTick;

	/** The tv init date. */
	private TextView tvDate;

	/** The tv init place. */
	private TextView tvPlace;;

	/** The tv device type. */
	private TextView tvDeviceType;

	/** The tv device code. */
	private TextView tvDeviceCode;

	/** The et device name. */
	private EditText etName;

	/** The btn delDevice. */
	private Button btnDelDevice;

	/** 当前设备的实例 */
	private XPGWifiDevice XPGWifiDevice;

	/** 确定是否解绑的对话框 */
	private Dialog unbindDialog;

	/** 等待中的对话框 */
	private ProgressDialog progressDialog;
	
	private boolean isChange = true;
	
//	/** the msg */
//	private Message msg = new Message();

	/**
	 * ClassName: Enum handler_key. <br/>
	 * <br/>
	 * date: 2014-11-26 17:51:10 <br/>
	 * 
	 * @author Lien
	 */
	private enum handler_key {

		/** 修改名称成功 */
		CHANGE_SUCCESS,

		/** 修改名称失败 */
		CHANGE_FAIL,

		/** 删除绑定关系成功 */
		DELETE_SUCCESS,

		/** 删除绑定关系失败 */
		DELETE_FAIL,
		
		/** 获取绑定列表 */
		GET_BOUND,

	}

	/** The handler. */
	Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			handler_key key = handler_key.values()[msg.what];
			
			switch (key) {
			case CHANGE_SUCCESS:
				DialogManager.dismissDialog(DeviceManageDetailActivity.this, progressDialog);
				ToastUtils.showShort(DeviceManageDetailActivity.this, "修改成功！");
				finish();
				break;

			case CHANGE_FAIL:
				DialogManager.dismissDialog(DeviceManageDetailActivity.this, progressDialog);
				ToastUtils.showShort(DeviceManageDetailActivity.this, "修改失败:"
						+ msg.obj.toString());
				break;

			case DELETE_SUCCESS:
				DialogManager.dismissDialog(DeviceManageDetailActivity.this, progressDialog);
				ToastUtils.showShort(DeviceManageDetailActivity.this, "删除成功！");
				finish();
				break;

			case DELETE_FAIL:
				DialogManager.dismissDialog(DeviceManageDetailActivity.this, progressDialog);
				ToastUtils.showShort(DeviceManageDetailActivity.this, "删除失败:"
						+ msg.obj.toString());
				break;
				
			case GET_BOUND:
				String uid = setmanager.getUid();
				String token = setmanager.getToken();
				mCenter.cGetBoundDevices(uid, token);
				break;
			}
		}

	};

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.wits.aircondition.activity.BaseActivity#onCreate(android.os.Bundle
	 * )
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_devices_info);
		initParams();
		initViews();
		initEvents();

	}

	/**
	 * Inits the params.
	 */
	private void initParams() {
		if (getIntent() != null) {
			String mac = getIntent().getStringExtra("mac");
			String did = getIntent().getStringExtra("did");
			XPGWifiDevice = findDeviceByMac(mac, did);
			XPGWifiDevice.setListener(deviceListener);
		}

	}

	/**
	 * Inits the views.
	 */
	private void initViews() {
		ivBack = (ImageView) findViewById(R.id.ivBack);
		ivTick = (ImageView) findViewById(R.id.ivTick);
		tvDate = (TextView) findViewById(R.id.tvDate);
		tvPlace = (TextView) findViewById(R.id.tvPlace);
		tvDeviceType = (TextView) findViewById(R.id.tvDeviceType);
		tvDeviceCode = (TextView) findViewById(R.id.tvDeviceCode);
		etName = (EditText) findViewById(R.id.etName);
		btnDelDevice = (Button) findViewById(R.id.btnDelDevice);
		unbindDialog = DialogManager.getUnbindDialog(this, this);
		progressDialog = new ProgressDialog(this);
		progressDialog.setCancelable(false);
		if (XPGWifiDevice != null) {
			if(StringUtils.isEmpty(XPGWifiDevice.getRemark())){
				String macAddress=XPGWifiDevice.getMacAddress();
				int size=macAddress.length();
				etName.setText(XPGWifiDevice.getProductName() + macAddress.substring(size-4, size));
			}else{
				etName.setText(XPGWifiDevice.getRemark());
			}
		}
	}

	/**
	 * Inits the events.
	 */
	private void initEvents() {
		btnDelDevice.setOnClickListener(this);
		ivBack.setOnClickListener(this);
		ivTick.setOnClickListener(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.ivBack:
			onBackPressed();
			break;
		case R.id.btnDelDevice:
			DialogManager.showDialog(this, unbindDialog);

			break;
		case R.id.ivTick:
			if (!NetworkUtils.isNetworkConnected(this)) {
				ToastUtils.showShort(this, "网络未连接");return;
			}
			if (!StringUtils.isEmpty(etName.getText().toString())) {
				isChange = true;
				progressDialog.setMessage("修改中，请稍候...");
				DialogManager.showDialog(this, progressDialog);
				mCenter.cUpdateRemark(setmanager.getUid(), setmanager
						.getToken(), XPGWifiDevice.getDid(), XPGWifiDevice
						.getPasscode(), etName.getText().toString());
			} else {
				ToastUtils.showShort(DeviceManageDetailActivity.this,
						"请输入一个设备名称");
			}
			break;
		case R.id.right_btn:
			if (!NetworkUtils.isNetworkConnected(this)) {
				ToastUtils.showShort(this, "网络未连接");return;
			}
			isChange = false;
			DialogManager.dismissDialog(this, unbindDialog);
			progressDialog.setMessage("删除中，请稍候...");
			DialogManager.showDialog(this, progressDialog);
			mCenter.cUnbindDevice(setmanager.getUid(), setmanager.getToken(),
					XPGWifiDevice.getDid(), XPGWifiDevice.getPasscode());
			break;
		}

	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onBackPressed()
	 */
	@Override
	public void onBackPressed() {
		finish();
	}

	/* (non-Javadoc)
	 * @see com.wits.framework.activity.BaseActivity#didBindDevice(int, java.lang.String, java.lang.String)
	 */
	@Override
	protected void didBindDevice(int error, String did) {
		Log.e("Device扫描结果", "error=" + error + ";did=" + did);
		Message msg = new Message();
		if (error == 0) {
			
			msg.what=handler_key.GET_BOUND.ordinal();
			handler.sendMessage(msg);
		} else {
			msg.what = handler_key.CHANGE_FAIL.ordinal();
			msg.obj = GizwitsErrorMsg.getEqual(error).getCHNDescript();
			handler.sendMessage(msg);
		}
		
	}
	
	/* (non-Javadoc)
	 * @see com.wits.framework.activity.BaseActivity#didUnbindDevice(int, java.lang.String, java.lang.String)
	 */
	@Override
	protected void didUnbindDevice(int error, String did) {
		Message msg = new Message();
		if (error == 0) {
			isChange = true;
			msg.what=handler_key.GET_BOUND.ordinal();
			handler.sendMessage(msg);
		} else {
			msg.what = handler_key.DELETE_FAIL.ordinal();
			msg.obj = GizwitsErrorMsg.getEqual(error).getCHNDescript();
			handler.sendMessage(msg);
		}
		
	}

	@Override
	protected void didDiscovered(int error, List<XPGWifiDevice> deviceList) {
		Log.d("onDiscovered", "Device count:" + deviceList.size());
		deviceslist=deviceList;
		Message msg = new Message();
		if(msg!=null)
		{
			msg.what=isChange ? handler_key.CHANGE_SUCCESS.ordinal() : handler_key.DELETE_SUCCESS.ordinal();
			handler.sendMessageDelayed(msg, 1500);
			msg=null;
		}
	}
	
	
}
