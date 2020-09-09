package com.mkandel.checklists.outbound.repositories;

import com.mkandel.checklists.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findAll();

    Optional<User> findByUsername(String username);
//    Optional<User> findById(int id);

    @Transactional
    void deleteById(int id);
}
