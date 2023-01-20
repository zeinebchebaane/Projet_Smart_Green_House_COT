package com.com.smart.greenhouse.security;




import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;


import java.lang.annotation.Annotation;
import java.util.Objects;

@Entity
public class RefreshToken implements authRequest.RefreshToken {

    @Column
    private String token;

    @Column
    private AccessToken accessToken;

    RefreshToken(Token token, AccessToken accessToken) {
        this.token = token.get();
        this.accessToken = accessToken;
    }

    @Deprecated
    RefreshToken() {
    }

    public String getToken() {
        return token;
    }

    public AccessToken getAccessToken() {
        return accessToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RefreshToken that = (RefreshToken) o;
        return Objects.equals(token, that.token);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(token);
    }

    @Override
    public String toString() {
        return "RefreshToken{" +
                "token='" + token + '\'' +
                ", accessToken=" + accessToken +
                '}';
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}