package com.myhexin.ymltest.service;

import com.myhexin.ymltest.dao.InfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class InfoService {

    @Autowired(required = false)
    private InfoDao infoDao;

    public boolean queryInfoById(String tableName, String id) {
        try {
            Object result = infoDao.queryInfoById(tableName, id);
            if(result != null) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new RuntimeException("查询失败: " + e.getMessage());
        }
    }

    @Transactional
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

    public boolean updateInfo(Map<String, Object> params, String tableName, String id) {
        try {
            int effectedNum = infoDao.updateInfo(params, tableName, id);
            if(effectedNum > 0) {
                return true;
            } else {
                throw new RuntimeException("更新失败!");
            }
        } catch (Exception e) {
            throw new RuntimeException("更新失败: " + e.getMessage());
        }
    }
}
