package com.example.test_kolokwium_2.controllers;

import com.example.test_kolokwium_2.contracts.AddressDTO;
import com.example.test_kolokwium_2.contracts.PersonDTO;
import com.example.test_kolokwium_2.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/person")
public class PersonController {

    PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping  //("cos")
    public ResponseEntity getAll(){
        var result = personService.getAll();
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity savePerson(@RequestBody PersonDTO dto){
        var id = personService.save(dto);
        return ResponseEntity.ok(id);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity getPersonById(@PathVariable long id) throws Throwable {
        var result = personService.getAll().stream().filter(e->e.getId() == id).findFirst();
        if(result.isPresent()){
            return ResponseEntity.ok(result.get());
        }
        return ResponseEntity.ok("error 404");
    }

    @PutMapping("{id}")
    public ResponseEntity updatePersonById(@RequestBody PersonDTO dto, @PathVariable long id){
        dto.setId(id);
        var result = personService.update(dto);
        if(result!=0){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.ok("error 404");
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletePersonById(@PathVariable long id){
        var result = personService.delete(id);
        if(result!=0){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.ok("error 404");
    }

    @GetMapping("{id}/addresses")
    public ResponseEntity getAddresesFromPersonsId(@PathVariable long id){
        var result = personService.getAddresses(id);
        if(result!=null){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.ok("error 404");
    }

    @PostMapping("{id}/addresses")
    public ResponseEntity addAddresToPersonById(@PathVariable long id, @RequestBody AddressDTO addressDTO){
        var result = personService.addAddres(id, addressDTO);
        if(result!=0){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.ok("error 404");
    }

}

