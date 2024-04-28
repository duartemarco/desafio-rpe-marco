package com.rpe.desafioestagiariovehicle.dto;

import com.rpe.desafioestagiariovehicle.enums.RoleName;

public record CreateUserDto(

        String email,
        String password,
        RoleName role

) {
}
