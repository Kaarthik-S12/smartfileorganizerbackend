package com.example.smartFileOrganizer.service;

import com.example.smartFileOrganizer.entity.User;
import com.example.smartFileOrganizer.repository.ProfileRepository;
import com.example.smartFileOrganizer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.smartFileOrganizer.entity.Profile;
@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private UserRepository userRepository;

    public Profile createProfile(Long userId, Profile profile){

        User user = userRepository.findById(userId)
                .orElseThrow();

        profile.setUser(user);
        profile.setEmail(user.getEmail());

        return profileRepository.save(profile);
    }

    public Profile getProfile(Long userId){

        return profileRepository.findByUserId(userId);
    }

    public Profile updateProfile(Long userId, Profile updated){

        Profile profile = profileRepository.findByUserId(userId);

        profile.setName(updated.getName());
        profile.setGender(updated.getGender());
        profile.setOccupation(updated.getOccupation());

        return profileRepository.save(profile);
    }
}
