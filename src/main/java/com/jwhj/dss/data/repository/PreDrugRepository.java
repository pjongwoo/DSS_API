package com.jwhj.dss.data.repository;

import com.jwhj.dss.data.Prescription;
import com.jwhj.dss.data.PrescriptionDrug;
import com.jwhj.dss.data.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PreDrugRepository extends CrudRepository<PrescriptionDrug, Long> {
    List<PrescriptionDrug> findByPrescription(Prescription prescription);

//    List<Drug> findByDrug(Drug drug);
}
