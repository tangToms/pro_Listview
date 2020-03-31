package com.example.pro_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
        private ArrayList<String> strlists;
        private Context mContext;
        public  ListViewAdapter(ArrayList<String> list,Context context){
            this.strlists=list;
            this.mContext=context;
        }

    //获取list大小
    @Override
    public int getCount() {
        return strlists.size();
    }
    @Override
    public Object getItem(int position) {
        return strlists!=null?strlists.get(position):null;
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    //创建空的View，放入数据
    //position当前位置
    //ViewGroup parent：每次调用都有一个空容器，返回值的view添加到空容器，getContext方法获取容器context
    //convertView：ItemView显示内容
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        //创建一个空TextView
//        TextView textView = new TextView(mContext);
//        //设置宽高
//        textView.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT,
//                AbsListView.LayoutParams.WRAP_CONTENT));
//        //设置文本大小
//        textView.setTextSize(30);
//        //设置文本
//        textView.setText(strlists.get(position));
//        return textView;


//        //LayoutInflater类将一个布局变成一个类
//        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
//        //inflate参数1：布局页面，参数2：root是否加入到某个容器
//        View view =  layoutInflater.inflate(R.layout.t_listview_item,null);
//        TextView textView = view.findViewById(R.id.tv1);
//        textView.setText(strlists.get(position));
//        return view;

        //ViewHoler类对象
        ViewHolder viewHolder = null;
        //开始时convertView为空，创建容器
        if (convertView==null){
            viewHolder = new ViewHolder();
            //LayoutInflater类将一个布局变成一个类
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            //inflate参数1：布局页面，参数2：root是否加入到某个容器
            //View view =  layoutInflater.inflate(R.layout.t_listview_item,null);
            //将View赋值给convertView
            //convertView = view;
            //上两句合并
            convertView = layoutInflater.inflate(R.layout.t_listview_item,null);
            //将ItemView的结构赋值给viewHolder
            viewHolder.textView1 = convertView.findViewById(R.id.tv1);
            convertView.setTag(viewHolder);
        }else {
            //converView有值，是已有的移出屏幕的ItemView
            viewHolder=(ViewHolder) convertView.getTag();
        }
        //设置组件值
        viewHolder.textView1.setText(strlists.get(position));
        return convertView;
    }

    //ViewHolder类，ItemView的组件结构
    class  ViewHolder{
            TextView textView1;
    }
}
