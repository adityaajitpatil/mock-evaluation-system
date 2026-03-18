package com.mock.mock_evaluation_system.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(name = "role_name")
    private String name;

    public Role() {}

    public Role(String name) {
        this.name = name;
    }

}