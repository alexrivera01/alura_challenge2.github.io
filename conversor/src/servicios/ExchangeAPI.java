package servicios;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;

public class ExchangeAPI {
    ClienteHTTP cliente = new ClienteHTTP();

    String urlBase = "https://v6.exchangerate-api.com/v6/48ba5a4d485140bdabe62eb1/latest/";

    public String obtenerJsonByMoneda(String monedaOrigen){
        String url = urlBase+monedaOrigen;
        return cliente.obtenerJson(url);
    }

    public double obtenerTasaDeCambio(String monedaOrigen, String monedaDesinto){
        String json = obtenerJsonByMoneda(monedaOrigen);
        double tasaDeCambio = 0;
        if(!json.isEmpty()){
            JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

            JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

            if(conversionRates != null){
                if(conversionRates.has(monedaDesinto)){
                    tasaDeCambio = conversionRates.get(monedaDesinto).getAsDouble();
                }
                else {
                    System.out.println("No se encuentra la moneda destino");
                }
            }else {
                System.out.println("Un problema asociado con el json");
                System.out.println(jsonObject);
            }

        }else {
            System.out.println("No se obtuvo la respuesta del json esperada");
        }
        return tasaDeCambio;
    }



}
