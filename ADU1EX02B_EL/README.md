# Lectura de Archivos XML con SAX en Java

## Descripción de la funcionalidad desarrollada

Este proyecto implementa una funcionalidad de lectura y procesamiento de archivos XML utilizando el método SAX  en Java. Con esta herramienta podrás:

- Leer y procesar archivos XML de manera eficiente.
- Extraer información específica de los nodos dentro de los archivos XML.
- Imprimir los detalles de los elementos encontrados de forma clara y organizada.

### Clases Implementadas

1. **`App`**: La clase principal que se encarga de ejecutar el parser sobre el archivo XML.
2. **`LlibreHandler`**: Clase que extiende de `DefaultHandler` para manejar los eventos SAX como el inicio y fin de elementos XML.
3. **`Llibre`**: Clase POJO que representa un libro con atributos como título, autor, año y resumen.

---

## Información sobre el ecosistema de desarrollo

- **Sistema Operativo**: Windows 10 (aunque es compatible con cualquier sistema que soporte Java).
- **IDE Recomendado**: IntelliJ IDEA.
- **SDK de Java**: JDK 17 o superior.
- **Librerías Utilizadas**: 
  - `java.io` para la gestión de archivos.
  - `javax.xml.parsers` para crear y configurar el `SAXParser`.
  - `org.xml.sax` para el análisis y procesamiento de los archivos XML.

Este proyecto utiliza solo las librerías estándar de Java y no requiere dependencias externas adicionales.

---

## Instrucciones de Uso
Para utilizar el proyecto, coloca el archivo XML en la carpeta resources y ajusta la ruta correspondiente en la clase App. Luego, ejecuta el proyecto  haciendo clic en el botón de play.


