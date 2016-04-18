/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.manufacturer;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.me.helpers.EditOrderXML;
import org.me.helpers.ReadProductXML;
import org.me.models.Product;
import org.me.models.PurchaseOrder;

/**
 *
 * @author Felicia
 */
@WebService(serviceName = "ManufacturerWS")
public class ManufacturerWS {
    /**
     * Web service operation
     * @param productName
     * @param customerRef
     * @param unitPrice
     * @return 
     */
    @WebMethod(operationName = "processPurchaseOrder")
    public boolean processPurchaseOrder(@WebParam(name = "productName") final String productName,
                             @WebParam(name = "unitPrice") final float unitPrice,
                             @WebParam(name = "customerRef") final String customerRef) {
        if(productName.toLowerCase().equals("dvd player") || 
            productName.toLowerCase().equals("video camera") || 
            productName.toLowerCase().equals("tv")) {
            // TODO Generate an order number, UUID.
            // Get the product from the product name given
            ReadProductXML read = new ReadProductXML();
            Product product = read.getProductByName(productName);

            int units;
            if(unitPrice >= product.getUnitPrice()) {
                boolean valid;
                // We need to produce and add this order order.xml file.
                units = (int) (unitPrice / product.getUnitPrice());
                if(units > 100) {
                    // Call the produce function every 100 units.
                    while(units > 100) {
                        produce(productName, 100);
                        units -= 100;
                    }
                    // Calls the produce function with < 100 units.
                    valid = produce(productName, units);
                } else {
                    valid = produce(productName, units);
                }
                if(!valid) {
                    // If was unable to produce correctly.
                    return false;
                }
            } else {
                // do not produce and do not add the order to order.xml
                return false;
            }

            // Update the product in  memory object and also add in ORDER XML file.
            PurchaseOrder purchaseOrder = new PurchaseOrder();
            purchaseOrder.setCustomerRef(customerRef);
            purchaseOrder.setOrderNum("0000000"); // Hard coded for easy testing
            purchaseOrder.setProduct(product);
            purchaseOrder.setQuantity(units);
            purchaseOrder.setUnitPrice(unitPrice);        

            EditOrderXML editOrder = new EditOrderXML();
            editOrder.addOrder(purchaseOrder);      

            return true;
        } else {
            return false;
        }
    }

    /**
     * Web service operation
     * @param productName
     * @return 
     */
    @WebMethod(operationName = "getProductInfo")
    public Product getProductInfo(@WebParam(name = "productName") final String productName) {
        Logger.getLogger(ManufacturerWS.class.getName()).log(Level.SEVERE, null, "OMGGG");
        if(productName.toLowerCase().equals("dvd player") || 
            productName.toLowerCase().equals("video camera") || 
            productName.toLowerCase().equals("tv")) {
            // Get the product from the product name given
            System.out.println("org.me.manufacturer.ManufacturerWS.getProductInfo()");
            ReadProductXML read = new ReadProductXML();
            Product product = read.getProductByName(productName);
            return product;
        } else {
            // There is no info, return null.
            return null;
        }
    }

    /**
     * Web service operation
     * @param orderNum
     * @param totalPrice
     * @return 
     */
    @WebMethod(operationName = "receivePayment")
    public boolean receivePayment(@WebParam(name = "orderNum") final String orderNum, @WebParam(name = "totalPrice") final float totalPrice) {
        EditOrderXML editOrder = new EditOrderXML();
        return editOrder.payOrder(orderNum, totalPrice);
    }
    
    /**
     * Produces the product specified if it is one of the three available products,
     * and if the quantity is less than or equal to 100.
     * 
     * @param productName
     * @param quantity
     * @return true if able to produce product, else false.
     */
    private boolean produce(String productName, int quantity) {
        if((productName.toLowerCase().equals("dvd player") || 
            productName.toLowerCase().equals("video camera") || 
            productName.toLowerCase().equals("tv")) && quantity <= 100) {
            // Produce products.
            System.out.println("Producing " + quantity  + " product(s)");
            return true;
        } else {
            // Retrun false, could not produce item due to incorrect product name,
            // or because of too large quantity.
            return false;
        }
    }
}
