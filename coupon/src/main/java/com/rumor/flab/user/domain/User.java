package com.rumor.flab.user.domain;

import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
public class User {
    private Long id;
    private String email;
    private String profileImage;
    private String country;
    private LocalDate created;
    private LocalDate updated;

    public User(String email, String profileImage, String country) {
        this.email = email;
        this.profileImage = profileImage;
        this.country = country;
    }
}
