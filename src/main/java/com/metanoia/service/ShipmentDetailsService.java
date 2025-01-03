package com.metanoia.service;

import com.metanoia.model.ShipmentDetails;
import com.metanoia.repository.ShipmentDetailsRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentDetailsService {

    @Autowired
    private ShipmentDetailsRepositoryCustom shipmentDetailsRepositoryCustom;

    public List<ShipmentDetails> getSpecificColumns(List<String> columns) {
        return shipmentDetailsRepositoryCustom.findSpecificColumns(columns);
    }
}
