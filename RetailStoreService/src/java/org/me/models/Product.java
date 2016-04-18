package org.me.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType( propOrder = { "manufacturerName", "productType", "unitPrice"} )
@XmlRootElement( name = "Product" )
public class Product
{
    private String manufacturerName;
    private String productType;
    private float unitPrice;
    
    /**
     * 
     * @param manufacturerName 
     */
    @XmlElement(name = "Manufacturer_Name", required = true)
    public void setManufacturerName(String manufacturerName)
    {
        this.manufacturerName = manufacturerName;
    }
    
    public String getManufacturerName() {
        return manufacturerName;
    }

    /**
     * 
     * @param productType 
     */
    @XmlElement(name = "Product_Type", required = true)
    public void setProductType(String productType)
    {
        this.productType = productType;
    }
    
    /**
     * 
     * @return 
     */
    public String getProductType() {
        return productType;
    }

    /**
     * 
     * @param unitPrice 
     */
    @XmlElement(name = "Unit_Price", required = true)
    public void setUnitPrice(float unitPrice)
    {
        this.unitPrice = unitPrice;
    }
    
    /**
     * 
     * @return 
     */
    public float getUnitPrice() {
        return unitPrice;
    }

}