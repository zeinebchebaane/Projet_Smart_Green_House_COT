package com.com.smart.greenhouse.security;


import java.util.function.Supplier;
import java.util.stream.Stream;

public  enum GrantType implements Supplier<String> {

    PASSWORD("password"),
    REFRESH_TOKEN("refresh_token");

    public final String value;

    GrantType(String value) {
        this.value = value;
    }

    @Override
    public String get() {
        return value;
    }

    static GrantType parse(String value) {
        return Stream.of(GrantType.values())
                .filter(g -> g.get().equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("There is not GrantType " + value));
    }
}