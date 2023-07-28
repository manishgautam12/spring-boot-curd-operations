package com.registration.registration.dao;

import org.springframework.data.repository.CrudRepository;

import com.registration.registration.entities.SignupModel;

public interface UserRepository extends CrudRepository<SignupModel,Integer> {
      public SignupModel findByRollNo(int rollNo);
}
