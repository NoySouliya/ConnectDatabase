package com.example.appwithdatabase;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;

public class listview_data extends Activity {
    ConnectDatabase db;
    ListView myListView;
    Cursor[] data = {db.getAllData()};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_listview);
        myListView = findViewById(R.id.myListView);
        DataAdapter myDataAdapter = new DataAdapter(getApplicationContext(), data);
        myListView.setAdapter(myDataAdapter);
    }
}
