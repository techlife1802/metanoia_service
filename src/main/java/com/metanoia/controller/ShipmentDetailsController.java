package com.metanoia.controller;


import com.metanoia.model.ShipmentDetails;
import com.metanoia.model.ShipmentDetailsDto;
import com.metanoia.model.ShipmentEntryRequest;
import com.metanoia.service.ShipmentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shipment-details")
@CrossOrigin
class ShipmentDetailsController {

    @Autowired
    private ShipmentDetailsService shipmentDetailsService;

    @PostMapping("/fetch-columns")
    public List<ShipmentDetails> fetchColumns(@RequestBody List<String> columns) {
        return shipmentDetailsService.getSpecificColumns(columns);
    }

    @PostMapping("/add-shipment")
    public void addShipmentDetails(@RequestBody ShipmentEntryRequest request) {
        shipmentDetailsService.saveShipment(request);
    }
}
