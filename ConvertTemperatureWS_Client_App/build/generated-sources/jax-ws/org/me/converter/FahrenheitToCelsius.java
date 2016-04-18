
package org.me.converter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for fahrenheitToCelsius complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="fahrenheitToCelsius">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fahr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fahrenheitToCelsius", propOrder = {
    "fahr"
})
public class FahrenheitToCelsius {

    protected String fahr;

    /**
     * Gets the value of the fahr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFahr() {
        return fahr;
    }

    /**
     * Sets the value of the fahr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFahr(String value) {
        this.fahr = value;
    }

}
