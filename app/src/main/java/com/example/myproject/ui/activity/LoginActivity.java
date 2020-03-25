package com.example.myproject.ui.activity;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myproject.R;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";

    private ImageView face_white_iv,pinset_iv,fingertouch_iv,emailpass_iv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        face_white_iv = findViewById(R.id.face_white_iv);
        pinset_iv = findViewById(R.id.pinset_white_iv);
        fingertouch_iv = findViewById(R.id.fingertouch_white_iv);
        emailpass_iv = findViewById(R.id.emailpass_white_iv);

    }
}
