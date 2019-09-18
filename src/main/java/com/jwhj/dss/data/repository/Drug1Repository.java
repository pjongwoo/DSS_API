package com.jwhj.dss.data.repository;

import com.jwhj.dss.data.Drug1;
import org.springframework.data.repository.CrudRepository;


public interface Drug1Repository extends CrudRepository<Drug1, Long> {
    Drug1 findOneById(int id);
}
