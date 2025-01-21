package com.mh.api.MhAPI.dto;

import com.mh.api.MhAPI.models.UserStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDTO {

    private String firstName;

    private String lastName;

    private String email;

    private LocalDate birthDate;

    private String password;


}
