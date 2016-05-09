package com.offertooffer.demo.ui.fragment;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.GetChars;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;

import cn.bmob.im.BmobChat;
import cn.bmob.im.bean.BmobChatUser;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobObject;
import cn.bmob.v3.listener.SaveListener;

import com.offertooffer.demo.R;
import com.offertooffer.demo.adapter.ShowTuiJianAdapter;
import com.offertooffer.demo.adapter.ShowZhaoPinAdapter;
import com.offertooffer.demo.adapter.UserFriendAdapter;
import com.offertooffer.demo.bean.OfferUser;
import com.offertooffer.demo.bean.PingJia;
import com.offertooffer.demo.bean.Record_YingPin;
import com.offertooffer.demo.bean.Record_ZhaoPin;
import com.offertooffer.demo.bean.User;
import com.offertooffer.demo.ui.ChatActivity;
import com.offertooffer.demo.ui.FragmentBase;
import com.offertooffer.demo.ui.MainActivity;
import com.offertooffer.demo.util.CharacterParser;
import com.offertooffer.demo.view.ClearEditText;
import com.offertooffer.demo.view.MyLetterView;

/**
 * 联系人
 * 
 * @ClassName: ContactFragment
 * @Description: TODO
 * @author smile
 * @date 2014-6-7 下午1:02:05
 */
@SuppressLint("DefaultLocale")
public class InfoListFragment extends FragmentBase  {

	ClearEditText mClearEditText;
	public ListView lvForXinxi;
	TextView dialog;

	private InputMethodManager inputMethodManager;

	/**
	 * 汉字转换成拼音的类
	 */
	private CharacterParser characterParser;
	private MainActivity mainActivity;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		System.out.println();

		return inflater.inflate(R.layout.fragment_zhaopin_list, container,
				false);

	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
		
		initTopBarForOnlyTitle("信息列表");
		initView();
		//默认让本页面的listview 显示招聘列表
		mainActivity.setDataForZhaoPinlist(lvForXinxi, getActivity().getApplicationContext());
	}

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		mainActivity = (MainActivity) activity;
	}

	private void initView() {
		// TODO Auto-generated method stub
		lvForXinxi = (ListView) findViewById(R.id.lvForXinxi);
	}

	private void findUser(String zhongjie_id) {
		// TODO Auto-generated method stub
		
	}

	public void setTuijianlvAdapter(List<Record_YingPin> lists) {
		// TODO Auto-generated method stub
		MainActivity abcd = (MainActivity) getActivity();

		ShowTuiJianAdapter showTuiJianAdapter = new ShowTuiJianAdapter(abcd,
				lists, new ShowTuiJianAdapter.OnItem_onclickLister() {

					@Override
					public void btn_connect_zhongjie(User user) {
						// TODO Auto-generated method stub
						   
						   Intent intent = new Intent(mainActivity, ChatActivity.class);
							intent.putExtra("user", user);
							startAnimActivity(intent);

						
						
					}

				

				});

		lvForXinxi.setAdapter(showTuiJianAdapter);
		lvForXinxi.invalidate();
	}

	public void setZhaopinlvAdapter(List<Record_ZhaoPin> lists) {
		MainActivity abcd = (MainActivity) getActivity();
		//创建适配器并监听每个item中的招聘者单击事件
		ShowZhaoPinAdapter showTuiJianAdapter = new ShowZhaoPinAdapter(mainActivity,
				lists, new ShowZhaoPinAdapter.OnItem_onclickLister() {

					@Override
					public void btn_connect_zhaopinzhe(User user) {
						 
						   Intent intent = new Intent(mainActivity, ChatActivity.class);
							intent.putExtra("user", user);
							startAnimActivity(intent);

					}

				});

		lvForXinxi.setAdapter(showTuiJianAdapter);
		lvForXinxi.invalidate();
   
	}

}
