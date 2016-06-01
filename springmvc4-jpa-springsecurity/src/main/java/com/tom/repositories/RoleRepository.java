package com.tom.repositories;

import com.tom.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * Created by tom on 2016/6/1.
 */
public interface RoleRepository extends JpaRepository<Role, Serializable>
{

}
