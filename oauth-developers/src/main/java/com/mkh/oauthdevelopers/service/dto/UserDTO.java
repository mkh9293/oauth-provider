package com.mkh.oauthdevelopers.service.dto;

import java.time.Instant;
import java.util.Set;

public class UserDTO {
    private Long id;

    private String login;

    private String firstName;
    private String lastName;
    private String email;
    private String imageUrl;
    private boolean activated = false;
    private String langKey;
    private String createdBy;
    private Instant createdDate;
    private String lastModifiedBy;
    private Instant lastModifiedDate;
    private Set<String> authorities;


    public UserDTO(User user) {
        this.id = id;
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.imageUrl = imageUrl;
        this.activated = activated;
        this.langKey = langKey;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.lastModifiedBy = lastModifiedBy;
        this.lastModifiedDate = lastModifiedDate;
        this.authorities = authorities;
    }
}
