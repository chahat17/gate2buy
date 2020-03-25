package com.example.myproject.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myproject.Adapter.NotificationAdapter;
import com.example.myproject.R;
import com.example.myproject.model.Notification;

import java.util.ArrayList;
import java.util.List;

public class NotificationActivity extends AppCompatActivity {
    private static final String TAG = "NotificationActivity";
    
    private ImageView back_iv;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Notification> notificationList = new ArrayList<>();
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        getSupportActionBar().hide();
        back_iv = findViewById(R.id.notification_back_iv);
        recyclerView = findViewById(R.id.Notification_rv);
        
        layoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        back_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        
        initNotificationList();

        adapter = new NotificationAdapter(getApplicationContext(),notificationList);
        recyclerView.setAdapter(adapter);
    }

    private void initNotificationList() {
        notificationList = new ArrayList<>();
        for(int i=1;i<10;i++) {
            notificationList.add(new Notification("Notification Message "+i,"10:48 am",
                    "This is test Description for Notification Message "+i));
        }

    }
}
