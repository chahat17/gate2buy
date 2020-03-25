package com.example.myproject.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myproject.MainActivity;
import com.example.myproject.R;

public class WalletFragment extends Fragment {
    private static final String TAG = "WalletFragment";
    private MainActivity mainActivity;
    private TextView depositHistory_tv,withdrawAmounts_tv,incomeHistory_tv,outstandingPayments_tv;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.wallet_fragment,container,false);
        initView(view);
        mainActivity = (MainActivity) getActivity();
        return view;
    }

    private void initView(View view) {
        depositHistory_tv = view.findViewById(R.id.DepositHistory_tv);
        withdrawAmounts_tv = view.findViewById(R.id.WithdrawAmounts_tv);
        incomeHistory_tv = view.findViewById(R.id.IncomeHistory_tv);
        outstandingPayments_tv = view.findViewById(R.id.OutstandingPayment_tv);

        depositHistory_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                depositHistory_tv.setTextColor(getResources().getColor(R.color.colorWhite));
                depositHistory_tv.setBackground(getResources().getDrawable(R.drawable.round_corner_black));
                withdrawAmounts_tv.setTextColor(getResources().getColor(R.color.colorBlack));
                withdrawAmounts_tv.setBackground(getResources().getDrawable(R.drawable.round_corner_white));
                incomeHistory_tv.setTextColor(getResources().getColor(R.color.colorBlack));
                incomeHistory_tv.setBackground(getResources().getDrawable(R.drawable.round_corner_white));
                outstandingPayments_tv.setTextColor(getResources().getColor(R.color.colorBlack));
                outstandingPayments_tv.setBackground(getResources().getDrawable(R.drawable.round_corner_white));
            }
        });

        withdrawAmounts_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                depositHistory_tv.setTextColor(getResources().getColor(R.color.colorBlack));
                depositHistory_tv.setBackground(getResources().getDrawable(R.drawable.round_corner_white));
                withdrawAmounts_tv.setTextColor(getResources().getColor(R.color.colorWhite));
                withdrawAmounts_tv.setBackground(getResources().getDrawable(R.drawable.round_corner_black));
                incomeHistory_tv.setTextColor(getResources().getColor(R.color.colorBlack));
                incomeHistory_tv.setBackground(getResources().getDrawable(R.drawable.round_corner_white));
                outstandingPayments_tv.setTextColor(getResources().getColor(R.color.colorBlack));
                outstandingPayments_tv.setBackground(getResources().getDrawable(R.drawable.round_corner_white));
            }
        });

        incomeHistory_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                depositHistory_tv.setTextColor(getResources().getColor(R.color.colorBlack));
                depositHistory_tv.setBackground(getResources().getDrawable(R.drawable.round_corner_white));
                withdrawAmounts_tv.setTextColor(getResources().getColor(R.color.colorBlack));
                withdrawAmounts_tv.setBackground(getResources().getDrawable(R.drawable.round_corner_white));
                incomeHistory_tv.setTextColor(getResources().getColor(R.color.colorWhite));
                incomeHistory_tv.setBackground(getResources().getDrawable(R.drawable.round_corner_black));
                outstandingPayments_tv.setTextColor(getResources().getColor(R.color.colorBlack));
                outstandingPayments_tv.setBackground(getResources().getDrawable(R.drawable.round_corner_white));
            }
        });

        outstandingPayments_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                depositHistory_tv.setTextColor(getResources().getColor(R.color.colorBlack));
                depositHistory_tv.setBackground(getResources().getDrawable(R.drawable.round_corner_white));
                withdrawAmounts_tv.setTextColor(getResources().getColor(R.color.colorBlack));
                withdrawAmounts_tv.setBackground(getResources().getDrawable(R.drawable.round_corner_white));
                incomeHistory_tv.setTextColor(getResources().getColor(R.color.colorBlack));
                incomeHistory_tv.setBackground(getResources().getDrawable(R.drawable.round_corner_white));
                outstandingPayments_tv.setTextColor(getResources().getColor(R.color.colorWhite));
                outstandingPayments_tv.setBackground(getResources().getDrawable(R.drawable.round_corner_black));
                mainActivity.openOutstandingPaymentFragment();
            }
        });
    }
}
