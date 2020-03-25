package com.example.myproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myproject.R;
import com.example.myproject.model.Message;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {
    private Context context;
    private List<Message> list;

    public MessageAdapter(Context context, List<Message> messageList) {
        this.context=context;
        this.list=messageList;
    }


    @NonNull
    @Override
    public MessageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.message_item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageAdapter.ViewHolder holder, int position) {
        holder.itemView.setTag(position);
        holder.productName.setText(list.get(position).getProductName());
        holder.productInfo.setText(list.get(position).getProductinfo());
        holder.productDate.setText(list.get(position).getProductDate());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView productName,productInfo,productDate;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productDate = itemView.findViewById(R.id.ProductDate_tv);
            productName = itemView.findViewById(R.id.ProductName_tv);
            productInfo = itemView.findViewById(R.id.ProductInfo_tv);
        }
    }
}
