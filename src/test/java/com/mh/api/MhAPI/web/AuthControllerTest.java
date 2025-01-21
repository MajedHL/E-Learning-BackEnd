package com.mh.api.MhAPI.web;

import com.mh.api.MhAPI.services.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@Slf4j
public class AuthControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private AuthService authServiceMock;

    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String URL = "/api/auth";

    private static final String TOKEN = "token";

    @Test
    public void login(){
        when(authServiceMock.authenticateUser(USERNAME, PASSWORD)).thenReturn(TOKEN);
        Map<String, Object> payload = new HashMap<>();
        payload.put("username",USERNAME);
        payload.put("password",PASSWORD);
       ResponseEntity<Map> res = restTemplate.postForEntity(URL+"/login", payload, Map.class);
       log.debug("Testing login, responseEntity body: {}",res.getBody());
       assertThat(res.getStatusCode(), is(HttpStatus.OK));
       assertThat(res.getBody().get("token"), is(TOKEN));
    }
}
