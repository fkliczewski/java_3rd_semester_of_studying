package com.example.test_kolokwium_2.repositories;

import com.example.test_kolokwium_2.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findPersonByFirstName(String firstName);
}
