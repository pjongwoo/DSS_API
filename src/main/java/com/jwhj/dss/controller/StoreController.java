package com.jwhj.dss.controller;

import com.jwhj.dss.data.Store;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/store")
@Api(value = "StoreController", description = "약국 검색 API")
public class StoreController {
    String endPoint = "http://apis.data.go.kr/B552657/ErmctInsttInfoInqireService/";
    String serviceKey = "serviceKey=231va86s8mqm2NVC5V5e3wWxtfRh5%2B1dBBBB2ZJb3E6DoeRzJPv3Kk19IYcZmBUyDez8LoibDglwKyWa3VC0Yg%3D%3D";

    @CrossOrigin(origins = "http://frontenddssreact.org.s3-website.ap-northeast-2.amazonaws.com")
    @RequestMapping(value="/address/{address1}/{address2}", method= RequestMethod.GET)
    @ApiOperation(value="지명으로 약국 검색", notes="지명으로 약국을 검색하는 API")
    public List<Store> searchByAddress(@PathVariable("address1") String address1, @PathVariable("address2") String address2){
        List<Store> result = new ArrayList<Store>();
        Map<String, String> parse = new HashMap<String, String>();

        try {
            String serviceName = "getParmacyListInfoInqire?";
            String Q0 = "&Q0=" + URLEncoder.encode(address1, "UTF-8");
            String Q1 = "&Q1=" + URLEncoder.encode(address2, "UTF-8");
            String ord = "&ORD=ADDR";
            String pageNo = "&pageNo=1";
            String numOfRows = "&numOfRows=50";
            String type = "&_type=json";
            String str_url = endPoint + serviceName + serviceKey + Q0 + Q1 + ord + numOfRows + type;

            URL url = new URL(str_url);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));
            String str_result = "";
            String line;
            while((line = br.readLine()) != null){
                str_result = str_result + line + "\n";
            }

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(str_result);
            JSONArray jsonArray =
                (JSONArray) (
                    (JSONObject) (
                        (JSONObject)(
                            (JSONObject) jsonObject.get("response")
                        ).get("body")
                    ).get("items")
                ).get("item");

            for(int i = 0 ; i<jsonArray.size() ; i++){
                Store store = new Store((JSONObject) jsonArray.get(i));
                result.add(store);
            }

            System.out.println("result : " + str_result);
        } catch (MalformedURLException e){
            System.out.println("MalformedURLException!!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException!!");
            e.printStackTrace();
        } catch (ParseException e) {
            System.out.println("ParseException!!");
            e.printStackTrace();
        }
        return result;
    }

    @CrossOrigin(origins = "http://frontenddssreact.org.s3-website.ap-northeast-2.amazonaws.com")
    @RequestMapping(value="/location/{x}/{y}", method= RequestMethod.GET)
    @ApiOperation(value="위치값으로 약국 검색", notes="위치값으로 약국을 검색하는 API")
    public List<Store> searchByLocation(@PathVariable("x") String x, @PathVariable("y") String y){
        List<Store> result = new ArrayList<Store>();
        Map<String, String> parse = new HashMap<String, String>();
        try {
            String serviceName = "getParmacyLcinfoInqire?";
            String Q0 = "&WGS84_LON=" + URLEncoder.encode(x, "UTF-8");
            String Q1 = "&WGS84_LAT=" + URLEncoder.encode(y, "UTF-8");
            String pageNo = "&pageNo=1";
            String numOfRows = "&numOfRows=10";
            String type = "&_type=json";
            String str_url = endPoint + serviceName + serviceKey + Q0 + Q1 + numOfRows + type;

            URL url = new URL(str_url);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));
            String str_result = "";
            String line;
            while((line = br.readLine()) != null){
                str_result = str_result + line + "\n";
            }

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(str_result);
            JSONArray jsonArray =
                    (JSONArray) (
                            (JSONObject) (
                                    (JSONObject)(
                                            (JSONObject) jsonObject.get("response")
                                    ).get("body")
                            ).get("items")
                    ).get("item");

            for(int i = 0 ; i<jsonArray.size() ; i++){
                Store store = new Store((JSONObject) jsonArray.get(i));
                result.add(store);
            }

            System.out.println("result : " + str_result);
        } catch (MalformedURLException e){
            System.out.println("MalformedURLException!!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException!!");
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return result;
    }
}
