package com.jwhj.dss.data.repository;

import com.jwhj.dss.data.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
    User findOneById(String id);
    User findOneByIdAndPassword(String id, String password);
}
