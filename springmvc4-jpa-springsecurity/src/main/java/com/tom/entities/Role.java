package com.tom.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by tom on 2016/6/1.
 */
@Entity
@Table(name = "ROLES")
public class Role implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer id;
    @Column(name="role_name",nullable=false)
    private String roleName;

    public Role() {
    }

    public Role(String roleName) {
        this.roleName = roleName;
    }
    public Role(Integer id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}
