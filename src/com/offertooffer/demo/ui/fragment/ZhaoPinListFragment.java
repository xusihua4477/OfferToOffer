package com.offertooffer.demo.ui.fragment;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
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
import com.offertooffer.demo.adapter.UserFriendAdapter;
import com.offertooffer.demo.bean.OfferUser;
import com.offertooffer.demo.bean.PingJia;
import com.offertooffer.demo.bean.User;
import com.offertooffer.demo.ui.FragmentBase;
import com.offertooffer.demo.util.CharacterParser;
import com.offertooffer.demo.view.ClearEditText;
import com.offertooffer.demo.view.MyLetterView;

/**
 * 联系人
 * @ClassName: ContactFragment
 * @Description: TODO
 * @author smile
 * @date 2014-6-7 下午1:02:05
 */
@SuppressLint("DefaultLocale")
public class ZhaoPinListFragment extends FragmentBase implements OnItemClickListener,OnItemLongClickListener{

	ClearEditText mClearEditText;

	TextView dialog;

	ListView listForXinxi;
	MyLetterView right_letter;

	private UserFriendAdapter userAdapter;// 好友

	List<User> friends = new ArrayList<User>();

	private InputMethodManager inputMethodManager;
	
	/**
	 * 汉字转换成拼音的类
	 */
	private CharacterParser characterParser;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
			
	
		
		return inflater.inflate(R.layout.fragment_zhaopin_list, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
	
System.out.println("onActivityCreated");
System.out.println("onActivityCreated");
System.out.println("onActivityCreated");
initTopBarForOnlyTitle("信息列表");
}

	@Override
	public boolean onItemLongClick(AdapterView<?> parent, View view,
			int position, long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		
	}

	

}
