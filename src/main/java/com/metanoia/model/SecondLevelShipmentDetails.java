package com.metanoia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
//@Table(name = "second_level_shipment_details")
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class SecondLevelShipmentDetails {
        private String commodity;
        private String portOfLoading;
        private String containerNo;
        private String destination;
        private String icd;
        private String shippingLine;
        private double weight;
        private String loadingStatus;
        private String containerStatus;
        private String blDraftStatus;
        private String billLandingNumber;
        private boolean loadingPicsShared;
        private boolean freightPaid;
        private String materialStatus;
        private String supplierName;
        private double supplierLmePercentage;
        private double supplierLmeRate;
        private double supplierFinalRate;
        private double supplierInvoiceValue;
        private String supplierPaymentTerms;
        private String supplierPaymentDate;
        private boolean supplierClaim;
        private boolean supplierClaimSettled;
        private double supplierClaimAmount;
        private String buyerName;
        private String consigneeName;
        private String qualityOfMaterial;
        private boolean sampleReportAvailable;
        private String blDraft;
        private boolean loadingPhotosShared;
        private double buyerLmePercentage;
        private String lmeFixedStatus;
        private boolean invoiceGenerated;
        private String invoiceDate;
        private double buyerLmeRate;
        private double buyerFinalRate;
        private double buyerInvoiceValue;
        private double amountCredited;
        private double balance;
        private double additionalCharges;
        private double discount;
        private boolean salesInvoiceShared;
        private String paymentCreditDate;
        private String expectedDateOfDeparture;
        private String blCourier;
        private String blRequirement;
        private String expectedDateOfArrival;
        private boolean buyerClaimShortage;
        private boolean buyerClaimSettled;
        private double buyerClaimAmount;

        // Getters and Setters for each attribute
        // Constructors, toString(), and other methods as needed
}

