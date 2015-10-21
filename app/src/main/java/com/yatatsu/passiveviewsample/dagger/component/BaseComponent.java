package com.yatatsu.passiveviewsample.dagger.component;

import com.squareup.picasso.Picasso;
import com.yatatsu.passiveviewsample.dagger.module.GithubApiModule;
import com.yatatsu.passiveviewsample.dagger.module.NetworkModule;
import com.yatatsu.passiveviewsample.dagger.module.ThreadingModule;
import com.yatatsu.passiveviewsample.dagger.scope.ApplicationScope;
import com.yatatsu.passiveviewsample.data.api.GitHubService;

import dagger.Component;

/**
 * BaseComponent
 */
@ApplicationScope
@Component(modules =
        {
                NetworkModule.class,
                ThreadingModule.class,
                GithubApiModule.class
        },
        dependencies = AppComponent.class)
public interface BaseComponent {
    GitHubService gitHubService();
    Picasso picasso();
}
