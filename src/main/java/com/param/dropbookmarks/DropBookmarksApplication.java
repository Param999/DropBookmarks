package com.param.dropbookmarks;

import com.param.dropbookmarks.auth.HelloAuthenticator;
import com.param.dropbookmarks.core.User;
import com.param.dropbookmarks.resources.HelloResource;
import io.dropwizard.Application;
import io.dropwizard.auth.AuthFactory;
import io.dropwizard.auth.basic.BasicAuthFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DropBookmarksApplication extends Application<DropBookmarksConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DropBookmarksApplication().run(args);
    }

    @Override
    public String getName() {
        return "DropBookmarks";
    }

    @Override
    public void initialize(final Bootstrap<DropBookmarksConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final DropBookmarksConfiguration configuration,
                    final Environment environment) {
        environment.jersey().register(new HelloResource());
        environment.jersey().register(
                AuthFactory.binder(
                        new BasicAuthFactory<>(
                                new HelloAuthenticator(configuration.getPassword()),
                                "SECURITY REALM",
                                User.class
                        )
                )
        );
    }

}
