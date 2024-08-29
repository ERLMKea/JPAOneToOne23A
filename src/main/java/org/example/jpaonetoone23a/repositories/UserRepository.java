package org.example.jpaonetoone23a.repositories;

import org.example.jpaonetoone23a.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {


}
