package com.example.myproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myproject.R;
import com.example.myproject.model.Notification;

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.myViewHolder> {

    private Context context;
    private List<Notification> list;

    public NotificationAdapter(Context context, List<Notification> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public NotificationAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.notification_item_layout,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationAdapter.myViewHolder holder, int position) {
        holder.itemView.setTag(position);
        holder.notificationName.setText(list.get(position).getMessage());
        holder.notificationTime.setText(list.get(position).getTime());
        holder.notificationInfo.setText(list.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{
        TextView notificationName,notificationTime,notificationInfo;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            notificationName = itemView.findViewById(R.id.NotificationName_tv);
            notificationTime = itemView.findViewById(R.id.NotificationDay_tv);
            notificationInfo = itemView.findViewById(R.id.NotificationInfo_tv);
        }
    }
}
