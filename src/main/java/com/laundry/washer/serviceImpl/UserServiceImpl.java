package com.laundry.washer.serviceImpl;

import com.laundry.washer.model.Userbio;
import com.laundry.washer.repository.UserRepository;
import com.laundry.washer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Service class for implementing business logic on the users data
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepo;

    //    implementation of saving user details to database
    @Override
    public void saveUserData(Userbio userbio) {
        userRepo.save(userbio);
    }

    //    implementation of validating users details
    @Override
    public Userbio validateUser(String name, String password) {
        Userbio user = userRepo.findUserbioByPreferredNameAndPassword(name, password).orElse(null);
        return user;
    }
}
