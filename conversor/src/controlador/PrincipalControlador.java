package controlador;

import servicios.ExchangeAPI;
import vista.Vista;

public class PrincipalControlador {
    Vista vistaPrincipal;
    ExchangeAPI exchangeAPI;

    public PrincipalControlador(){
        vistaPrincipal = new Vista(this);
    }

    public void iniciar(){
        vistaPrincipal.menuPrincipal();
    }

    public void procesar(int opcion, int cantidadAConvertir) {
        switch (opcion){
            case 1:
                exchangeAPI.obtenerTasaDeCambio();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
        }
    }

    public int convertirMoneda(String monedaOrigen, String monedaDestino, int cantidadAConvertir){

    }
}
