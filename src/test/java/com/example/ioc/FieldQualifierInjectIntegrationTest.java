package com.example.ioc;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.inject.Inject;
import javax.inject.Named;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        loader=AnnotationConfigContextLoader.class,
        classes=ApplicationContextTestResourceNameType.class)
public class FieldQualifierInjectIntegrationTest extends TestCase {

    @Autowired
    @Named("defaultArbitrary")
    private ArbitraryDependency defaultDependency;

    @Autowired
    @Named("anotherArbitrary")
    private ArbitraryDependency namedDependency;

    @Test
    public void givenInjectQualifier_WhenOnField_ThenDefaultFileValid(){
        assertNotNull(defaultDependency);
        assertEquals("Arbitrary Dependency",
                defaultDependency.toString());
    }

    @Test
    public void givenInjectQualifier_WhenOnField_ThenNamedFileValid(){
        assertNotNull(defaultDependency);
        assertEquals("Another Arbitrary Dependency",
                namedDependency.toString());
    }
}