# Conversión entre XML y JSON con Java

## Descripción del proyecto

Este proyecto implementa un sistema de conversión entre los formatos **XML** y **JSON** utilizando la biblioteca **org.json** en un proyecto **Java** con **Maven**. El objetivo principal es practicar la manipulación de datos, el uso de bibliotecas y el concepto de encapsulación en las clases.

### Funcionalidades principales

1. **Conversión de XML a JSON**:
    - Transforma un documento XML (cadena de texto) en un objeto de tipo `JSONObject`.
    - Gestiona errores si el documento XML no es válido.

2. **Conversión de JSON a XML**:
    - Transforma un objeto `JSONObject` en una cadena de texto en formato XML.
    - Gestiona errores si el objeto JSON no es válido para la conversión.

3. **Lectura y escritura de archivos**:
    - Lee un archivo XML desde el disco, lo convierte a JSON y lo guarda en un archivo nuevo.
    - Lee el archivo JSON generado, lo convierte a XML y lo guarda en otro archivo.

4. **Impresión de resultados**:
    - Muestra el contenido del archivo XML original, el JSON generado y el XML reconvertido.

---

## Clases implementadas

### **`Xml2Json`**
Clase que implementa la funcionalidad de conversión de XML a JSON. Sus principales características son:
- **Método público**:
    - **`convertirXmlAJson(String xmlString)`**:
        - Convierte una cadena de texto XML en un objeto `JSONObject`.
        - Lanza una excepción si el texto proporcionado no es un XML válido.

### **`Json2Xml`**
Clase que implementa la funcionalidad de conversión de JSON a XML. Sus principales características son:
- **Método público**:
    - **`convertirJsonAXml(JSONObject jsonObject)`**:
        - Convierte un objeto `JSONObject` en una cadena de texto XML.
        - Lanza una excepción si el objeto JSON no es válido para la conversión.

### **`Main`**
Clase principal del proyecto encargada de probar las funcionalidades:
- Lee un archivo XML, lo convierte a JSON y guarda el resultado.
- Lee el archivo JSON generado, lo convierte a XML y guarda el resultado.
- Muestra el contenido de los archivos por consola.

---

## Ecosistema de desarrollo

- **Sistema Operativo**: Compatible con cualquier sistema que soporte Java.
- **IDE recomendado**: IntelliJ IDEA, Eclipse, NetBeans.
- **Versión de Java**: JDK 17 o superior.
- **Biblioteca JSON**: org.json.
- **Gestor de dependencias**: Maven.

---

## Cuaderno de carga

### Cómo ejecutar

Para ejecutar el proyecto debemos introducir el archivo xml que deseamos convertir a json y al reves dentro de la carpeta resources. Una vez hecho ese paso, procederemos a darle al boton  de play dentro en el IDE y los archivos que se crearan a causa del encendido del proyecto apareceran en el root de la carpeta del proyecto.# Conversión entre XML y JSON con Java

## Descripción del proyecto

Este proyecto implementa un sistema de conversión entre los formatos **XML** y **JSON** utilizando la biblioteca **org.json** en un proyecto **Java** con **Maven**. El objetivo principal es practicar la manipulación de datos, el uso de bibliotecas y el concepto de encapsulación en las clases.

### Funcionalidades principales

1. **Conversión de XML a JSON**:
    - Transforma un documento XML (cadena de texto) en un objeto de tipo `JSONObject`.
    - Gestiona errores si el documento XML no es válido.

2. **Conversión de JSON a XML**:
    - Transforma un objeto `JSONObject` en una cadena de texto en formato XML.
    - Gestiona errores si el objeto JSON no es válido para la conversión.

3. **Lectura y escritura de archivos**:
    - Lee un archivo XML desde el disco, lo convierte a JSON y lo guarda en un archivo nuevo.
    - Lee el archivo JSON generado, lo convierte a XML y lo guarda en otro archivo.

4. **Impresión de resultados**:
    - Muestra el contenido del archivo XML original, el JSON generado y el XML reconvertido.

---

## Clases implementadas

### **`Xml2Json`**
Clase que implementa la funcionalidad de conversión de XML a JSON. Sus principales características son:
- **Método público**:
    - **`convertirXmlAJson(String xmlString)`**:
        - Convierte una cadena de texto XML en un objeto `JSONObject`.
        - Lanza una excepción si el texto proporcionado no es un XML válido.

### **`Json2Xml`**
Clase que implementa la funcionalidad de conversión de JSON a XML. Sus principales características son:
- **Método público**:
    - **`convertirJsonAXml(JSONObject jsonObject)`**:
        - Convierte un objeto `JSONObject` en una cadena de texto XML.
        - Lanza una excepción si el objeto JSON no es válido para la conversión.

### **`Main`**
Clase principal del proyecto encargada de probar las funcionalidades:
- Lee un archivo XML, lo convierte a JSON y guarda el resultado.
- Lee el archivo JSON generado, lo convierte a XML y guarda el resultado.
- Muestra el contenido de los archivos por consola.

---

## Ecosistema de desarrollo

- **Sistema Operativo**: Compatible con cualquier sistema que soporte Java.
- **IDE recomendado**: IntelliJ IDEA, Eclipse, NetBeans.
- **Versión de Java**: JDK 17 o superior.
- **Biblioteca JSON**: org.json.
- **Gestor de dependencias**: Maven.

---

## Cuaderno de carga

### Cómo ejecutar

Para ejecutar el proyecto debemos introducir el archivo xml que deseamos convertir a json y al reves dentro de la carpeta resources. Una vez hecho ese paso, procederemos a darle al boton  de play dentro en el IDE y los archivos que se crearan a causa del encendido del proyecto apareceran en el root de la carpeta del proyecto.