package com.example.demo.repositories;

import com.example.demo.domain.Email;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmailRepo extends JpaRepository<Email, Long> {
}
