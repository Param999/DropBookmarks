package com.param.dropbookmarks.auth;

import com.google.common.base.Optional;
import com.param.dropbookmarks.core.User;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;

public class HelloAuthenticator implements Authenticator<BasicCredentials, User> {

    @Override
    public Optional<User> authenticate(BasicCredentials basicCredentials) throws AuthenticationException {
        if("pass".equals(basicCredentials.getPassword())){
            return Optional.of(new User());
        }else{
            return Optional.absent();
        }
    }
}