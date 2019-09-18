package com.jwhj.dss.data;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "dss_user")
@Getter
@Setter
public class User {

    @Id
    @Column(name="USER_ID")
    private String id;
    private String email;
    private String password;
    private String nickname;
    private String birth;

    @CreationTimestamp
    @Column(updatable=false)
    private Timestamp create_date;

    @UpdateTimestamp
    private Timestamp update_date;

    public User(String id, String password, String nickname, String email, String birth){
        this.id = id;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
        this.birth = birth;
    }

    public User() {

    }

    public User(String id) {
        this.id = id;
    }
}

