package com.jwhj.dss.service;

import com.jwhj.dss.data.Drug;
import com.jwhj.dss.data.Prescription;
import com.jwhj.dss.data.PrescriptionDrug;
import com.jwhj.dss.data.User;

import java.util.List;

public interface PreService {


    /**
     * id로 처방전 조회
     * @param user
     * @return
     */
    public List<Prescription> selectpreById(User user);

    /**
     * id로 처방전 상세 조회
     * @param prescription
     * @return
     */
    public List<PrescriptionDrug> selectpreDrugById(Prescription prescription);
}
