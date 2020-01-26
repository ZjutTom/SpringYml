package com.myhexin.ymltest.service;

import com.myhexin.ymltest.component.MgComponent;
import com.myhexin.ymltest.model.U;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MgService {

    @Autowired
    private MgComponent mgComponent;

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
}
