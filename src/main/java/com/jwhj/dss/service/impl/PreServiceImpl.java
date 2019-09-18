package com.jwhj.dss.service.impl;

import com.google.common.collect.ImmutableList;
import com.jwhj.dss.data.Drug;
import com.jwhj.dss.data.Prescription;
import com.jwhj.dss.data.PrescriptionDrug;
import com.jwhj.dss.data.User;
import com.jwhj.dss.data.repository.DrugRepository;
import com.jwhj.dss.data.repository.PreDrugRepository;
import com.jwhj.dss.data.repository.PreRepository;
import com.jwhj.dss.service.DrugService;
import com.jwhj.dss.service.PreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PreServiceImpl implements PreService {
    @Autowired
    PreRepository preRepository;
    @Autowired
    PreDrugRepository preDrugRepository;

    @Override
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public List<Prescription> selectpreById(User user) {
        return preRepository.findByUser(user);
    }

    @Override
    public List<PrescriptionDrug> selectpreDrugById(Prescription prescription) {
        return preDrugRepository.findByPrescription(prescription);
    }
}
