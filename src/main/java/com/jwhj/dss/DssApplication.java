package com.jwhj.dss;

import com.jwhj.dss.data.Member;
import com.jwhj.dss.data.Prescription;
import com.jwhj.dss.data.Team;
import com.jwhj.dss.data.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@SpringBootApplication
public class DssApplication {

    public static void main(String[] args) {
        SpringApplication.run(DssApplication.class, args);

//
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DSSjdbc");
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//
//        try{
//            tx.begin();
//            testSave(em);
//            tx.commit();
//        }catch (Exception e){
//            tx.rollback();
//        }finally {
//            em.close();
//        }
//        emf.close();
    }

    public static void testSave(EntityManager em){
//        Team team1 = new Team( "팀1");
//        em.persist(team1);
//
//        Member member1 = new Member("회원1");
//        member1.setTeam(team1);
//        em.persist(member1);
//
//
//        Member member2 = new Member("회원2");
//        member2.setTeam(team1);
//        em.persist(member2);
//
        User user = new User("test4", "test4", "테스트1", "test1@abc.com" , "1992-08-21");
        em.persist(user);
        Prescription pre = new Prescription("종우약국","3","2", "2019-06-01");
        pre.setUser(user);
        em.persist(pre);
    }


}
