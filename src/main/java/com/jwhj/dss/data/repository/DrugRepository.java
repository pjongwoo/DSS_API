package com.jwhj.dss.data.repository;

import com.jwhj.dss.data.Drug;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DrugRepository extends CrudRepository<Drug, Long> {
    List<Drug> findByNameContaining(String name);

    Drug findOneById(int id);

//    List<Drug> findByDrug(Drug drug);
}
