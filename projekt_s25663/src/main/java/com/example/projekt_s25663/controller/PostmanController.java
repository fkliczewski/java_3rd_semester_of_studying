package com.example.projekt_s25663.controller;


import com.example.projekt_s25663.model.Postman;
import com.example.projekt_s25663.service.PostmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("postman")
public class PostmanController {
    PostmanService postmanService;

    @Autowired
    public PostmanController(PostmanService postmanService) {
        this.postmanService = postmanService;
    }

    @PostMapping("create")
    public ResponseEntity<Postman> createPostman(@RequestBody Postman postman){
        return ResponseEntity.ok(postmanService.createPostman(postman));
    }

    @GetMapping("read")
    public ResponseEntity<Postman> getPostmanById(@RequestParam Long id){
        return ResponseEntity.ok(postmanService.getPostmanById(id));
    }

    @GetMapping("readall")
    public ResponseEntity<List<Postman>> getAllPostmans(){
        return ResponseEntity.ok(postmanService.getAllPostmans());
    }

    @PutMapping("update")
    public ResponseEntity<Postman> updatePostman(@RequestBody Postman postman, @RequestParam Long id){
        return ResponseEntity.ok(postmanService.updatePostman(id, postman));
    }

    @DeleteMapping("delete")
    public ResponseEntity<String> deletePostman(@RequestParam Long id){
        postmanService.deletePostman(id);
        return ResponseEntity.ok("deleted postman with id: "+id);
    }

    @DeleteMapping("deleteall")
    public ResponseEntity<String> deleteAllPostmans(){
        postmanService.deleteAllPostmans();
        return ResponseEntity.ok("deleted all postmans :(");
    }
}
