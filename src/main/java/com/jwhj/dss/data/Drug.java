package com.jwhj.dss.data;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="DSS_DRUG_VIEW")
public @Data class Drug {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ingredient_detail;
    private String division;
    private String pro_basic;
    private String validity;
    private String manufacturing;
    private String usage;
    private String caution;
    private String name;
    private String company_name;
    private String crude;
    private String display_front;
    private String display_back;
    private String shape;
    private String color_front;
    private String color_back;
    private String div_front;
    private String div_back;
    private String div_name;
    private String code_name;
    private String text_front;
    private String text_back;
    private String big_image;

    public int getId() {
        return id;
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
