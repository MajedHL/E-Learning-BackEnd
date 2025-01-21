package com.mh.api.MhAPI.service;

import com.mh.api.MhAPI.models.User;
import com.mh.api.MhAPI.repositories.UserRepository;
import com.mh.api.MhAPI.services.UserService;
import com.mh.api.MhAPI.utils.MHException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.annotation.meta.When;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    private static final String USERNAME = "saaid";

    @Mock
    private UserRepository userRepositoryMock;

    @Mock
    private User userMock;

    @InjectMocks
    private UserService service;


    @Test
    public void getUserByUsername(){
        when(userRepositoryMock.findUserByEmail(USERNAME)).thenReturn(Optional.of(userMock));
        assertThat(service.getUserByUsername(USERNAME),is(userMock));
    }

    @Test
    public void addUser() throws Exception {
        when(userMock.getEmail()).thenReturn(USERNAME);
        when(userRepositoryMock.findUserByEmail(USERNAME)).thenReturn(Optional.empty());

        service.addUser(userMock);
        verify(userRepositoryMock,times(1)).save(any(User.class));
    }

    @Test
    public void addUserFail() throws Exception {
        when(userMock.getEmail()).thenReturn(USERNAME);
        when(userRepositoryMock.findUserByEmail(USERNAME)).thenReturn(Optional.of(userMock));


        MHException e = assertThrows(MHException.class, ()->service.addUser(userMock));
        verify(userRepositoryMock,never()).save(any(User.class));
        assertEquals(e.getCode(),MHException.CODE_USER_EXISTS);
        assertEquals(e.getMessage(),MHException.USER_EXISTS);
    }


    @Test
    public void getUserByUsernameNotFound(){
        when(userRepositoryMock.findUserByEmail(USERNAME)).thenReturn(Optional.empty());
        assertThrows(NoSuchElementException.class,()-> service.getUserByUsername(USERNAME));
    }


}
