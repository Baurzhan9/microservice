package com.example.courserating.service;

import com.example.courserating.model.User;
import com.example.courserating.repository.UserRepository;
import com.example.courserating.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public List<User> findAll() {
        return userRepository.findAll();
    }
    @Transactional
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }


}
