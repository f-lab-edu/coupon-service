package com.rumor.flab.friend.adapter.out.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class FriendEntity {

    @Id @GeneratedValue
    private Long id;
    private Long groupId;
    private Long userId;
    private LocalDate created;
    private LocalDate updated;

}
