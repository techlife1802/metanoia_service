package com.metanoia.repository;

import com.metanoia.model.ShipmentDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ShipmentDetailsRepositoryCustom {

    @Autowired
    private EntityManager entityManager;

    /**
     * Dynamically fetches specific columns from the 'shipment_details' table and maps them to a list of
     * ShipmentDetails objects, where only the requested columns are populated.
     *
     * @param columnNames List of column names to fetch from the database.
     * @return A list of ShipmentDetails objects with only the requested columns populated.
     */
    public List<ShipmentDetails> findSpecificColumns(String user, LocalDateTime startDate, LocalDateTime endDate, List<String> columnNames) {
        // Build the dynamic SQL query to select the requested columns


        StringBuilder sql = new StringBuilder("SELECT ");
        sql.append("id, ");

        // Append each column to the SELECT part of the SQL query
        for (int i = 0; i < columnNames.size(); i++) {
            sql.append(columnNames.get(i));
            if (i < columnNames.size() - 1) {
                sql.append(", ");
            }
        }
        sql.append(" FROM shipment_details WHERE created_by = :user AND created_date BETWEEN :startDate AND :endDate");

        // Execute the native query
        Query query = entityManager.createNativeQuery(sql.toString());
        query.setParameter("user", user);
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);

        // Get the result list as Object arrays (each row is an Object[])
        List<Object[]> results = query.getResultList();

        // List to hold the mapped ShipmentDetails objects
        List<ShipmentDetails> shipmentDetailsList = new ArrayList<>();

        // Loop over each result row and map it to ShipmentDetails
        for (Object[] row : results) {
            ShipmentDetails shipmentDetails = new ShipmentDetails();
            shipmentDetails.setId(row[0].toString());
            // Map each row to the corresponding fields in ShipmentDetails
            for (int i = 0; i < columnNames.size(); i++) {
                String columnName = columnNames.get(i);
                Object value = row[i + 1];

                // Map the values to the correct field in ShipmentDetails based on column name
                mapValueToField(shipmentDetails, columnName, value);
            }

            // Add the mapped object to the result list
            shipmentDetailsList.add(shipmentDetails);
        }

        return shipmentDetailsList;
    }

    /**
     * Helper method to map the database column value to the corresponding field in the ShipmentDetails object.
     *
     * @param shipmentDetails The ShipmentDetails object to map the value to.
     * @param columnName      The column name from the query result.
     * @param value           The value from the query result.
     */
    private void mapValueToField(ShipmentDetails shipmentDetails, String columnName, Object value) {
        switch (columnName) {
            case "id":
                shipmentDetails.setId((String) value);
                break;
            case "seal_number":
                shipmentDetails.setSealNumber((String) value);
                break;
            case "bl_instruction_filled":
                shipmentDetails.setBlInstructionFilled(value != null ? Boolean.parseBoolean(value.toString()) : null);
                break;
            case "additional_charges":
                shipmentDetails.setAdditionalCharges(value != null ? Double.parseDouble(value.toString()) : null);
                break;
            case "amount_credited":
                shipmentDetails.setAmountCredited(value != null ? Double.parseDouble(value.toString()) : null);
                break;
            case "bae_received":
                shipmentDetails.setBaeReceived(value != null ? Boolean.parseBoolean(value.toString()) : null);
                break;
            case "balance":
                shipmentDetails.setBalance(value != null ? Double.parseDouble(value.toString()) : null);
                break;
            case "bill_landing_number":
                shipmentDetails.setBillLandingNumber(value != null ? Integer.parseInt(value.toString()) : null);
                break;
            case "bl_courier":
                shipmentDetails.setBlCourier(value != null ? Boolean.parseBoolean(value.toString()) : null);
                break;
            case "bl_draft":
                shipmentDetails.setBlDraft((String) value);
                break;
            case "bl_draft_status":
                shipmentDetails.setBlDraftStatus((String) value);
                break;
            case "bl_requirement":
                shipmentDetails.setBlRequirement(value != null ? Boolean.parseBoolean(value.toString()) : null);
                break;
            case "booking_number":
                shipmentDetails.setBookingNumber((String) value);
                break;
            case "buyer_claim_amount":
                shipmentDetails.setBuyerClaimAmount(value != null ? Double.parseDouble(value.toString()) : null);
                break;
            case "buyer_claim_settled":
                shipmentDetails.setBuyerClaimSettled(value != null ? Boolean.parseBoolean(value.toString()) : null);
                break;
            case "buyer_claim_shortage":
                shipmentDetails.setBuyerClaimShortage(value != null ? Boolean.parseBoolean(value.toString()) : null);
                break;
            case "buyer_final_rate":
                shipmentDetails.setBuyerFinalRate(value != null ? Double.parseDouble(value.toString()) : null);
                break;
            case "buyer_invoice_value":
                shipmentDetails.setBuyerInvoiceValue(value != null ? Double.parseDouble(value.toString()) : null);
                break;
            case "buyer_lme_percentage":
                shipmentDetails.setBuyerLmePercentage(value != null ? Double.parseDouble(value.toString()) : null);
                break;
            case "buyer_lme_rate":
                shipmentDetails.setBuyerLmeRate(value != null ? Double.parseDouble(value.toString()) : null);
                break;
            case "buyer_name":
                shipmentDetails.setBuyerName((String) value);
                break;
            case "commodity":
                shipmentDetails.setCommodity((String) value);
                break;
            case "consignee_name":
                shipmentDetails.setConsigneeName((String) value);
                break;
            case "container_status":
                shipmentDetails.setContainerStatus((String) value);
                break;
            case "created_date":
                shipmentDetails.setCreatedDate(value != null ? ((Timestamp) value).toLocalDateTime() : null);
                break;
            case "custom_clearance":
                shipmentDetails.setCustomClearance(value != null ? Boolean.parseBoolean(value.toString()) : null);
                break;
            case "destination":
                shipmentDetails.setDestination((String) value);
                break;
            case "discount":
                shipmentDetails.setDiscount(value != null ? Double.parseDouble(value.toString()) : null);
                break;
            case "draft_generated":
                shipmentDetails.setDraftGenerated(value != null ? Boolean.parseBoolean(value.toString()) : null);
                break;
            case "empty_container_received":
                shipmentDetails.setEmptyContainerReceived((String) value);
                break;
            case "expected_date_of_arrival":
                shipmentDetails.setExpectedDateOfArrival(value != null ? ((Timestamp) value).toLocalDateTime() : null);
                break;
            case "expected_date_of_departure":
                shipmentDetails.setExpectedDateOfDeparture(value != null ? ((Timestamp) value).toLocalDateTime() : null);
                break;
            case "forwarder":
                shipmentDetails.setForwarder((String) value);
                break;
            case "freight_paid":
                shipmentDetails.setFreightPaid(value != null ? Boolean.parseBoolean(value.toString()) : null);
                break;
            case "icd":
                shipmentDetails.setIcd((String) value);
                break;
            case "invoice_date":
                shipmentDetails.setInvoiceDate(value != null ? ((Timestamp) value).toLocalDateTime() : null);
                break;
            case "invoice_generated":
                shipmentDetails.setInvoiceGenerated(value != null ? Boolean.parseBoolean(value.toString()) : null);
                break;
            case "lme_fixed_status":
                shipmentDetails.setLmeFixedStatus((String) value);
                break;
            case "loading_photos_shared":
                shipmentDetails.setLoadingPhotosShared(value != null ? Boolean.parseBoolean(value.toString()) : null);
                break;
            case "loading_pics_shared":
                shipmentDetails.setLoadingPicsShared(value != null ? Boolean.parseBoolean(value.toString()) : null);
                break;
            case "loading_status":
                shipmentDetails.setLoadingStatus((String) value);
                break;
            case "material_status":
                shipmentDetails.setMaterialStatus((String) value);
                break;
            case "payment_credit_date":
                shipmentDetails.setPaymentCreditDate(value != null ? ((Timestamp) value).toLocalDateTime() : null);
                break;
            case "port_of_loading":
                shipmentDetails.setPortOfLoading((String) value);
                break;
            case "quality_of_material":
                shipmentDetails.setQualityOfMaterial((String) value);
                break;
            case "sales_invoice_shared":
                shipmentDetails.setSalesInvoiceShared(value != null ? Boolean.parseBoolean(value.toString()) : null);
                break;
            case "sample_report_available":
                shipmentDetails.setSampleReportAvailable(value != null ? Boolean.parseBoolean(value.toString()) : null);
                break;
            case "shipping_bill_filled":
                shipmentDetails.setShippingBillFilled(value != null ? Boolean.parseBoolean(value.toString()):null);
                break;
            case "shipping_line":
                shipmentDetails.setShippingLine((String) value);
                break;
            case "supplier_claim":
                shipmentDetails.setSupplierClaim(value != null ? Boolean.parseBoolean(value.toString()) : null);
                break;
            case "supplier_claim_amount":
                shipmentDetails.setSupplierClaimAmount(value != null ? Double.parseDouble(value.toString()) : null);
                break;
            case "supplier_claim_settled":
                shipmentDetails.setSupplierClaimSettled(value != null ? Boolean.parseBoolean(value.toString()) : null);
                break;
            case "supplier_final_rate":
                shipmentDetails.setSupplierFinalRate(value != null ? Double.parseDouble(value.toString()) : null);
                break;
            case "supplier_invoice_value":
                shipmentDetails.setSupplierInvoiceValue(value != null ? Double.parseDouble(value.toString()) : null);
                break;
            case "supplier_lme_percentage":
                shipmentDetails.setSupplierLmePercentage(value != null ? Double.parseDouble(value.toString()) : null);
                break;
            case "supplier_lme_rate":
                shipmentDetails.setSupplierLmeRate(value != null ? Double.parseDouble(value.toString()) : null);
                break;
            case "supplier_name":
                shipmentDetails.setSupplierName((String) value);
                break;
            case "supplier_payment_date":
                shipmentDetails.setSupplierPaymentDate(value != null ? ((Timestamp) value).toLocalDateTime() : null);
                break;
            case "supplier_payment_terms":
                shipmentDetails.setSupplierPaymentTerms((String) value);
                break;
            case "updated_date":
                shipmentDetails.setUpdatedDate(value != null ? ((Timestamp) value).toLocalDateTime() : null);
                break;
            case "vgm_filled":
                shipmentDetails.setVgmFilled(value != null ? Boolean.parseBoolean(value.toString()) : null);
                break;
            case "container_no":
                shipmentDetails.setContainerNo((String) value);
                break;
            case "weight":
                shipmentDetails.setWeight(value != null ? new BigDecimal(value.toString()) : null);
                break;
            case "payment_credited":
                shipmentDetails.setPaymentCredited(value != null ? Boolean.parseBoolean(value.toString()) : null);
            case "updated_by":
                shipmentDetails.setUpdatedBy((String) value);
                break;
            case "created_by":
                shipmentDetails.setCreatedBy((String) value);
                break;
            default:
                throw new IllegalArgumentException("Unknown column: " + columnName);
        }
    }
}
