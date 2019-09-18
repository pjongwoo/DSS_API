package com.jwhj.dss.data;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "DSS_PRESCRIPTION_DRUG")
@Data
public class PrescriptionDrug {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRESCRIPTION_DRUG_SEQ")
    @SequenceGenerator(sequenceName = "pre_drug_seq", allocationSize = 1, name = "PRESCRIPTION_DRUG_SEQ")
    @Column(name="PRESCRIPTION_DRUG_ID")
    private int id;
    @ManyToOne
    @JoinColumn(name="DRUG_ID")
    private Drug drug;
    private String drug_dosage;
    private String drug_time;
    @ManyToOne
    @JoinColumn(name="PRESCRIPTION_ID")
    private Prescription prescription;

    public PrescriptionDrug(){}
    public PrescriptionDrug(String drug_dosage, String drug_time){
        this.drug_dosage = drug_dosage;
        this.drug_time = drug_time;
    }

}
