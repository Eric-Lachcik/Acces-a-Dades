package org.example;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.Scanner;

import static org.example.Metodos.*;

public class Main {
    public static void main(String[] args) {

        try {
            //Iniciamos un Scanner.
            Scanner sc = new Scanner(System.in);

            //Booleano de control del while.
            boolean continuar = true;
            while (continuar) {
                try {
                    System.out.println();
                    System.out.println("Elige una opcion, elige  escribiendo el numero que deseas de los disponibles: \n 1-'Crear Personas' \n 2-'Buscar Personas' \n 3-'Eliminar Personas' \n 4-'Modificar Personas' \n 5-'Mostrar Personas' \n 6-'Salir del Programa' ");

                    int opcion = sc.nextInt();
                    switch (opcion) {

                        //Caso insertar datos.
                        case 1:
                            System.out.println("Has elegido 'Insertar Personas' ");
                            insertarDatos();
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

                }catch (Exception e) {
                    System.out.println("Error segundo catch" + e.getMessage());
                }
            }
            // Inserta datos
            insertarDatos();

            // Lee datos
            leerDatos();

            // Modifica datos
            modificarDatosLlibre(1, "Títol Actualitzat");

            // Elimina un llibre
            eliminarLlibre(1);

            // Elimina un autor
            eliminarAutor(1);

            hibernate.shutdown();
        }catch (Exception e) {
            System.out.println("Error primer catch" + e.getMessage());
        }
    }
}
