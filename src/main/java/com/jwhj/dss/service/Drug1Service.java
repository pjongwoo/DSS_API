package com.jwhj.dss.service;

import com.jwhj.dss.data.Drug1;

import java.util.List;

public interface Drug1Service {

    /**
     * 명칭으로 약품명 모두조회
     * @return
     */
    public List<Drug1> selectDrug1All();

    /**
     * 모양으로 약품명 수정
     * @param drug
     * @return
     */
    public void updateDrug1Byform(Drug1 drug);

    public Drug1 selectDrug1ById(int id);
}
