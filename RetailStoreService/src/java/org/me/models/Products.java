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
@XmlRootElement( name = "Products" )
public class Products {
    
    private List products;
    
    /**
     * element that is going to be marshaled in the xml
     * @param products
     */
    @XmlElement(name = "Product", required = true)
    public void setProducts(List products)
    {
        this.products = products;
    }
    
    /**
     * 
     * @return 
     */
    public List getProducts() {
        return products;
    }
    
}
