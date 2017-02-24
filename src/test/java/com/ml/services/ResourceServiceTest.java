package com.ml.services;

import com.ml.base.BaseServiceTest;
import com.ml.entities.Resource;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ResourceServiceTest extends BaseServiceTest {
    @Autowired
    private ResourceService resourceService;

    @Test
    public void findUserResources() throws Exception {
        List<Resource> userResources = resourceService.findUserResources(1L);
        for (Resource resource : userResources) {
            System.out.println(resource.getDesc());
        }
    }

}