package com.metanoia.controller;

import com.metanoia.model.ShipmentDetails;
import com.metanoia.model.ShipmentDetailsUserRequest;
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

    @PostMapping("/get-shipment-details")
    public List<ShipmentDetails> fetchColumns(@RequestBody ShipmentDetailsUserRequest request) {
        log.info("received request for shipment details ::{}", request);
        return shipmentDetailsService.getShipmentEntriesSpecificColumns(request);
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