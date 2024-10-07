package com.msvc.user.service.impl;

import com.msvc.user.entity.Qualification;
import com.msvc.user.entity.User;
import com.msvc.user.exceptions.ResourceNotFoundException;
import com.msvc.user.repository.UserRepository;
import com.msvc.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        String id = UUID.randomUUID().toString();
        user.setUserId(id);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        List<User> users = userRepository.findAll();

        for (User user : users) {
            ArrayList<Qualification> qualificationsUser = restTemplate.getForObject("http://localhost:8083/qualifications/users/"+user.getUserId(), ArrayList.class);
            user.setQualifications(qualificationsUser);
        }
        return users;
    }

    @Override
    public User getById(String userld) {

        User user = userRepository.findById(userld)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con el Id:" + userld));

        ArrayList<Qualification> qualificationsUser = restTemplate.getForObject("http://localhost:8083/qualifications/users/"+user.getUserId(), ArrayList.class);

        user.setQualifications(qualificationsUser);

        return user;
    }
}
