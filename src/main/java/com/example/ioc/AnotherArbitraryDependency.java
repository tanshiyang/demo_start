package com.example.ioc;

import org.springframework.stereotype.Component;

@Component
public class AnotherArbitraryDependency extends ArbitraryDependency {
    private final String label = "Another Arbitrary Dependency";

    @Override
    public String toString() {
        return label;
    }
}
