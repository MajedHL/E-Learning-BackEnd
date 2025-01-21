package com.mh.api.MhAPI.services;

import com.mh.api.MhAPI.dto.UserDTO;
import com.mh.api.MhAPI.models.User;
import com.mh.api.MhAPI.repositories.UserRepository;
import com.mh.api.MhAPI.utils.MHException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Slf4j
public class UserService {

    protected final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void addUser(User user) throws Exception{
        Optional<User> checkUser = userRepository.findUserByEmail(user.getEmail());
        if(checkUser.isPresent()){
            throw  new MHException(MHException.USER_EXISTS, MHException.CODE_USER_EXISTS);
       }
        userRepository.save(user);

    }

    public String deleteUser(Long id){
     if(!userRepository.existsById(id)){
         return "User with id "+id+" doesnt exist";
     }
        userRepository.deleteById(id);
     return "User with id "+id+" deleted";
    }


    public String updateUser(Long id, UserDTO userDto){
        log.debug("updating user with id {}",id);
        String message=" user with id "+id+" has been updated";
        User user = userRepository.findById(id).orElseThrow(()->new NoSuchElementException("user with id "+id+" doesnt exist"));

      if(userDto.getFirstName()!=null)  user.setFirstName(userDto.getFirstName());
      if(userDto.getLastName()!=null)   user.setLastName(userDto.getLastName());
      if(userDto.getBirthDate()!=null)  user.setBirthDate(userDto.getBirthDate());
      if(userDto.getEmail()!=null)      user.setEmail(userDto.getEmail());
      if(userDto.getPassword()!=null)   user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        userRepository.save(user);
        return message;
    }

    public String getUserFirstNameByUsername(String username){
        Optional<User> checkUser = userRepository.findUserByEmail(username);
        if(checkUser.isPresent()) return checkUser.get().getFirstName();
        else return "";
    }

    public User getUserByUsername(String username){
        return userRepository.findUserByEmail(username).orElseThrow(()->new NoSuchElementException());
    }

    public Boolean userExists(User user){
        return userRepository.existsById(user.getId());
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(()->new NoSuchElementException());
    }
}
