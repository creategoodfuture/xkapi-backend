package com.xk.xkapiinterface;

import com.xk.xkapiclientsdk.client.XkapiClient;
import com.xk.xkapiclientsdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class XkapiInterfaceApplicationTests {
    @Resource
    private XkapiClient xkapiClient;

    @Test
    void contextLoads() {
        String result=xkapiClient.getNameByGet("xk");
        User user=new User();
        user.setUsername("cxa");
        String usernameByPost=xkapiClient.getUsernameByPost(user);
        System.out.println(result);
        System.out.println(usernameByPost);
    }

}
