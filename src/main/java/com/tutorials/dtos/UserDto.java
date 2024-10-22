package com.tutorials.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserDto {

    private Integer userId;

    @NotEmpty
    @Size(min = 2,max = 20,message = "Name should be in between 2-20 character")
    private  String name;

    //consider as User-Name
    @Email(message = "Invalid email address..")
    private String email;

    @Size(min = 4,max = 8,message = "password should be in between 4-8 character")
    private String password;

    private String gender;

    @Size(max = 10,message = "phone number should be 10 digit..!!")
    private String phoneNo;

    private String address;

    private String about;

    private Date createdAt;

    private boolean active;
}
