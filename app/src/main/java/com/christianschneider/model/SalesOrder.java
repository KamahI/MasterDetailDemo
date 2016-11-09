
package com.christianschneider.model;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * SalesOrder object structured to match the Northwind OData service
 * <p></p>
 * The EntityType Name for the Northwind service we are using is "Products"
 * <p></p>
 * In this URL: <a href="http://services.odata.org/V2/Northwind/Northwind.svc/Products?$orderby=ProductID" target=_blank>
 * http://services.odata.org/V2/Northwind/Northwind.svc/Products?$orderby=ProductID </a>
 * <ul>
 * <li>Products is the EntityType Name</li>
 * <li>?$orderby=ProductID returns the data sorted by that field. </li>
 * <li>You could use ?$orderby=ProductName so that all results are returned in alphabetical order</li>
 * </ul>
 * <p></p>
 * To find the EntityType name, get the service metadata:
 * <ul>
 * <li><a href="http://services.odata.org/V2/Northwind/Northwind.svc/$metadata" target=_blank> http://services.odata.org/V2/Northwind/Northwind.svc/$metadata </a></li>
 * <li>Then look for &lt;EntityType Name = "xyz" &gt;</li>
 * </ul>
 */

public class SalesOrder {
    private final String TAG = this.getClass().getSimpleName();

    // Fields from Northwind OData SalesOrder Collection
    public String salesOrderId;
    private String note;
    private String noteLanguage;
    private String customerId;
    private String customerName;
    private String currencyCode;
    private String grossAmount;
    private String netAmount;
    private String taxAmount;
    private String lifecycleStatus;
    private String lifecycleStatusDescription;
    private String billingStatus;
    private String billingStatusDescription;
    private String deliveryStatus;
    private String deliveryStatusDescription;
    private String createdAt;
    private String changedAt;
    private List<SalesOrderItem> salesOrderItems;


    /**
     * Helper method to log the attributes of a SalesOrder object
     */
    private void logSalesOrderContents() {
        String str = ("Sales Order ID: " + this.salesOrderId);
        str = str.concat(", Note = " + this.note);
        str = str.concat(", Note Language = " + this.noteLanguage);
        str = str.concat(", Customer ID = " + this.customerId);
        str = str.concat(", Customer Name = " + this.customerName);
        str = str.concat(", Currency Code = " + this.currencyCode);
        str = str.concat(", Gross Amount = " + this.grossAmount);
        str = str.concat(", Net Amount = " + this.netAmount);
        str = str.concat(", Tax Amount = " + this.taxAmount);
        str = str.concat(", Life STatus = " + this.lifecycleStatus);
        str = str.concat(", Life Descr = " + this.lifecycleStatusDescription);
        str = str.concat(", Bill Status = " + this.billingStatus);
        str = str.concat(", Bill Desc = " + this.billingStatusDescription);
        str = str.concat(", Deliv STatus = " + this.deliveryStatus);
        str = str.concat(", Deliv Desc = " + this.deliveryStatusDescription);
        str = str.concat(", Created At = " + this.createdAt);
        str = str.concat(", Changed AT = " + this.changedAt);
        Log.d(TAG, str);
    }


    /**
     * Helper method too log all elements of an ArrayList of Products.
     */

    public static void logSalesOrderArrayList(ArrayList<SalesOrder> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.get(i).logSalesOrderContents();
        }

    }

    /**
     * Constructor used in the {@link SalesOrderDataSingleton#getSalesOrderSets()} method}
     *
     * @param salesOrderId
     */
    public SalesOrder(String salesOrderId) {
        super();
        this.salesOrderId = salesOrderId;
    }


    //Getter and Setter methods


    public List<SalesOrderItem> getSalesOrderItems() {
        return salesOrderItems;
    }

    public void setSalesOrderItems(List<SalesOrderItem> salesOrderItems) {
        this.salesOrderItems = salesOrderItems;
    }

    public void setSalesOrderId(String salesOrderId) {
        this.salesOrderId = salesOrderId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNoteLanguage() {
        return noteLanguage;
    }

    public void setNoteLanguage(String noteLanguage) {
        this.noteLanguage = noteLanguage;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getGrossAmount() {
        return grossAmount;
    }

    public void setGrossAmount(String grossAmount) {
        this.grossAmount = grossAmount;
    }

    public String getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(String netAmount) {
        this.netAmount = netAmount;
    }

    public String getLifecycleStatus() {
        return lifecycleStatus;
    }

    public void setLifecycleStatus(String lifecycleStatus) {
        this.lifecycleStatus = lifecycleStatus;
    }

    public String getBillingStatus() {
        return billingStatus;
    }

    public void setBillingStatus(String billingStatus) {
        this.billingStatus = billingStatus;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSalesOrderId() {
        return salesOrderId;
    }

    public String getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(String taxAmount) {
        this.taxAmount = taxAmount;
    }

    public String getLifecycleStatusDescription() {
        return lifecycleStatusDescription;
    }

    public void setLifecycleStatusDescription(String lifecycleStatusDescription) {
        this.lifecycleStatusDescription = lifecycleStatusDescription;
    }

    public String getBillingStatusDescription() {
        return billingStatusDescription;
    }

    public void setBillingStatusDescription(String billingStatusDescription) {
        this.billingStatusDescription = billingStatusDescription;
    }

    public String getDeliveryStatusDescription() {
        return deliveryStatusDescription;
    }

    public void setDeliveryStatusDescription(String deliveryStatusDescription) {
        this.deliveryStatusDescription = deliveryStatusDescription;
    }

    public String getChangedAt() {
        return changedAt;
    }

    public void setChangedAt(String changedAt) {
        this.changedAt = changedAt;
    }
}

