package com.yatatsu.passiveviewsample.ui.repos;


import com.yatatsu.passiveviewsample.data.model.Repository;
import com.yatatsu.passiveviewsample.ui.base.Screen;

import java.util.List;

public interface ReposScreen extends Screen {
    void showRepositories(List<Repository> repositories);
    void showError(String message);
}
