package com.metanoia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "shipment_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String commodity;

    @Column(name = "port_of_loading")
    private String portOfLoading;

    private String destination;

    @Column(name = "icd")
    private String icd;

    private String forwarder;

    @Column(name = "shipping_line")
    private String shippingLine;

    @Column(name = "booking_number")
    private String bookingNumber;

    @Column(name = "empty_container_received")
    private String emptyContainerReceived;

    private BigDecimal weight;

    @Column(name = "loading_status")
    private String loadingStatus;

    @Column(name = "vgm_filled")
    private String vgmFilled;

    @Column(name = "custom_clearance")
    private String customClearance;

    @Column(name = "shipping_bill_filled")
    private String shippingBillFilled;

    @Column(name = "bae_received")
    private String baeReceived;

    @Column(name = "container_status")
    private String containerStatus;

    @Column(name = "bl_instruction_filled")
    private String BlInstructionFilled;

    @Column(name = "draft_generated")
    private String draftGenerated;

    @Column(name = "bl_draft_status")
    private String blDraftStatus;

    @Column(name = "bill_landing_number")
    private String billLandingNumber;

    @Column(name = "loading_pics_shared")
    private String loadingPicsShared;

    // Second-level details
    @Column(name = "freight_paid")
    private boolean freightPaid;

    @Column(name = "material_status")
    private String materialStatus;

    @Column(name = "supplier_name")
    private String supplierName;

    @Column(name = "supplier_lme_percentage")
    private double supplierLmePercentage;

    @Column(name = "supplier_lme_rate")
    private double supplierLmeRate;

    @Column(name = "supplier_final_rate")
    private double supplierFinalRate;

    @Column(name = "supplier_invoice_value")
    private double supplierInvoiceValue;

    @Column(name = "supplier_payment_terms")
    private String supplierPaymentTerms;

    @Column(name = "supplier_payment_date")
    private LocalDate supplierPaymentDate;

    @Column(name = "supplier_claim")
    private boolean supplierClaim;

    @Column(name = "supplier_claim_settled")
    private boolean supplierClaimSettled;

    @Column(name = "supplier_claim_amount")
    private double supplierClaimAmount;

    @Column(name = "buyer_name")
    private String buyerName;

    @Column(name = "consignee_name")
    private String consigneeName;

    @Column(name = "quality_of_material")
    private String qualityOfMaterial;

    @Column(name = "sample_report_available")
    private boolean sampleReportAvailable;

    @Column(name = "bl_draft")
    private String blDraft;

    @Column(name = "loading_photos_shared")
    private boolean loadingPhotosShared;

    @Column(name = "buyer_lme_percentage")
    private double buyerLmePercentage;

    @Column(name = "lme_fixed_status")
    private String lmeFixedStatus;

    @Column(name = "invoice_generated")
    private boolean invoiceGenerated;

    @Column(name = "invoice_date")
    private LocalDate invoiceDate;

    @Column(name = "buyer_lme_rate")
    private double buyerLmeRate;

    @Column(name = "buyer_final_rate")
    private double buyerFinalRate;

    @Column(name = "buyer_invoice_value")
    private double buyerInvoiceValue;

    @Column(name = "amount_credited")
    private double amountCredited;

    @Column(name = "balance")
    private double balance;

    @Column(name = "additional_charges")
    private double additionalCharges;

    @Column(name = "discount")
    private double discount;

    @Column(name = "sales_invoice_shared")
    private boolean salesInvoiceShared;

    @Column(name = "payment_credit_date")
    private LocalDate paymentCreditDate;

    @Column(name = "expected_date_of_departure")
    private LocalDate expectedDateOfDeparture;

    @Column(name = "bl_courier")
    private String blCourier;

    @Column(name = "bl_requirement")
    private String blRequirement;

    @Column(name = "expected_date_of_arrival")
    private LocalDate expectedDateOfArrival;

    @Column(name = "buyer_claim_shortage")
    private boolean buyerClaimShortage;

    @Column(name = "buyer_claim_settled")
    private boolean buyerClaimSettled;

    @Column(name = "buyer_claim_amount")
    private double buyerClaimAmount;

    @Column(name = "created_date")
    private LocalDate createdDate;

    @Column(name = "updated_date")
    private LocalDate updatedDate;

    @Column(name = "updated_by")
    private String updatedBy;

}
