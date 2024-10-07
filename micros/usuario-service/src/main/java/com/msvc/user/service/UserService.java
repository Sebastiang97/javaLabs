package com.msvc.user.service;

import com.msvc.user.entity.User;

import java.util.List;

public interface UserService {

    User save (User user);

    List<User> getAll ();

    User getById (String userld);
}
