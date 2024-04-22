package com.xk.xkapiclientsdk.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.xk.xkapiclientsdk.model.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.HashMap;
import java.util.Map;

import static com.xk.xkapiclientsdk.utils.SignUtils.genSign;


public class XkapiClient {

    private String accessKey;

    private String secretKey;

    public XkapiClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    public String getNameByGet(String name){
        HashMap<String,Object>paramMap=new HashMap<>();

        paramMap.put("name",name);
        String result= HttpUtil.get("http://localhost:8123/api/name/",paramMap);
        System.out.println(result);
        return result;

    }


    public String getNameByPost(@RequestParam String name){
        HashMap<String,Object>paramMap=new HashMap<>();

        paramMap.put("name",name);
        String result= HttpUtil.post("http://localhost:8123/api/name/",paramMap);
        System.out.println(result);
        return result;

    }

    private Map<String,String> getHeadersMap(String body){

        Map<String,String>hashMap=new HashMap<>();
        hashMap.put("accessKey",accessKey);

        hashMap.put("nonce", RandomUtil.randomNumbers(4));

        hashMap.put("body",body);
        hashMap.put("timeStamp",String.valueOf(System.currentTimeMillis()/1000));

        hashMap.put("sign",genSign(body,secretKey));

        return hashMap;
    }

    public String getUsernameByPost(@RequestBody User user) {
        String json = JSONUtil.toJsonStr(user);
        HttpResponse httpResponse = HttpRequest.post("http://localhost:8123/api/name/user")
                .addHeaders(getHeadersMap(json))
                .body(json)
                .execute();
        System.out.println(httpResponse.getStatus());
        String result = httpResponse.body();
        System.out.println(result);
        return result;
    }




}

