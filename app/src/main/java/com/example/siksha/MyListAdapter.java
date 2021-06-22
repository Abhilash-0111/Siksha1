package com.example.siksha;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder>{
    List<homeworkd> listdata=new ArrayList<>();
    Context context1 ;
    public MyListAdapter(Context context) {
        this.context1 = context;
    }

    // RecyclerView recyclerView;
    public MyListAdapter(List<homeworkd> listdata,Context context) {
        this.listdata = listdata;
        this.context1 = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final homeworkd myListData = listdata.get(position);
        holder.hwmessage.setText(listdata.get(position).getMessage());
        holder.hwlink.setText(listdata.get(position).getLink());
        holder.hwlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"click on item: "+myListData.getMessage(),Toast.LENGTH_LONG).show();
                Uri uri = Uri.parse(myListData.getLink()); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                context1.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView hwmessage;
        public TextView hwlink;
        final Context context ;
        public ViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            this.hwmessage = (TextView) itemView.findViewById(R.id.hwmessage);
            this.hwlink = (TextView) itemView.findViewById(R.id.hwlink);

        }
    }
}
