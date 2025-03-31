package com.metanoia.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "shipment_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShipmentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "commodity")
    private String commodity;

    @Column(name = "port_of_loading")
    private String portOfLoading;

    @Column(name = "container_no")
    private String containerNo;

    @Column(name = "destination")
    private String destination;

    @Column(name = "icd")
    private String icd;

    @Column(name = "forwarder")
    private String forwarder;

    @Column(name = "shipping_line")
    private String shippingLine;

    @Column(name = "booking_number")
    private String bookingNumber;

    @Column(name = "seal_number")
    private String sealNumber;

    @Column(name = "empty_container_received")
    private Boolean emptyContainerReceived;

    @Column(name = "weight")
    private BigDecimal weight;

    @Column(name = "loading_status")
    private String loadingStatus;

    @Column(name = "vgm_filled")
    private Boolean vgmFilled;

    @Column(name = "custom_clearance")
    private Boolean customClearance;

    @Column(name = "shipping_bill_filled")
    private Boolean shippingBillFilled;

    @Column(name = "bae_received")
    private Boolean baeReceived;

    @Column(name = "container_status")
    private String containerStatus;

    @Column(name = "bl_instruction_filled")
    private Boolean blInstructionFilled;

    @Column(name = "draft_generated")
    private Boolean draftGenerated;

    @Column(name = "bl_draft_status")
    private String blDraftStatus;

    @Column(name = "bill_landing_number")
    private Integer billLandingNumber;

    @Column(name = "loading_pics_shared")
    private Boolean loadingPicsShared;

    // Second-level details
    @Column(name = "freight_paid")
    private Boolean freightPaid;

    @Column(name = "material_status")
    private String materialStatus;

    @Column(name = "supplier_name")
    private String supplierName;

    @Column(name = "supplier_lme_percentage")
    private Double supplierLmePercentage;

    @Column(name = "supplier_lme_rate")
    private Double supplierLmeRate;

    @Column(name = "supplier_final_rate")
    private Double supplierFinalRate;

    @Column(name = "supplier_invoice_value")
    private Double supplierInvoiceValue;

    @Column(name = "supplier_payment_terms")
    private String supplierPaymentTerms;

    @Column(name = "supplier_payment_date")
    private LocalDateTime supplierPaymentDate;

    @Column(name = "supplier_claim")
    private Boolean supplierClaim;

    @Column(name = "supplier_claim_settled")
    private Boolean supplierClaimSettled;

    @Column(name = "supplier_claim_amount")
    private Double supplierClaimAmount;

    @Column(name = "buyer_name")
    private String buyerName;

    @Column(name = "consignee_name")
    private String consigneeName;

    @Column(name = "quality_of_material")
    private String qualityOfMaterial;

    @Column(name = "sample_report_available")
    private Boolean sampleReportAvailable;

    @Column(name = "bl_draft")
    private String blDraft;

    @Column(name = "loading_photos_shared")
    private Boolean loadingPhotosShared;

    @Column(name = "buyer_lme_percentage")
    private Double buyerLmePercentage;

    @Column(name = "lme_fixed_status")
    private String lmeFixedStatus;

    @Column(name = "invoice_generated")
    private Boolean invoiceGenerated;

    @Column(name = "invoice_date")
    private LocalDateTime invoiceDate;

    @Column(name = "buyer_lme_rate")
    private Double buyerLmeRate;

    @Column(name = "buyer_final_rate")
    private Double buyerFinalRate;

    @Column(name = "buyer_invoice_value")
    private Double buyerInvoiceValue;

    @Column(name = "amount_credited")
    private Double amountCredited;

    @Column(name = "balance")
    private Double balance;

    @Column(name = "additional_charges")
    private Double additionalCharges;

    @Column(name = "discount")
    private Double discount;

    @Column(name = "sales_invoice_shared")
    private Boolean salesInvoiceShared;

    @Column(name = "payment_credit_date")
    private LocalDateTime paymentCreditDate;

    @Column(name = "expected_date_of_departure")
    private LocalDateTime expectedDateOfDeparture;

    @Column(name = "bl_courier")
    private Boolean blCourier;

    @Column(name = "bl_requirement")
    private Boolean blRequirement;

    @Column(name = "expected_date_of_arrival")
    private LocalDateTime expectedDateOfArrival;

    @Column(name = "buyer_claim_shortage")
    private Boolean buyerClaimShortage;

    @Column(name = "buyer_claim_settled")
    private Boolean buyerClaimSettled;

    @Column(name = "buyer_claim_amount")
    private Double buyerClaimAmount;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "payment_credited")
    private Boolean paymentCredited;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "created_by")
    private String createdBy;

}
