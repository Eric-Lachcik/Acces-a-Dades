package org.example;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        try{
            //Iniciamos un Scanner.
            Scanner sc = new Scanner(System.in);
            //Booleano de control del while.
            boolean continuar = true;

            //Iniciamos la base de datos.
            if (basededatos.inicializar()){
                while(continuar){
                    try{
                        System.out.println();
                        System.out.println("Elige una opcion, elige  escribiendo el numero que deseas de los disponibles: \n 1-'Crear' \n 2-'Leer' \n 3-'Salir' ");

                        int opcion = sc.nextInt();

                        //Switch con tres opciones que corresponden a las tres acciones requeridas.
                        switch (opcion) {

                            //Caso añadir datos.
                            case 1:
                                System.out.println("Has elegido 'Crear' ");
                                basededatos.insertarDatos();
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
                            //Caso insertar valor invalido.
                            default:
                                System.out.println("Has elegido una opción incorrecta");

                                System.out.println("----------------------------------------------");
                                System.out.println("---------- Volviendo A Mostrar Menu ----------");
                                System.out.println("-----------------(⊙_(⊙_⊙)_⊙)------------------");
                        }

                    }catch (Exception e){
                        System.out.println("Error" + e.getMessage());
                    }
                }
            }else {
                System.out.println("No se ha creado bien la base de datos");
            }
        } catch (Exception e) {
            System.out.println("Ha petado desde el principio" + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}