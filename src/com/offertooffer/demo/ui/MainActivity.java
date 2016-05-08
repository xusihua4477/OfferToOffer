package com.offertooffer.demo.ui;

import java.util.List;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import cn.bmob.im.BmobChat;
import cn.bmob.im.BmobChatManager;
import cn.bmob.im.BmobNotifyManager;
import cn.bmob.im.bean.BmobChatUser;
import cn.bmob.im.bean.BmobInvitation;
import cn.bmob.im.bean.BmobMsg;
import cn.bmob.im.config.BmobConfig;
import cn.bmob.im.db.BmobDB;
import cn.bmob.im.inteface.EventListener;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobQuery.CachePolicy;
import cn.bmob.v3.listener.FindListener;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.lidroid.xutils.BitmapUtils;
import com.offertooffer.demo.CustomApplcation;
import com.offertooffer.demo.MyMessageReceiver;
import com.offertooffer.demo.R;
import com.offertooffer.demo.adapter.ShowTuiJianAdapter;
import com.offertooffer.demo.bean.Record_YingPin;
import com.offertooffer.demo.bean.Record_ZhaoPin;
import com.offertooffer.demo.ui.fragment.ContactFragment;
import com.offertooffer.demo.ui.fragment.RecentFragment;
import com.offertooffer.demo.ui.fragment.SettingsFragment;
import com.offertooffer.demo.ui.fragment.ZhaoPinListFragment;

/**
 * 登陆
 * 
 * @ClassName: MainActivity
 * @Description: TODO
 * @author smile
 * @date 2014-5-29 下午2:45:35
 */
public class MainActivity extends ActivityBase implements EventListener {

	private Button[] mTabs;
	private ContactFragment contactFragment;
	private RecentFragment recentFragment;
	private SettingsFragment settingFragment;
	private Fragment[] fragments;
	private int index;
	private int currentTabIndex;

	ImageView iv_recent_tips, iv_contact_tips;// 消息提示
	private ZhaoPinListFragment zhaopinListFragment;
	private SlidingMenu slidingMenu;
	private View view_sldingMunu;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// 开启定时检测服务（单位为秒）-在这里检测后台是否还有未读的消息，有的话就取出来
		// 如果你觉得检测服务比较耗流量和电量，你也可以去掉这句话-同时还有onDestory方法里面的stopPollService方法
		BmobChat.getInstance(this).startPollService(20);
		// 开启广播接收器
		initNewMessageBroadCast();
		initTagMessageBroadCast();
		initView();
		initTab();
		initSiindMenu();
	}

	private void initSiindMenu() {
		// TODO Auto-generated method stub
		slidingMenu = new SlidingMenu(this);
		slidingMenu.setMode(SlidingMenu.LEFT);
		slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		// slidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		slidingMenu.setAlwaysDrawnWithCacheEnabled(true);
		// slidingMenu.setBehindOffset(100);
		slidingMenu.setBehindWidth(400);
		view_sldingMunu = View.inflate(getApplicationContext(),
				R.layout.slidingmenu, null);

		setSlidingMenuOnitemListener(view_sldingMunu);
		slidingMenu.setMenu(view_sldingMunu);
		slidingMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
		setSlidingmenu_UserInfo(view_sldingMunu);
	}

	private void setSlidingmenu_UserInfo(View view11) {
		// TODO Auto-generated method stub
		BmobChatUser currentUser = userManager.getCurrentUser();
		ImageView ivUser_slidingMenu = (ImageView) view11
				.findViewById(R.id.iv_headIv);
		TextView tvName = (TextView) view11.findViewById(R.id.tvLoginName);
		if (currentUser.getUsername() != null) {
			tvName.setText(currentUser.getUsername());
		}

		BitmapUtils bitmapUtils = new BitmapUtils(getApplicationContext());

		String uri = currentUser.getAvatar();
		bitmapUtils.display(ivUser_slidingMenu, uri);

		// ivUser_slidingMenu.setImageBitmap(bm);

	}

	private void setSlidingMenuOnitemListener(View view_sldingMunu) {
		// TODO Auto-generated method stub
		LinearLayout fl = (LinearLayout) view_sldingMunu
				.findViewById(R.id.framelayout_slindingmenu);
		for (int i = 0; i < fl.getChildCount(); i++) {
			final View view = fl.getChildAt(i);

			view.setOnClickListener(new OnClickListener() {

				private ZhaoPinListFragment zhaoPinListFragment;

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					if (view instanceof RelativeLayout) {
						int parseInt = Integer.parseInt(v.getTag().toString());
						Intent i;
						switch (parseInt) {
						// 对应 头像信息
						case 1:

							break;
						// 对应 发布招聘信息
						case 2:
							i = new Intent(MainActivity.this,
									PublishZhaoPinActivity.class);
							startActivity(i);
							break;
						// 对应 发布推荐人信息
						case 3:

							/*
							 * i = new Intent(MainActivity.this,
							 * PublishTuiJianLiActivity.class);
							 * startActivity(i);
							 */
							break;

						// 对应 浏览招聘信息
						case 4:
							/*
							 * i = new Intent(MainActivity.this,
							 * ShowZhaoPinActivity.class); startActivity(i);
							 */
							zhaoPinListFragment = (ZhaoPinListFragment) getSupportFragmentManager()
									.findFragmentByTag("zhaopinListFragment");
							initTopBarForOnlyTitle("招聘信息");
							setDataForZhaoPinlist(zhaoPinListFragment.lvForXinxi,MainActivity.this);
							slidingMenu.showContent();

							break;
						// 对应 浏览荐人信息
						case 5:
							initTopBarForOnlyTitle("人才推荐信息");
							zhaoPinListFragment = (ZhaoPinListFragment) getSupportFragmentManager()
									.findFragmentByTag("zhaopinListFragment");

							setDataForTuijianlist(
									zhaoPinListFragment.lvForXinxi,
									MainActivity.this);
							slidingMenu.showContent();
							/*
							 * i = new Intent(MainActivity.this,
							 * ShowTuiJianActivity.class); startActivity(i);
							 */
							break;
						// 对应 我发布的信息
						case 6:

							break;
						// 对应 通知信息
						case 7:

							break;
						default:
							slidingMenu.toggle();
							break;
						}
					}
				}
			});
		}
	}

	public void setDataForTuijianlist(final ListView lvForXinxi,
			final Context context) {

		final BmobQuery<Record_YingPin> bmobQuery = new BmobQuery<Record_YingPin>();
		bmobQuery.order("createdAt");
		// 先判断是否有缓存
		boolean isCache = bmobQuery.hasCachedResult(context,
				Record_YingPin.class);
		if (isCache) {
			bmobQuery.setCachePolicy(CachePolicy.CACHE_ELSE_NETWORK); // 先从缓存取数据，如果没有的话，再从网络取。
		} else {
			bmobQuery.setCachePolicy(CachePolicy.NETWORK_ELSE_CACHE); // 如果没有缓存的话，则先从网络中取
		}
		bmobQuery.findObjects(context, new FindListener<Record_YingPin>() {
			@SuppressLint("ShowToast")
			@Override
			public void onError(int arg0, String arg1) {
				Toast.makeText(context, arg1, 3000).show();

			}

			@Override
			public void onSuccess(List<Record_YingPin> lists) {
				// TODO Auto-generated method stub
				zhaopinListFragment.setTuijianlvAdapter(lists);

			}

		});

	}

	public void setDataForZhaoPinlist(final ListView lvForXinxi,
			final Context context) {

		final BmobQuery<Record_ZhaoPin> bmobQuery = new BmobQuery<Record_ZhaoPin>();
		bmobQuery.order("createdAt");
		// 先判断是否有缓存
		boolean isCache = bmobQuery.hasCachedResult(context,
				Record_ZhaoPin.class);
			bmobQuery.setCachePolicy(CachePolicy.NETWORK_ELSE_CACHE); // 如果没有缓存的话，则先从网络中取
		
		bmobQuery.findObjects(context, new FindListener<Record_ZhaoPin>() {
			@SuppressLint("ShowToast")
			@Override
			public void onError(int arg0, String arg1) {
				Toast.makeText(context, arg1, 3000).show();

			}

			@Override
			public void onSuccess(List<Record_ZhaoPin> lists) {
				// TODO Auto-generated method stub
				System.out.println(lists.get(0).toString());
				System.out.println(lists.get(0).toString());
				System.out.println(lists.get(0).toString());
				zhaopinListFragment.setZhaopinlvAdapter(lists);

			}

		});

	}

	private void initView() {
		mTabs = new Button[4];
		mTabs[0] = (Button) findViewById(R.id.btn_message);
		mTabs[1] = (Button) findViewById(R.id.btn_contract);
		mTabs[2] = (Button) findViewById(R.id.btn_set);
		mTabs[3] = (Button) findViewById(R.id.btn_news);
		iv_recent_tips = (ImageView) findViewById(R.id.iv_recent_tips);
		iv_contact_tips = (ImageView) findViewById(R.id.iv_contact_tips);
		// 把第信息列表设为选中状态
		mTabs[3].setSelected(true);
		currentTabIndex = 3;
	}

	private void initTab() {
		contactFragment = new ContactFragment();
		recentFragment = new RecentFragment();
		settingFragment = new SettingsFragment();
		zhaopinListFragment = new ZhaoPinListFragment();
		fragments = new Fragment[] { recentFragment, contactFragment,
				settingFragment, zhaopinListFragment };
		// 添加显示第一个fragment
		getSupportFragmentManager()
				.beginTransaction()
				.add(R.id.fragment_container, recentFragment, "recentFragment")
				.hide(recentFragment)
				.add(R.id.fragment_container, zhaopinListFragment,
						"zhaopinListFragment").hide(zhaopinListFragment)
				.add(R.id.fragment_container, contactFragment)
				.hide(contactFragment).show(zhaopinListFragment).commit();
	}

	/**
	 * button点击事件
	 * 
	 * @param view
	 */
	public void onTabSelect(View view) {
		switch (view.getId()) {
		case R.id.btn_message:
			index = 0;
			break;
		case R.id.btn_contract:
			index = 1;
			break;
		case R.id.btn_set:
			index = 2;
			break;
		case R.id.btn_news:
			index = 3;
			break;
		}
		if (currentTabIndex != index) {
			FragmentTransaction trx = getSupportFragmentManager()
					.beginTransaction();
			trx.hide(fragments[currentTabIndex]);
			if (!fragments[index].isAdded()) {
				trx.add(R.id.fragment_container, fragments[index]);
			}
			trx.show(fragments[index]).commit();
		}
		mTabs[currentTabIndex].setSelected(false);
		// 把当前tab设为选中状态
		mTabs[index].setSelected(true);
		currentTabIndex = index;
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		// 小圆点提示
		if (BmobDB.create(this).hasUnReadMsg()) {
			iv_recent_tips.setVisibility(View.VISIBLE);
		} else {
			iv_recent_tips.setVisibility(View.GONE);
		}
		if (BmobDB.create(this).hasNewInvite()) {
			iv_contact_tips.setVisibility(View.VISIBLE);
		} else {
			iv_contact_tips.setVisibility(View.GONE);
		}
		MyMessageReceiver.ehList.add(this);// 监听推送的消息
		// 清空
		MyMessageReceiver.mNewNum = 0;

	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		MyMessageReceiver.ehList.remove(this);// 取消监听推送的消息
	}

	@Override
	public void onMessage(BmobMsg message) {
		// TODO Auto-generated method stub
		refreshNewMsg(message);
	}

	/**
	 * 刷新界面
	 * 
	 * @Title: refreshNewMsg
	 * @Description: TODO
	 * @param @param message
	 * @return void
	 * @throws
	 */
	private void refreshNewMsg(BmobMsg message) {
		// 声音提示
		boolean isAllow = CustomApplcation.getInstance().getSpUtil()
				.isAllowVoice();
		if (isAllow) {
			CustomApplcation.getInstance().getMediaPlayer().start();
		}
		iv_recent_tips.setVisibility(View.VISIBLE);
		// 也要存储起来
		if (message != null) {
			BmobChatManager.getInstance(MainActivity.this).saveReceiveMessage(
					true, message);
		}
		if (currentTabIndex == 0) {
			// 当前页面如果为会话页面，刷新此页面
			if (recentFragment != null) {
				recentFragment.refresh();
			}
		}
	}

	NewBroadcastReceiver newReceiver;

	private void initNewMessageBroadCast() {
		// 注册接收消息广播
		newReceiver = new NewBroadcastReceiver();
		IntentFilter intentFilter = new IntentFilter(
				BmobConfig.BROADCAST_NEW_MESSAGE);
		// 优先级要低于ChatActivity
		intentFilter.setPriority(3);
		registerReceiver(newReceiver, intentFilter);
	}

	/**
	 * 新消息广播接收者
	 * 
	 */
	private class NewBroadcastReceiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			// 刷新界面
			refreshNewMsg(null);
			// 记得把广播给终结掉
			abortBroadcast();
		}
	}

	TagBroadcastReceiver userReceiver;

	private void initTagMessageBroadCast() {
		// 注册接收消息广播
		userReceiver = new TagBroadcastReceiver();
		IntentFilter intentFilter = new IntentFilter(
				BmobConfig.BROADCAST_ADD_USER_MESSAGE);
		// 优先级要低于ChatActivity
		intentFilter.setPriority(3);
		registerReceiver(userReceiver, intentFilter);
	}

	/**
	 * 标签消息广播接收者
	 */
	private class TagBroadcastReceiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			BmobInvitation message = (BmobInvitation) intent
					.getSerializableExtra("invite");
			refreshInvite(message);
			// 记得把广播给终结掉
			abortBroadcast();
		}
	}

	@Override
	public void onNetChange(boolean isNetConnected) {
		// TODO Auto-generated method stub
		if (isNetConnected) {
			ShowToast(R.string.network_tips);
		}
	}

	@Override
	public void onAddUser(BmobInvitation message) {
		// TODO Auto-generated method stub
		refreshInvite(message);
	}

	/**
	 * 刷新好友请求
	 * 
	 * @Title: notifyAddUser
	 * @Description: TODO
	 * @param @param message
	 * @return void
	 * @throws
	 */
	private void refreshInvite(BmobInvitation message) {
		boolean isAllow = CustomApplcation.getInstance().getSpUtil()
				.isAllowVoice();
		if (isAllow) {
			CustomApplcation.getInstance().getMediaPlayer().start();
		}
		iv_contact_tips.setVisibility(View.VISIBLE);
		if (currentTabIndex == 1) {
			if (contactFragment != null) {
				contactFragment.refresh();
			}
		} else {
			// 同时提醒通知
			String tickerText = message.getFromname() + "请求添加好友";
			boolean isAllowVibrate = CustomApplcation.getInstance().getSpUtil()
					.isAllowVibrate();
			BmobNotifyManager.getInstance(this).showNotify(isAllow,
					isAllowVibrate, R.drawable.ic_launcher, tickerText,
					message.getFromname(), tickerText.toString(),
					NewFriendActivity.class);
		}
	}

	@Override
	public void onOffline() {
		// TODO Auto-generated method stub
		showOfflineDialog(this);
	}

	@Override
	public void onReaded(String conversionId, String msgTime) {
		// TODO Auto-generated method stub
	}

	private static long firstTime;

	/**
	 * 连续按两次返回键就退出
	 */
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		if (firstTime + 2000 > System.currentTimeMillis()) {
			super.onBackPressed();
		} else {
			ShowToast("再按一次退出程序");
		}
		firstTime = System.currentTimeMillis();
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		try {
			unregisterReceiver(newReceiver);
		} catch (Exception e) {
		}
		try {
			unregisterReceiver(userReceiver);
		} catch (Exception e) {
		}
		// 取消定时检测服务
		// BmobChat.getInstance(this).stopPollService();
	}

}
