package org.example;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.Scanner;

import static org.example.Metodos.*;

public class Main {
    public static void main(String[] args) {
        // URL del servidor de MySQL (me refiero a esto '//localhost:3307' )
        String ip = "//localhost:3307";

        // No tocar
        String urlTotal = "jdbc:mysql:" + ip;

        // Cambiar el nombre de la bd que quieres crear
        String nombreBaseDatos = "bd";

        String usuario = "root";
        String contra = "root";
        try {
                //Iniciamos BD.
                Basededatos.crearBaseDeDatos(urlTotal, nombreBaseDatos, usuario, contra);
                // Para no tener que modificar el archivo hibernate.
                System.setProperty("hibernate.database.name", nombreBaseDatos);
                System.setProperty("hibernate.database.url", ip);



                //Iniciamos un Scanner.
                Scanner sc = new Scanner(System.in);

                //Booleano de control del while.
                boolean continuar = true;
                while (continuar) {
                    try {
                        System.out.println();
                        System.out.println("Elige una opcion, elige  escribiendo el numero que deseas de los disponibles: \n 1-'Crear Autores' \n 2-'Crear Libros' \n 3-'Mostrar Datos' \n 4-'Modificar Libros' \n 5-'Modificar Autores' \n 6-'Eliminar Libros'  \n 7-'Eliminar Autores' \n 8-'Salir del Programa' ");

                        int opcion = sc.nextInt();
                        switch (opcion) {

                            //Caso crear autores.
                            case 1:
                                System.out.println("Has elegido 'Crear Autores' ");
                                insertarDatosAutor(sc);
                                break;

                            //Caso crear libros.
                            case 2:
                                System.out.println("Has elegido 'Crear Libros' ");
                                crearLlibre(sc);
                                break;

                            //Caso mostrar datos.
                            case 3:
                                System.out.println("Has elegido 'Mostrar Datos' ");
                                leerDatos();
                                break;

                            //Caso modificar datos libro.
                            case 4:
                                System.out.println("Has elegido 'Modificar Libros' ");
                                modificarDatosLlibre(sc);
                                break;

                            //Caso modificar datos libro.
                            case 5:
                                System.out.println("Has elegido 'Modificar Autores' ");
                                modificarDatosAutor(sc);
                                break;

                            //Caso Eliminar Libros.
                            case 6:
                                System.out.println("Has elegido 'Eliminar Libros' ");
                                eliminarLlibre(sc);
                                break;

                            //Caso Eliminar Autores.
                            case 7:
                                System.out.println("Has elegido 'Eliminar Autores' ");
                                eliminarAutor(sc);
                                break;

                            //Caso salir del programa.
                            case 8:
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

                    }catch (Exception e) {
                        System.out.println("Error segundo catch" + e.getMessage());
                    }
                }
                hibernate.shutdown();
            }catch (Exception e) {
                System.out.println("Error primer catch" + e.getMessage());
            }
    }
}
