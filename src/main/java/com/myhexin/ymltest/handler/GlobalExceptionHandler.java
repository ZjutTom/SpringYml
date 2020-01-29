package com.myhexin.ymltest.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    private Map<String, Object> exceptionHandler(Exception e) {
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("status_code", 1);
        modelMap.put("status_msg", e.getMessage());
        return modelMap;
    }
}
