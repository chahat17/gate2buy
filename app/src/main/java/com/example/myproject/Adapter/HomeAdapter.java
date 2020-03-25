package com.example.myproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myproject.R;
import com.example.myproject.model.Home;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.myViewHolder> {

    private Context context;
    private List<Home> list;

    public HomeAdapter(Context context, List<Home> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.home_item_layout,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.itemView.setTag(position);
        holder.productName.setText(list.get(position).getProductName());
        holder.orderId.setText(list.get(position).getOrderId());
        holder.orderStatus.setText(list.get(position).getProductStatus());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{
        TextView productName,orderId,orderStatus;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.product_name_tv);
            orderId = itemView.findViewById(R.id.order_id_tv);
            orderStatus = itemView.findViewById(R.id.order_status_tv);
        }
    }
}
