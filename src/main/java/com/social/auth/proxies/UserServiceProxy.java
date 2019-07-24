package com.social.auth.proxies;


import com.social.auth.model.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "UserService", url = "localhost:8087")
@RequestMapping(value = "/users")
public interface UserServiceProxy {

    @GetMapping(value = "/username/{username}")
    UserDTO getUserByUsername(@PathVariable String username);
}
