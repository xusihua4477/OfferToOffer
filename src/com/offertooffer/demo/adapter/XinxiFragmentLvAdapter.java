package com.offertooffer.demo.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.offertooffer.demo.bean.Record_ZhaoPin;
import com.offertooffer.demo.bean.User;

public class XinxiFragmentLvAdapter extends BaseAdapter {
	Context context;
	List<Record_ZhaoPin> records;
	List<User> users;

	public XinxiFragmentLvAdapter(Context context,
			List<Record_ZhaoPin> records, List<User> users) {
		super();
		this.context = context;
		this.records = records;
		this.users = users;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		return null;
	}

}
