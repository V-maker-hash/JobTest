package com.example.demo.controller;

import com.example.demo.domain.Email;
import com.example.demo.service.EmailService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmailController {

    private EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/emails")
    public List<Email> findAll() {
        return emailService.findAll();
    }


    @GetMapping("/emails/{emailId}")
    public Email getEmployee(@PathVariable Long emailId) {

        Email email = emailService.findById(emailId);

        if (email == null) {
            throw new RuntimeException("Email id not found - " + emailId);
        }

        return email;
    }


    @PostMapping("/emails")
    public String addEmployee(@RequestBody Email email) throws Exception {

        email.setId((long) 0);

        emailService.save(email);
        return "email" + " : " + email.getAddress();
    }

    @PutMapping("/emails")
    public Email updateEmail(@RequestBody Email email) throws Exception {

        emailService.save(email);

        return email;
    }


    @DeleteMapping("/emails/{emailId}")
    public String deleteEmail(@PathVariable Long emailId) {

        Email tempEmail = emailService.findById(emailId);

        if (tempEmail == null) {
            throw new RuntimeException("Email id not found - " + emailId);
        }

        emailService.deleteById(emailId);

        return "Deleted email id - " + emailId;
    }

}
