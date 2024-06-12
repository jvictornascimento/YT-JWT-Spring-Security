package com.example.jwt.JwtTest.services;

import com.example.jwt.JwtTest.Dtos.RegisterDTO;
import com.example.jwt.JwtTest.infra.security.SecurityConfiguraion;
import com.example.jwt.JwtTest.models.User;
import com.example.jwt.JwtTest.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User save(RegisterDTO data){
        User user = new User();
        BeanUtils.copyProperties(data, user);
        user.setPassword(new BCryptPasswordEncoder().encode(data.password()));
        return userRepository.save(user);
    }
    public boolean existByEmail(String email){
        if(userRepository.findByEmail(email)!=null)return true;
        else return false;
    }


}
