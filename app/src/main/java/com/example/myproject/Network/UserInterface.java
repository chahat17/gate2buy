package com.example.myproject.Network;

import com.example.myproject.model.Login.LoginResponseBody;
import com.example.myproject.model.getlanguage.GetLanguageResponseBody;
import com.example.myproject.model.getprofile.GetProfileResponseBody;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface UserInterface {
    @FormUrlEncoded
    @POST("development/Api/api")
    Call<LoginResponseBody> sendLogin(@FieldMap Map<String, String> fields);

    @FormUrlEncoded
    @GET("development/Api/api")
    Call<GetProfileResponseBody> getProfile(@QueryMap Map<String, String> map);

    @FormUrlEncoded
    @GET("development/Api/api")
    Call<GetLanguageResponseBody> getLanguage(@QueryMap Map<String, String> map);
}
