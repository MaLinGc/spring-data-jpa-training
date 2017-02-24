package com.ml.controller;

import com.ml.commons.result.Result;
import com.ml.entities.Resource;
import com.ml.services.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller("/resource")
public class ResourceController extends BaseController {

    @Autowired
    private ResourceService resourceService;

    @GetMapping("/manager")
    public String resources() {
        return "resource/resource";
    }

    @GetMapping(path = "/list")
    public Page<Resource> resources(Pageable pageable) {
        return resourceService.findAll(pageable);
    }

    @GetMapping(path = "/addPage")
    public String addPage() {
        return "resource/add";
    }

    @GetMapping(path = "/editPage")
    public String editPage(Long id, Model model) {
        Resource resource = resourceService.findOne(id);
        model.addAttribute("resource", resource);
        return "resource/edit";
    }

    @PostMapping(path = "/add")
    public Result<String> add(Resource resource) {
        resourceService.save(resource);
        return new Result<>(true);
    }

    @PostMapping(path = "/edit")
    public Result<String> edit(Resource resource) {
        resourceService.save(resource);
        return new Result<>(true);
    }

    @PostMapping(path = "/delete")
    public Result<String> delete(Long id) {
        resourceService.delete(id);
        return new Result<>(true);
    }
}
