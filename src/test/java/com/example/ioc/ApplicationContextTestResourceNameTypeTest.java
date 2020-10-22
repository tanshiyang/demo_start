package com.example.ioc;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.annotation.Resource;
import java.io.File;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        loader= AnnotationConfigContextLoader.class,
        classes=ApplicationContextTestResourceNameType.class)
public class ApplicationContextTestResourceNameTypeTest extends TestCase {
    @Resource
    private File defaultFile;

    @Resource
    @Qualifier("defaultFile")
    private File dependancy1;

    @Resource
    @Qualifier("namedFile")
    private File dependancy2;

    @Resource(name = "namedFile")
    private File dependancy3;

    @Test
    public void givenResourceAnnotation_WhenOnField_ThenDependencyValid(){
        assertNotNull(defaultFile);
        assertEquals("defaultFile.txt", defaultFile.getName());

        assertNotNull(dependancy1);
        assertEquals("defaultFile.txt", dependancy1.getName());

        assertNotNull(dependancy2);
        assertEquals("namedFile.txt", dependancy2.getName());

        assertNotNull(dependancy3);
        assertEquals("namedFile.txt", dependancy3.getName());
    }
}