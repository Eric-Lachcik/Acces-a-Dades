# Gestión de Autores y Libros con Java y Hibernate

## Descripción del proyecto

Este proyecto implementa un sistema de gestión de autores y libros utilizando **Java**, **Hibernate** y una base de datos **MySQL**. La aplicación permite realizar operaciones CRUD (Crear, Leer, Actualizar y Eliminar) de manera interactiva a través de un menú en consola.

### Funcionalidades principales

1. **Crear Autores**: Permite agregar nuevos registros de autores con nombre y fecha de nacimiento.
2. **Crear Libros**: Agrega libros vinculados a autores existentes, especificando el título y el año de publicación.
3. **Mostrar Datos**: Lista todos los autores con sus libros asociados y todos los libros con sus respectivos autores.
4. **Modificar Autores**: Actualiza el nombre y/o la fecha de nacimiento de los autores registrados.
5. **Modificar Libros**: Permite cambiar el título y/o el año de publicación de los libros.
6. **Eliminar Autores**: Borra un autor y sus libros asociados de manera segura.
7. **Eliminar Libros**: Elimina un libro específico de la base de datos.
8. **Salir del Programa**: Finaliza la ejecución de manera segura.

---

## Clases implementadas

### **`Main`**
Es la clase principal del proyecto, que incluye un menú interactivo para que el usuario realice operaciones CRUD sobre los autores y libros almacenados en la base de datos.

### **`Autor`**
Representa la entidad de autores en la base de datos. Sus atributos principales son:
- **`id`** (autogenerado).
- **`nom`** (nombre del autor).
- **`dataNaixement`** (fecha de nacimiento del autor).
- **`llibres`** (conjunto de libros asociados al autor).

### **`Llibre`**
Representa la entidad de libros en la base de datos. Sus atributos principales son:
- **`id`** (autogenerado).
- **`titol`** (título del libro).
- **`anyPublicacio`** (año de publicación del libro).
- **`autor`** (autor asociado al libro).

### **`Metodos`**
Contiene la lógica para realizar operaciones sobre las entidades `Autor` y `Llibre`. Las principales funcionalidades son:
- **Insertar autores**.
- **Insertar libros**.
- **Listar datos de autores y libros**.
- **Modificar registros existentes**.
- **Eliminar registros de manera segura**.

### **`hibernate`**
Gestor de sesiones de Hibernate para conectar con la base de datos MySQL. Configura y maneja el ciclo de vida de las sesiones.

### **`Basededatos`**
Clase utilitaria para la creación inicial de la base de datos en MySQL.

---

## Ecosistema de desarrollo

- **Sistema Operativo**: Compatible con cualquier sistema que soporte Java y MySQL.
- **IDE recomendado**: IntelliJ IDEA, Eclipse, NetBeans.
- **Versión de Java**: JDK 17 o superior.
- **Base de datos**: MySQL.
- **ORM**: Hibernate configurado mediante `hibernate.cfg.xml`.

---

## Cuaderno de carga

### Cómo ejecutar

1. Configurar el proyecto:
    En el archivo clase `Main` hay una variable declarada String ip, necesitas cambiar **//localhost:3307** para poder obviamente conectarte al server de MySQL, modificas 'localhost' por un ip o no  y '3307' por el puerto donde estas ejecutando MySQL. A continuación, hay una variable String nombreBaseDatos, la cual la modificas para darle el nombre que tu quieres a la base de datos que se creara en tu MySQL Server. Finalmente, modifica tambien el **usuario** y la **contra** para que puedas acceder a tu propia conexión.

    PD:No es necesario modificar el archivo hibernate.cfg.xml porque estoy usando System.setProperty para ya modificar el archivo de hibernate.

2. Ejecutar el proyecto:
   - Abre el proyecto en tu IDE.
   - Ejecuta la clase `Main` para iniciar el menú interactivo.

   PD:Las tablas **Autor** y **Llibre** aparareceran en mysql workbench cuando decidas seleccionar alguna opcion del menú.

### Opciones del menú

- **1. Crear Autores**:
  - Ingresa el nombre y la fecha de nacimiento del autor.
  - Valida que los campos sean correctos antes de almacenarlos.
- **2. Crear Libros**:
  - Agrega un libro especificando su título, año de publicación, y el ID de un autor existente.
  - Valida que el autor exista en la base de datos.
- **3. Mostrar Datos**:
  - Lista todos los autores junto con sus libros asociados.
  - Muestra todos los libros con sus respectivos autores.
- **4. Modificar Autores**:
  - Permite actualizar el nombre y/o la fecha de nacimiento de un autor por ID.
- **5. Modificar Libros**:
  - Actualiza el título y/o el año de publicación de un libro por ID.
- **6. Eliminar Autores**:
  - Elimina un autor específico y todos sus libros asociados.
- **7. Eliminar Libros**:
  - Borra un libro específico por ID.
- **8. Salir del Programa**:
  - Cierra las conexiones y finaliza la ejecución.

---

## Consideraciones adicionales

- **Dependencias**:
  - Incluye las librerías necesarias para Hibernate y MySQL en tu archivo `pom.xml` si utilizas Maven:
    ```xml
    <dependencies>
        <dependency>
            <groupId>org.hibernate.orm</groupId>
            <artifactId>hibernate-core</artifactId>
            <version>6.6.3.Final</version>
        </dependency>

        <dependency>
            <groupId>com.mysql</groupId>
            <artifactId>mysql-connector-j</artifactId>
            <version>8.3.0</version>
        </dependency>
        <dependency>
            <groupId>jakarta.persistence</groupId>
            <artifactId>jakarta.persistence-api</artifactId>
            <version>3.1.0</version>
        </dependency>
    </dependencies>
    ```

