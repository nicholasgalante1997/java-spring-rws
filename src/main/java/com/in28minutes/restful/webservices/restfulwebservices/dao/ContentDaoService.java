package com.in28minutes.restful.webservices.restfulwebservices.dao;

import com.in28minutes.restful.webservices.restfulwebservices.models.Content;
import com.in28minutes.restful.webservices.restfulwebservices.models.User;
import com.in28minutes.restful.webservices.restfulwebservices.repositories.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ContentDaoService {
    @Autowired
    private ContentRepository contentRepository;

    public List<Content> findAll() {
        return contentRepository.findAll();
    };

    public Content save(Content content) {
        return contentRepository.save(content);
    }

    public Content findOne(int id) {
        Optional<Content> content = contentRepository.findById(id);
        if (content.isPresent()) {
            return content.get();
        }
        return null;
    }

    public Content deleteOne(int id) {
        Optional<Content> content = contentRepository.findById(id);
        if (content.isPresent()) {
            contentRepository.deleteById(id);
            return content.get();
        }
        return null;
    }
}
