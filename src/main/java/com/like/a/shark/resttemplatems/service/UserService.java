package com.like.a.shark.resttemplatems.service;

import com.like.a.shark.resttemplatems.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    @Value("${sping.external.service.base-url}")
    private String basePath;

    private final RestTemplate restTemplate;

    public List<UserDTO> getUsers(){
        UserDTO[] response = restTemplate.getForObject(basePath+"/users", UserDTO[].class);
        return Arrays.asList(response);
    }

    public void saveUser(UserDTO user){
        restTemplate.postForObject(basePath+"/users", user, UserDTO.class);
    }

    public void updateUser(Integer id, UserDTO user){
        restTemplate.put(basePath+"/users/"+id, user);
    }

    public void deleteUser(Integer id){
        restTemplate.delete(basePath+"/users/"+id);
    }
}
