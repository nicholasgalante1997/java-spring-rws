package com.in28minutes.restful.webservices.restfulwebservices.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Annotation to hide class properties from being dispatched in http responses,
 * the response now looks like this
 * ```json
 * {
 *     "id": 1,
 *     "username": "nickgdev"
 * }
 * ```
 * */
@Entity
@JsonIgnoreProperties(value = {"accessKey", "secretToken"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min=4)
    private String username;

    @Size(min=6)
    private String accessKey;

    @Size(min=4)
    private String secretToken;

    public List<Content> getContent() {
        return content;
    }

    public void setContent(List<Content> content) {
        this.content = content;
    }

    @OneToMany(mappedBy="user")
    private List<Content> content;

    public User () {}

    public User(String username, String accessKey, String secretToken){
        this.username = username;
        this.accessKey = accessKey;
        this.secretToken = secretToken;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretToken() {
        return secretToken;
    }

    public void setSecretToken(String secretToken) {
        this.secretToken = secretToken;
    }

}
