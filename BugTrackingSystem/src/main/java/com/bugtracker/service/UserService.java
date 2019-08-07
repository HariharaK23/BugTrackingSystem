package com.bugtracker.service;
import com.bugtracker.model.Login;
import com.bugtracker.model.User;


public interface UserService {
	User validateUser(Login login);
}
