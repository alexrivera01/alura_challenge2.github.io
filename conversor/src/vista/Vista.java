package vista;

import controlador.PrincipalControlador;

import java.util.Scanner;

public class Vista {
    PrincipalControlador principalControlador;

    public Vista(PrincipalControlador principalControlador){
        this.principalControlador = principalControlador;
    }

    public void menuPrincipal(){
        imprimirMenuPrincipal();
        int opcionMenuPrincipal = obtenerYVerificarOpcionMenuPrincipal();
        int cantidadAConvertir = obtenerYVerificarCantidadAConvertir();
        enviarDatosMenuPrincipalAControlador(opcionMenuPrincipal,cantidadAConvertir);
    }

    public void imprimirMenuPrincipal(){
        imprimir("Menu Principal");
        imprimir("1) Dolar =>> Peso argentino ");
        imprimir("2) Peso argentino =>> Dolar ");
        imprimir("3) Dolar =>> Real brasileño ");
        imprimir("4) Real brasileño =>> Dolar");
        imprimir("5. Dolar =>> Peso Colombiano ");
        imprimir("6. Peso Colombiano =>> Dolar ");
        imprimir("7. Salir ");
        imprimir("");

    }
    public int obtenerYVerificarOpcionMenuPrincipal(){
        int opcionMenuPrincipal;
        do{
            opcionMenuPrincipal = pedirOpcion("Ingrese su opcion: ");
            if(opcionMenuPrincipal <1 || opcionMenuPrincipal >7){
                imprimir("Debe escoger una opción valida...");
            }
        }while (opcionMenuPrincipal <1 || opcionMenuPrincipal >7);
        return opcionMenuPrincipal;
    }
    public int obtenerYVerificarCantidadAConvertir(){
        int cantidadAConvertir;

        do{
            cantidadAConvertir = pedirOpcion("Ingrese la cantidad a convertir: ");
            if(cantidadAConvertir<0){
                imprimir("Debe ser mayor a cero");
            }
        }while (cantidadAConvertir < 0);
        return cantidadAConvertir;
    }
    public void enviarDatosMenuPrincipalAControlador(int opcion, int cantidadAConvertir){
        principalControlador.procesar(opcion,cantidadAConvertir);
    }

    public void menuDeseaContinuar(){
        imprimir("Si desea hacer otra conversion presione enter... ");
        pedirCadena();
        menuPrincipal();
    }

    public void mostrarMensaje(String mensaje){
        imprimir(mensaje);
    }

    private void imprimir(String mensaje){
        System.out.println(mensaje);
    }

    private int pedirOpcion(String mensaje){
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;
        try {
            System.out.printf(mensaje);
            opcion = scanner.nextInt();

        }catch (Exception e){
            imprimir(e.getMessage());
        }
        return opcion;
    }
    private void pedirCadena(){
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}
