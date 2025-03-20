package com.metanoia.controller;


import com.metanoia.model.ShipmentDetails;
import com.metanoia.model.ShipmentDetailsDto;
import com.metanoia.model.ShipmentEntryRequest;
import com.metanoia.service.ShipmentDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shipment-details")
@CrossOrigin
@Slf4j
class ShipmentDetailsController {

    @Autowired
    private ShipmentDetailsService shipmentDetailsService;

    @PostMapping("/get-shipment-details/{user}")
    public List<ShipmentDetails> fetchColumns(@PathVariable("user") String user,@RequestBody List<String> columns) {
        log.info("received request for columns: {} for user : {}",columns,user);
        return shipmentDetailsService.getShipmentEntriesSpecificColumns(user,columns);
    }

    @PostMapping("/add-shipment")
    public void addShipmentDetails(@RequestBody ShipmentEntryRequest request) {
        shipmentDetailsService.saveShipment(request);
    }

    @PostMapping("/update-shipment")
    public void updateShipmentDetails(@RequestBody ShipmentEntryRequest request) {
        shipmentDetailsService.updateShipment(request);
    }
}
