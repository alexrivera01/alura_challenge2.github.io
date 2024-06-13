package controlador;

import servicios.ExchangeAPI;
import vista.Vista;

public class PrincipalControlador {
    Vista vistaPrincipal;
    ExchangeAPI exchangeAPI;

    public PrincipalControlador(){
        vistaPrincipal = new Vista(this);
        exchangeAPI = new ExchangeAPI();
    }

    public void iniciar(){
        vistaPrincipal.menuPrincipal();
    }

    public void procesar(int opcion, int cantidadAConvertir) {
        switch (opcion){
            case 1:
                convertirMoneda("USD","ARS",cantidadAConvertir);
                break;
            case 2:
                convertirMoneda("ARG","USD",cantidadAConvertir);
                break;
            case 3:
                convertirMoneda("USD","BRL",cantidadAConvertir);
                break;
            case 4:
                convertirMoneda("BRL","USD",cantidadAConvertir);
                break;
            case 5:
                convertirMoneda("USD", "COP",cantidadAConvertir);
                break;
            case 6:
                convertirMoneda("COP", "USD",cantidadAConvertir);
                break;
            case 7:
                break;
        }
    }



    public double convertirMoneda(String monedaOrigen, String monedaDestino, int cantidadAConvertir){
        double tasaCambio = obtenerTasaCambio(monedaOrigen,monedaDestino);
        double cantidadConvertida = 0;
        if(tasaCambio != 0 ){
            cantidadConvertida = tasaCambio * cantidadAConvertir;
            String mensajeAEnviar = "El valor: "+cantidadAConvertir+"["+monedaOrigen+"] "+ "corresponde al valor final de > "+ cantidadConvertida +"[" + monedaDestino + "]";
            vistaPrincipal.mostrarMensaje(mensajeAEnviar);
            vistaPrincipal.menuDeseaContinuar();
        }else {
            vistaPrincipal.mostrarMensaje("No se pudo obtener la tasa de cambio correctamente");
        }
        return cantidadConvertida;
    }

    public double obtenerTasaCambio(String monedaOrigen,String monedaDestino){
        return exchangeAPI.obtenerTasaDeCambio(monedaOrigen,monedaDestino);
    }


}
