package com.example.test_kolokwium_2.repositories;

import com.example.test_kolokwium_2.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    
}
