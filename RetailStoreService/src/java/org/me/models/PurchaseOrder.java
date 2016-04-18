/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Felicia
 */
@XmlType( propOrder = { "orderNum", "customerRef", "product", "quantity", "unitPrice", "isPaid"} )
@XmlRootElement( name = "Purchase_Order" )
public class PurchaseOrder {
    private String orderNum;
    private String customerRef;
    private Product product;
    private int quantity;
    private float unitPrice;
    private boolean isPaid;

    
    public String getOrderNum() {
        return orderNum;
    }

    @XmlElement(name = "Order_Num", required = true)
    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getCustomerRef() {
        return customerRef;
    }

    @XmlElement(name = "Customer_Ref", required = true)
    public void setCustomerRef(String customerRef) {
        this.customerRef = customerRef;
    }

    public Product getProduct() {
        return product;
    }

    @XmlElement(name = "Product", required = true)
    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    @XmlElement(name = "Quantity", required = true)
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    @XmlElement(name = "Unit_Price", required = true)
    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public boolean isIsPaid() {
        return isPaid;
    }

    @XmlElement(name = "Is_Paid", required = true)
    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }
    
    
    
}
