package com.xk.xkapiinterface.contorller;


import com.xk.xkapiclientsdk.model.User;
import com.xk.xkapiclientsdk.utils.SignUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/name")

public class NameController {

    @GetMapping("/")
    public String getNameByGet(String name, HttpServletRequest request) {
        System.out.println(request.getHeader("yupi"));
        return "GET 你的名字是" + name;
    }

    @PostMapping("/")
    public String getNameByPost(@RequestParam String name) {
        return "POST 你的名字是" + name;
    }

    @PostMapping("/user")
    public String getUsernameByPost(@RequestBody User user, HttpServletRequest request){

        String accessKey=request.getHeader("accessKey");
        String nonce=request.getHeader("nonce");
        String timestamp=request.getHeader("timestamp");
        String sign=request.getHeader("sign");
        String body=request.getHeader("body");
        if(!accessKey.equals("xk")){
            throw  new RuntimeException("无权限");
        }
        if(Long.parseLong(nonce)>10000){
            throw new RuntimeException("无权限");
        }
      String serverSign=  SignUtils.genSign(body,"abcdef");
        if(!sign.equals(serverSign)){
            throw new RuntimeException("无权限");
        }
        return "POST 用户名字是" + user.getUsername();

    }

}

