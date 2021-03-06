
package org.me.converter;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "ConverterWS", targetNamespace = "http://converter.me.org/", wsdlLocation = "http://localhost:8080/ConverterWS/ConverterWS?wsdl")
public class ConverterWS_Service
    extends Service
{

    private final static URL CONVERTERWS_WSDL_LOCATION;
    private final static WebServiceException CONVERTERWS_EXCEPTION;
    private final static QName CONVERTERWS_QNAME = new QName("http://converter.me.org/", "ConverterWS");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/ConverterWS/ConverterWS?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CONVERTERWS_WSDL_LOCATION = url;
        CONVERTERWS_EXCEPTION = e;
    }

    public ConverterWS_Service() {
        super(__getWsdlLocation(), CONVERTERWS_QNAME);
    }

    public ConverterWS_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), CONVERTERWS_QNAME, features);
    }

    public ConverterWS_Service(URL wsdlLocation) {
        super(wsdlLocation, CONVERTERWS_QNAME);
    }

    public ConverterWS_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CONVERTERWS_QNAME, features);
    }

    public ConverterWS_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ConverterWS_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ConverterWS
     */
    @WebEndpoint(name = "ConverterWSPort")
    public ConverterWS getConverterWSPort() {
        return super.getPort(new QName("http://converter.me.org/", "ConverterWSPort"), ConverterWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ConverterWS
     */
    @WebEndpoint(name = "ConverterWSPort")
    public ConverterWS getConverterWSPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://converter.me.org/", "ConverterWSPort"), ConverterWS.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CONVERTERWS_EXCEPTION!= null) {
            throw CONVERTERWS_EXCEPTION;
        }
        return CONVERTERWS_WSDL_LOCATION;
    }

}
