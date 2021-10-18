package com.in28minutes.restful.webservices.restfulwebservices.dao;

import com.in28minutes.restful.webservices.restfulwebservices.models.User;
import com.in28minutes.restful.webservices.restfulwebservices.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserDaoService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    };

    public User save(User user) {
       User added = new User(user.getUsername(), user.getAccessKey(), user.getSecretToken());
       userRepository.save(added);
       return added;
    }

    public User findOne(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }

    public User deleteOne(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
            return user.get();
        }
        return null;
    }
}
