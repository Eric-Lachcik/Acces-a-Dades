# Gestión de Empleados con Java y SQLite

## Descripción de la funcionalidad desarrollada

Este proyecto implementa un sistema básico de gestión de empleados utilizando **Java** y una base de datos **SQLite**. Con esta herramienta podrás:

- Crear y almacenar datos de empleados de manera estructurada.
- Leer y mostrar los registros de empleados almacenados en la base de datos.
- Interactuar con el sistema a través de un menú en consola, con opciones claras y simples.

### Clases Implementadas

1. **`Main`**: La clase principal que ejecuta el programa. Contiene el menú interactivo y permite al usuario seleccionar las opciones de creación o lectura de datos.
2. **`basededatos`**: Clase que gestiona las operaciones con la base de datos SQLite:
   - Crear la tabla `empleados` si no existe.
   - Insertar nuevos registros de empleados.
   - Leer y mostrar los registros almacenados.

---

## Información sobre el ecosistema de desarrollo

- **Sistema Operativo**: Windows 10 (compatible con cualquier sistema que soporte Java y SQLite).
- **IDE Recomendado**: IntelliJ IDEA, Eclipse o cualquier IDE con soporte para Java.
- **SDK de Java**: JDK 17 o superior.
- **Librerías Utilizadas**: 
  - `java.sql` para la interacción con SQLite.
  - `java.util.Scanner` para entrada de datos desde la consola.

Este proyecto utiliza únicamente librerías estándar de Java, por lo que no requiere dependencias externas adicionales.

---

## Cuaderno de carga

Coloca tu propia base de datos SQLite cambiando la variable url que se ubica en la clase basededatos.

1. Ejecuta la clase `Main` desde tu IDE.
2. Usa el menú en consola para interactuar con el sistema:
   - **Crear**: Agrega nuevos empleados ingresando sus datos (ID, nombre, edad y email).
   - **Leer**: Muestra todos los registros de empleados en la consola.
   - **Salir**: Finaliza el programa.

El sistema creará automáticamente la tabla `empleados` y la base de datos en la ubicacion especificada de la variable url si no existe, y gestionará los datos en la base de datos sin necesidad de configuración adicional.
