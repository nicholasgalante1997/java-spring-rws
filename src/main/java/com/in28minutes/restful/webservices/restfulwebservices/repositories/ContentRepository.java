package com.in28minutes.restful.webservices.restfulwebservices.repositories;


import com.in28minutes.restful.webservices.restfulwebservices.models.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository extends JpaRepository<Content, Integer> { }
