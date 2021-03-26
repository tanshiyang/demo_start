package com.example.aop;

import com.example.ioc.ArbitraryDependency;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UseSimpleAopTest extends TestCase {
    @Resource
    UseSimpleAop useSimpleAop ;

    @Test
    public void testJustPrint() {
        useSimpleAop.justPrint("world");
    }
}