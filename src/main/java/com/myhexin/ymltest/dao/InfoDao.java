package com.myhexin.ymltest.dao;

import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface InfoDao {
    int insertInfo(@Param("params") Map<String, Object> params,
                   @Param("tableName") String tableName,
                   @Param("id") String id,
                   @Param("uId") String uId,
                   @Param("userId") String userId);
}
