package com.auth_youtube.auth;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/token")
public class TokenController {
    

    @PostMapping("/")
    public String token(@RequestBody User user) {



        HttpHeaders headers = new HttpHeaders();
        RestTemplate rt = new RestTemplate();

        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("password", user.password);
        formData.add("clientId", user.clientId);
        formData.add("grantType", user.grantType);
        formData.add("user", user.user);

        HttpEntity<MultiValueMap<String,String>> entity
            = new HttpEntity<>(formData,headers);

        var result = rt.postForEntity("http://127.0.0.1:8080/realms/demo/protocol/openid-connect/token", entity, String.class);

        return result.toString();
    }

    public record User (String password, String clientId,  String grantType, String user){

    }

}
