package ru.kata.spring.boot_security.demo.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role")
    private String name;


    public Role() {}

    public Role(Long id ,String name) {
        this.id = id;
        this.name = name;
    }

    public Role(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String trueGetName() {
        if (this.name.equals("ROLE_ADMIN")) {
            return "ADMIN";
        }
        return "USER";
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return name.split("_")[1];
    }

    @Override
    public String getAuthority() {
        return getName();
    }
}
