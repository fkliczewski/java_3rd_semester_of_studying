package com.example.test_kolokwium_2.services;

import com.example.test_kolokwium_2.contracts.AddressDTO;
import com.example.test_kolokwium_2.contracts.PersonDTO;
import com.example.test_kolokwium_2.model.Address;
import com.example.test_kolokwium_2.model.Person;
import com.example.test_kolokwium_2.repositories.AddressRepository;
import com.example.test_kolokwium_2.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PersonService {
    PersonRepository personRepository;
    AddressRepository addressRepository;

    @Autowired
    public PersonService(PersonRepository personRepository, AddressRepository addressRepository) {
        this.personRepository = personRepository;
        this.addressRepository = addressRepository;
    }

    public List<PersonDTO> getAll(){
        return personRepository.findAll()
                .stream()
                .map(e->new PersonDTO(e.getId(), e.getFirstName(), e.getLastName())).toList();
    }

    public long save (PersonDTO dto){
        var person = new Person();
        person.setId(dto.getId());
        person.setFirstName(dto.getFirst_name());
        person.setLastName(dto.getLast_name());

        personRepository.save(person);
        return person.getId();
    }

    public long update(PersonDTO dto){
        var person = personRepository.findById(dto.getId());
        if(person.isPresent()){
            person.get().setFirstName(dto.getFirst_name());
            person.get().setLastName(dto.getLast_name());
            personRepository.save(person.get());
            return person.get().getId();
        }

        return 0;
    }

    public long delete (long id){
        personRepository.deleteById(id);
        return id;
    }

    public long addAddres(long personId, AddressDTO addressDTO){
        var person = personRepository.findById(personId);
        if(person.isPresent()) {
            var addres = new Address();
            addres.setId(addressDTO.getId());
            addres.setCity(addressDTO.getCity());
            addres.setPostalCode(addressDTO.getPostal_code());
            addres.setStreet(addressDTO.getStreet());

            person.get().getAddress_list().add(addres);
            personRepository.save(person.get());

            return personId;
        }

        return 0;
    }

    public List<AddressDTO> getAddresses(long personId){
        var person = personRepository.findById(personId);
        if(person.isPresent()){
            return person.get().getAddress_list()
                    .stream()
                    .map(e->new AddressDTO(e.getId(), e.getCity(), e.getPostalCode(), e.getStreet()))
                    .toList();

        }
        return null;
    }


}
