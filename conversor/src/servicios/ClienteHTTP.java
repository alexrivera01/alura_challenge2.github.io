package servicios;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClienteHTTP {
    HttpClient cliente = HttpClient.newHttpClient();

    public String obtenerJson(String url){
        String jsonResponse = "";

        URI uri = URI.create(url);

        HttpRequest request = HttpRequest.newBuilder()
                .GET().
                uri(uri)
                .build();
        try{
            HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(response.statusCode());
            jsonResponse = response.body();

        }catch (IOException e){
            System.out.println(e);
        }catch (InterruptedException e){
            System.out.println(e);
        }finally {
            return jsonResponse;
        }
    }

}
