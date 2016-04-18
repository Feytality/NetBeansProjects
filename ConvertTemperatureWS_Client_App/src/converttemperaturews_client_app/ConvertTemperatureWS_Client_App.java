/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converttemperaturews_client_app;

/**
 *
 * @author Felicia
 */
public class ConvertTemperatureWS_Client_App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            String fahr = "10";
            String celsius = "35";

            String celToFahrResult = celsiusToFahrenheit(celsius);
            System.out.println("Celsius value " + celsius + " equals to " +
                    celToFahrResult + " fahrenheit.");

            String fahrToCelResult = fahrenheitToCelsius(fahr);
            System.out.println("Fahrenheit value " + fahr + " equals to " +
                fahrToCelResult + " celsius.");
        } catch (Exception e) {
            System.out.println("Could not convert temperature!");
            System.out.println(e);
        }
    }

    private static String celsiusToFahrenheit(java.lang.String celsius) {
        org.me.converter.ConverterWS_Service service = new org.me.converter.ConverterWS_Service();
        org.me.converter.ConverterWS port = service.getConverterWSPort();
        return port.celsiusToFahrenheit(celsius);
    }

    private static String fahrenheitToCelsius(java.lang.String fahr) {
        org.me.converter.ConverterWS_Service service = new org.me.converter.ConverterWS_Service();
        org.me.converter.ConverterWS port = service.getConverterWSPort();
        return port.fahrenheitToCelsius(fahr);
    }
    
}
