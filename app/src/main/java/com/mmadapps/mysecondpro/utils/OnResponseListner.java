package com.mmadapps.mysecondpro.utils;

/**
 * Created by bhaskara.reddy on 04-02-2017.
 */
public interface OnResponseListner<T> {
    void onResponse(T response, WebServices.ApiType URL, boolean isSucces);
}
