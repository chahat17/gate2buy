package com.example.myproject.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myproject.Adapter.OutstandingPaymentAdapter;
import com.example.myproject.MainActivity;
import com.example.myproject.R;
import com.example.myproject.model.OutstandingPayment;

import java.util.ArrayList;
import java.util.List;

public class OutstandingPaymentFragment extends Fragment {
    private static final String TAG = "OutstandingPaymentFragment";

    private MainActivity mainActivity;
    private EditText search_et;
    private Button search_btn;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<OutstandingPayment> outstandingPaymentList=new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.outstanding_payment_fragment,container,false);
        mainActivity = (MainActivity) getActivity();
        initView(view);
        return view;
    }

    private void initView(View view) {
        search_et = view.findViewById(R.id.search_et);
        search_btn = view.findViewById(R.id.search_btn);
        recyclerView = view.findViewById(R.id.OutstandingPayment_rv);

        layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        initOutstandingPaymentList();

        adapter=new OutstandingPaymentAdapter(getActivity(),outstandingPaymentList);
        recyclerView.setAdapter(adapter);

    }

    private void initOutstandingPaymentList() {
        outstandingPaymentList=new ArrayList<>();
        outstandingPaymentList.add(new OutstandingPayment("415","Johnson","Trappe","4903.00"));
        outstandingPaymentList.add(new OutstandingPayment("416","Johnson","Trappe","6750.00"));
        outstandingPaymentList.add(new OutstandingPayment("417","Johnson","Trappe","7903.00"));
        outstandingPaymentList.add(new OutstandingPayment("418","Johnson","Trappe","8803.00"));
        outstandingPaymentList.add(new OutstandingPayment("419","Johnson","Trappe","4903.00"));
        outstandingPaymentList.add(new OutstandingPayment("420","Johnson","Trappe","5903.00"));
    }

}
