package com.jwhj.dss.data;

import lombok.Getter;
import lombok.Setter;
import org.json.simple.JSONObject;

import javax.persistence.*;

@Getter
@Setter
public class Store {

    private String rnum;
    private String dutyAddr;
    private String dutyEtc;
    private String dutyMapimg;
    private String dutyName;
    private String dutyTel1;
    private String dutyTime1s;
    private String dutyTime2s;
    private String dutyTime3s;
    private String dutyTime4s;
    private String dutyTime5s;
    private String dutyTime6s;
    private String dutyTime7s;
    private String dutyTime8s;
    private String dutyTime1c;
    private String dutyTime2c;
    private String dutyTime3c;
    private String dutyTime4c;
    private String dutyTime5c;
    private String dutyTime6c;
    private String dutyTime7c;
    private String dutyTime8c;
    private String hpid;
    private String postCdn1;
    private String postCdn2;
    private String wgs84Lon;
    private String wgs84Lat;
    private String distance;
    private String dutyDiv;
    private String dutyDivName;
    private String dutyFax;
    private String startTime;
    private String endTime;

    public Store(JSONObject o) {
        try { rnum = o.get("rnum").toString(); }catch (Exception e){ rnum = null; }
        try { dutyAddr = o.get("dutyAddr").toString();}catch (Exception e){ dutyAddr = null; }
        try { dutyEtc = o.get("dutyEtc").toString();}catch (Exception e){ dutyEtc = null; }
        try { dutyMapimg = o.get("dutyMapimg").toString();}catch (Exception e){ dutyMapimg = null; }
        try { dutyName = o.get("dutyName").toString();}catch (Exception e){ dutyName = null; }
        try { dutyTel1 = o.get("dutyTel1").toString();}catch (Exception e){ dutyTel1 = null; }
        try { dutyTime1s = o.get("dutyTime1s").toString();}catch (Exception e){ dutyTime1s = null; }
        try { dutyTime2s = o.get("dutyTime2s").toString();}catch (Exception e){ dutyTime2s = null; }
        try { dutyTime3s = o.get("dutyTime3s").toString();}catch (Exception e){ dutyTime3s = null; }
        try { dutyTime4s = o.get("dutyTime4s").toString();}catch (Exception e){ dutyTime4s = null; }
        try { dutyTime5s = o.get("dutyTime5s").toString();}catch (Exception e){ dutyTime5s = null; }
        try { dutyTime6s = o.get("dutyTime6s").toString();}catch (Exception e){ dutyTime6s = null; }
        try { dutyTime7s = o.get("dutyTime7s").toString();}catch (Exception e){ dutyTime7s = null; }
        try { dutyTime8s = o.get("dutyTime8s").toString();}catch (Exception e){ dutyTime8s = null; }
        try { dutyTime1c = o.get("dutyTime1c").toString();}catch (Exception e){ dutyTime1c = null; }
        try { dutyTime2c = o.get("dutyTime2c").toString();}catch (Exception e){ dutyTime2c = null; }
        try { dutyTime3c = o.get("dutyTime3c").toString();}catch (Exception e){ dutyTime3c = null; }
        try { dutyTime4c = o.get("dutyTime4c").toString();}catch (Exception e){ dutyTime4c = null; }
        try { dutyTime5c = o.get("dutyTime5c").toString();}catch (Exception e){ dutyTime5c = null; }
        try { dutyTime6c = o.get("dutyTime6c").toString();}catch (Exception e){ dutyTime6c = null; }
        try { dutyTime7c = o.get("dutyTime7c").toString();}catch (Exception e){ dutyTime7c = null; }
        try { dutyTime8c = o.get("dutyTime8c").toString();}catch (Exception e){ dutyTime8c = null; }
        try { hpid = o.get("hpid").toString();}catch (Exception e){ hpid = null; }
        try { postCdn1 = o.get("postCdn1").toString();}catch (Exception e){ postCdn1 = null; }
        try { postCdn2 = o.get("postCdn2").toString();}catch (Exception e){ postCdn2 = null; }
        try { wgs84Lon = o.get("wgs84Lon").toString();}catch (Exception e){ wgs84Lon = null; }
        try { wgs84Lat = o.get("wgs84Lat").toString();}catch (Exception e){ wgs84Lat = null; }
        try { distance = o.get("distance").toString();}catch (Exception e){ distance = null; }
        try { dutyDiv = o.get("dutyDiv").toString();}catch (Exception e){ dutyDiv = null; }
        try { dutyDivName = o.get("dutyDivName").toString();}catch (Exception e){ dutyDivName = null; }
        try { dutyFax = o.get("dutyFax").toString();}catch (Exception e){ dutyFax = null; }
        try { startTime = o.get("startTime").toString();}catch (Exception e){ startTime = null; }
        try { endTime = o.get("endTime").toString();}catch (Exception e){ endTime = null; }
    }
}
