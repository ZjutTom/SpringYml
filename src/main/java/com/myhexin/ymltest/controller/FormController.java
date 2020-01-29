package com.myhexin.ymltest.controller;

import com.myhexin.ymltest.service.MgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class FormController {

    @Autowired
    private MgService mgService;

    @RequestMapping("/add")
    public Map<String, Object> add(@RequestBody Map<String, Object> params) {
        return mgService.add(params);
    }
}
