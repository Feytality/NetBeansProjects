/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.helpers;

import org.me.models.Product;
import org.me.models.Products;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

/**
 * Responsible for reading the product xml and making real objects from the XML!
 *
 * @author Felicia
 */
public class ReadProductXML {

    private List<Product> products;

    public ReadProductXML() {
        try {

            // Unmarshal products.xml
            JAXBContext productJC = JAXBContext.newInstance(Product.class, Products.class);
            Products ps = (Products) productJC.createUnmarshaller().unmarshal(new File(ReadProductXML.class.getResource("products.xml").getPath()));
            products = ps.getProducts();
        } catch (JAXBException ex) {
            Logger.getLogger(ReadProductXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Gets the product based on the name of the product. If it cannot find the
     * product, it will return null.
     *
     * @param productName
     * @return
     */
    public Product getProductByName(String productName) {
        for (Product product : products) {
            if (product.getProductType().toLowerCase().equals(productName.toLowerCase())) {
                return product;
            }
        }
        return null;
    }
}
