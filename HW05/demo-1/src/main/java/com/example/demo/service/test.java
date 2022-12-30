package com.example.demo.service;

import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class test {

    @Autowired
    MemberRepository memberRepository;

    public Member test(String id){
        return memberRepository.getById(id);
    }
}
