package com.example.Bcrypt;

import org.junit.Test;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Random;

public class BcryptTest {
    @Test
    public void generatePassword(){
        String password = BCrypt.hashpw("password", BCrypt.gensalt());
        System.out.println(password);
        System.out.println(BCrypt.checkpw(password,"password"));

        password = BCrypt.hashpw("password", BCrypt.gensalt());
        System.out.println(password);
        System.out.println(BCrypt.checkpw(password,"password"));
    }

    @Test
    public void test01(){
        System.out.println(generateString(20));
    }

    public  String generateString(int length) {
        StringBuffer sb = new StringBuffer();
        String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }
}
