package com.jwhj.dss.data;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="DSS_DRUG_INFO1")
public @Data class Drug1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String pass_date;
    private String ingredient_detail;
    private String classes;
    private String drugs_class;
    private String testament;
    private String division;
    private String packing;
    private String insurance_code;
    private String pro_basic;
    private String total;
    private String status;
    private String update_content;
    private String insert_id;
    private String attachfile;
    private String review_date;
    private String effect;
    private String manufacturing;
    private String store;
    private String validity;
    private String usage;
    private String appearance;
    private String company;
    private String review_yn;
    private String permission_yn;
    private String subject;
    private String cancel_date;
    private String code;
    private String caution;
    private String update_date;
    private String ingredient;

    public int getId() {
        return id;
    }
    public String getManufacturing() {
        return manufacturing;
    }
    public String getUsage() {
        return usage;
    }
    public String getCaution() {
        return caution;
    }

    public void setManufacturing(String manufacturing) {
        this.manufacturing = manufacturing;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public void setCaution(String caution) {
        this.caution = caution;
    }
}
