package com.laundry.washer.service;

import com.laundry.washer.model.Userbio;

public interface UserService {
//    method signature for saving user data
    void saveUserData(Userbio userbio);

//    method signature for validating user data
    Userbio validateUser(String name, String password);

}
