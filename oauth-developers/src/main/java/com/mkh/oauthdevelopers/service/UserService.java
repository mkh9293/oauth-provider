package com.mkh.oauthdevelopers.service;

import com.mkh.oauthdevelopers.domain.Authority;
import com.mkh.oauthdevelopers.domain.User;
import com.mkh.oauthdevelopers.repository.AuthorityRepository;
import com.mkh.oauthdevelopers.repository.UserRepository;
import com.mkh.oauthdevelopers.security.AuthoritiesConstants;
import com.mkh.oauthdevelopers.service.dto.UserDTO;
import com.mkh.oauthdevelopers.service.util.RandomUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Service
@Transactional
public class UserService {

    private final Logger log = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthorityRepository authorityRepository;
//    private final CacheManager cacheManager;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authorityRepository = authorityRepository;
//        this.cacheManager = cacheManager;
    }

    public User registerUser(UserDTO userDTO, String password) {
        User newUser = new User();
        String encryptedPassword = passwordEncoder.encode(password);
        newUser.setLogin(userDTO.getLogin().toLowerCase());
        // new user gets initially a generated password
        newUser.setPassword(encryptedPassword);
        newUser.setFirstName(userDTO.getFirstName());
        newUser.setLastName(userDTO.getLastName());
        newUser.setEmail(userDTO.getEmail().toLowerCase());
        newUser.setImageUrl(userDTO.getImageUrl());
        newUser.setLangKey(userDTO.getLangKey());
        // new user is not active
        newUser.setActivated(false);
        // new user gets registration key
        newUser.setActivationKey(RandomUtil.generateActivationKey());
        Set<Authority> authorities = new HashSet<>();
        authorityRepository.findById(AuthoritiesConstants.USER).ifPresent(authorities::add);
        newUser.setAuthorities(authorities);
        userRepository.save(newUser);
        this.clearUserCaches(newUser);
        log.debug("Created Information for User: {}", newUser);
        return newUser;
    }

    private void clearUserCaches(User user) {
//        Objects.requireNonNull(cacheManager.getCache(UserRepository.USERS_BY_LOGIN_CACHE)).evict(user.getLogin());
//        Objects.requireNonNull(cacheManager.getCache(UserRepository.USERS_BY_EMAIL_CACHE)).evict(user.getEmail());
    }
}
