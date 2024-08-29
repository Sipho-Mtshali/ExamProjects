package com.examprojects.examprojects.service;

import com.examprojects.examprojects.model.UserModel;
import com.examprojects.examprojects.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UsersRepository usersRepository;
    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
    public UserModel registerUser(String username, String password, String email)
    {
        if (username == null && password == null) {
            return null;
        }
        else{
            UserModel user = new UserModel();
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            return usersRepository.save(user);
        }
    }
    public UserModel authenticate(String username, String password){
        return usersRepository.findByUsernameAndPassword(username, password).orElse(null);
    }
}
