package com.yatatsu.passiveviewsample.data.model;


import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static com.google.common.truth.Truth.assert_;

@RunWith(JUnit4.class)
public class UserTest {


    @Test
    public void testFromJson() throws Exception {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        User user = gson.fromJson(json(), User.class);
        assert_().that(user.login).isEqualTo("octocat");
        assert_().that(user.name).isEqualTo("monalisa octocat");
        assert_().that(user.avatarUrl).isEqualTo("https://github.com/images/error/octocat_happy.gif");
    }

    private String json() {
        return "{\n" +
                "  \"login\": \"octocat\",\n" +
                "  \"id\": 1,\n" +
                "  \"avatar_url\": \"https://github.com/images/error/octocat_happy.gif\",\n" +
                "  \"gravatar_id\": \"\",\n" +
                "  \"url\": \"https://api.github.com/users/octocat\",\n" +
                "  \"html_url\": \"https://github.com/octocat\",\n" +
                "  \"followers_url\": \"https://api.github.com/users/octocat/followers\",\n" +
                "  \"following_url\": \"https://api.github.com/users/octocat/following{/other_user}\",\n" +
                "  \"gists_url\": \"https://api.github.com/users/octocat/gists{/gist_id}\",\n" +
                "  \"starred_url\": \"https://api.github.com/users/octocat/starred{/owner}{/repo}\",\n" +
                "  \"subscriptions_url\": \"https://api.github.com/users/octocat/subscriptions\",\n" +
                "  \"organizations_url\": \"https://api.github.com/users/octocat/orgs\",\n" +
                "  \"repos_url\": \"https://api.github.com/users/octocat/repos\",\n" +
                "  \"events_url\": \"https://api.github.com/users/octocat/events{/privacy}\",\n" +
                "  \"received_events_url\": \"https://api.github.com/users/octocat/received_events\",\n" +
                "  \"type\": \"User\",\n" +
                "  \"site_admin\": false,\n" +
                "  \"name\": \"monalisa octocat\",\n" +
                "  \"company\": \"GitHub\",\n" +
                "  \"blog\": \"https://github.com/blog\",\n" +
                "  \"location\": \"San Francisco\",\n" +
                "  \"email\": \"octocat@github.com\",\n" +
                "  \"hireable\": false,\n" +
                "  \"bio\": \"There once was...\",\n" +
                "  \"public_repos\": 2,\n" +
                "  \"public_gists\": 1,\n" +
                "  \"followers\": 20,\n" +
                "  \"following\": 0,\n" +
                "  \"created_at\": \"2008-01-14T04:33:35Z\",\n" +
                "  \"updated_at\": \"2008-01-14T04:33:35Z\"\n" +
                "}";
    }
}