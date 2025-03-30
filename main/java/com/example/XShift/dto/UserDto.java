package com.example.XShift.dto;

import com.example.XShift.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String userName;
    private String email;
    private String password;
    private Role role;
}