package com.example.myproject.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.myproject.MainActivity;
import com.example.myproject.R;

public class OrdersFragment extends Fragment {
    private static final String TAG = "OrdersFragment";
    private MainActivity mainActivity;

    private ConstraintLayout pending_cl,approved_cl,unpaid_cl,toBeShipped_cl,shipped_cl,toBeReviewed_cl,inDispute_cl;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.orders_fragment,container,false);
        initViews(view);
        mainActivity = (MainActivity) getActivity();
        return view;
    }

    private void initViews(View view) {
        pending_cl = view.findViewById(R.id.Pending_cl);
        approved_cl = view.findViewById(R.id.Approved_cl);
        unpaid_cl = view.findViewById(R.id.Unpaid_cl);
        toBeShipped_cl = view.findViewById(R.id.TobeShipped_cl);
        shipped_cl = view.findViewById(R.id.Shipped_cl);
        toBeReviewed_cl = view.findViewById(R.id.TobeReviewed_cl);
        inDispute_cl = view.findViewById(R.id.InDispute_cl);
    }

}
