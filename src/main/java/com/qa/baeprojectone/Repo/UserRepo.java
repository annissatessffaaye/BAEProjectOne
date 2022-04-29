package com.qa.baeprojectone.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.qa.baeprojectone.domain.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);

   // @Query(value = "SELECT * FROM user WHERE username = ?1", nativeQuery=true);

}