package com.spring_security._example.service;

import com.spring_security._example.model.UserModel;
import com.spring_security._example.model.UserPrincipal;
import com.spring_security._example.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
//UserService saare userDetaisSercide k mehod ko hi implement skarra hai mannuly bas humne yaha likhe hai
public class UserService implements UserDetailsService {

    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = userRepo.findByUsername(username); // make sure method name in repo matches
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new UserPrincipal(user);
    }

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    public UserModel save(UserModel userModel){
        userModel.setPassword(encoder.encode(userModel.getPassword()));
        return userRepo.save(userModel);
    }
    public Optional<UserModel> findUser(int id){
        return userRepo.findById(id);
    }


}
