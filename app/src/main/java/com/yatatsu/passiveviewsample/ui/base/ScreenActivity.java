package com.yatatsu.passiveviewsample.ui.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Passive View implementation
 */
public abstract class ScreenActivity<T extends Controller> extends AppCompatActivity implements Screen {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getController().registerScreen(this);
    }

    protected abstract T getController();
}
