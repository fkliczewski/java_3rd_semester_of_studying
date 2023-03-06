package com.example.projekt_s25663.repository;

import com.example.projekt_s25663.model.Postman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostmanRepository extends JpaRepository<Postman, Long> {
}
