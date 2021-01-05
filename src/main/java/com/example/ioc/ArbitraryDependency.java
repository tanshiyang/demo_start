package com.example.ioc;

import org.springframework.stereotype.Component;

@Component
public class ArbitraryDependency {

    private final String label = "Arbitrary Dependency";

    @Override
    public String toString() {
        return label;
    }
}