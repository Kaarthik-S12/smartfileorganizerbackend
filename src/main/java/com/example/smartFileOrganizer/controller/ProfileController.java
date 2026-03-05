package com.example.smartFileOrganizer.controller;

import com.example.smartFileOrganizer.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.smartFileOrganizer.entity.Profile;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @PostMapping("/{userId}")
    public Profile create(@PathVariable Long userId,
                          @RequestBody Profile profile){

        return profileService.createProfile(userId,profile);
    }

    @GetMapping("/{userId}")
    public Profile get(@PathVariable Long userId){

        return profileService.getProfile(userId);
    }

    @PutMapping("/{userId}")
    public Profile update(@PathVariable Long userId,
                          @RequestBody Profile profile){

        return profileService.updateProfile(userId,profile);
    }
}
