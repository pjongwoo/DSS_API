package com.jwhj.dss.service.impl;

import com.google.common.collect.ImmutableList;
import com.jwhj.dss.data.Drug;
import com.jwhj.dss.data.repository.DrugRepository;
import com.jwhj.dss.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DrugServiceImpl implements DrugService {
    @Autowired
    DrugRepository drugRepository;

    @Override
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public List<Drug> selectDrugAll() {
        return ImmutableList.copyOf(drugRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public List<Drug> selectDrugByName(String name) {
        return drugRepository.findByNameContaining(name);
    }

    @Override
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public Drug selectDrugById(int id) {
        return drugRepository.findOneById(id);
    }


//    @Override
//    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
//    public List<Drug> selectDrugByform_test(String ingredient_detail, String company_name, String display_front, String display_back, String color_front, String color_back, String div_front, String div_back, String div_name, String shape, String text_front, String text_back) {
//        return null;
//    }

    @Override
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public List<Drug> selectDrugByform(Drug drug) {
        return null;
    }

    @Override
    public void updateDrugByform(Drug drug) {
        drugRepository.save(drug);
    }
}
