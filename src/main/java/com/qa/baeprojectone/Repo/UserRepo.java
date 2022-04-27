package com.qa.baeprojectone.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.qa.baeprojectone.domain.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

}