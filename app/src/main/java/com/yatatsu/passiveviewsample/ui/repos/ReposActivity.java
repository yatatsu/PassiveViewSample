package com.yatatsu.passiveviewsample.ui.repos;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.yatatsu.autobundle.Arg;
import com.yatatsu.autobundle.AutoBundle;
import com.yatatsu.passiveviewsample.PVSApplication;
import com.yatatsu.passiveviewsample.R;
import com.yatatsu.passiveviewsample.dagger.component.DaggerActivityInjectorComponent;
import com.yatatsu.passiveviewsample.data.model.Repository;
import com.yatatsu.passiveviewsample.ui.adapter.ReposAdapter;
import com.yatatsu.passiveviewsample.ui.base.ScreenActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import timber.log.Timber;

public class ReposActivity extends ScreenActivity<ReposController> implements ReposScreen {

    @Inject
    ReposController controller;

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;

    @Arg
    String username;

    private ReposAdapter reposAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repos);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        AutoBundle.bind(this);
        controller.onCreateScreen(username);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        reposAdapter = new ReposAdapter(this, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = recyclerView.getChildAdapterPosition(view);
                controller.onItemClick(reposAdapter.getItem(position));
            }
        });
        recyclerView.setAdapter(reposAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        controller.onStartScreen();
    }

    @Override
    protected void onStop() {
        super.onStop();
        controller.onStopScreen();
    }

    @Override
    protected ReposController getController() {
        DaggerActivityInjectorComponent.builder()
                .baseComponent(PVSApplication.getBaseComponent())
                .build()
                .inject(this);
        return controller;
    }

    @Override
    public void showRepositories(List<Repository> repositories) {
        reposAdapter.setRepos(repositories);
    }

    @Override
    public void showError(String message) {
        Timber.e(message);
    }

    @Override
    public void openUrl(String url) {
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
        } catch (ActivityNotFoundException e) {
            Timber.e(e, "cannot open %s", url);
        }
    }
}
