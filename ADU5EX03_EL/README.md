# Proyecto de conversión de JSON a XML con MongoDB

## Descripción del proyecto

Este proyecto implementa un sistema que permite la conversión de documentos **JSON** a **XML**, almacenados en una base de datos **MongoDB**. La conversión se realiza mediante la biblioteca **org.json** en un proyecto **Java** con **Maven**. El sistema permite recuperar documentos desde una colección de MongoDB, convertirlos a formato XML y mostrarlos por consola.

---

## Funcionalidades principales

1. **Conexión con MongoDB:**
   - Conexión automática a una base de datos local de MongoDB.
   - Lectura de documentos desde la colección configurada.

2. **Conversión de JSON a XML:**
   - Transformación de documentos JSON almacenados en MongoDB a formato XML.
   - Manejo de excepciones en caso de datos no convertibles.

3. **Visualización de resultados:**
   - Impresión en consola de los documentos JSON originales y su representación en formato XML.

---

## Clases implementadas

### **`Main`**
Clase principal del proyecto encargada de conectar con la base de datos MongoDB, leer los documentos y realizar las conversiones JSON a XML.

#### Características principales:
- **Atributos:**
  - `Url`: URL de la base de datos MongoDB.
  - `DATABASE_NAME`: Nombre de la base de datos.
  - `COLLECTION_NAME`: Nombre de la colección donde se almacenan los documentos JSON.

- **Método principal:**
  - Conecta a MongoDB y lee los documentos de la colección configurada.
  - Convierte cada documento JSON a XML mediante la clase `JSONaXML`.
  - Maneja excepciones si ocurren errores durante la conversión.

### **`JSONaXML`**
Clase encargada de realizar la conversión de objetos JSON a cadenas de texto en formato XML.

#### Características principales:
- **Método público:**
  - `convertirJsonAXml(JSONObject jsonObject)`: Convierte un objeto `JSONObject` a una cadena en formato XML.
  - Lanza una excepción si el objeto JSON no es válido para la conversión.

---

## Ecosistema de desarrollo

- **Sistema Operativo:** Compatible con cualquier sistema que soporte Java.
- **IDE recomendado:** IntelliJ IDEA, Eclipse, NetBeans.
- **Versión de Java:** JDK 17 o superior.
- **Bibliotecas:**
  - **MongoDB Driver:** org.mongodb (versión 5.2.1).
  - **JSON Library:** org.json (versión 20231013).
- **Gestor de dependencias:** Maven.

---

## Cuaderno de carga

Antes de ejecutar el proyecto  tienes que modificar la variable String **Url** con la Url de la conexion de tu Mongo. Para finalizar, ejecute el proyecto dando le al botón de play de tu IDE y se ejecutara el proyecto.
