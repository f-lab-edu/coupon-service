package com.rumor.flab.friend.adapter.out.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class FriendGroup {

    @Id @GeneratedValue
    private Long id;
    private Long owner;
    private String name;
    private LocalDate created;
    private LocalDate updated;

}
