package org.example;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        //Iniciamos un Scanner.
        Scanner sc = new Scanner(System.in);
        //Booleano de control del while. 
        boolean continuar = true;

        while(continuar){
            try{
                //Iniciamos la base de datos.
                basededatos.inicializar();

                System.out.println("Elige una opcion, elige  escribiendo el numero que deseas de los disponibles: \n 1-'Crear' \n 2-'Leer' \n 3-'Salir' ");

                int opcion = sc.nextInt();

                //Switch con tres opciones que corresponden a las tres acciones requeridas.
                switch (opcion) {

                    //Caso añadir datos.
                    case 1:
                        System.out.println("Has elegido 'Crear' ");
                        break;

                    //Caso leer datos.
                    case 2:
                        System.out.println("Has elegido 'Leer' ");
                        basededatos.mostrarDatos();
                        break;
                    //Caso salir del programa.
                    case 3:
                        System.out.println("Saliendo del programa (ˉ﹃ˉ) ");
                        sc.close();
                        continuar = false;
                        break;

                    default:
                        System.out.println("Has elegido una opción incorrecta");
                }

            }catch (Exception e){
                System.out.println("Error" + e.getMessage());
            }
        }
    }
}