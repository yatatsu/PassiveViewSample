package com.yatatsu.passiveviewsample.ui.user;

import com.yatatsu.passiveviewsample.TestInjectionHelper;
import com.yatatsu.passiveviewsample.data.api.MockData;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.inject.Inject;

import static org.mockito.Mockito.*;

/**
 * Unit test for {@link UserController}
 */
@RunWith(JUnit4.class)
public class UserControllerTest {

    @Inject
    UserController controller;
    @Mock
    UserScreen mockUserScreen;

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
    public void testOnCreateScreen() {
        controller.onCreateScreen("username");
        verify(mockUserScreen).showUserImage(MockData.mockUser().avatarUrl);
        verify(mockUserScreen).showUserName(MockData.mockUser().name);
    }

    @Test
    public void testOnClickReposButton() {
        controller.onCreateScreen("username");
        controller.onClickReposButton();
        verify(mockUserScreen).navigateToReposScreen("username");
    }
}