package com.yatatsu.passiveviewsample.ui.user;

import com.yatatsu.passiveviewsample.DaggerTestInjectorComponent;
import com.yatatsu.passiveviewsample.TestInjectionHelper;
import com.yatatsu.passiveviewsample.dagger.component.BaseComponent;
import com.yatatsu.passiveviewsample.dagger.component.DaggerBaseComponent;
import com.yatatsu.passiveviewsample.dagger.module.MockGithubApiModule;
import com.yatatsu.passiveviewsample.dagger.module.MockNetworkModule;
import com.yatatsu.passiveviewsample.dagger.module.MockThreadingModule;
import com.yatatsu.passiveviewsample.data.api.GitHubService;
import com.yatatsu.passiveviewsample.data.api.MockData;
import com.yatatsu.passiveviewsample.data.model.User;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.inject.Inject;

import retrofit.HttpException;
import retrofit.Response;
import rx.Observable;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Unit test for {@link UserController}
 */
@RunWith(JUnit4.class)
public class UserControllerTest {

    @Inject
    UserController controller;
    @Mock
    UserScreen mockUserScreen;
    @Mock
    GitHubService mockGitHubService;

    @Before
    public void setup() throws Exception {
        TestInjectionHelper.getInstance()
                .getInjectorComponent()
                .inject(this);
        MockitoAnnotations.initMocks(this);
        controller.registerScreen(mockUserScreen);
    }

    @After
    public void tearDown() throws Exception {
        controller.onDestroyScreen();
    }

    @Test
    public void testOnCreateScreen() throws Exception {
        controller.onCreateScreen("username");
        verify(mockUserScreen).showUserImage(MockData.MOCK_USER.avatarUrl);
        verify(mockUserScreen).showUserName(MockData.MOCK_USER.name);
    }

    @Test
    public void testNotFoundError() throws Exception {
        String username = "username";

        when(mockGitHubService.getUser(username)).
                thenReturn(Observable.<User>error(
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
        controller.registerScreen(mockUserScreen);
        controller.onCreateScreen(username);
        verify(mockUserScreen).showErrorDialog("Not Found");
    }

    @Test
    public void testOnClickReposButton() throws Exception {
        controller.onCreateScreen("username");
        controller.onClickReposButton();
        verify(mockUserScreen).navigateToReposScreen("username");
    }
}