package com.offertooffer.demo.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import cn.bmob.im.BmobUserManager;
import cn.bmob.im.bean.BmobChatUser;

/**
 * 除登陆注册和欢迎页面外继承的基类-用于检测是否有其他设备登录了同一账号
 * 
 * @ClassName: ActivityBase
 * @Description: TODO
 * @author smile
 * @date 2014-6-13 下午5:18:24
 */
public class ActivityBase extends BaseActivity {

	public Dialog dialog_tip;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// 自动登陆状态下检测是否在其他设备登陆
		checkLogin();
		getCurrentUser();
	}
	public <T> void  startActivity_mine(Class<T> class1) {
		// TODO Auto-generated method stub
		Intent i=new Intent(getApplicationContext(), class1);
		startActivity(i);
		
	}

	public void showMyDialog(String string) {
		// TODO Auto-generated method stub
		if (dialog_tip == null) {
			dialog_tip = new Dialog(getApplicationContext());
		}

		dialog_tip.setTitle(string);
		dialog_tip.show();

	}

	public void hideDialog(String string) {
		// TODO Auto-generated method stub
		if (dialog_tip != null) {
			dialog_tip.dismiss();
		}

	

	}

	public BmobChatUser getCurrentUser() {
		// TODO Auto-generated method stub
		userManager = BmobUserManager.getInstance(getApplicationContext());
		BmobChatUser currentUser = userManager.getCurrentUser();
		return currentUser;
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		// 锁屏状态下的检测
		checkLogin();
	}

	public void checkLogin() {
		BmobUserManager userManager = BmobUserManager.getInstance(this);
		if (userManager.getCurrentUser() == null) {
			ShowToast("您的账号已在其他设备上登录!");
			startActivity(new Intent(this, LoginActivity.class));
			finish();
		}
	}

	/**
	 * 隐藏软键盘 hideSoftInputView
	 * 
	 * @Title: hideSoftInputView
	 * @Description: TODO
	 * @param
	 * @return void
	 * @throws
	 */
	public void hideSoftInputView() {
		InputMethodManager manager = ((InputMethodManager) this
				.getSystemService(Activity.INPUT_METHOD_SERVICE));
		if (getWindow().getAttributes().softInputMode != WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN) {
			if (getCurrentFocus() != null)
				manager.hideSoftInputFromWindow(getCurrentFocus()
						.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
		}
	}

}
