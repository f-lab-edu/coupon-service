package com.rumor.flab.user.adapter.out.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class UserEntity {

    @Id @GeneratedValue
    private Long id;
    private String email;
    private String profileImage;
    private String country;
    private LocalDate created;
    private LocalDate updated;
}
