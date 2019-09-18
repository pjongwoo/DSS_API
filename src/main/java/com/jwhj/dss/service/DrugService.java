package com.jwhj.dss.service;

import com.jwhj.dss.data.Drug;
import com.jwhj.dss.data.Prescription;

import java.util.List;

public interface DrugService {

    /**
     * 명칭으로 약품명 모두조회
     * @return
     */
    public List<Drug> selectDrugAll();

    /**
     * 명칭으로 약품명 조회
     * @param name
     * @return
     */
    public List<Drug> selectDrugByName(String name);

    /**
     * 일련번호으로 약품명 조회
     * @param id
     * @return
     */
    public Drug selectDrugById(int id);

//    /**
//     * 모양으로 약품명 조회
//     * @param ingredient_detail
//     * @param company_name
//     * @param display_front
//     * @param display_back
//     * @param color_front
//     * @param color_back
//     * @param div_front
//     * @param div_back
//     * @param div_name
//     * @param shape
//     * @param text_front
//     * @param text_back
//     * @return
//     */
//    public List<Drug> selectDrugByform_test(String ingredient_detail, String company_name, String display_front, String display_back, String color_front, String color_back, String div_front, String div_back, String div_name, String shape, String text_front, String text_back);


    /**
     * 모양으로 약품명 조회
     * @param drug
     * @return
     */
    public List<Drug> selectDrugByform(Drug drug);

    /**
     * 모양으로 약품명 수정
     * @param drug
     * @return
     */
    public void updateDrugByform(Drug drug);

}
