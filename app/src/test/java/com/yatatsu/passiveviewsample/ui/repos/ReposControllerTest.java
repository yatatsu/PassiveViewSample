package com.yatatsu.passiveviewsample.ui.repos;

import com.yatatsu.passiveviewsample.TestInjectionHelper;
import com.yatatsu.passiveviewsample.data.api.MockData;
import com.yatatsu.passiveviewsample.data.model.Repository;

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
 * Unit test for {@link ReposController}
 */
@RunWith(JUnit4.class)
public class ReposControllerTest {

    @Inject
    ReposController controller;

    @Mock
    ReposScreen mockReposScreen;

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
        verify(mockReposScreen).openUrl(repo.htmlUrl);
    }

    @Test
    public void testOnStartScreen() throws Exception {
        controller.onCreateScreen("username");
        controller.onStartScreen();
        verify(mockReposScreen).showRepositories(MockData.MOCK_REPOS);
    }
}