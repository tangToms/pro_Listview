package com.example.pro_listview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListViewActivity extends Activity {
    //上下文
    private Context mContext;
    private ListView listView;
    private ListViewAdapter listViewAdapter;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //绑定layout
        setContentView(R.layout.t_listview);
        //上下文初始化
        mContext = ListViewActivity.this;
        //获取ListView
        listView = (ListView) findViewById(R.id.ListView1);
        //创建数据list
        ArrayList<String> list = new ArrayList<String>();
        //添加数据
        for(int i=0;i<20;i++){
            list.add("listView"+i);
        }
        //创建ListViewAdapter对象
        listViewAdapter = new ListViewAdapter(list,mContext);
        //ListView绑定Adapter
        listView.setAdapter(listViewAdapter);

        //ListView滚动监听器
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                switch (scrollState) {
                    case AbsListView.OnScrollListener.SCROLL_STATE_IDLE:
                        //未动作
                        Log.i("i","IDLE");
                    case AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL:
                        //拖拽
                        Log.i("i","touch_scroll");
                    case AbsListView.OnScrollListener.SCROLL_STATE_FLING:
                        //扫过
                        Log.i("i","fling");

                }

            }
            //滚动就回调函数
            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                Log.i("i","firstItem:"+firstVisibleItem+"  visibleItem:"+visibleItemCount+"  total:"+totalItemCount);
            }
        });

        //ListView的点击监听器
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //这里参数id，就是ListViewAdapter的getItemId方法返回值
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //将上面listViewAdapter对象变成类全局变量
                //调用Adapter的getItem方法
                String data = (String)listViewAdapter.getItem(position);
                Toast.makeText(mContext,data,Toast.LENGTH_SHORT);
            }
        });


    }
}
