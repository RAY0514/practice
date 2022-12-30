package com.example.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class testTest {

    @Autowired
    test test;

    @Test
    void test1() {
        System.out.println(test.test("1"));
    }

}