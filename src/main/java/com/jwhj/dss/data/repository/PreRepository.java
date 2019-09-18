package com.jwhj.dss.data.repository;

import com.jwhj.dss.data.Drug;
import com.jwhj.dss.data.Prescription;
import com.jwhj.dss.data.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PreRepository extends CrudRepository<Prescription, Long> {
    List<Prescription> findByUser(User user);

//    List<Drug> findByDrug(Drug drug);
}
