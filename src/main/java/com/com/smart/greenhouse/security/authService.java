package com.com.smart.greenhouse.security;

import com.com.smart.greenhouse.exceptions.UserNotAuthorizedException;
import com.com.smart.greenhouse.models.User;
import com.com.smart.greenhouse.repository.UserTokenRepository;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.time.Duration;
import java.util.*;

@ApplicationScoped
public class authService {

    private static final Config config = ConfigProvider.getConfig();

    static final int EXPIRE_IN = config.getValue("jwt.lifetime.duration",Integer.class);
    static final Duration EXPIRES = Duration.ofSeconds(EXPIRE_IN);
    @Inject
    private UserTokenRepository userTokenRepository ;

    @Inject
    private SecurityService securityService;

    @Inject
    private Validator validator;




    public authResponse token(authRequest request) {

        final User user = securityService.findBy(request.getEmail(), request.getPassword());
        System.out.println(user.toString());
        Optional<UserToken> optionalUserToken = userTokenRepository.findByEmail(request.getEmail()) ;
        UserToken userToken ;
        if(optionalUserToken.isPresent()){
            userToken=optionalUserToken.get() ;
        }else{
            userToken=new UserToken(request.getEmail()) ;
        }

        final com.com.smart.greenhouse.security.Token token= com.com.smart.greenhouse.security.Token.generate() ;
        final String jwt = UserJWT.createToken(user, token, EXPIRES);
        AccessToken accessToken = new AccessToken(token.get(), jwt, EXPIRES);
        //here the error
        RefreshToken refreshToken = new RefreshToken(Token.generate(), accessToken);
        userToken.add(refreshToken);
        userTokenRepository.save(userToken);
        final authResponse response = authResponse.of(accessToken, refreshToken, EXPIRE_IN);
        return response;
    }





    public authResponse refreshToken(authRequest request) {
        System.out.println("refresh methode is activated");
        final Set<ConstraintViolation<authRequest>> violations = validator.validate(request, authRequest
                .RefreshToken.class);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }

        System.out.println(userTokenRepository.findByRefreshToken(request.getRefreshToken()));
        final UserToken userToken = userTokenRepository.findByRefreshToken(request.getRefreshToken())
                .orElseThrow(() -> new UserNotAuthorizedException());

        final User user = securityService.findBy(userToken.getEmail());
        final Token token = Token.generate();
        final String jwt = UserJWT.createToken(user, token, EXPIRES);
        AccessToken accessToken = new AccessToken(token.get(), jwt, EXPIRES);
        RefreshToken refreshToken = userToken.update(accessToken, request.getRefreshToken(), userTokenRepository);
        final authResponse response = authResponse.of(accessToken, refreshToken, EXPIRE_IN);

        return response;
    }



}