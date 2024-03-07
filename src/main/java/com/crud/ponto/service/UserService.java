package com.crud.ponto.service;

import com.crud.ponto.controller.CreateUserDto;
import com.crud.ponto.entity.User;
import com.crud.ponto.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public UUID createUser(CreateUserDto createUserDto){

       var entity = new User(
               UUID.randomUUID(),
               createUserDto.nome(),
               createUserDto.idade(),
               Instant.now(),
               null);

       var userSaved = userRepository.save(entity);

       return userSaved.getUserId();
    }
}
