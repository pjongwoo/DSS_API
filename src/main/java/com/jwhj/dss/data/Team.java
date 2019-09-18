package com.jwhj.dss.data;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Team {

    @Id
    @Column(name="TEAM_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
    @SequenceGenerator(sequenceName = "customer_seq", allocationSize = 1, name = "CUST_SEQ")
    long id;
    String name;

    public Team(String name) {
        this.name = name;
    }
}
