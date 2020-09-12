/*
 * Copyright (c) 2020. Marc Kandel
 */

package com.mkandel.checklists.outbound.repositories;

import com.mkandel.checklists.entities.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
}
