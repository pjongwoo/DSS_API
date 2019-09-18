package com.jwhj.dss.data;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Member {

    @Id
    @Column(name = "MEMBER_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRESCRIPTION_SEQ")
    @SequenceGenerator(sequenceName = "pre_seq", allocationSize = 1, name = "PRESCRIPTION_SEQ")
    private long id;
    private String username;

    @ManyToOne
    @JoinColumn(name="TEAM_ID")
    private Team team;

    public Member(String username) {
        this.username = username;
    }

}
