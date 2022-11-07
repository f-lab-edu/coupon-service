package com.rumor.flab.coupon.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Coupon {

    @Id @GeneratedValue
    private Long id;
    private Long owner;
    private String name;
    private String image;
    private LocalDate created;
    private LocalDate updated;
}
