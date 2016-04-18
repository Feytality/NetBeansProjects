/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.converter;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author Felicia
 */
@WebService(serviceName = "ConverterWS")
@Stateless()
public class ConverterWS {


    /**
     * Web service operation
     * @param fahr
     * @return 
     */
    @WebMethod(operationName = "fahrenheitToCelsius")
    public String fahrenheitToCelsius(@WebParam(name = "fahr") String fahr) {
        try {
        double f = Double.parseDouble(fahr);
        double celsius = Math.round(((f - 32.0) / 9.0) * 5.0);
        
        return Double.toString(celsius);
        } catch (NumberFormatException e) {
            return "Could not parse fahrenheit value: " + fahr;
        } catch (NullPointerException e) {
            return "Please enter a fahrenheit value.";
        }
    }

    /**
     * Web service operation
     * @param celsius
     * @return 
     */
    @WebMethod(operationName = "celsiusToFahrenheit")
    public String celsiusToFahrenheit(@WebParam(name = "celsius") String celsius) {
        try {
            double c = Double.parseDouble(celsius);
            double fahr = Math.round(((c * 9.0) / 5.0) + 32.0);

            return Double.toString(fahr);
        } catch (NumberFormatException e) {
            return "Could not parse celsius value: " + celsius;
        } catch (NullPointerException e) {
            return "Please enter a celsius value.";
        }
    }
}
