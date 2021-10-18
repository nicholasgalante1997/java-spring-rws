package com.in28minutes.restful.webservices.restfulwebservices.controllers;

import com.in28minutes.restful.webservices.restfulwebservices.dao.ContentDaoService;
import com.in28minutes.restful.webservices.restfulwebservices.dao.UserDaoService;
import com.in28minutes.restful.webservices.restfulwebservices.exceptions.UserNotFoundException;
import com.in28minutes.restful.webservices.restfulwebservices.models.Content;
import com.in28minutes.restful.webservices.restfulwebservices.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CORS permissions
 * REST Controller http web annotation
 * Start the URI with the api and version
 * */
@CrossOrigin
@RestController
@RequestMapping("/api/v1/")
public class UserController {

    @Autowired
    private UserDaoService userDaoService;
    @Autowired
    private ContentDaoService contentDaoService;

    @GetMapping(path = "/users")
    public ResponseEntity<List<User>> getUsers () {
        return new ResponseEntity<>(userDaoService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/users/{userId}/content")
    public ResponseEntity<List<Content>> getContentByUser (@PathVariable int userId) throws UserNotFoundException {
        User user = userDaoService.findOne(userId);
        if (user == null) {
            throw new UserNotFoundException(
                    "User not found, error stemmed from a call for a user with an id of "
                            + userId
            );
        }
        return new ResponseEntity<>(user.getContent(), HttpStatus.OK);
    }

    @PostMapping(path = "/users/{userId}/content")
    public ResponseEntity<Map<String, Integer>> createContent (@PathVariable int userId, @RequestBody Content content) throws UserNotFoundException {
        User user = userDaoService.findOne(userId);
        if (user == null) {
            throw new UserNotFoundException(
                    "User not found, error stemmed from a call for a user with an id of "
                            + userId
            );
        }
        content.setUser(user);
        Content saved = contentDaoService.save(content);
        Map<String, Integer> res = new HashMap<>();
        res.put("id", saved.getId());
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @GetMapping(path = "/users/{userId}")
    public ResponseEntity<User> getUser(@PathVariable int userId) throws UserNotFoundException {
        User user = userDaoService.findOne(userId);
        if (user == null) {
            throw new UserNotFoundException(
                    "User not found, error stemmed from a call for a user with an id of "
                    + userId
            );
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping(path = "/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        return new ResponseEntity<>(userDaoService.save(user), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/users/{userId}")
    public ResponseEntity<User> deleteUser(@PathVariable int userId) throws UserNotFoundException {
        User user = userDaoService.deleteOne(userId);
        if (user == null) {
            throw new UserNotFoundException(
                    "User not found, error stemmed from a call for a user with an id of "
                            + userId
            );
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
