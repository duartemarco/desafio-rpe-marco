package com.rpe.desafioestagiariovehicle.dto;

import com.rpe.desafioestagiariovehicle.model.Role;

import java.util.List;

public record RecoveryUserDto(

        Long id,
        String email,
        List<Role> roles

) {
}