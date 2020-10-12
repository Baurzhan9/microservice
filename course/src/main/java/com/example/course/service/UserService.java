package com.example.course.service;


import com.example.course.model.User;
import com.example.course.service.impl.UserServiceImpl;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService implements UserServiceImpl {
    @Autowired
    RestTemplate restTemplate;

    @Transactional
    public User getUserById(Long id) {
//        return restTemplate.getForObject
//                ("http://customer-info-service/user/" + id,
//                        User.class);
        String apiCredentials = "admin:admin";
        String base64Credentials = new String(Base64.encodeBase64(apiCredentials.getBytes()));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);
        HttpEntity<String> entity = new HttpEntity<>(headers);


//        return restTemplate.getForObject(
//                "http://book-info-service/book/info/" + userId,
//                UserBook.class);
        return restTemplate.exchange("http://course-user/user/" + id,
                HttpMethod.GET, entity, User.class).getBody();
    }



    @Transactional
    public User getUserByUsername(String username) {
        return restTemplate.getForObject("http://course-user/userByUsername/" + username, User.class);
    }
}
