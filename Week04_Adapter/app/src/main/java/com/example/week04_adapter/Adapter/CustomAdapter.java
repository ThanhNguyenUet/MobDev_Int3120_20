package com.example.week04_adapter.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.week04_adapter.R;

public class CustomAdapter extends BaseAdapter {
    Context context;
    String countryList[];
    String userName[];
    // layout inflater -> create a view from a layout ( same as )
    LayoutInflater inflater;

    // Constructor
    public CustomAdapter(Context ctx, String[] countryList, String[] userName) {
        this.context = ctx;
        this.countryList = countryList;
        this.userName = userName;
        inflater = LayoutInflater.from(ctx);
    }

    // number of rows
    @Override
    public int getCount() {
        return countryList.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.custom_listview_item, null);
        }
        TextView username = convertView.findViewById(R.id.textView3);
        TextView country = convertView.findViewById(R.id.textView4);

        username.setText(userName[i]);
        country.setText(countryList[i]);
        return convertView;
    }
}
