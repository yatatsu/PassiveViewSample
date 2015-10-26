package com.yatatsu.passiveviewsample.ui;


import java.net.UnknownHostException;

import retrofit.HttpException;

public class ApiErrorPresenter {

    public static String getErrorMessage(Throwable e) {
        if (e instanceof UnknownHostException) {
            return "No internet";
        }
        if (e instanceof HttpException) {
            if (((HttpException) e).code() == 404) {
                return "Not Found";
            }
        }
        return "Unknown error";
    }
}
