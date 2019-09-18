package com.jwhj.dss.controller;


import com.jwhj.dss.data.User;
import com.jwhj.dss.model.ApiResponseMessage;
import com.jwhj.dss.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@RestController
@RequestMapping(value = "/user")
@Api(value = "UserController", description = "유저 관련 API", basePath="/user")
public class UserController {

    @Autowired
    UserService userService;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("DSSjdbc");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

//    @RequestMapping(value = "", method = RequestMethod.GET)
//    @ApiOperation(value = "사용자 목록 조회", notes = "사용자 목록을 조회하는 API.")
//    public List<User> getUserList(){
//
//        return userService.selectUserList();
//    }

    @CrossOrigin(origins = "http://frontenddssreact.org.s3-website.ap-northeast-2.amazonaws.com")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "사용자 정보 조회", notes = "사용자의 정보를 조회하는 API. User entity 클래스의 id값을 기준으로 데이터를 가져온다.")
    public User getUser( @PathVariable("id") String id ){

        return userService.selectUser(id);
    }

    @CrossOrigin(origins = "http://frontenddssreact.org.s3-website.ap-northeast-2.amazonaws.com")
    @RequestMapping(value = "/userCheck/{id}/{pwd}", method = RequestMethod.GET)
    @ApiOperation(value = "로그 체크", notes = "아이디와 패스워드로 등록한 사용자인지 체크.")
    public User getUser( @PathVariable("id") String id, @PathVariable("pwd") String pwd){
        User user = new User();
        try {
            tx.begin();
            user = em.find(User.class, id);
            tx.commit();
            if (user.getPassword().equals(pwd)) {
                return user;
            } else {
                return null;
            }
//            userService.insertUser(user);
        } catch(Exception e){
            tx.rollback();
            return null;
        }
    }

    @CrossOrigin(origins = "http://frontenddssreact.org.s3-website.ap-northeast-2.amazonaws.com")
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation(value = "사용자 정보 등록", notes = "사용자 정보를 저장하는 API. User entity 클래스로 데이터를 저장한다.")
    public ResponseEntity<ApiResponseMessage> insertUser( User user ){
        ApiResponseMessage message = new ApiResponseMessage("Success", "등록되었습니다.", "", "");
        ResponseEntity<ApiResponseMessage> response = new ResponseEntity<ApiResponseMessage>(message, HttpStatus.OK);

        try {
            tx.begin();
            em.persist(user);
            tx.commit();
//            userService.insertUser(user);
        } catch(Exception ex){
            message = new ApiResponseMessage("Failed", "사용자 등록에 실패하였습니다.", "ERROR00001", "Fail to registration for user information.");
            response = new ResponseEntity<ApiResponseMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
            tx.rollback();
        }

        return response;
    }

    @CrossOrigin(origins = "http://frontenddssreact.org.s3-website.ap-northeast-2.amazonaws.com")
    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ApiOperation(value = "사용자 정보 수정", notes = "사용자 정보를 수정하는 API. User entity 클래스로 데이터를 수정한다. 이때엔 정보를 등록할 때와는 다르게 id 값을 함깨 보내줘야한다.")
            public ResponseEntity<ApiResponseMessage> updateUser( User user ){
        ApiResponseMessage message = new ApiResponseMessage("Success", "등록되었습니다.", "", "");
        ResponseEntity<ApiResponseMessage> response = new ResponseEntity<ApiResponseMessage>(message, HttpStatus.OK);

        try {
            tx.begin();
            em.persist(user);
            tx.commit();
//            userService.updateUser(user);
        } catch(Exception ex){
            message = new ApiResponseMessage("Failed", "사용자 등록에 실패하였습니다.", "ERROR00001", "Fail to registration for user information.");
            response = new ResponseEntity<ApiResponseMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
            tx.rollback();
        }

        return response;
    }

    @CrossOrigin(origins = "http://frontenddssreact.org.s3-website.ap-northeast-2.amazonaws.com")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "사용자 정보 삭제", notes = "사용자 정보를 삭제하는 API. User entity 클래스의 id 값으로 데이터를 삭제한다.")
    public ResponseEntity<ApiResponseMessage> deleteUser( @PathVariable("id") String id ){
        ApiResponseMessage message = new ApiResponseMessage("Success", "등록되었습니다.", "", "");
        ResponseEntity<ApiResponseMessage> response = new ResponseEntity<ApiResponseMessage>(message, HttpStatus.OK);

        try {
            userService.deleteUser(id);
        } catch(Exception ex){
            message = new ApiResponseMessage("Failed", "사용자 정보 삭제에 실패하였습니다.", "ERROR00003", "Fail to remove for user information.");
            response = new ResponseEntity<ApiResponseMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return response;
    }
}
