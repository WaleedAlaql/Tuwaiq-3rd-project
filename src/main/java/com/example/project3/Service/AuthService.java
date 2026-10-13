package com.example.project3.Service;


import com.example.project3.API.ApiException;
import com.example.project3.Model.User;
import com.example.project3.Repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository authRepository;
    public List<User> getAllUsers(Integer adminId){
        User admin = authRepository.findUserById(adminId);
        if (admin == null)
            throw new ApiException("admin not found");

        return authRepository.findAll();
    }

    public User getUserById(Integer adminId, Integer userId){
        User admin = authRepository.findUserById(adminId);
        User user = authRepository.findUserById(userId);
        if (admin == null)
            throw new ApiException("admin not found");
        if (user == null)
            throw new ApiException("user not found");
        return user;

    }



}
