package com.mmadapps.mysecondpro.utils;

import android.app.Activity;
import android.app.IntentService;
import android.content.Context;
import android.support.v4.app.Fragment;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by bhaskara.reddy on 09-03-2017.
 */

public class WebServices<T> {

    private T t;
    Call<T> call = null;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    ApiType apiTypeVariable;
    Context context;
    OnResponseListner<T> onResponseListner;


    public enum ApiType {

        Userlogin, Usersignup, Forgotpassword

    }

    public static String RadioCitytesturl = "http://52.172.188.220/Radiocity/";
    public static String youtubeurl = "https://www.googleapis.com/youtube/v3/";

    private static OkHttpClient.Builder builder;

    public WebServices(OnResponseListner<T> onResponseListner) {
        this.onResponseListner = onResponseListner;
        if (onResponseListner instanceof Activity) {
            this.context = (Context) onResponseListner;
        } else if (onResponseListner instanceof IntentService) {
            this.context = (Context) onResponseListner;
        } else if (onResponseListner instanceof android.app.DialogFragment) {
            android.app.DialogFragment dialogFragment = (android.app.DialogFragment) onResponseListner;
            this.context = dialogFragment.getActivity();
        } else {
            Fragment fragment = (android.support.v4.app.Fragment) onResponseListner;
            this.context = fragment.getActivity();
        }

        builder = getHttpClient();
    }

    public OkHttpClient.Builder getHttpClient() {
        if (builder == null) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(logging);
            return httpClient;
        }
        return builder;
    }


    // for post response

    /*public void userLoginservice(String api, ApiType apiTypes, Loginbeanscons loginpostdata) {

        apiTypeVariable = apiTypes;

        Retrofit retrofit = new Retrofit.Builder().baseUrl(api).addConverterFactory(GsonConverterFactory.create()).client(builder.build()).build();
        GitApi gi = retrofit.create(GitApi.class);
        call = (Call<T>) gi.userLogin(loginpostdata);
        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                t = (T) response.body();

                onResponseListner.onResponse(t, apiTypeVariable, true);
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {

                onResponseListner.onResponse(null, apiTypeVariable, false);
            }

        });
    }
*/


    // for get response



   /* public void getHomepageservice(String api, ApiType apiTypes) {

        apiTypeVariable = apiTypes;

        Retrofit retrofit = new Retrofit.Builder().baseUrl(api).addConverterFactory(GsonConverterFactory.create()).client(builder.build()).build();
        GitApi gi = retrofit.create(GitApi.class);
        call = (Call<T>) gi.getHomepagedetails();
        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                t = (T) response.body();

                onResponseListner.onResponse(t, apiTypeVariable, true);
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {

                onResponseListner.onResponse(null, apiTypeVariable, false);
            }

        });
    }*/




}
