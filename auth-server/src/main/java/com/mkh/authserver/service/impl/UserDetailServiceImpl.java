package com.mkh.authserver.service.impl;

import com.mkh.authserver.domain.User;
import com.mkh.authserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        System.out.println("===");
        System.out.println(user);
        System.out.println(user.getUsername());
        System.out.println(user.getRoles());
        System.out.println(user.getPassword());
        System.out.println("===");

        List<GrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        });

        System.out.println("ttttt");

        return new org.springframework.security.core.userdetails.User(user.getUsername(), "{noop}"+user.getPassword(), authorities);
    }
}
