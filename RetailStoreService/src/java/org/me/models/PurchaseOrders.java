/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.models;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Felicia
 */
@XmlRootElement( name = "Purchase_Orders" )
public class PurchaseOrders {
    
    private List<PurchaseOrder> purchaseOrders;
    
    /**
     * element that is going to be marshaled in the xml
     * @param purchaseOrders
     */
    @XmlElement(name = "Purchase_Order", required = true)
    public void setPurchaseOrders(List purchaseOrders)
    {
        this.purchaseOrders = purchaseOrders;
    }
    
    /**
     * 
     * @return 
     */
    public List getPurchaseOrders() {
        return purchaseOrders;
    }
    
}
