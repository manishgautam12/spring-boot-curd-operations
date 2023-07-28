package com.registration.registration.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.registration.registration.entities.SignupModel;
import com.registration.registration.services.SignupService;


@RestController
@RequestMapping("v1/api/user/")
public class SignupController {
    @Autowired
     private SignupService signupService;

    @GetMapping("/allUsers")
    public ResponseEntity<List<SignupModel>> getUsers()
    {
        List<SignupModel> list=this.signupService.getAllUser();
        if(list.size()<=0)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }

    @GetMapping("/oneUser/{rollNo}")
    public ResponseEntity<SignupModel> getUser(@PathVariable("rollNo") int rollNo)
    {
        SignupModel user=signupService.getUserByRollNo(rollNo);
        if(user==null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(user));
    }

    @PostMapping("/addUser/")
    public ResponseEntity<SignupModel> addUser(@RequestBody SignupModel user)
    {
        SignupModel u=null;
        try {
           u=this.signupService.addUser(user);
            return ResponseEntity.of(Optional.of(u)); 
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
       
    }

    @DeleteMapping("/deleteUser/{rollNo}")
    public ResponseEntity<Void> deleteUser(@PathVariable("rollNo") int rollNo)
    {
        try {
             this.signupService.deleteUser(rollNo);
             return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
             e.printStackTrace();
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
       
    }

    @PutMapping("/updateUser/{rollNo}")
    public ResponseEntity<SignupModel> updateUser(@RequestBody SignupModel user,@PathVariable("rollNo") int rollNo)
    {
        try {
            this.signupService.updateUser(user,rollNo);
            return ResponseEntity.ok().body(user);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
         
    }

    
}
