package com.example.ioc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;
import java.io.File;
import java.security.Timestamp;
import java.util.Date;

@Slf4j
@Resource
public class ApplicationContextTestResourceNameType {
    @Bean("defaultFile")
    public File defaultFile() {
        File namedFile = new File("defaultFile.txt");
        Date date = new Date();
        log.info("defaultFile实例创建,"+ date.getTime());
        return namedFile;
    }

    @Bean("namedFile")
    public File namedFile() {
        File namedFile = new File("namedFile.txt");
        return namedFile;
    }

    @Bean("defaultArbitrary")
    public ArbitraryDependency defaultArbitrary(){
        ArbitraryDependency dependency = new ArbitraryDependency();
        return dependency;
    }

    @Bean("anotherArbitrary")
    public ArbitraryDependency anotherArbitrary(){
        ArbitraryDependency dependency = new AnotherArbitraryDependency();
        return dependency;
    }
}
