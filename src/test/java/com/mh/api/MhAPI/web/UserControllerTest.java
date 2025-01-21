package com.mh.api.MhAPI.web;

import com.mh.api.MhAPI.models.User;
import com.mh.api.MhAPI.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;


import java.util.List;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@Slf4j
public class UserControllerTest {

    private static final String URL = "/api/user";
    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private UserService userServiceMock;

    @Mock
    private User userMock;

    @Test
    public void getAllUsersUnAuthorized(){
       ResponseEntity<String> res = restTemplate.getForEntity(URL+"/all", String.class);
        assertThat(res.getStatusCode(), is(HttpStatus.UNAUTHORIZED));
        log.debug(String.valueOf(res));
       verify(userServiceMock,never()).getAllUsers();
    }

//    @Test
//    public void getAllUsersAuthorized(){
//        String validToken = "Bearer mock-valid-token";
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Authorization", validToken);
//
//        HttpEntity<Void> entity = new HttpEntity<>(headers);
//
//        when(userServiceMock.getAllUsers()).thenReturn(List.of(userMock));
//
//
//        ResponseEntity<String> res = restTemplate.exchange(
//                URL + "/all", HttpMethod.GET, entity, String.class
//        );
//
//        assertThat(res.getStatusCode(), is(HttpStatus.OK));
//
//        verify(userServiceMock).getAllUsers();
//    }

}
