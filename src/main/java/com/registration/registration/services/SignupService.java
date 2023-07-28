package com.registration.registration.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.registration.registration.dao.UserRepository;
import com.registration.registration.entities.SignupModel;

@Component
public class SignupService {

    @Autowired
    private UserRepository userRepository;
    // private static List<SignupModel> list=new ArrayList<>();

    // static{
    //     list.add(new SignupModel(90,"ravish","ravish12@gmai.com","Ravish123"));
    //     list.add(new SignupModel(80,"rohit","rohit12@gmai.com","Rohit123"));
    //     list.add(new SignupModel(70,"vishal","vishal12@gmai.com","vishal123"));
    // }

    //// get all user
    public List<SignupModel> getAllUser()
    {
        List<SignupModel> list=(List<SignupModel>)this.userRepository.findAll();
        return list;
    }

    //// get single user
    public SignupModel getUserByRollNo(int rollNo)
    {
      SignupModel user=null;
      try {
        // user=list.stream().filter(e->e.getRollNo()==rollNo).findFirst().get();
        user=this.userRepository.findByRollNo(rollNo);
      } catch (Exception e) {
         e.printStackTrace();
      }
      return user;
    }

    /// add user
    public SignupModel addUser(SignupModel user)
    {
        SignupModel u=this.userRepository.save(user);
        return u;
    }
    //// delete user
    public void deleteUser(int rollNo)
    {
        //    list=list.stream().filter(user->user.getRollNo()!=rollNo).collect(Collectors.toList());
        this.userRepository.deleteById(rollNo);
    }

    ///////// update user
    public void updateUser(SignupModel user, int rollNo) {
            // list=list.stream().map(u->{
            //     if(u.getRollNo()==rollNo)
            //     {
            //         u.setName(user.getName());
            //         u.setEmail(user.getEmail());
            //     }
            //     return u;
            // }).collect(Collectors.toList());
            user.setRollNo(rollNo);
            this.userRepository.save(user);
    }
}
