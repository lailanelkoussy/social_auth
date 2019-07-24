package com.social.auth.model.dto;

import lombok.Data;


import java.time.LocalDate;

@Data
public class UserDTO {

    private int userId;

    private String email;

    private String username;

    private String password;

    private boolean active;

    private String firstName;

    private String middleName;

    private String lastName;

    private LocalDate birthday;

    private Boolean accountExpired = false;

    private Boolean accountLocked = false;

    private Boolean credentialsExpired = false;

    private Boolean enabled = true;
}
