package com.backend.moto_adventure.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Setter
    private int type;
    @Setter
    private String username;
    @Setter
    private String password;
    @Setter
    private String name;
    @Setter
    private String email;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // or AUTO, depending on your use case
    private Integer id_User;
}
