package com.example.myproject.model.Login;

import android.content.Context;
import android.util.Log;

import com.example.myproject.Network.RetroNetwork;
import com.example.myproject.Network.UserInterface;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginRepo {

    private static LoginRepo loginRepo;
    LoginResponseBody res=LoginResponseBody.getInstance();

    public static LoginRepo getLoginRepo(){
        if(loginRepo==null){
            loginRepo=new LoginRepo();
        }
        return loginRepo;
    }
    private String email,password,key;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }


    Map<String,String> map=new HashMap<>();

    public Observable<LoginResponseBody> getDataFromLoginAPI(){
        getFieldMap();
        return Observable.create(new ObservableOnSubscribe<LoginResponseBody>() {
            @Override
            public void subscribe(ObservableEmitter<LoginResponseBody> emitter) throws Exception {

                UserInterface userInterface= RetroNetwork.getRetrofit().create(UserInterface.class);
                Call<LoginResponseBody> call=userInterface.sendLogin(map);
                call.enqueue(new Callback<LoginResponseBody>() {
                    @Override
                    public void onResponse(Call<LoginResponseBody> call, Response<LoginResponseBody> response) {
                        Log.e("Response", String.valueOf(response.code()+" , "+response.body()));
                        LoginDataRes dataRes=new LoginDataRes();
                        dataRes.setToken(response.body().getData().getToken());
                        res.setData(dataRes);
                        res.setStatusCode(response.body().getStatusCode());



                        emitter.onNext(res);
                    }

                    @Override
                    public void onFailure(Call<LoginResponseBody> call, Throwable t) {
                       Log.e("Failure",t.getMessage());
                            emitter.onError(t);
                    }
                });
            }
        });
    }

    private void getFieldMap() {

        map.put("call","authenticate");
        map.put("email",getEmail());
        map.put("password",getPassword());
        map.put("key",getKey());

    }
}
