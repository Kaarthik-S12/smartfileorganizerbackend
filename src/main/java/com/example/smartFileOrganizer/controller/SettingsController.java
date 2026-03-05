package com.example.smartFileOrganizer.controller;

import com.example.smartFileOrganizer.entity.AllowedPath;
import com.example.smartFileOrganizer.service.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/settings")
public class SettingsController {

    @Autowired
    private SettingsService service;

    @PostMapping("/add")
    public List<AllowedPath> addPaths(@RequestParam Long userId,
                                      @RequestParam List<String> paths){

        return service.addPaths(userId, paths);
    }

    @GetMapping("/list")
    public List<AllowedPath> getPaths(@RequestParam Long userId){

        return service.getPaths(userId);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){

        service.deletePath(id);

        return "Path removed";
    }
}