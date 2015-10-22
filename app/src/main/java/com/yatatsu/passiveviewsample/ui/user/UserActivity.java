package com.yatatsu.passiveviewsample.ui.user;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.yatatsu.autobundle.Arg;
import com.yatatsu.autobundle.AutoBundle;
import com.yatatsu.passiveviewsample.PVSApplication;
import com.yatatsu.passiveviewsample.R;
import com.yatatsu.passiveviewsample.dagger.component.DaggerActivityInjectorComponent;
import com.yatatsu.passiveviewsample.ui.base.ScreenActivity;
import com.yatatsu.passiveviewsample.ui.repos.ReposActivityAutoBundle;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import timber.log.Timber;

public class UserActivity extends ScreenActivity<UserController> implements UserScreen {

    @Inject
    UserController controller;
    @Inject
    Picasso picasso;

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.text_user_name)
    TextView userNameView;
    @Bind(R.id.user_image)
    ImageView userImageView;

    @Arg
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        AutoBundle.bind(this);
        setTitle(username);
        controller.onCreateScreen(username);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        controller.onDestroyScreen();
    }

    @OnClick(R.id.fab_show_repos)
    void onClickFab() {
        controller.onClickReposButton();
    }

    @Override
    protected UserController getController() {
        DaggerActivityInjectorComponent.builder()
                .baseComponent(PVSApplication.getBaseComponent())
                .build()
                .inject(this);
        return controller;
    }

    @Override
    public void showUserImage(String avatarUrl) {
        picasso.load(avatarUrl)
                .fit()
                .into(userImageView);
    }

    @Override
    public void showUserName(String fullName) {
        userNameView.setText(fullName);
    }

    @Override
    public void showErrorDialog(String message) {
        Timber.d("showErrorDialog with %s", message);
    }

    @Override
    public void navigateToReposScreen(String username) {
        Intent intent = ReposActivityAutoBundle
                .createIntentBuilder(username)
                .build(this);
        startActivity(intent);
    }
}
