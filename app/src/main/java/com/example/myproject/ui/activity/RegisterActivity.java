package com.example.myproject.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myproject.R;
import com.example.myproject.model.Login.LoginRepo;
import com.example.myproject.model.Login.LoginResponseBody;

import io.reactivex.observers.DisposableObserver;

public class RegisterActivity extends AppCompatActivity {

    private static final String TAG = "RegisterActivity";

    private EditText email_et,password_et,tokenKey_et;
    private Button login_btn;
    LoginRepo loginRepo=LoginRepo.getLoginRepo();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        email_et = findViewById(R.id.email_register_et);
        password_et = findViewById(R.id.password_register_et);
        tokenKey_et = findViewById(R.id.tokenKey_register_et);
        login_btn = findViewById(R.id.login_register_btn);

        email_et.setText("ra@raconsulting.dk");
        password_et.setText("REN05and");
        tokenKey_et.setText("t9F53MNK5d6522074a284B8d2sPN");


        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginRepo.setEmail(email_et.getText().toString());
                loginRepo.setPassword(password_et.getText().toString());
                loginRepo.setKey(tokenKey_et.getText().toString());
                getResponse();
            }
        });



    }

    private void getResponse() {
        DisposableObserver<LoginResponseBody> disposableObserver=loginRepo.getDataFromLoginAPI().
                subscribeWith(new DisposableObserver<LoginResponseBody>() {
                    @Override
                    public void onNext(LoginResponseBody loginResponseBody) {
                        if(loginResponseBody.getStatusCode()==200){
                            Intent i =new Intent(getApplicationContext(),LoginActivity.class);
                            startActivity(i);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
