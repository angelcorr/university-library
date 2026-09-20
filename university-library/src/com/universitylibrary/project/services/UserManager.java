package com.universitylibrary.project.services;

import com.universitylibrary.project.models.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class UserManager {
  private static volatile UserManager instance;
  private final List<User> users = new ArrayList<>();

  private UserManager() {}

  public static UserManager getInstance() {
    if (instance == null) {
      synchronized (UserManager.class) {
        if (instance == null) {
          instance = new UserManager();
        }
      }
    }
    return instance;
  }

  public User addUser(String id, String fullName, String address, String phoneNumber) {
    verifyIfUserExists(id);

    User user = new User.Builder()
        .id(id)
        .fullName(fullName)
        .address(address)
        .phoneNumber(phoneNumber)
        .build();

    users.add(user);
    return user;
  }

  public void verifyIfUserExists(String id) {
    if(searchById(id).isPresent()) {
      throw new IllegalStateException("There is an existing user with id " + id);
    }
  }

  public Optional<User> searchById(String id) {
    return users.stream().filter(user -> user.getId().equals(id)).findFirst();
  }

  public List<User> getUsers() {
    return Collections.unmodifiableList(users);
  }
}
