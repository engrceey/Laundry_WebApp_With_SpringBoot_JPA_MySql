package com.laundry.washer.dto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Setter
@Getter
public class PostDto {
    private long postId;

    @NotEmpty
    private String username;

    @NotEmpty
    private String phoneNumber;

    @NotEmpty
    private String message;

    @NotEmpty
    private String service;

    @NotEmpty
    private String status;

    @NotEmpty
    private Date date;

}
