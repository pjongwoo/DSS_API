package com.jwhj.dss.service.impl;

import com.google.common.collect.ImmutableList;
import com.jwhj.dss.data.User;
import com.jwhj.dss.data.repository.UserRepository;
import com.jwhj.dss.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public List<User> selectUserList() {
        return ImmutableList.copyOf(userRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public User selectUser(String id) {
        return userRepository.findOneById(id);
    }

    @Override
    public User selectUserCheck(String id, String password) {
        userRepository.findOneByIdAndPassword(id, password);
        return null;
    }

    @Override
    @Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void insertUser(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void deleteUser(String id) {
        userRepository.deleteById(id);

    }
}
