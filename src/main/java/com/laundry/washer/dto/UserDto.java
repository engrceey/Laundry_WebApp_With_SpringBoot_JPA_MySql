package com.laundry.washer.dto;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Setter
@Getter
public class UserDto {
    private long id;

    @NotEmpty
    private String fullName;

    @NotEmpty
    private String preferredName;

    @NotEmpty
    private String phoneNumber;

    @NotEmpty
    private String email;

    @NotEmpty
    private String role;
}
