package com.example.projekt_s25663.service;

import com.example.projekt_s25663.model.Postman;
import com.example.projekt_s25663.repository.PostmanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostmanService {
    PostmanRepository postmanRepository;

    @Autowired
    public PostmanService(PostmanRepository postmanRepository) {
        this.postmanRepository = postmanRepository;
    }

    public Postman createPostman(Postman postman){
        return postmanRepository.save(postman);
    }

    public Postman getPostmanById(Long id){
        Optional<Postman> p = postmanRepository.findById(id);
        if(p.isPresent()){
            return p.get();
        }
        throw new IllegalArgumentException();
    }

    public List<Postman> getAllPostmans(){
        return postmanRepository.findAll();
    }

    public Postman updatePostman(Long id, Postman updatedPostman){
        Postman postmanToUpdate = getPostmanById(id);

        if(updatedPostman.getName() != null){
            postmanToUpdate.setName(updatedPostman.getName());
        }
        if(updatedPostman.getSurname() != null){
            postmanToUpdate.setSurname(updatedPostman.getSurname());
        }
        if(updatedPostman.getAge() != 0){
            postmanToUpdate.setAge(updatedPostman.getAge());
        }
        if(updatedPostman.getRegionId() != 0){
            postmanToUpdate.setRegionId(updatedPostman.getRegionId());
        }
        if(updatedPostman.getAddres() != null){
            postmanToUpdate.setAddres(updatedPostman.getAddres());
        }
        if(updatedPostman.getEmail() != null){
            postmanToUpdate.setEmail(updatedPostman.getEmail());
        }
        if(updatedPostman.getJobPositionId() != 0){
            postmanToUpdate.setJobPositionId(updatedPostman.getJobPositionId());
        }
        if(updatedPostman.getGender() != null){
            postmanToUpdate.setGender(updatedPostman.getGender());
        }

        postmanRepository.save(postmanToUpdate);

        return postmanToUpdate;
    }

    public void deletePostman(Long id){
        postmanRepository.deleteById(id);
    }

    public void deleteAllPostmans(){
        postmanRepository.deleteAll();
    }

}
