package com.example.enums;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@RunWith(SpringRunner.class)

public class TypeEnumTest extends TestCase {
    @Test
    public void testJustPrint()  {
        System.out.println(TypeEnum.ADMIN);
        System.out.println(TypeEnum.ADMIN.getDesc());
    }

    @Test
    public void ClassForNameTest() {
        Class<?> clazz = null;
        try {
            clazz = Class.forName("com.example.entity.User");
            Constructor<?> constructor = clazz.getConstructors()[0];
            Object x = constructor.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(clazz.getTypeName());
    }
}