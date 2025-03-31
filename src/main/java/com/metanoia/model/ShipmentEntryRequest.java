package com.metanoia.model;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ShipmentEntryRequest {

    private String id;
    private String commodity;
    private String portOfLoading;
    private String destination;
    private String icd;
    private String forwarder;
    private String shippingLine;
    private String bookingNumber;
    private Boolean emptyContainerReceived;
    private BigDecimal weight;
    private String loadingStatus;
    private Boolean vgmFilled;
    private Boolean customClearance;
    private Boolean shippingBillFilled;
    private Boolean baeReceived;
    private String containerStatus;
    private Boolean draftGenerated;
    private String blDraftStatus;
    private Integer billLandingNumber;
    private Boolean loadingPicsShared;
    private String containerNo;
    private String sealNumber;
    private Boolean blInstructionFilled;
    private Boolean paymentCredited;

    //second level details
    private Boolean freightPaid;
    private String materialStatus;
    private String supplierName;
    private Double supplierLmePercentage;
    private Double supplierLmeRate;
    private Double supplierFinalRate;
    private Double supplierInvoiceValue;
    private String supplierPaymentTerms;
    private String supplierPaymentDate;
    private Boolean supplierClaim;
    private Boolean supplierClaimSettled;
    private Double supplierClaimAmount;
    private String buyerName;
    private String consigneeName;
    private String qualityOfMaterial;
    private Boolean sampleReportAvailable;
    private String blDraft;
    private Boolean loadingPhotosShared;
    private Double buyerLmePercentage;
    private String lmeFixedStatus;
    private Boolean invoiceGenerated;
    private String invoiceDate;
    private Double buyerLmeRate;
    private Double buyerFinalRate;
    private Double buyerInvoiceValue;
    private Double amountCredited;
    private Double balance;
    private Double additionalCharges;
    private Double discount;
    private Boolean salesInvoiceShared;
    private String paymentCreditDate;
    private String expectedDateOfDeparture;
    private Boolean blCourier;
    private Boolean blRequirement;
    private String expectedDateOfArrival;
    private Boolean buyerClaimShortage;
    private Boolean buyerClaimSettled;
    private Double buyerClaimAmount;

    private String createdDate;
    private String updatedDate;
    private String updatedBy;
    private String createdBy;

}
