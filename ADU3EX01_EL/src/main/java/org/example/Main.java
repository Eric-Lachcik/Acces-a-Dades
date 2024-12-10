package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try{
            //Iniciamos la base de datos.
            // Creamos el EntityManagerFactory basado en el persistence.xml.
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb_example");
            EntityManager em = emf.createEntityManager();

            //Iniciamos un Scanner.
            Scanner sc = new Scanner(System.in);

            //Booleano de control del while.
            boolean continuar = true;

                while(continuar){
                    try{
                        System.out.println();
                        System.out.println("Elige una opcion, elige  escribiendo el numero que deseas de los disponibles: \n 1-'Crear Personas' \n 2-'Buscar Personas' \n 3-'Eliminar Personas' \n 4-'Modificar Personas' \n 5-'Mostrar Personas' \n 6-'Salir del Programa' ");

                        int opcion = sc.nextInt();

                        //Switch con tres opciones que corresponden a las tres acciones requeridas.
                        switch (opcion) {

                            //Caso crear datos.
                            case 1:
                                System.out.println("Has elegido 'Crear Personas' ");
                                Basededatos.crearPersona(em, sc);
                                break;
                            //Caso buscar datos.
                            case 2:
                                System.out.println("Has elegido 'Buscar Personas' ");
                                Basededatos.buscarPersona(em, sc);
                                break;
                            //Caso eliminar datos.
                            case 3:
                                System.out.println("Has elegido 'Eliminar Personas' ");
                                Basededatos.eliminarPersona(em, sc, null);
                                break;

                            //Caso modificar datos.
                            case 4:
                                System.out.println("Has elegido 'Modificar Personas' ");
                                Basededatos.modificarPersona(em, sc, null);
                                break;

                            //Caso mostrar datos.
                            case 5:
                                System.out.println("Has elegido 'Mostrar Personas' ");
                                Basededatos.mostrarPersonas(em);
                                break;

                            //Caso salir del programa.
                            case 6:
                                System.out.println("Saliendo del programa (ˉ﹃ˉ) ");
                                em.close();
                                emf.close();
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
        } catch (Exception e) {
            System.out.println("Ha petado desde el principio" + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}