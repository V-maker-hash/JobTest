package com.example.demo.service;

import com.example.demo.domain.Email;
import com.example.demo.repositories.EmailRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmailServiceImpl implements EmailService {

    private EmailRepo emailRepo;

    public EmailServiceImpl(EmailRepo emailRepo) {
        this.emailRepo = emailRepo;
    }

    @Override
    public List<Email> findAll() {
        return emailRepo.findAll();
    }

    @Override
    public Email findById(Long theId) {
        Optional<Email> result = emailRepo.findById(theId);
        Email email = null;
        if (result.isPresent()) {
            email = result.get();
        } else {
            throw new RuntimeException("Did not find the Email " + theId);
        }
        return email;
    }

    @Override
    public void save(Email email) throws Exception {

        for (Email tempEmail : emailRepo.findAll()) {
            if (tempEmail.getAddress().equals(email.getAddress())) {
                throw new Exception();
            }
        }
        emailRepo.save(email);

    }

    @Override
    public void deleteById(Long theId) {
        emailRepo.deleteById(theId);
    }
}
