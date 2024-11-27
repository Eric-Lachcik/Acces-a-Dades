package org.example;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Scanner;

public class Basededatos {

    //Metodo encargado de añadir Personas nuevo a la base de datos.
    public static void crearPersona(EntityManager em, Scanner sc) {
        Scanner scAgr = new Scanner(System.in);
        boolean agregarMas = true;

        while (agregarMas) {

            //Validacion de campo nombre.
            String nom = "";
            while (!nom.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                System.out.print("Ingrese nombre del empleado (solo letras y espacios): ");
                nom = sc.nextLine();
                if (!nom.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                    System.out.println("El nombre solo puede contener letras y espacios.");
                }
            }

            int edad = -1;
            //Validacion de campo edad.
            while (edad < 0) {
                System.out.print("Ingrese edad del empleado (solo números positivos): ");
                if (sc.hasNextInt()) {
                    edad = sc.nextInt();
                    if (edad < 0) {
                        System.out.println("La edad debe ser un número positivo.");
                    }
                } else {
                    System.out.println("Por favor, ingrese un número válido.");
                    sc.next();
                }
            }
            sc.nextLine();

            String email = "";
            //Validacion de campo Email, tiene que contener el @.
            while (!email.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
                System.out.print("Ingrese email del empleado (formato válido): ");
                email = sc.nextLine();
                if (!email.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
                    System.out.println("Por favor, ingrese un email válido.");
                }
            }

            //Creamos el objeto persona que añadiremos a la base de datos de objectdb.
            Persona nuevaPersona = new Persona(nom, edad, email);

            em.getTransaction().begin();
            em.persist(nuevaPersona);
            em.getTransaction().commit();

            System.out.println("Persona creada: " + nuevaPersona);

            System.out.print("¿Desea agregar otro empleado? (s/n): ");
            String respuesta = scAgr.nextLine();
            agregarMas = respuesta.equalsIgnoreCase("s");
        }

    }

    //Metodo encargado de buscar una persona para despues elegir modificar o eliminarlo.
    public static void buscarPersona(EntityManager em, Scanner sc) {

    }

    //Metodo encargado de eliminar un objeto persona de nuestra seleccion.
    public static void eliminarPersona(EntityManager em, Scanner sc) {

        String nombre = sc.nextLine();

        while (!nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
            System.out.print("Ingrese nombre del empleado (solo letras y espacios): ");
            nombre = sc.nextLine();
            if (!nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                System.out.println("El nombre solo puede contener letras y espacios.");
            }
        }

        em.getTransaction().begin();
        //Configuramos el prompt de la query que tenemos que usar.
        Query query = em.createQuery("DELETE FROM Persona p WHERE p.nom = :nombre");
        query.setParameter("nombre", nombre);
        int result = query.executeUpdate();
        em.getTransaction().commit();
        //Ejecutamos la query deseada si se ha encontrado en la base de datos el nombre de la persona el cual deseamos eliminar.
        if (result > 0) {
            System.out.println("Persona eliminada correctamente.");
        } else {
            System.out.println("No se encontró ninguna persona con el nombre: " + nombre);
        }
    }
    //Metodo encargado de Modificar una personar despues de hacer una busqueda por nombre en la base de datos.
    public static void modificarPersona(EntityManager em, Scanner sc) {
        String nombre = sc.nextLine();

        while (!nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
            System.out.print("Ingrese nombre del empleado (solo letras y espacios): ");
            nombre = sc.nextLine();
            if (!nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                System.out.println("El nombre solo puede contener letras y espacios.");
            }
        }

        em.getTransaction().begin();
        TypedQuery<Persona> query = em.createQuery("SELECT p FROM Persona p WHERE p.nom = :nombre", Persona.class);
        query.setParameter("nombre", nombre);
        List<Persona> personas = query.getResultList();

        if (personas.isEmpty()) {
            System.out.println("No se encontró ninguna persona con el nombre: " + nombre);
        } else {
            Persona persona = personas.get(0);
            System.out.println("Persona encontrada: " + persona);


            System.out.println("Introduce el nuevo nombre (deja vacío para no cambiar):");
            String nuevoNombre = sc.nextLine();
            if(nuevoNombre.isEmpty()){
                System.out.println("Nada Introducido");
            }else{
                while (!nuevoNombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                    System.out.print("Ingrese nombre del empleado (deja vacío para no cambiar): ");
                    nuevoNombre = sc.nextLine();
                    if (!nuevoNombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                        System.out.println("El nombre solo puede contener letras y espacios.");
                    }
                }
                persona.setNom(nuevoNombre);
            }


            System.out.println("Introduce la nueva edad (deja vacío para no cambiar):");
            String nuevaEdad = sc.nextLine();
            if(nuevaEdad.isEmpty()){
                System.out.println("Nada Introducido");
            }else{
                persona.setEdad(Integer.parseInt(nuevaEdad));
            }


            System.out.println("Introduce el nuevo email (deja vacío para no cambiar):");
            String nuevoEmail = sc.nextLine();
            if(nuevoEmail.isEmpty()) {
                System.out.println("Nada Introducido");
            }else{
                //Validacion de campo Email, tiene que contener el @.
                while (!nuevoEmail.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
                    System.out.print("Ingrese email del empleado (deja vacío para no cambiar): ");
                    nuevoEmail = sc.nextLine();
                    if (!nuevoEmail.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$") & !nuevoEmail.isEmpty() ) {
                        System.out.println("Por favor, ingrese un email válido.");
                    }
                }
                if (!nuevoEmail.isEmpty()) persona.setEmail(nuevoEmail);
            }

            em.merge(persona);
            System.out.println("Persona actualizada: " + persona);
        }
        em.getTransaction().commit();
    }

    //Metodo encargado de mostrar las Personas contenidas dentro de la base de datos.
    public static void mostrarPersonas(EntityManager em) {
        TypedQuery<Persona> query = em.createQuery("SELECT p FROM Persona p", Persona.class);
        List<Persona> personas = query.getResultList();

        if (personas.isEmpty()) {
            System.out.println("No hay personas en la base de datos.");
        } else {
            System.out.println("Lista de personas:");
            personas.forEach(System.out::println);
        }
    }
}

