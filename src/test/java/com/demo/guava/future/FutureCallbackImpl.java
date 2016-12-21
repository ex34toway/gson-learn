package com.demo.guava.future;

import com.google.common.util.concurrent.FutureCallback;

/**
 * Created by liliang on 2016/12/20.
 */
public class FutureCallbackImpl implements FutureCallback<String> {

    private StringBuilder builder = new StringBuilder();

    @Override
    public void onSuccess(String result) {
        builder.append(result).append(" ok");
    }

    @Override
    public void onFailure(Throwable t) {
        builder.append(t.toString());
    }

    public String getCallbackResult() {
        return builder.toString();
    }
}
