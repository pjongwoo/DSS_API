package com.jwhj.dss.service.impl;

import com.google.common.collect.ImmutableList;
import com.jwhj.dss.data.Drug;
import com.jwhj.dss.data.Drug1;
import com.jwhj.dss.data.repository.Drug1Repository;
import com.jwhj.dss.service.Drug1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class Drug1ServiceImpl implements Drug1Service {
    @Autowired
    Drug1Repository drug1Repository;

    @Override
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public List<Drug1> selectDrug1All() {
        return ImmutableList.copyOf(drug1Repository.findAll());
    }

    @Override
    public void updateDrug1Byform(Drug1 Drug1) {
        drug1Repository.save(Drug1);
    }

    @Override
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public Drug1 selectDrug1ById(int id) {
        return drug1Repository.findOneById(id);
    }
}
