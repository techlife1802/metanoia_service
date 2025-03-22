package com.metanoia.service;

import com.metanoia.model.ShipmentDetails;
import com.metanoia.model.ShipmentDetailsUserRequest;
import com.metanoia.model.ShipmentEntryRequest;
import com.metanoia.model.User;
import com.metanoia.repository.ShipmentDetailsRepositoryCustom;
import com.metanoia.repository.ShipmentRepository;
import com.metanoia.repository.UserRepository;
import com.metanoia.util.MetanoiaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class ShipmentDetailsService {

    @Autowired
    private ShipmentDetailsRepositoryCustom shipmentDetailsRepositoryCustom;

    @Autowired
    ShipmentRepository shipmentRepository;

    @Autowired
    UserRepository userRepository;

    public List<ShipmentDetails> getShipmentEntriesSpecificColumns(ShipmentDetailsUserRequest request) {
        User userData = userRepository.findByUsername(request.getUser());
        if (userData != null && userData.getAccessLevel().equals("admin")) {
            return shipmentRepository.findAllByCreatedDateBetween(convertDateString(request.getStartDate()),convertDateString(request.getEndDate()));
        } else if (userData != null && userData.getUsername() != null) {
            return shipmentDetailsRepositoryCustom.findSpecificColumns(request.getUser(), convertDateString(request.getStartDate()),convertDateString(request.getEndDate()), request.getColumns().stream().map(col -> MetanoiaUtil.getColumnName(ShipmentDetails.class, col)).toList());
        } else {
            throw new RuntimeException("User not found"+request.getUser());
        }
    }

    public void updateShipment(ShipmentEntryRequest request) {
        Optional<ShipmentDetails> detailsOptional = shipmentRepository.findById(request.getId());
        if (detailsOptional.isPresent()) {
            ShipmentDetails details = detailsOptional.get();
            details.setCommodity(Optional.ofNullable(request.getCommodity()).orElse(""));
            details.setPortOfLoading(Optional.ofNullable(request.getPortOfLoading()).orElse(""));
            details.setDestination(Optional.ofNullable(request.getDestination()).orElse(""));
            details.setIcd(Optional.ofNullable(request.getIcd()).orElse(""));
            details.setForwarder(Optional.ofNullable(request.getForwarder()).orElse(""));
            details.setShippingLine(Optional.ofNullable(request.getShippingLine()).orElse(""));
            details.setBookingNumber(Optional.ofNullable(request.getBookingNumber()).orElse(""));
            details.setEmptyContainerReceived(Optional.ofNullable(request.getEmptyContainerReceived()).orElse(""));
            details.setWeight(Optional.ofNullable(request.getWeight()).orElse(BigDecimal.ZERO));
            details.setLoadingStatus(Optional.ofNullable(request.getLoadingStatus()).orElse(""));
            details.setVgmFilled(Optional.ofNullable(request.getVgmFilled()).orElse(Boolean.FALSE));
            details.setCustomClearance(Optional.ofNullable(request.getCustomClearance()).orElse(Boolean.FALSE));
            details.setShippingBillFilled(Optional.ofNullable(request.getShippingBillFilled()).orElse(Boolean.FALSE));
            details.setBaeReceived(Optional.ofNullable(request.getBaeReceived()).orElse(Boolean.FALSE));
            details.setContainerStatus(Optional.ofNullable(request.getContainerStatus()).orElse(""));
            details.setBlInstructionFilled(Optional.ofNullable(request.getBlInstructionFilled()).orElse(Boolean.FALSE));
            details.setDraftGenerated(Optional.ofNullable(request.getDraftGenerated()).orElse(Boolean.FALSE));
            details.setBlDraftStatus(Optional.ofNullable(request.getBlDraftStatus()).orElse(""));
            details.setBillLandingNumber(Optional.ofNullable(request.getBillLandingNumber()).orElse(0));
            details.setLoadingPicsShared(Optional.ofNullable(request.getLoadingPicsShared()).orElse(Boolean.FALSE));
            details.setFreightPaid(request.getFreightPaid());
            details.setSampleReportAvailable(request.getSampleReportAvailable());
            details.setLoadingPhotosShared(request.getLoadingPhotosShared());
            details.setSalesInvoiceShared(request.getSalesInvoiceShared());
            details.setInvoiceGenerated(request.getInvoiceGenerated());
            details.setBuyerClaimShortage(request.getBuyerClaimShortage());
            details.setBuyerClaimSettled(request.getBuyerClaimSettled());
            details.setSupplierClaim(request.getSupplierClaim());
            details.setSupplierClaimSettled(request.getSupplierClaimSettled());
            details.setMaterialStatus(Optional.ofNullable(request.getMaterialStatus()).orElse(""));
            details.setSupplierName(Optional.ofNullable(request.getSupplierName()).orElse(""));
            details.setSupplierLmePercentage(Optional.ofNullable(request.getSupplierLmePercentage()).orElse(0.0));
            details.setSupplierLmeRate(Optional.ofNullable(request.getSupplierLmeRate()).orElse(0.0));
            details.setSupplierFinalRate(Optional.ofNullable(request.getSupplierFinalRate()).orElse(0.0));
            details.setSupplierInvoiceValue(Optional.ofNullable(request.getSupplierInvoiceValue()).orElse(0.0));
            details.setSupplierPaymentTerms(Optional.ofNullable(request.getSupplierPaymentTerms()).orElse(""));
            details.setSupplierClaimAmount(Optional.ofNullable(request.getSupplierClaimAmount()).orElse(0.0));
            details.setBuyerName(Optional.ofNullable(request.getBuyerName()).orElse(""));
            details.setConsigneeName(Optional.ofNullable(request.getConsigneeName()).orElse(""));
            details.setQualityOfMaterial(Optional.ofNullable(request.getQualityOfMaterial()).orElse(""));
            details.setBlDraft(Optional.ofNullable(request.getBlDraft()).orElse(""));
            details.setBuyerLmePercentage(Optional.ofNullable(request.getBuyerLmePercentage()).orElse(0.0));
            details.setLmeFixedStatus(Optional.ofNullable(request.getLmeFixedStatus()).orElse(""));
            details.setBuyerLmeRate(Optional.ofNullable(request.getBuyerLmeRate()).orElse(0.0));
            details.setBuyerFinalRate(Optional.ofNullable(request.getBuyerFinalRate()).orElse(0.0));
            details.setBuyerInvoiceValue(Optional.ofNullable(request.getBuyerInvoiceValue()).orElse(0.0));
            details.setAmountCredited(Optional.ofNullable(request.getAmountCredited()).orElse(0.0));
            details.setBalance(Optional.ofNullable(request.getBalance()).orElse(0.0));
            details.setAdditionalCharges(Optional.ofNullable(request.getAdditionalCharges()).orElse(0.0));
            details.setDiscount(Optional.ofNullable(request.getDiscount()).orElse(0.0));
            details.setBuyerClaimAmount(Optional.ofNullable(request.getBuyerClaimAmount()).orElse(0.0));
            details.setBlCourier(Optional.ofNullable(request.getBlCourier()).orElse(Boolean.FALSE));
            details.setBlRequirement(Optional.ofNullable(request.getBlRequirement()).orElse(Boolean.FALSE));
            details.setSupplierPaymentDate(convertDateString(request.getSupplierPaymentDate()));
            details.setInvoiceDate(convertDateString(request.getInvoiceDate()));
            details.setPaymentCreditDate(convertDateString(request.getPaymentCreditDate()));
            details.setExpectedDateOfDeparture(convertDateString(request.getExpectedDateOfDeparture()));
            details.setExpectedDateOfArrival(convertDateString(request.getExpectedDateOfArrival()));
            details.setContainerNo(Optional.ofNullable(request.getContainerNo()).orElse(""));
            details.setSealNumber(Optional.ofNullable(request.getSealNumber()).orElse(""));
            details.setBlInstructionFilled(Optional.ofNullable(request.getBlInstructionFilled()).orElse(Boolean.FALSE));
            details.setUpdatedDate(convertDateString(request.getUpdatedDate()));
            details.setUpdatedBy(request.getUpdatedBy());
            shipmentRepository.save(details);
        } else {
            throw new RuntimeException("Shipment not found with id ::" + request.getId());
        }
    }

    public void saveShipment(ShipmentEntryRequest request) {
        ShipmentDetails details = ShipmentDetails.builder()
                .commodity(Optional.ofNullable(request).map(ShipmentEntryRequest::getCommodity).orElse(""))
                .portOfLoading(Optional.ofNullable(request).map(ShipmentEntryRequest::getPortOfLoading).orElse(""))
                .destination(Optional.ofNullable(request).map(ShipmentEntryRequest::getDestination).orElse(""))
                .icd(Optional.ofNullable(request).map(ShipmentEntryRequest::getIcd).orElse(""))
                .forwarder(Optional.ofNullable(request).map(ShipmentEntryRequest::getForwarder).orElse(""))
                .shippingLine(Optional.ofNullable(request).map(ShipmentEntryRequest::getShippingLine).orElse(""))
                .bookingNumber(Optional.ofNullable(request).map(ShipmentEntryRequest::getBookingNumber).orElse(""))
                .emptyContainerReceived(Optional.ofNullable(request).map(ShipmentEntryRequest::getEmptyContainerReceived).orElse(""))
                .weight(Optional.ofNullable(request).map(ShipmentEntryRequest::getWeight).orElse(BigDecimal.ZERO))
                .loadingStatus(Optional.ofNullable(request).map(ShipmentEntryRequest::getLoadingStatus).orElse(""))
                .vgmFilled(Optional.ofNullable(request).map(ShipmentEntryRequest::getVgmFilled).orElse(Boolean.FALSE))
                .customClearance(Optional.ofNullable(request).map(ShipmentEntryRequest::getCustomClearance).orElse(Boolean.FALSE))
                .shippingBillFilled(Optional.ofNullable(request).map(ShipmentEntryRequest::getShippingBillFilled).orElse(Boolean.FALSE))
                .baeReceived(Optional.ofNullable(request).map(ShipmentEntryRequest::getBaeReceived).orElse(Boolean.FALSE))
                .containerStatus(Optional.ofNullable(request).map(ShipmentEntryRequest::getContainerStatus).orElse(""))
                .blInstructionFilled(Optional.ofNullable(request).map(ShipmentEntryRequest::getBlInstructionFilled).orElse(Boolean.FALSE))
                .draftGenerated(Optional.ofNullable(request).map(ShipmentEntryRequest::getDraftGenerated).orElse(Boolean.FALSE))
                .blDraftStatus(Optional.ofNullable(request).map(ShipmentEntryRequest::getBlDraftStatus).orElse(""))
                .containerNo(Optional.ofNullable(request).map(ShipmentEntryRequest::getContainerNo).orElse(""))
                .sealNumber(Optional.ofNullable(request).map(ShipmentEntryRequest::getSealNumber).orElse(""))
                .paymentCredited(Optional.ofNullable(request).map(ShipmentEntryRequest::getPaymentCredited).orElse(Boolean.FALSE))
                .billLandingNumber(Optional.ofNullable(request).map(ShipmentEntryRequest::getBillLandingNumber).orElse(0))
                .loadingPicsShared(Optional.ofNullable(request).map(ShipmentEntryRequest::getLoadingPicsShared).orElse(Boolean.FALSE))

                // Primitive types with default values
                .freightPaid(Optional.ofNullable(request).map(ShipmentEntryRequest::getFreightPaid).orElse(false))
                .sampleReportAvailable(Optional.ofNullable(request).map(ShipmentEntryRequest::getSampleReportAvailable).orElse(false))
                .loadingPhotosShared(Optional.ofNullable(request).map(ShipmentEntryRequest::getLoadingPhotosShared).orElse(false))
                .salesInvoiceShared(Optional.ofNullable(request).map(ShipmentEntryRequest::getSalesInvoiceShared).orElse(false))
                .invoiceGenerated(Optional.ofNullable(request).map(ShipmentEntryRequest::getInvoiceGenerated).orElse(false))
                .buyerClaimShortage(Optional.ofNullable(request).map(ShipmentEntryRequest::getBuyerClaimShortage).orElse(false))
                .buyerClaimSettled(Optional.ofNullable(request).map(ShipmentEntryRequest::getBuyerClaimSettled).orElse(false))
                .supplierClaim(Optional.ofNullable(request).map(ShipmentEntryRequest::getSupplierClaim).orElse(false))
                .supplierClaimSettled(Optional.ofNullable(request).map(ShipmentEntryRequest::getSupplierClaimSettled).orElse(false))

                // Handling null for Strings and numeric values
                .materialStatus(Optional.ofNullable(request).map(ShipmentEntryRequest::getMaterialStatus).orElse(""))
                .supplierName(Optional.ofNullable(request).map(ShipmentEntryRequest::getSupplierName).orElse(""))
                .supplierLmePercentage(Optional.ofNullable(request).map(ShipmentEntryRequest::getSupplierLmePercentage).orElse(0.0))
                .supplierLmeRate(Optional.ofNullable(request).map(ShipmentEntryRequest::getSupplierLmeRate).orElse(0.0))
                .supplierFinalRate(Optional.ofNullable(request).map(ShipmentEntryRequest::getSupplierFinalRate).orElse(0.0))
                .supplierInvoiceValue(Optional.ofNullable(request).map(ShipmentEntryRequest::getSupplierInvoiceValue).orElse(0.0))
                .supplierPaymentTerms(Optional.ofNullable(request).map(ShipmentEntryRequest::getSupplierPaymentTerms).orElse(""))
                .supplierClaimAmount(Optional.ofNullable(request).map(ShipmentEntryRequest::getSupplierClaimAmount).orElse(0.0))
                .buyerName(Optional.ofNullable(request).map(ShipmentEntryRequest::getBuyerName).orElse(""))
                .consigneeName(Optional.ofNullable(request).map(ShipmentEntryRequest::getConsigneeName).orElse(""))
                .qualityOfMaterial(Optional.ofNullable(request).map(ShipmentEntryRequest::getQualityOfMaterial).orElse(""))
                .blDraft(Optional.ofNullable(request).map(ShipmentEntryRequest::getBlDraft).orElse(""))
                .buyerLmePercentage(Optional.ofNullable(request).map(ShipmentEntryRequest::getBuyerLmePercentage).orElse(0.0))
                .lmeFixedStatus(Optional.ofNullable(request).map(ShipmentEntryRequest::getLmeFixedStatus).orElse(""))
                .buyerLmeRate(Optional.ofNullable(request).map(ShipmentEntryRequest::getBuyerLmeRate).orElse(0.0))
                .buyerFinalRate(Optional.ofNullable(request).map(ShipmentEntryRequest::getBuyerFinalRate).orElse(0.0))
                .buyerInvoiceValue(Optional.ofNullable(request).map(ShipmentEntryRequest::getBuyerInvoiceValue).orElse(0.0))
                .amountCredited(Optional.ofNullable(request).map(ShipmentEntryRequest::getAmountCredited).orElse(0.0))
                .balance(Optional.ofNullable(request).map(ShipmentEntryRequest::getBalance).orElse(0.0))
                .additionalCharges(Optional.ofNullable(request).map(ShipmentEntryRequest::getAdditionalCharges).orElse(0.0))
                .discount(Optional.ofNullable(request).map(ShipmentEntryRequest::getDiscount).orElse(0.0))
                .buyerClaimAmount(Optional.ofNullable(request).map(ShipmentEntryRequest::getBuyerClaimAmount).orElse(0.0))
                .blCourier(Optional.ofNullable(request).map(ShipmentEntryRequest::getBlCourier).orElse(Boolean.FALSE))
                .blRequirement(Optional.ofNullable(request).map(ShipmentEntryRequest::getBlRequirement).orElse(Boolean.FALSE))

                // Parsing dates safely
                .supplierPaymentDate(convertDateString(Optional.ofNullable(request).map(ShipmentEntryRequest::getSupplierPaymentDate).orElse(null)))
                .invoiceDate(convertDateString(Optional.ofNullable(request).map(ShipmentEntryRequest::getInvoiceDate).orElse(null)))
                .paymentCreditDate(convertDateString(Optional.ofNullable(request).map(ShipmentEntryRequest::getPaymentCreditDate).orElse(null)))
                .expectedDateOfDeparture(convertDateString(Optional.ofNullable(request).map(ShipmentEntryRequest::getExpectedDateOfDeparture).orElse(null)))
                .expectedDateOfArrival(convertDateString(Optional.ofNullable(request).map(ShipmentEntryRequest::getExpectedDateOfArrival).orElse(null)))
                .createdDate(convertDateString(Optional.ofNullable(request).map(ShipmentEntryRequest::getCreatedDate).orElse(null)))
                .updatedDate(convertDateString(Optional.ofNullable(request).map(ShipmentEntryRequest::getCreatedDate).orElse(null)))
                .updatedBy(Optional.ofNullable(request).map(ShipmentEntryRequest::getUpdatedBy).orElse(null))
                .createdBy(Optional.ofNullable(request).map(ShipmentEntryRequest::getCreatedBy).orElse(null))
                .build();

        shipmentRepository.save(details);
    }

    private LocalDateTime convertDateString(String dateString) {
        if (dateString != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            return LocalDateTime.parse(dateString, formatter);
        }
        return null;
    }
}
