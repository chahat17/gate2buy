package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myproject.ui.fragment.HomeFragment;
import com.example.myproject.ui.fragment.MessagesFragment;
import com.example.myproject.ui.NotificationActivity;
import com.example.myproject.ui.fragment.OrdersFragment;
import com.example.myproject.ui.fragment.OutstandingPaymentFragment;
import com.example.myproject.ui.fragment.WalletFragment;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    // Header Title
    private TextView headerTitle;
    // Footer Layouts
    private ConstraintLayout home,wallet,messages,orders,account;
    // Footer Layout Texts
    private TextView home_tv,wallet_tv,messages_tv,orders_tv,account_tv;
    // Footer Layout Images
    private ImageView home_iv,wallet_iv,messages_iv,orders_iv,account_iv;
    // Notification Image
    private ImageView notification_iv,back_iv;
    // Fragments
    private MessagesFragment messagesFragment;
    private WalletFragment walletFragment;
    private OrdersFragment ordersFragment;
    private OutstandingPaymentFragment outstandingPaymentFragment;
    private HomeFragment homeFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        headerTitle = findViewById(R.id.headerTitle_tv);
        home = findViewById(R.id.Home_tv);
        wallet = findViewById(R.id.Wallet_tv);
        messages = findViewById(R.id.Messages_tv);
        orders = findViewById(R.id.Orders_tv);
        account = findViewById(R.id.Account_tv);
        home_tv = findViewById(R.id.Home);
        wallet_tv = findViewById(R.id.Wallet);
        messages_tv = findViewById(R.id.Messages);
        orders_tv = findViewById(R.id.Orders);
        account_tv = findViewById(R.id.Account);
        home_iv = findViewById(R.id.Home_iv);
        wallet_iv = findViewById(R.id.Wallet_iv);
        messages_iv = findViewById(R.id.Messages_iv);
        orders_iv = findViewById(R.id.Orders_iv);
        account_iv = findViewById(R.id.Account_iv);
        notification_iv = findViewById(R.id.notification_iv);
        back_iv = findViewById(R.id.back_iv);

        back_iv.setVisibility(View.GONE);

        setAllFooterItemsDefault();
        messages.setBackgroundColor(getResources().getColor(R.color.colorBlack));
        messages_tv.setTextColor(getResources().getColor(R.color.colorWhite));
        messages_iv.setImageResource(R.drawable.messages_white);
        openMessagesFragment();

        back_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAllFooterItemsDefault();
                wallet.setBackgroundColor(getResources().getColor(R.color.colorBlack));
                wallet_tv.setTextColor(getResources().getColor(R.color.colorWhite));
                wallet_iv.setImageResource(R.drawable.wallet_white);
                openWalletFragment();
            }
        });

        messages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAllFooterItemsDefault();
                messages.setBackgroundColor(getResources().getColor(R.color.colorBlack));
                messages_tv.setTextColor(getResources().getColor(R.color.colorWhite));
                messages_iv.setImageResource(R.drawable.messages_white);
                openMessagesFragment();
            }
        });
        wallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAllFooterItemsDefault();
                wallet.setBackgroundColor(getResources().getColor(R.color.colorBlack));
                wallet_tv.setTextColor(getResources().getColor(R.color.colorWhite));
                wallet_iv.setImageResource(R.drawable.wallet_white);
                openWalletFragment();
            }
        });
        orders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAllFooterItemsDefault();
                orders.setBackgroundColor(getResources().getColor(R.color.colorBlack));
                orders_tv.setTextColor(getResources().getColor(R.color.colorWhite));
                orders_iv.setImageResource(R.drawable.orders_white);
                openOrdersFragment();
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAllFooterItemsDefault();
                home.setBackgroundColor(getResources().getColor(R.color.colorBlack));
                home_tv.setTextColor(getResources().getColor(R.color.colorWhite));
                home_iv.setImageResource(R.drawable.orders_white);
                openHomeFragment();
            }
        });

        notification_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), NotificationActivity.class);
                startActivity(i);
            }
        });

    }

    private void setAllFooterItemsDefault() {
        home.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        home_tv.setTextColor(getResources().getColor(R.color.colorBlack));
        home_iv.setImageResource(R.drawable.home);
        wallet.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        wallet_tv.setTextColor(getResources().getColor(R.color.colorBlack));
        wallet_iv.setImageResource(R.drawable.wallet);
        messages.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        messages_tv.setTextColor(getResources().getColor(R.color.colorBlack));
        messages_iv.setImageResource(R.drawable.messages);
        orders.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        orders_tv.setTextColor(getResources().getColor(R.color.colorBlack));
        orders_iv.setImageResource(R.drawable.orders);
        account.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        account_tv.setTextColor(getResources().getColor(R.color.colorBlack));
        account_iv.setImageResource(R.drawable.account);
    }

    //............. Fragment Replacing Methods ......................

    public void openWalletFragment() {
        back_iv.setVisibility(View.GONE);
        headerTitle.setText("My Wallet");
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        walletFragment = new WalletFragment();

        transaction.replace(R.id.main_activity_frame, walletFragment);
        transaction.addToBackStack("walletFragment");
        transaction.commit();
    }

    public void openMessagesFragment() {
        back_iv.setVisibility(View.GONE);
        headerTitle.setText("Messages");
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        messagesFragment = new MessagesFragment();

        transaction.replace(R.id.main_activity_frame, messagesFragment);
        transaction.addToBackStack("messagesFragment");
        transaction.commit();
    }

    public void openOrdersFragment() {
        back_iv.setVisibility(View.GONE);
        headerTitle.setText("Orders");
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        ordersFragment = new OrdersFragment();

        transaction.replace(R.id.main_activity_frame, ordersFragment);
        transaction.addToBackStack("ordersFragment");
        transaction.commit();
    }

    public void openOutstandingPaymentFragment() {
        back_iv.setVisibility(View.VISIBLE);
        headerTitle.setText("Outstanding Payment");
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        outstandingPaymentFragment = new OutstandingPaymentFragment();

        transaction.replace(R.id.main_activity_frame, outstandingPaymentFragment);
        transaction.addToBackStack("outstandingPaymentFragment");
        transaction.commit();
    }

    private void openHomeFragment() {
        back_iv.setVisibility(View.GONE);
        headerTitle.setText("Home");
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        homeFragment = new HomeFragment();

        transaction.replace(R.id.main_activity_frame, homeFragment);
        transaction.addToBackStack("homeFragment");
        transaction.commit();
    }

}
