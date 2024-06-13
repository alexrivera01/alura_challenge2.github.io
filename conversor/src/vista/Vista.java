package vista;

import controlador.PrincipalControlador;

import java.util.Scanner;

public class Vista {
    PrincipalControlador principalControlador;

    public Vista(PrincipalControlador principalControlador){
        this.principalControlador = principalControlador;
    }

    public void menuPrincipal(){
        int opcion;
        int cantidadAConvertir;

        imprimir("Menu Principal");
        imprimir("1. Convertir ");
        imprimir("2. Convertir ");
        imprimir("3. Convertir ");
        imprimir("4. Convertir ");
        imprimir("5. Convertir ");
        imprimir("6. Convertir ");
        imprimir("7. Salir ");
        imprimir("");


        do{
            opcion = pedirOpcion("Ingrese su opcion");
            if(opcion <1 || opcion >7){
                imprimir("Debe escoger una opción valida");
            }
            else {
                do{
                    cantidadAConvertir = pedirOpcion("Ingrese la cantidad a convertir");
                    if(cantidadAConvertir<0){
                        imprimir("Debe ser mayor a cero");
                    }
                    else {
                        principalControlador.procesar(opcion,cantidadAConvertir);
                    }
                }while (cantidadAConvertir < 0);


            }

        }while (opcion <1 || opcion >7);

    }

    public void imprimir(String mensaje){
        System.out.println(mensaje);
    }

    public int pedirOpcion(String mensaje){
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
}
