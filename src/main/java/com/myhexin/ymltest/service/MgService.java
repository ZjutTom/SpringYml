package com.myhexin.ymltest.service;

import com.myhexin.ymltest.component.MgComponent;
import com.myhexin.ymltest.model.U;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MgService {

    @Autowired
    private MgComponent mgComponent;

    @Autowired
    private InfoService infoService;

    public Map<String, Object> add(Map<String, Object> params) {
        Map<String, Object> modelMap = new HashMap<>();
        int statusCode = 0;
        String statusMsg = "success";

        String id = "1001";
        String userId = "100010";
        List<U> uList = mgComponent.getLists();
        for (U u : uList) {
            String uId = u.getuId();
            if(uId.equals("10030")) {
                String uName = u.getuName();
                String tableName = u.getTableName();
                Map<String, String> valueKeyMap = getValueKeyMap(u);
                Map<String, Object> info = new HashMap<>();
                for (Map.Entry<String, String> entry : valueKeyMap.entrySet()) {
                    String key = entry.getValue();
                    String value = String.valueOf(params.get(key));
                    info.put(key, value);
                }
                infoService.insertInfo(info, tableName, id, uId, userId);
            }
        }

        modelMap.put("status_code", statusCode);
        modelMap.put("status_msg", statusMsg);
        return modelMap;
    }

    void test() {
        List<U> uList = mgComponent.getLists();
        for (U u : uList) {
            String uId = u.getuId();
            if(uId.equals("10031")) {
                String uName = u.getuName();
                String tableName = u.getTableName();
                Map<String, Object> info = u.getInfo();
                for (Map.Entry<String, Object> entry : info.entrySet()) {
                    String key = entry.getKey();
                    String value = String.valueOf(entry.getValue());
                    System.out.println("key: " + key + " value: " + value);
                }
            }
        }
    }

    private Map<String, String> getValueKeyMap(U u) {
        Map<String, String> map = new HashMap<>();
        Map<String, Object> info = u.getInfo();
        for(Map.Entry<String, Object> entry : info.entrySet()) {
            map.put(String.valueOf(entry.getValue()), entry.getKey());
        }
        return map;
    }
}
