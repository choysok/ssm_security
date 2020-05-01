package com.page;

import com.page.ssm.utils.BCryptPasswordEncoderUtils;
import org.junit.Test;

public class TestBCryptPasswordEncoderUtils {
    @Test
    public void run(){

        String  ps= "123";
        String newPs = BCryptPasswordEncoderUtils.encodePassword(ps);
        System.out.println("加密："+newPs);
    }
}
