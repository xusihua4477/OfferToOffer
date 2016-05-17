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
 * ����½ע��ͻ�ӭҳ����̳еĻ���-���ڼ���Ƿ��������豸��¼��ͬһ�˺�
 * 
 * @ClassName: ActivityBase
 * @Description: TODO
 * @author smile
 * @date 2014-6-13 ����5:18:24
 */
public class ActivityBase extends BaseActivity {

	public Dialog dialog_tip;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// �Զ���½״̬�¼���Ƿ��������豸��½
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
		// ����״̬�µļ��
		checkLogin();
	}

	public void checkLogin() {
		BmobUserManager userManager = BmobUserManager.getInstance(this);
		if (userManager.getCurrentUser() == null) {
			ShowToast("�����˺����������豸�ϵ�¼!");
			startActivity(new Intent(this, LoginActivity.class));
			finish();
		}
	}

	/**
	 * ��������� hideSoftInputView
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
