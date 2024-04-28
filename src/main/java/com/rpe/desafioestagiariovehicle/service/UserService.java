package com.rpe.desafioestagiariovehicle.service;

import com.rpe.desafioestagiariovehicle.dto.CreateUserDto;
import com.rpe.desafioestagiariovehicle.dto.LoginUserDto;
import com.rpe.desafioestagiariovehicle.dto.RecoveryJwtTokenDto;
import com.rpe.desafioestagiariovehicle.model.Role;
import com.rpe.desafioestagiariovehicle.model.User;
import com.rpe.desafioestagiariovehicle.repository.UserRepository;
import com.rpe.desafioestagiariovehicle.security.SecurityConfiguration;
import com.rpe.desafioestagiariovehicle.security.authentication.JwtTokenService;
import com.rpe.desafioestagiariovehicle.security.userdetails.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityConfiguration securityConfiguration;

    public RecoveryJwtTokenDto authenticateUser(LoginUserDto loginUserDto) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(loginUserDto.email(), loginUserDto.password());

        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return new RecoveryJwtTokenDto(jwtTokenService.generateToken(userDetails));
    }

    public void createUser(CreateUserDto createUserDto) {
        User newUser = User.builder()
                .email(createUserDto.email())
                .password(securityConfiguration.passwordEncoder().encode(createUserDto.password()))
                .roles(List.of(Role.builder().name(createUserDto.role()).build()))
                .build();

        userRepository.save(newUser);
    }
}