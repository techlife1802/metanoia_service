package com.metanoia.repository;

import com.metanoia.model.ShipmentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ShipmentRepository extends JpaRepository<ShipmentDetails, String> {

    @Query("SELECT s FROM ShipmentDetails s WHERE s.createdDate BETWEEN :startDate AND :endDate")
    List<ShipmentDetails> findAllByCreatedDateBetween(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

}
