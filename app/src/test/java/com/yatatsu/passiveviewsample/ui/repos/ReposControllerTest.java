package com.yatatsu.passiveviewsample.ui.repos;

import com.yatatsu.passiveviewsample.DaggerTestInjectorComponent;
import com.yatatsu.passiveviewsample.TestInjectionHelper;
import com.yatatsu.passiveviewsample.dagger.component.BaseComponent;
import com.yatatsu.passiveviewsample.dagger.component.DaggerBaseComponent;
import com.yatatsu.passiveviewsample.dagger.module.MockGithubApiModule;
import com.yatatsu.passiveviewsample.dagger.module.MockNetworkModule;
import com.yatatsu.passiveviewsample.dagger.module.MockThreadingModule;
import com.yatatsu.passiveviewsample.data.api.GitHubService;
import com.yatatsu.passiveviewsample.data.api.MockData;
import com.yatatsu.passiveviewsample.data.model.Repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import javax.inject.Inject;

import retrofit.HttpException;
import retrofit.Response;
import rx.Observable;

import static org.mockito.Mockito.*;

/**
 * Unit test for {@link ReposController}
 */
@RunWith(JUnit4.class)
public class ReposControllerTest {

    @Inject
    ReposController controller;

    @Mock
    ReposScreen mockReposScreen;
    @Mock
    GitHubService mockGitHubService;

    @Before
    public void setup() throws Exception {
        TestInjectionHelper.getInstance()
                .getInjectorComponent()
                .inject(this);
        MockitoAnnotations.initMocks(this);
        controller.registerScreen(mockReposScreen);
    }

    @After
    public void tearDown() throws Exception {
        controller.onStopScreen();
    }

    @Test
    public void testOnItemClick() throws Exception {
        Repository repo = MockData.MOCK_REPOS.get(0);
        controller.onItemClick(repo);
        verify(mockReposScreen).openUrl(repo.getHtmlUrl());
    }

    @Test
    public void testOnStartScreen() throws Exception {
        controller.onCreateScreen("username");
        controller.onStartScreen();
        verify(mockReposScreen).showRepositories(MockData.MOCK_REPOS);
    }

    @Test
    public void testNotFoundError() throws Exception {
        String username = "username";

        when(mockGitHubService.getRepositories(username)).
                thenReturn(Observable.<List<Repository>>error(
                        new HttpException(Response.error(404, null))));
        BaseComponent baseComponent = DaggerBaseComponent.builder()
                .appComponent(TestInjectionHelper.getAppComponent())
                .networkModule(new MockNetworkModule())
                .threadingModule(new MockThreadingModule())
                .githubApiModule(new MockGithubApiModule(mockGitHubService))
                .build();
        DaggerTestInjectorComponent.builder()
                .baseComponent(baseComponent)
                .build()
                .inject(this);
        controller.registerScreen(mockReposScreen);
        controller.onCreateScreen(username);
        controller.onStartScreen();
        verify(mockReposScreen).showError("Not Found");
    }
}