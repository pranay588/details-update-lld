package com.example.LLD.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LLD.models.UserPermAdd;

@Repository
public interface UserPermAddRepo extends JpaRepository<UserPermAdd,String>{

}
