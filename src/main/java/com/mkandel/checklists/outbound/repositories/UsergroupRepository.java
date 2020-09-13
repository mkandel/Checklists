/*
 * Copyright (c) 2020. Marc Kandel
 */

package com.mkandel.checklists.outbound.repositories;

import com.mkandel.checklists.entities.Usergroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsergroupRepository extends CrudRepository<Usergroup, Integer> {
    List<Usergroup> findAll();
}
