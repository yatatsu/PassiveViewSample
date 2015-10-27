package com.yatatsu.passiveviewsample.ui;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.net.UnknownHostException;

import retrofit.HttpException;
import retrofit.Response;

import static com.google.common.truth.Truth.assert_;

@RunWith(JUnit4.class)
public class ApiErrorPresenterTest {

    @Test
    public void testGetErrorMessage() throws Exception {
        assert_().that(ApiErrorPresenter.getErrorMessage(new UnknownHostException()))
                .isEqualTo("No internet");
        Response response = Response.error(404, null);
        assert_().that(ApiErrorPresenter.getErrorMessage(new HttpException(response)))
                .isEqualTo("Not Found");
        assert_().that(ApiErrorPresenter.getErrorMessage(new UnsupportedOperationException()))
                .isEqualTo("Unknown error");
    }
}