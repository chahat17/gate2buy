package com.example.myproject.model;

import android.content.Context;
import android.util.Log;

import com.example.myproject.Network.RetroNetwork;
import com.example.myproject.Network.UserInterface;
import com.example.myproject.model.Login.LoginDataRes;
import com.example.myproject.model.Login.LoginResponseBody;
import com.example.myproject.model.getlanguage.DataLanguage;
import com.example.myproject.model.getlanguage.GetLanguageResponseBody;
import com.example.myproject.model.getprofile.DataProfile;
import com.example.myproject.model.getprofile.GetProfileResponseBody;
import com.example.myproject.sharedpreferences.SharedPreferenceHelper;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiRepository {
    private static final String TAG = "ApiRepository";
    private static ApiRepository apiRepository;
    private String email,password,key,token,language;
    private SharedPreferenceHelper helper;
    LoginResponseBody res=LoginResponseBody.getInstance();
    GetProfileResponseBody getProfileResponseBody = GetProfileResponseBody.getInstance();
    GetLanguageResponseBody getLanguageResponseBody = GetLanguageResponseBody.getInstance();

    public static ApiRepository getApiRepository(){
        if(apiRepository ==null){
            apiRepository =new ApiRepository();
        }
        return apiRepository;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

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

    public Observable<LoginResponseBody> getDataFromLoginAPI(Context context){
        helper = new SharedPreferenceHelper(context);
        this.map = getLoginFieldMap();
        return Observable.create(new ObservableOnSubscribe<LoginResponseBody>() {
            @Override
            public void subscribe(ObservableEmitter<LoginResponseBody> emitter) throws Exception {

                UserInterface userInterface= RetroNetwork.getRetrofit().create(UserInterface.class);
                Call<LoginResponseBody> call=userInterface.sendLogin(map);
                call.enqueue(new Callback<LoginResponseBody>() {
                    @Override
                    public void onResponse(Call<LoginResponseBody> call, Response<LoginResponseBody> response) {
                        Log.d(TAG, "LoginResponse: "+ response.code()+" , "+response.body());
                  //      Log.e("Login Response", String.valueOf(response.code()+" , "+response.body()));
                        LoginDataRes dataRes=new LoginDataRes();
                        dataRes.setToken(response.body().getData().getToken());
                        res.setData(dataRes);
                        res.setStatusCode(response.body().getStatusCode());

                        setToken(response.body().getData().getToken());

                        helper.getUserPreferences().edit()
                                .putKey(getKey())
                                .putToken(getToken())
                                .apply();

                        emitter.onNext(res);
                    }

                    @Override
                    public void onFailure(Call<LoginResponseBody> call, Throwable t) {
                        Log.d(TAG, "onLoginFailure: "+t.getMessage());
                        emitter.onError(t);
                    }
                });
            }
        });
    }

    public Observable<GetProfileResponseBody> getProfileDataFromApi(Context context) {
        helper = new SharedPreferenceHelper(context);
        this.map = getLoginprofileMap();
        return Observable.create(new ObservableOnSubscribe<GetProfileResponseBody>() {
            @Override
            public void subscribe(ObservableEmitter<GetProfileResponseBody> emitter) throws Exception {
                UserInterface userInterface= RetroNetwork.getRetrofit().create(UserInterface.class);
                Call<GetProfileResponseBody> call = userInterface.getProfile(map);
                call.enqueue(new Callback<GetProfileResponseBody>() {
                    @Override
                    public void onResponse(Call<GetProfileResponseBody> call, Response<GetProfileResponseBody> response) {
                        Log.d(TAG, "GetProfileResponse: "+ response.code()+" , "+response.body());
                        DataProfile dataProfile = new DataProfile(
                                response.body().getDataProfile().getFullName(),
                                response.body().getDataProfile().getDefaultLanguageCode(),
                                response.body().getDataProfile().getDefaultCurrency(),
                                response.body().getDataProfile().getPhoto()
                        );
                        getProfileResponseBody.setMessage(response.body().getMessage());
                        getProfileResponseBody.setStatus(response.body().getStatus());
                        getProfileResponseBody.setStatusCode(response.body().getStatusCode());
                        getProfileResponseBody.setDataProfile(dataProfile);

                        setLanguage(response.body().getDataProfile().getDefaultLanguageCode());

                        helper.getUserPreferences().edit()
                                .putLanguage(getLanguage())
                                .apply();

                        emitter.onNext(getProfileResponseBody);
                    }

                    @Override
                    public void onFailure(Call<GetProfileResponseBody> call, Throwable t) {
                        Log.d(TAG, "onGetProfileFailure: "+t.getMessage());
                        emitter.onError(t);
                    }
                });
            }
        });
    }

    public Observable<GetLanguageResponseBody> getLanguageDataFromApi(Context context) {
        helper = new SharedPreferenceHelper(context);
        this.map = getLoginLanguageMap();
        return Observable.create(new ObservableOnSubscribe<GetLanguageResponseBody>() {
            @Override
            public void subscribe(ObservableEmitter<GetLanguageResponseBody> emitter) throws Exception {
                UserInterface userInterface= RetroNetwork.getRetrofit().create(UserInterface.class);
                Call<GetLanguageResponseBody> call = userInterface.getLanguage(map);
                call.enqueue(new Callback<GetLanguageResponseBody>() {
                    @Override
                    public void onResponse(Call<GetLanguageResponseBody> call, Response<GetLanguageResponseBody> response) {
                        Log.d(TAG, "GetLanguageResponse: "+ response.code()+" , "+response.body());
                        DataLanguage dataLanguage = response.body().getDataLanguage();
                        getLanguageResponseBody.setMessage(response.body().getMessage());
                        getLanguageResponseBody.setStatus(response.body().getStatus());
                        getLanguageResponseBody.setStatusCode(response.body().getStatusCode());
                        getLanguageResponseBody.setDataLanguage(dataLanguage);

                        helper.getUserPreferences().edit()
                                .putLanguageResponse(new Gson().toJson(response.body()))
                                .apply();

                        emitter.onNext(getLanguageResponseBody);
                    }

                    @Override
                    public void onFailure(Call<GetLanguageResponseBody> call, Throwable t) {
                        Log.d(TAG, "onGetLanguageFailure: "+t.getMessage());
                        emitter.onError(t);
                    }
                });
            }
        });
    }

    private Map<String,String> getLoginFieldMap() {
        map=new HashMap<>();
        map.put("call","authenticate");
        map.put("email",getEmail());
        map.put("password",getPassword());
        map.put("key",getKey());
        return map;
    }

    private Map<String,String> getLoginprofileMap() {
        map=new HashMap<>();
        map.put("call","get_profile");
        map.put("key",getKey());
        map.put("token",getToken());
        return map;
    }

    private Map<String,String> getLoginLanguageMap() {
        map=new HashMap<>();
        map.put("call","get_language");
        map.put("key",getKey());
        map.put("language",getLanguage());
        return map;
    }

}
