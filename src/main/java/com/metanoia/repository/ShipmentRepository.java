package com.metanoia.repository;

import com.metanoia.model.ShipmentDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentRepository extends JpaRepository<ShipmentDetails,Long> {

}
