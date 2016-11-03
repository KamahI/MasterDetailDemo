package com.christianschneider.model;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by christianschneider on 28.10.16.
 */

public class SalesOrderItem {

    private final String TAG = this.getClass().getSimpleName();

    // Fields from Northwind OData SalesOrderItem Collection
    private String salesOrderId;
    private String itemPosition;
    private String productID;
    public String note;
    private String noteLanguage;
    private String currencyCode;
    private String grossAmount;
    private String netAmount;
    private String taxAmount;
    private String deliveryDate;
    private String quantity;
    private String quantityUnit;

    /**
     * Helper method to log the attributes of a SalesOrder object
     */
    private void logSalesOrderItemContents() {
        String str = "Sales Order ID: " + this.salesOrderId;
        str = str.concat(", Item Position: " + this.itemPosition);
        str = str.concat(", Product ID = " + this.productID);
        str = str.concat(", Note = " + this.note);
        str = str.concat(", Note Languag = " + this.noteLanguage);
        str = str.concat(", Currency Code = " + this.currencyCode);
        str = str.concat(", Gross Amount = " + this.grossAmount);
        str = str.concat(", Net Amount = " + this.netAmount);
        str = str.concat(", Tax Amount = " + this.taxAmount);
        str = str.concat(", delivery Date = " + this.deliveryDate);
        str = str.concat(", Quantity = " + this.quantity);
        str = str.concat(", Quantity Unit = " + this.quantityUnit);
        Log.d(TAG, str);
    }


    /**
     * Helper method too log all elements of an ArrayList of Products.
     */

    public static void logSalesOrderItemArrayList(ArrayList<SalesOrderItem> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.get(i).logSalesOrderItemContents();
        }

    }

    /**
     * Constructor used in the {@link SalesOrderDataSingleton#getSalesOrderSets()} method}
     *
     * @param note
     */
    public SalesOrderItem(String note) {
        super();
        this.note = note;
    }

    public String getItemPosition() {
        return itemPosition;
    }

    public void setItemPosition(String itemPosition) {
        this.itemPosition = itemPosition;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
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

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
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

    public String getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(String taxAmount) {
        this.taxAmount = taxAmount;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getQuantityUnit() {
        return quantityUnit;
    }

    public void setQuantityUnit(String quantityUnit) {
        this.quantityUnit = quantityUnit;
    }

    public String getSalesOrderId() {
        return salesOrderId;
    }

    public void setSalesOrderId(String salesOrderId) {
        this.salesOrderId = salesOrderId;
    }
}
