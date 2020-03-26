package com.example.myproject;

import android.hardware.biometrics.BiometricPrompt;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;

import androidx.annotation.RequiresApi;

@RequiresApi(api = Build.VERSION_CODES.P)
public class FingerprintHelper extends BiometricPrompt.AuthenticationCallback {
    private FingerPrintListener mListener;

    public FingerprintHelper(FingerPrintListener mListener) {
        this.mListener = mListener;
    }

   public  interface FingerPrintListener{
        void authenticationFailed(String error);
        void authenticationSuccess(FingerprintManager.AuthenticationResult result);
    }


}
