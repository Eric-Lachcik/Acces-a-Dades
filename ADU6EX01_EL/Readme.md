# Microservicio de Gestión de Productos con Spring Boot y SQLite  

## 📋 Descripción del Proyecto  

Este proyecto implementa una **API REST** con Spring Boot para gestionar productos almacenados en una base de datos **SQLite**. El objetivo es practicar el desarrollo de microservicios, las operaciones CRUD (Crear, Leer, Actualizar, Eliminar) y la integración con bases de datos SQL.  

---

## 🚀 Funcionalidades Principales  

- **Operaciones CRUD completas**:  
  - `POST /productos`: Crear un nuevo producto.  
  - `GET /productos`: Listar todos los productos.  
  - `GET /productos/{id}`: Obtener un producto por ID.  
  - `PUT /productos/{id}`: Actualizar un producto existente.  
  - `DELETE /productos/{id}`: Eliminar un producto.  

- **Validación de datos**:  
  - Campos obligatorios: `nombre`, `precio`, `cantidad` (no pueden ser nulos).  
  - Errores gestionados: `404 Not Found`, `400 Bad Request`, etc.  

- **Persistencia de datos**:  
  - Base de datos SQLite local (`identifier.sqlite`).  
  - Configuración automática con Hibernate.  

---

## 🛠️ Clases Implementadas  

### **`Producto` (Entidad JPA)**  
- **Propósito**: Representa un producto almacenado en la base de datos SQLite.  
- **Características**:  
  - Mapea la tabla `productos` con campos: `id`, `nombre`, `descripción`, `precio`, `cantidad`.  
  - Validación de campos obligatorios (`nombre`, `precio`, `cantidad`).  
  - Anotaciones JPA: `@Entity`, `@Table`, `@Id`, `@GeneratedValue`.  

---

### **`ProductoRepository` (Repositorio)**  
- **Propósito**: Gestiona las operaciones CRUD con la base de datos.  
- **Características**:  
  - Extiende `JpaRepository` para heredar métodos como `save()`, `findById()`, `findAll()`, `deleteById()`.  
  - No requiere implementación manual gracias a Spring Data JPA.  

---

### **`ProductoController` (Controlador REST)**  
- **Propósito**: Gestiona las peticiones HTTP y enruta las operaciones CRUD.  
- **Endpoints principales**:  
  - `POST /productos`: Crea un nuevo producto.  
  - `GET /productos`: Devuelve todos los productos.  
  - `GET /productos/{id}`: Devuelve un producto por ID.  
  - `PUT /productos/{id}`: Actualiza un producto existente.  
  - `DELETE /productos/{id}`: Elimina un producto.  

---

### **`Adu6Ex01ElApplication` (Clase Principal)**  
- **Propósito**: Inicializa la aplicación Spring Boot.  
- **Características**:  
  - Anotación `@SpringBootApplication` para habilitar la autoconguración.  
  - Método `main` para ejecutar el servidor.  


## 🖥️ Ecosistema de desarrollo  

- **Sistema Operativo**:  
  ✅ Compatible con Windows, Linux y macOS.  
- **IDE recomendado**:  
  - **IntelliJ IDEA** (Versión Ultimate o Community)  
- **Versión de Java**:  
  - JDK 17 o superior (Se recomienda **Amazon Corretto 17**).  
- **Gestión de dependencias**:  
  - **Maven** (versión 3.6.3 o superior).  
- **Herramientas adicionales**: 
  - **Postman** (para pruebas de endpoints).  

---

## Cuaderno de carga

### Cómo ejecutar

Para ejecutar el proyecto en teoria es facil basta con tener descargadas las depednecias del pom y darle al boton de play del IDE que este usando y a partir de alli dirigirse a cualquier herramienta para probar las directrices CRUD.