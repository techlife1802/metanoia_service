package com.metanoia.controller;


import com.metanoia.model.ShipmentDetails;
import com.metanoia.service.ShipmentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shipment-details")
class ShipmentDetailsController {

    @Autowired
    private ShipmentDetailsService shipmentDetailsService;

    @PostMapping("/fetch-columns")
    public List<ShipmentDetails> fetchColumns(@RequestBody List<String> columns) {
        return shipmentDetailsService.getSpecificColumns(columns);
    }
}
