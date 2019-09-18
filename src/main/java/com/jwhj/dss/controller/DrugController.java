package com.jwhj.dss.controller;

import com.jwhj.dss.data.*;
import com.jwhj.dss.model.ApiResponseMessage;
import com.jwhj.dss.service.DrugService;
import com.jwhj.dss.service.PreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/drug")
@Api(value = "DrugController", description = "약품 검색 API")
public class DrugController {

    @Autowired
    DrugService drugService;
    @Autowired
    PreService preService;

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("DSSjdbc");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
//    @Autowired
//    Drug1Service drug1Service;

    @CrossOrigin(origins = "http://frontenddssreact.org.s3-website.ap-northeast-2.amazonaws.com")
    @RequestMapping(value="/findAll", method= RequestMethod.GET)
    @ApiOperation(value="이름으로 약품 검색", notes="이름으로 약품을 검색하는 API")
    public List<Drug> selectDrugAll(){
//        List<Drug1> resultList = drug1Service.selectDrug1All();
//        List<Drug1> new_resultList = new ArrayList<Drug1>();
//
//        for(int i=0 ; i<resultList.size() ; i++){
//            Drug1 item = resultList.get(i);
//            PdfParser pdfParser = new PdfParser();
//            try {
//                if(item.getManufacturing().indexOf("https://nedrug.mfds.go.kr/pbp/cmn/pdfDownload/") >= 0) {
//                    pdfParser.setFilePath("/Volumes/JetDrive/manufacturing/new_manu/" + item.getId() + ".pdf");
//                    String manufacturing = pdfParser.ToText();item.setManufacturing(manufacturing);
//                }
//            }catch (IOException e) { }catch (NullPointerException e){}
//            try {
//                if(item.getUsage().indexOf("https://nedrug.mfds.go.kr/pbp/cmn/pdfDownload/") >= 0) {
//                    pdfParser.setFilePath("/Volumes/JetDrive/usage/new_usage/" + item.getId() + ".pdf");
//                    String usage = pdfParser.ToText(); item.setUsage(usage);
//                }
//            }catch(IOException e){}catch (NullPointerException e){}
//            try {
//                if(item.getCaution().indexOf("https://nedrug.mfds.go.kr/pbp/cmn/pdfDownload/") >= 0) {
//                    pdfParser.setFilePath("/Volumes/JetDrive/caution/new_caution/" + item.getId() + ".pdf");
//                    String caution = pdfParser.ToText(); item.setCaution(caution);
//                }
//            }catch(IOException e){}catch (NullPointerException e){}
//            drug1Service.updateDrug1Byform(item);
//            new_resultList.add(item);
//        }

        return drugService.selectDrugAll();
    }

    @CrossOrigin(origins = "http://frontenddssreact.org.s3-website.ap-northeast-2.amazonaws.com")
    @RequestMapping(value="/findName/{name}", method= RequestMethod.GET)
    @ApiOperation(value="이름으로 약품 검색", notes="이름으로 약품을 검색하는 API")
    public List<Drug> selectDrugByName(@PathVariable("name") String name) throws IOException {
        return drugService.selectDrugByName(name);
    }

    @CrossOrigin(origins = "http://frontenddssreact.org.s3-website.ap-northeast-2.amazonaws.com")
    @RequestMapping(value="/findId/{id}", method= RequestMethod.GET)
    @ApiOperation(value="일련번호로 약품 검색", notes="일련번호로 약품을 검색하는 API")
    public Drug selectDrugById(@PathVariable("id") int id){
        return drugService.selectDrugById(id);
    }

    @CrossOrigin(origins = "http://frontenddssreact.org.s3-website.ap-northeast-2.amazonaws.com")
    @RequestMapping(value="/findForm", method= RequestMethod.POST)
    @ApiOperation(value="검색폼으로 약품 검색", notes="검색폼으로 약품을 검색하는 API")
    public List<Drug> selectDrugById(Drug drug){
        return drugService.selectDrugByform(drug);
    }

    @CrossOrigin(origins = "http://frontenddssreact.org.s3-website.ap-northeast-2.amazonaws.com")
    @RequestMapping(value="/selectPreById/{ID}", method= RequestMethod.GET)
    @ApiOperation(value="ID로 처방전 리스트 검색", notes="ID로 처방전 리스트 검색하는 API")
    public List<Prescription> selectPreById(@PathVariable("ID") String ID) throws IOException {
        User user = new User(ID);
        return preService.selectpreById(user);
    }

    @CrossOrigin(origins = "http://frontenddssreact.org.s3-website.ap-northeast-2.amazonaws.com")
    @RequestMapping(value="/selectPreDrugById/{ID}", method= RequestMethod.GET)
    @ApiOperation(value="ID로 처방전 상세리스트 검색", notes="ID로 처방전 상세리스트 검색하는 API")
    public List<PrescriptionDrug> selectPreDrugById(@PathVariable("ID") int ID) throws IOException {
        Prescription prescription = new Prescription(ID);
        return preService.selectpreDrugById(prescription);
    }

    @CrossOrigin(origins = "http://frontenddssreact.org.s3-website.ap-northeast-2.amazonaws.com")
    @RequestMapping(value="/insertPre/{USER_ID}/{HOSPITAL_NAME}/{DOSES_DAY}/{DOSES_TIME}/{CREATE_DATE}", method= RequestMethod.GET)
    @ApiOperation(value="처방전 등록", notes="처방전 등록하는 API")
    public int insertPre(@PathVariable("USER_ID") String USER_ID, @PathVariable("HOSPITAL_NAME") String HOSPITAL_NAME, @PathVariable("DOSES_DAY") String DOSES_DAY, @PathVariable("DOSES_TIME") String DOSES_TIME, @PathVariable("CREATE_DATE") String CREATE_DATE){
        int pre_id = 0;
        try {
            tx.begin();
            User user = em.find(User.class, USER_ID);
            Prescription pre = new Prescription(HOSPITAL_NAME,DOSES_DAY,DOSES_TIME, CREATE_DATE);
            pre.setUser(user);
            em.persist(pre);
            tx.commit();
            pre_id = pre.getID();
        } catch(Exception ex){
            tx.rollback();
        }
        return pre_id;
    }

    @CrossOrigin(origins = "http://frontenddssreact.org.s3-website.ap-northeast-2.amazonaws.com")
    @RequestMapping(value="/insertPreDetail/{PRESCRIPTION_ID}/{DRUG_ID}/{DRUG_DOSAGE}/{DRUG_TIME}", method= RequestMethod.GET)
    @ApiOperation(value="처방전 상세 등록", notes="처방전 상세 등록하는 API")
    public int insertPreDetail(@PathVariable("PRESCRIPTION_ID") int PRESCRIPTION_ID, @PathVariable("DRUG_ID") int DRUG_ID, @PathVariable("DRUG_DOSAGE") String DRUG_DOSAGE, @PathVariable("DRUG_TIME") String DRUG_TIME){
        ApiResponseMessage message = new ApiResponseMessage("Success", "등록되었습니다.", "", "");
        ResponseEntity<ApiResponseMessage> response = new ResponseEntity<ApiResponseMessage>(message, HttpStatus.OK);
        int preDrug_id = 0;
        try {
            tx.begin();
            Drug drug = em.find(Drug.class, DRUG_ID);
            Prescription pre = em.find(Prescription.class, PRESCRIPTION_ID);
            PrescriptionDrug preDrug = new PrescriptionDrug(DRUG_DOSAGE, DRUG_TIME);
            preDrug.setDrug(drug);
            preDrug.setPrescription(pre);
            em.persist(preDrug);
            tx.commit();
            preDrug_id = preDrug.getId();
        } catch(Exception ex){
            message = new ApiResponseMessage("Failed", "처방전 등록에 실패하였습니다.", "ERROR00001", "Fail to registration for user information.");
            response = new ResponseEntity<ApiResponseMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
            tx.rollback();
        }
        return preDrug_id;
    }


    public static void copyNonNullProperties(Object src, Object target) {
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
    }

    public static String[] getNullPropertyNames (Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for(java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}
