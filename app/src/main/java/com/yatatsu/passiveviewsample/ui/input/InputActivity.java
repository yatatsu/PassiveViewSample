package com.yatatsu.passiveviewsample.ui.input;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.yatatsu.passiveviewsample.PVSApplication;
import com.yatatsu.passiveviewsample.R;
import com.yatatsu.passiveviewsample.dagger.component.DaggerActivityInjectorComponent;
import com.yatatsu.passiveviewsample.ui.base.ScreenActivity;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import timber.log.Timber;


public class InputActivity extends ScreenActivity<InputController> implements InputScreen {

    @Inject
    InputController controller;

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.edit_text)
    EditText editText;
    @Bind(R.id.input_layout)
    TextInputLayout inputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_GO) {
                    controller.onSubmitEditText(textView.getText().toString());
                    return true;
                }
                return false;
            }
        });
    }

    @OnClick(R.id.submit_username)
    void onClickSubmitUsername() {
        controller.onSubmitEditText(editText.getText().toString());
    }

    @Override
    protected InputController getController() {
        DaggerActivityInjectorComponent.builder()
                .baseComponent(PVSApplication.getBaseComponent())
                .build()
                .inject(this);
        return controller;
    }

    @Override
    public void navigateToUserScreen(String username) {
        Timber.d("username: %s", username);
    }

    @Override
    public void showError(String message) {
        inputLayout.setError(message);
    }

    @Override
    public void hideError() {
        inputLayout.setError(null);
    }
}
