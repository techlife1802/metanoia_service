package com.metanoia.service;

import com.metanoia.model.ShipmentDetails;
import com.metanoia.model.ShipmentDetailsDto;
import com.metanoia.model.ShipmentEntryRequest;
import com.metanoia.repository.ShipmentDetailsRepositoryCustom;
import com.metanoia.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

@Service
public class ShipmentDetailsService {

    @Autowired
    private ShipmentDetailsRepositoryCustom shipmentDetailsRepositoryCustom;

    @Autowired
    ShipmentRepository shipmentRepository;

    public List<ShipmentDetails> getSpecificColumns(List<String> columns) {
        return shipmentDetailsRepositoryCustom.findSpecificColumns(columns);
    }


    public void saveShipment(ShipmentEntryRequest request) {
        ShipmentDetails details = ShipmentDetails.builder()
                .commodity(Optional.ofNullable(request.getCommodity()).orElse(""))
                .portOfLoading(Optional.ofNullable(request.getPortOfLoading()).orElse(""))
                .destination(Optional.ofNullable(request.getDestination()).orElse(""))
                .icd(Optional.ofNullable(request.getIcd()).orElse(""))
                .forwarder(Optional.ofNullable(request.getForwarder()).orElse(""))
                .shippingLine(Optional.ofNullable(request.getShippingLine()).orElse(""))
                .bookingNumber(Optional.ofNullable(request.getBookingNumber()).orElse(""))
                .emptyContainerReceived(Optional.ofNullable(request.getEmptyContainerReceived()).orElse(""))
                .weight(Optional.ofNullable(request.getWeight()).orElse(BigDecimal.ZERO))
                .loadingStatus(Optional.ofNullable(request.getLoadingStatus()).orElse(""))
                .vgmFilled(Optional.ofNullable(request.getVgmFilled()).orElse(""))
                .customClearance(Optional.ofNullable(request.getCustomClearance()).orElse(""))
                .shippingBillFilled(Optional.ofNullable(request.getShippingBillFilled()).orElse(""))
                .baeReceived(Optional.ofNullable(request.getBaeReceived()).orElse(""))
                .containerStatus(Optional.ofNullable(request.getContainerStatus()).orElse(""))
                .BlInstructionFilled(Optional.ofNullable(request.getBlInstructionFilled()).orElse(""))
                .draftGenerated(Optional.ofNullable(request.getDraftGenerated()).orElse(""))
                .blDraftStatus(Optional.ofNullable(request.getBlDraftStatus()).orElse(""))
                .billLandingNumber(Optional.ofNullable(request.getBillLandingNumber()).orElse(""))
                .loadingPicsShared(Optional.ofNullable(request.getLoadingPicsShared()).orElse(""))

                // Primitive types with default values
                .freightPaid(request.isFreightPaid())
                .sampleReportAvailable(request.isSampleReportAvailable())
                .loadingPhotosShared(request.isLoadingPhotosShared())
                .salesInvoiceShared(request.isSalesInvoiceShared())
                .invoiceGenerated(request.isInvoiceGenerated())
                .buyerClaimShortage(request.isBuyerClaimShortage())
                .buyerClaimSettled(request.isBuyerClaimSettled())
                .supplierClaim(request.isSupplierClaim())
                .supplierClaimSettled(request.isSupplierClaimSettled())

                // Handling null for Strings and numeric values
                .materialStatus(Optional.ofNullable(request.getMaterialStatus()).orElse(""))
                .supplierName(Optional.ofNullable(request.getSupplierName()).orElse(""))
                .supplierLmePercentage(Optional.of(request.getSupplierLmePercentage()).orElse(0.0))
                .supplierLmeRate(Optional.of(request.getSupplierLmeRate()).orElse(0.0))
                .supplierFinalRate(Optional.of(request.getSupplierFinalRate()).orElse(0.0))
                .supplierInvoiceValue(Optional.of(request.getSupplierInvoiceValue()).orElse(0.0))
                .supplierPaymentTerms(Optional.ofNullable(request.getSupplierPaymentTerms()).orElse(""))
                .supplierClaimAmount(Optional.of(request.getSupplierClaimAmount()).orElse(0.0))
                .buyerName(Optional.ofNullable(request.getBuyerName()).orElse(""))
                .consigneeName(Optional.ofNullable(request.getConsigneeName()).orElse(""))
                .qualityOfMaterial(Optional.ofNullable(request.getQualityOfMaterial()).orElse(""))
                .blDraft(Optional.ofNullable(request.getBlDraft()).orElse(""))
                .buyerLmePercentage(Optional.of(request.getBuyerLmePercentage()).orElse(0.0))
                .lmeFixedStatus(Optional.ofNullable(request.getLmeFixedStatus()).orElse(""))
                .buyerLmeRate(Optional.of(request.getBuyerLmeRate()).orElse(0.0))
                .buyerFinalRate(Optional.of(request.getBuyerFinalRate()).orElse(0.0))
                .buyerInvoiceValue(Optional.of(request.getBuyerInvoiceValue()).orElse(0.0))
                .amountCredited(Optional.of(request.getAmountCredited()).orElse(0.0))
                .balance(Optional.of(request.getBalance()).orElse(0.0))
                .additionalCharges(Optional.of(request.getAdditionalCharges()).orElse(0.0))
                .discount(Optional.of(request.getDiscount()).orElse(0.0))
                .buyerClaimAmount(Optional.of(request.getBuyerClaimAmount()).orElse(0.0))
                .blCourier(Optional.ofNullable(request.getBlCourier()).orElse(""))
                .blRequirement(Optional.ofNullable(request.getBlRequirement()).orElse(""))

                // Parsing dates safely
                .supplierPaymentDate(convertDateString(request.getSupplierPaymentDate()))
                .invoiceDate(convertDateString(request.getInvoiceDate()))
                .paymentCreditDate(convertDateString(request.getPaymentCreditDate()))
                .expectedDateOfDeparture(convertDateString(request.getExpectedDateOfDeparture()))
                .expectedDateOfArrival(convertDateString(request.getExpectedDateOfArrival()))
                .createdDate(convertDateString(request.getCreatedDate()))
                .updatedDate(convertDateString(request.getCreatedDate()))
                .updatedBy(request.getUpdatedBy())
                .build();

        shipmentRepository.save(details);
    }

    private LocalDateTime convertDateString(String dateString){
        if(dateString!=null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            return LocalDateTime.parse(dateString, formatter);
        }
        return null;
    }
}
