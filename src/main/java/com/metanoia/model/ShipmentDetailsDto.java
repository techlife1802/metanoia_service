package com.metanoia.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder
public class ShipmentDetailsDto {

    private String commodity;
    private String portOfLoading;
    private String destination;
    private String icd;
    private String forwarder;
    private String shippingLine;
    private String bookingNumber;
    private String emptyContainerReceived;
    private BigDecimal weight;
    private String loadingStatus;
    private String vgmFilled;
    private String customClearance;
    private String shippingBillFilled;
    private String baeReceived;
    private String containerStatus;
    private String BlInstructionFilled;
    private String draftGenerated;
    private String blDraftStatus;
    private String billLandingNumber;
    private String loadingPicsShared;

    //second level details
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

    private LocalDate createdDate;
    private LocalDate updatedDate;

}
