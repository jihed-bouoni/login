package com.cpg.login1.demo.service;

import com.cpg.login1.demo.model.User;
import com.cpg.login1.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UserService
{
    @Autowired
    UserRepository userRepository;
    public User registerUser(User user)
    {
if (user.getUsername() !=null && user.getPassword() !=null )
{
    User user1 = new User();
    user1.setUsername(user.getUsername());
    user1.setPassword(user.getPassword());
    user1.setEmail(user.getEmail());
    return userRepository.save(user1);
}
else
{
    return null;
}
    }
    public User authenticate(String username,String password)
    {
        return userRepository.findByUsernameAndPassword(username,password).orElse(null);
    }
}
