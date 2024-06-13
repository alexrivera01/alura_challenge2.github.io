import controlador.PrincipalControlador;
import servicios.ClienteHTTP;
import servicios.ExchangeAPI;

import java.net.URI;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PrincipalControlador principalControlador = new PrincipalControlador();
        principalControlador.iniciar();

    }
}