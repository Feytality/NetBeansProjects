/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.helpers;

import org.me.models.Product;
import org.me.models.PurchaseOrders;
import org.me.models.PurchaseOrder;
import org.me.models.Products;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * Method which is in change of altering the existing XML for all purchase
 * orders.
 *
 * @author Felicia
 */
public class EditOrderXML {

    private JAXBContext orderJC;
    private Marshaller orderJM;
    private PurchaseOrders purchaseOrders;
    private List<PurchaseOrder> purchaseOrderList = new ArrayList();
    private final String PURCHASE_ORDER_PATH = EditOrderXML.class.getResource("purchaseOrders.xml").getPath();

    public EditOrderXML() {
        try {
            // Unmarshal the Order XML
            this.orderJC = JAXBContext.newInstance(Product.class, Products.class, PurchaseOrder.class, PurchaseOrders.class);
            this.orderJM = orderJC.createMarshaller();
            unmarshalOrders();
        } catch (JAXBException ex) {
            Logger.getLogger(EditOrderXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void marshalOrders() {
        try {
            orderJM.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            orderJM.marshal(purchaseOrders, new File(PURCHASE_ORDER_PATH));
            orderJM.marshal(purchaseOrders, System.out);
        } catch (JAXBException ex) {
            Logger.getLogger(EditOrderXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void unmarshalOrders() {
        try {
            purchaseOrders = (PurchaseOrders) orderJC.createUnmarshaller().unmarshal(new File(PURCHASE_ORDER_PATH));
            purchaseOrderList = purchaseOrders.getPurchaseOrders();
        } catch (JAXBException ex) {
            Logger.getLogger(EditOrderXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Adds purchase order to the purchase order list, and updates the order.xml
     * accordingly.
     *
     * @param purchaseOrder
     */
    public void addOrder(PurchaseOrder purchaseOrder) {
        System.out.println("Adding purchase order (Order Number: " + purchaseOrder.getOrderNum() + ")");
        purchaseOrderList.add(purchaseOrder);
        purchaseOrders.setPurchaseOrders(purchaseOrderList);

        marshalOrders();
    }

    /**
     * Sets order in purchaseOrders.xml to paid if the order number and total
     * price given matches that in the xml.
     *
     * @param orderNum
     * @param totalPrice
     * @return true if order was paid, else false
     */
    public boolean payOrder(String orderNum, float totalPrice) {
        //System.out.printf("Paying order for order number $s and total price $f", orderNum, totalPrice);
        for (PurchaseOrder po : purchaseOrderList) {
            if (po.getOrderNum().equals(orderNum) && po.getUnitPrice() == totalPrice) {
                po.setIsPaid(true);
                purchaseOrders.setPurchaseOrders(purchaseOrderList);
                // Save to the xml
                marshalOrders();
                return true;
            }
        }

        return false;
    }
}
