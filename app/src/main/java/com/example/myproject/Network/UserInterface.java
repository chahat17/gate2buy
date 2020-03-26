package com.example.myproject.Network;

import com.example.myproject.model.Login.LoginResponseBody;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UserInterface {
    @FormUrlEncoded
    @POST("development/Api/api")
    Call<LoginResponseBody> sendLogin(@FieldMap Map<String, String> fields);
}
