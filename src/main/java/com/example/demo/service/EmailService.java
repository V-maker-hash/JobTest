package com.example.demo.service;

import com.example.demo.domain.Email;

import java.util.List;

public interface EmailService {

    List<Email> findAll();

    Email findById(Long theId);

    void save(Email email) throws Exception;

    void deleteById(Long theId);

}
