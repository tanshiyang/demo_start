package com.example;

import org.junit.Test;

public class SimpeTest {

    @Test
    public void Test01(){
        fun1("a","b","c");
    }
    private void fun1(String... strs){
        for (String s :
                strs) {
            System.out.println(s);
        }
    }
}
