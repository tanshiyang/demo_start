package com.example.ioc;

import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.annotation.Resource;
import java.io.File;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        loader=AnnotationConfigContextLoader.class,
        classes=ApplicationContextTestResourceNameType.class)
public class MethodResourceInjectionIntegrationTest extends TestCase {

    private File defaultFile;

    @Resource(name="namedFile")
    protected void xxx(File dependancy1) {
        this.defaultFile = dependancy1;
        log.info("这个方法怎么会自动被调用呢？");
    }

    @Test
    public void givenResourceAnnotation_WhenSetter_ThenDependencyValid(){
        assertNotNull(defaultFile);
        assertEquals("namedFile.txt", defaultFile.getName());
    }
}