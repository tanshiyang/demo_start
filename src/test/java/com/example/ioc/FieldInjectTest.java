package com.example.ioc;

import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.inject.Inject;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        loader=AnnotationConfigContextLoader.class,
        classes=ArbitraryDependency.class)
public class FieldInjectTest extends TestCase {

    @Autowired
    private ArbitraryDependency fieldInjectDependency;

    @Test
    public void givenInjectAnnotation_WhenOnField_ThenValidDependency(){
        assertNotNull(fieldInjectDependency);
        assertEquals("Arbitrary Dependency",
                fieldInjectDependency.toString());
    }
}