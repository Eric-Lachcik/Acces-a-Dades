# Gestión de Personas con Java y ObjectDB

## Descripción del proyecto

Este proyecto implementa un sistema de gestión de personas utilizando **Java** y una base de datos **ObjectDB**. La aplicación permite realizar operaciones CRUD (Crear, Leer, Actualizar y Eliminar) de manera interactiva a través de un menú en consola.

### Funcionalidades principales

1. **Crear Personas**: Permite agregar nuevos registros de personas con nombre, edad y email.
2. **Buscar Personas**: Encuentra registros por nombre para visualizar, modificar o eliminar.
3. **Eliminar Personas**: Borra registros específicos de la base de datos.
4. **Modificar Personas**: Actualiza los datos existentes de una persona.
5. **Mostrar Personas**: Lista todas las personas almacenadas en la base de datos.
6. **Salir**: Finaliza el programa de manera segura.

---

## Clases implementadas

### **`Main`**
Es la clase principal del proyecto, que incluye el menú interactivo. Este guía al usuario para realizar las operaciones disponibles sobre la base de datos.

### **`Persona`**
Representa la entidad que se almacena en la base de datos ObjectDB, con los siguientes atributos:
- **`id`** (autogenerado).
- **`nom`** (nombre de la persona).
- **`edad`** (edad de la persona).
- **`email`** (correo electrónico).

### **`Basededatos`**
Contiene métodos estáticos para realizar operaciones sobre la base de datos, como crear, buscar, modificar, eliminar y mostrar registros.

---

## Ecosistema de desarrollo

- **Sistema Operativo**: Windows 10 (compatible con cualquier sistema que soporte Java y ObjectDB).
- **IDE recomendado**: IntelliJ IDEA, Eclipse, NetBeans.
- **Versión de Java**: JDK 17 o superior.
- **Base de datos**: ObjectDB configurada mediante `persistence.xml`.

---

## Cuaderno de carga

### Como  ejecutar

- En este caso, no disponemos de URLS que dependen del ordenador en el cual se este ejecutando el proyecto, dentro del persistence esta configurado para que la base de datos de ObjectDb se cree en la raiz del proyecto. En principio con solo darle al play en tu IDE se deberia de ejecutar todo perfectamente.

### Opciones del menú

- **1. Crear Personas**:
  - Ingresa los datos (nombre, edad, email) de forma interactiva.
  - Valida los formatos de los campos antes de almacenarlos.
- **2. Buscar Personas**:
  - Localiza una persona por su nombre y elige entre modificarla, eliminarla o cancelar.
- **3. Eliminar Personas**:
  - Elimina un registro específico por nombre.
- **4. Modificar Personas**:
  - Cambia cualquier campo (nombre, edad o email) de un registro existente.
- **5. Mostrar Personas**:
  - Lista todas las personas almacenadas en la base de datos.
- **6. Salir del Programa**:
  - Cierra de forma segura las conexiones a la base de datos y finaliza la ejecución.

---