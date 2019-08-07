package com.bugtracker.dao;
import com.bugtracker.model.Login;
import com.bugtracker.model.User;


public interface UserDao {
  User validateUser(Login login);
}