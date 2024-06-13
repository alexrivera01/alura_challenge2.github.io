package servicios;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;

public class ExchangeAPI {
    ClienteHTTP cliente = new ClienteHTTP();

    String urlBase = "https://v6.exchangerate-api.com/v6/48ba5a4d485140bdabe62eb1/latest/";
    //String modenaAConvertir = "";

    public String obtenerJsonByMoneda(String monedaOrigen){
        String url = urlBase+monedaOrigen;
        return cliente.obtenerJson(url);
    }

    public void obtenerTasaDeCambio(String monedaOrigen, String monedaDesinto){
        String json = obtenerJsonByMoneda(monedaOrigen);

        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

        if(conversionRates.has(monedaDesinto)){
            double tasaDeCambio = conversionRates.get(monedaDesinto).getAsDouble();

            System.out.println("has monedaDestino:"+tasaDeCambio);
        }
        else {
            System.out.println("Has not monedaDestino");
        }
    }



}
