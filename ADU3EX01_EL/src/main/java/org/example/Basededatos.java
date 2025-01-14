package org.example;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Scanner;

public class Basededatos {

    // Metodo encargado de añadir Personas nuevas a la base de datos.
    public static void crearPersona(EntityManager em, Scanner sc) {
        Scanner scAgr = new Scanner(System.in);
        boolean agregarMas = true;

        while (agregarMas) {
            try {
                sc.nextLine();
                // Validación de campo nombre.
                String nom = "";
                while (!nom.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                    System.out.print("Ingrese nombre del empleado (solo letras y espacios): ");
                    nom = sc.nextLine();
                    if (!nom.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                        System.out.println("El nombre solo puede contener letras y espacios.");
                    }
                }

                int edad = -1;
                // Validación de campo edad.
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
                // Validación de campo Email.
                while (!email.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
                    System.out.print("Ingrese email del empleado (formato válido): ");
                    email = sc.nextLine();
                    if (!email.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
                        System.out.println("Por favor, ingrese un email válido.");
                    }
                }

                // Crear objeto Persona.
                Persona nuevaPersona = new Persona(nom, edad, email);

                try {
                    em.getTransaction().begin();
                    em.persist(nuevaPersona);
                    em.getTransaction().commit();
                    System.out.println("Persona creada: " + nuevaPersona);
                } catch (Exception e) {
                    em.getTransaction().rollback();
                    System.out.println("Error al guardar la persona en la base de datos: " + e.getMessage());
                }

                System.out.print("¿Desea agregar otro empleado? (s/n): ");
                String respuesta = scAgr.nextLine();
                agregarMas = respuesta.equalsIgnoreCase("s");

            } catch (Exception e) {
                System.out.println("Error durante el proceso de creación: " + e.getMessage());
            }
        }
    }

    // Metodo encargado de buscar una persona.
    public static void buscarPersona(EntityManager em, Scanner sc) {
        try {
            System.out.print("Ingrese el nombre de la persona que desea buscar: ");
            String nombre = sc.nextLine();
            // Validación del nombre.
            while (!nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                System.out.print("Ingrese un nombre válido (solo letras y espacios): ");
                nombre = sc.nextLine();
            }

            TypedQuery<Persona> query = em.createQuery("SELECT p FROM Persona p WHERE p.nom = :nombre", Persona.class);
            query.setParameter("nombre", nombre);
            List<Persona> personas = query.getResultList();

            if (personas.isEmpty()) {
                System.out.println("No se encontró ninguna persona con el nombre: " + nombre);
            } else {
                System.out.println("Se encontró la siguiente persona:");
                Persona persona = personas.get(0);
                System.out.println(persona);

                System.out.println("¿Qué desea hacer con esta persona?");
                System.out.println("1. Modificar");
                System.out.println("2. Eliminar");
                System.out.println("3. Cancelar");
                System.out.print("Elija una opción: ");
                int opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        modificarPersona(em, sc, nombre);
                        break;
                    case 2:
                        eliminarPersona(em, sc, nombre);
                        break;
                    case 3:
                        System.out.println("Operación cancelada.");
                        break;
                    default:
                        System.out.println("Opción no válida. Operación cancelada.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error durante la búsqueda: " + e.getMessage());
        }
    }

    // Metodo encargado de eliminar un objeto Persona.
    public static void eliminarPersona(EntityManager em, Scanner sc, String nombre) {
        try {
            if (nombre == null || nombre.isEmpty()) {
                System.out.print("Ingrese nombre del empleado (solo letras y espacios): ");
                nombre = sc.nextLine();
                while (!nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                    System.out.print("Ingrese un nombre válido (solo letras y espacios): ");
                    nombre = sc.nextLine();
                }
            }

            em.getTransaction().begin();
            Query query = em.createQuery("DELETE FROM Persona p WHERE p.nom = :nombre");
            query.setParameter("nombre", nombre);
            int result = query.executeUpdate();
            em.getTransaction().commit();

            if (result > 0) {
                System.out.println("Persona eliminada correctamente.");
            } else {
                System.out.println("No se encontró ninguna persona con el nombre: " + nombre);
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Error al eliminar la persona: " + e.getMessage());
        }
    }

    // Metodo encargado de modificar una Persona.
    public static void modificarPersona(EntityManager em, Scanner sc, String nombre) {
        try {
            if (nombre == null || nombre.isEmpty()) {
                System.out.print("Ingrese nombre del empleado (solo letras y espacios): ");
                nombre = sc.nextLine();
                while (!nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                    System.out.print("Ingrese un nombre válido (solo letras y espacios): ");
                    nombre = sc.nextLine();
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
                if (!nuevoNombre.isEmpty()) {
                    while (!nuevoNombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                        System.out.print("Ingrese un nombre válido: ");
                        nuevoNombre = sc.nextLine();
                    }
                    persona.setNom(nuevoNombre);
                }

                System.out.println("Introduce la nueva edad (deja vacío para no cambiar):");
                String nuevaEdad = sc.nextLine();
                if (!nuevaEdad.isEmpty()) {
                    persona.setEdad(Integer.parseInt(nuevaEdad));
                }

                System.out.println("Introduce el nuevo email (deja vacío para no cambiar):");
                String nuevoEmail = sc.nextLine();
                if (!nuevoEmail.isEmpty()) {
                    while (!nuevoEmail.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
                        System.out.print("Ingrese un email válido: ");
                        nuevoEmail = sc.nextLine();
                    }
                    persona.setEmail(nuevoEmail);
                }

                em.merge(persona);
                System.out.println("Persona actualizada: " + persona);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Error al modificar la persona: " + e.getMessage());
        }
    }

    // Metodo encargado de mostrar las Personas contenidas dentro de la base de datos.
    public static void mostrarPersonas(EntityManager em) {
        try {
            TypedQuery<Persona> query = em.createQuery("SELECT p FROM Persona p", Persona.class);
            List<Persona> personas = query.getResultList();

            if (personas.isEmpty()) {
                System.out.println("No hay personas en la base de datos.");
            } else {
                System.out.println("Lista de personas:");
                personas.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar las personas: " + e.getMessage());
        }
    }

}

