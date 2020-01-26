package com.myhexin.ymltest.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MgServiceTest {

    @Autowired
    private MgService mgService;

    @Test
    void test() {
        mgService.test();
    }
}