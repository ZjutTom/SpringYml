package com.myhexin.ymltest.service;

import com.myhexin.ymltest.dao.InfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class InfoService {

    @Autowired(required = false)
    private InfoDao infoDao;

    public boolean insertInfo(Map<String, Object> params, String tableName, String id, String uId, String userId) {
        try {
            int effectedNum = infoDao.insertInfo(params, tableName, id, uId, userId);
            if(effectedNum > 0) {
                return true;
            } else {
                throw new RuntimeException("插入失败!");
            }
        } catch (Exception e) {
            throw new RuntimeException("插入失败: " + e.getMessage());
        }
    }
}
