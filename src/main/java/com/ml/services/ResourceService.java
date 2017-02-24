package com.ml.services;

import com.ml.entities.Resource;
import com.ml.repositories.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    public Resource findOne(Long id) {
        return resourceRepository.findOne(id);
    }

    public Page<Resource> findAll(Pageable pageable) {
        return resourceRepository.findAll(pageable);
    }

    public void save(Resource resource) {
        resourceRepository.save(resource);
    }

    public void delete(Long id) {
        resourceRepository.delete(id);
    }

    public List<Resource> findUserResources(Long userId) {
        return resourceRepository.findUserResources(userId);
    }
}
