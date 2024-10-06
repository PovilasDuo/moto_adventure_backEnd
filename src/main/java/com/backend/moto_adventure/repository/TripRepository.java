package com.backend.moto_adventure.repository;

import com.backend.moto_adventure.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
    @Query("SELECT t FROM Trip t WHERE t.startDate BETWEEN :startDate AND :endDate")
    List<Trip> findTripsBetweenDates(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
