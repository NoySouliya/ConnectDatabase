package com.example.appwithdatabase;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class DataAdapter extends BaseAdapter {
    Cursor[] Data;
    Context myContext;
    LayoutInflater myInflater;
    public DataAdapter (Context MyContext, Cursor[] data){
        this.myContext = MyContext;
        this.Data = data;
        myInflater = (LayoutInflater.from(MyContext));
    }
    @Override
    public int getCount() {
        return Data.length;
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
