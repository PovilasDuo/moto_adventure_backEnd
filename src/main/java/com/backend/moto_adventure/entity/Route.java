package com.backend.moto_adventure.entity;

import jakarta.persistence.*;
import lombok.*;
import java.sql.*;

@Getter
@Entity
@Table(name = "route")
@AllArgsConstructor
@NoArgsConstructor
public class Route {
    @Setter
    private float length;
    @Setter
    private float time;
    @Id
    private Integer id_Route;
}
