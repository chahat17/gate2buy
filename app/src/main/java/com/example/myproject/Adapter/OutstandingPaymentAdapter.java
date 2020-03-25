package com.example.myproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myproject.R;
import com.example.myproject.model.OutstandingPayment;

import java.util.List;
import java.util.zip.Inflater;

public class OutstandingPaymentAdapter extends RecyclerView.Adapter<OutstandingPaymentAdapter.myViewHolder> {

    private Context context;
    private List<OutstandingPayment> list;

    public OutstandingPaymentAdapter(Context context, List<OutstandingPayment> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.outstanding_payment_item_layout,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.itemView.setTag(position);
        holder.id.setText(list.get(position).getOrderid());
        holder.name.setText(list.get(position).getCustomerName());
        holder.title.setText(list.get(position).getTitle());
        holder.total.setText(list.get(position).getTotal());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{
        TextView id,name,title,total;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.item1);
            name = itemView.findViewById(R.id.item2);
            title = itemView.findViewById(R.id.item3);
            total = itemView.findViewById(R.id.item4);
        }
    }
}
