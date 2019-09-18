package com.jwhj.dss.data;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "DSS_PRESCRIPTION")
@Data
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRESCRIPTION_SEQ")
    @SequenceGenerator(sequenceName = "pre_seq", allocationSize = 1, name = "PRESCRIPTION_SEQ")
    @Column(name="PRESCRIPTION_ID")
    private int ID;
    private String HOSPITAL_NAME;
    private String DOSES_DAY;
    private String DOSES_TIME;
    private String CREATE_DATE;
    @ManyToOne
    @JoinColumn(name="USER_ID")
    private User user;

    public Prescription(int id) {
        this.ID = id;
    }

//    @OneToMany(fetch =FetchType.LAZY)
//    private List<PrescriptionDrug> prescriptionDrugList;

    public void setUser(User user){
        this.user = user;
    }

    public Prescription(){}

    public Prescription(String hospital_name, String doses_day, String doses_time, String create_date){
        this.HOSPITAL_NAME = hospital_name;
        this.DOSES_DAY = doses_day;
        this.DOSES_TIME = doses_time;
        this.CREATE_DATE = create_date;
    }

}
