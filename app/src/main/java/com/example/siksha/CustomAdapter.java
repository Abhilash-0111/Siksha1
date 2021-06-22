package com.example.siksha;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;



 class CustomAdapter extends BaseAdapter {

    Context context ;
    String notifications[] ;
    LayoutInflater inflater ;

    public CustomAdapter(Context applicationContext,String[] notifications){
        this.context = applicationContext ;
        this.notifications = notifications ;
        inflater = (LayoutInflater.from(applicationContext)) ;

    }

    @Override
    public int getCount(){

        return notifications.length ;

    }

    @Override
    public Object getItem(int i){

        return null ;
    }

    @Override
    public long getItemId(int i){

        return 0 ;
    }



    @Override
    public View getView(int i, View view, ViewGroup viewGroup){

        view = inflater.inflate(R.layout.list_view,null) ;
        TextView notification = (TextView)view.findViewById(R.id.text1);
        notification.setText(notifications[i]) ;
        return view ;
    }



}
