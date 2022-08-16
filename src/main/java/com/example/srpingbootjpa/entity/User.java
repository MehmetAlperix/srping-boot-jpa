package com.example.srpingbootjpa.entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "myTable")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;

}
