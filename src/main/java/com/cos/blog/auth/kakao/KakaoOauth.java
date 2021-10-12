package com.cos.blog.auth.kakao;

import com.cos.blog.model.KakaoProfile;
import com.cos.blog.model.OAuthToken;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class KakaoOauth {

    @GetMapping("/auth/kakao/callback")
    public @ResponseBody String callback(@RequestParam("code") String code) {
        System.out.println("!!!!!!!" + code );

        // 카카오 토큰 받는 순서
        // 1. restTemplate 생성
        // 2. HttpHeaders 생성( Content-type...
        // 3. MultiValueMap 생성 : Body 정보를 params으로
        // 4. HttpEntity 생성 : 헤더와 바디를 묶는 용도
        // 5. ResponseEntity : url/http_method/헤더바디/응답리턴 양식

        RestTemplate rt = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");

        MultiValueMap<String,String> parmas = new LinkedMultiValueMap<>();
            parmas.add("grant_type","authorization_code");
            parmas.add("client_id","b0c3492437bf70995dbe665e6954254b");
            parmas.add("redirect_uri","http://localhost:8000/auth/kakao/callback");
            parmas.add("code",code);

        HttpEntity<MultiValueMap<String,String>> kakaoTokenRequest = new HttpEntity<>(parmas, headers);

        ResponseEntity response = rt.exchange(
                "https://kauth.kakao.com/oauth/token",
                HttpMethod.POST,
                kakaoTokenRequest,
                String.class
        );

        OAuthToken oauthToken = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            oauthToken = objectMapper.readValue((String) response.getBody(), OAuthToken.class);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        //#################################################
        // Kakaco 정보 얻기
        //#################################################

        String code2 = null;

        RestTemplate rtOfInfo = new RestTemplate();
        HttpHeaders headersOfInfo = new HttpHeaders();
        headersOfInfo.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");
        headersOfInfo.add("Authorization","Bearer " + oauthToken.getAccess_token());

        HttpEntity<MultiValueMap<String,String>> kakaoTokenRequestOfInfo = new HttpEntity<>(headersOfInfo);

        ResponseEntity responseOfInfo = rtOfInfo.exchange(
                "https://kapi.kakao.com/v2/user/me",
                HttpMethod.POST,
                kakaoTokenRequestOfInfo,
                String.class
        );


        KakaoProfile kakaoProfile = null;
        ObjectMapper objectMapperOfInfo = new ObjectMapper();
        try {
            kakaoProfile = objectMapperOfInfo.readValue( (String) responseOfInfo.getBody() , KakaoProfile.class);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


        //System.out.println(" @@@@@" + oauthToken.getAccess_token());




    return "카카오 인증 완료 : " + kakaoProfile.toString()  ;
    }
}
