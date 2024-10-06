package com.backend.moto_adventure.entity;

import jakarta.persistence.*;
import lombok.*;
import java.sql.Date;
import java.sql.Time;

@Getter
@Entity
@Table(name = "trip")
@AllArgsConstructor
@NoArgsConstructor
public class Trip {
    @Setter
    @Column(name = "startTime")
    private Time startTime;
    @Setter
    @Column(name = "startDate")
    private Date startDate;
    @Setter
    private String location;
    @Id
    private Integer id_Trip;

    @Setter
    @ManyToOne // Define a many-to-one relationship
    @JoinColumn(name = "fk_Userid_User", referencedColumnName = "id_User", nullable = false)
    private User fk_Userid_User;

    @Setter
    @ManyToOne // Define a many-to-one relationship
    @JoinColumn(name = "fk_Routeid_Route", referencedColumnName = "id_Route", nullable = false)
    private Route fk_Routeid_Route;
}
