package com.example.myproject.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;
import androidx.core.hardware.fingerprint.FingerprintManagerCompat;

import com.example.myproject.FingerprintHelper;
import com.example.myproject.MainActivity;
import com.example.myproject.R;

import java.util.concurrent.Executor;

public class LoginActivity extends AppCompatActivity  {

    private static final String TAG = "LoginActivity";
    final Activity activity=this;
    private FingerprintHelper fingerprintHelper;
    private FingerprintManager fingerprintManager;
    androidx.core.hardware.fingerprint.FingerprintManagerCompat mFingerprintManager;
    private Executor executor;
    private BiometricPrompt biometricPrompt;
    private BiometricPrompt.PromptInfo promptInfo;

    private ImageView face_white_iv,pinset_iv,fingertouch_iv,emailpass_iv;
    Boolean canAuthenticate=false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        face_white_iv = findViewById(R.id.face_white_iv);
        pinset_iv = findViewById(R.id.pinset_white_iv);
        fingertouch_iv = findViewById(R.id.fingertouch_white_iv);
        emailpass_iv = findViewById(R.id.emailpass_white_iv);

        getBiometricStatus();


        fingertouch_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(canAuthenticate)
            biometricPrompt.authenticate(promptInfo);
                else
                    Toast.makeText(getApplicationContext(),"No authentication found",Toast.LENGTH_SHORT).show();
            }
        });



        executor = ContextCompat.getMainExecutor(this);
        biometricPrompt = new BiometricPrompt(LoginActivity.this,
                executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode,
                                              @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                Toast.makeText(getApplicationContext(),
                        "Authentication error: " + errString, Toast.LENGTH_SHORT)
                        .show();
            }

            @Override
            public void onAuthenticationSucceeded(
                    @NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Toast.makeText(getApplicationContext(),
                        "Authentication succeeded!", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                Toast.makeText(getApplicationContext(), "Authentication failed",
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });

        promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("Biometric login for my app")
                .setSubtitle("Log in using your biometric credential")
                .setNegativeButtonText("Use account password")
                .build();










    }

    private void getBiometricStatus() {

        BiometricManager biometricManager = BiometricManager.from(activity);
        switch (biometricManager.canAuthenticate()) {
            case BiometricManager.BIOMETRIC_SUCCESS:
                Log.d("MY_APP_TAG", "App can authenticate using biometrics.");
                canAuthenticate=true;
                break;
            case BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE:
                Log.e("MY_APP_TAG", "No biometric features available on this device.");
                break;
            case BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE:
                Log.e("MY_APP_TAG", "Biometric features are currently unavailable.");
                break;
            case BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED:
                Log.e("MY_APP_TAG", "The user hasn't associated " +
                        "any biometric credentials with their account.");
                break;
        }

    }


}

