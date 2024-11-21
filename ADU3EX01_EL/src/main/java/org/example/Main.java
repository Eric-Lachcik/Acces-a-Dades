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
            if (continuar){
                while(continuar){
                    try{
                        System.out.println();
                        System.out.println("Elige una opcion, elige  escribiendo el numero que deseas de los disponibles: \n 1-'Crear Personas' \n 2-'Eliminar Personas' \n 3-'Modificar Personas' \n 4-'Mostrar Personas' \n 5-'Salir del Programa' ");

                        int opcion = sc.nextInt();

                        //Switch con tres opciones que corresponden a las tres acciones requeridas.
                        switch (opcion) {

                            //Caso crear datos.
                            case 1:
                                System.out.println("Has elegido 'Crear Personas' ");

                                break;

                            //Caso eliminar datos.
                            case 2:
                                System.out.println("Has elegido 'Eliminar Personas' ");

                                break;

                            //Caso modificar datos.
                            case 3:
                                System.out.println("Has elegido 'Modificar Personas' ");

                                break;

                            //Caso mostrar datos.
                            case 4:
                                System.out.println("Has elegido 'Mostrar Personas' ");

                                break;

                            //Caso salir del programa.
                            case 5:
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