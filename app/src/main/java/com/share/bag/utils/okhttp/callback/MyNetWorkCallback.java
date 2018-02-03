package com.share.bag.utils.okhttp.callback;

import org.json.JSONException;

/**
 * Created by xingge on 2017/7/11.
 */

public interface MyNetWorkCallback<T> {

    void onSuccess(T t) throws JSONException;

    void onError(int errorCode, String errorMsg);

}
