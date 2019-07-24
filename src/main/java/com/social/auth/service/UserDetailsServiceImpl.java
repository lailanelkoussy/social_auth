package com.social.auth.service;

import com.social.auth.model.User;
import com.social.auth.model.UserAuthority;
import com.social.auth.model.dto.CustomGrantedAuthority;
import com.social.auth.model.dto.CustomUserDetails;
import com.social.auth.model.dto.UserDTO;
import com.social.auth.proxies.UserServiceProxy;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserServiceProxy userServiceProxy;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDTO userDTO;
        try {
            userDTO = userServiceProxy.getUserByUsername(username);
        } catch (Exception e) {
            throw new EntityNotFoundException("User not found");
        }

        User user = new User();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(userDTO, user);
        CustomUserDetails customUserDetails = new CustomUserDetails();
        customUserDetails.setUserName(user.getUsername());
        customUserDetails.setPassword(user.getPassword());
        return customUserDetails;

    }

}
