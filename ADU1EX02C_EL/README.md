# Lectura de Archivos XML con JAXB en Java

## Descripción de la funcionalidad desarrollada

Este proyecto implementa una funcionalidad de lectura y procesamiento de archivos XML utilizando la tecnología **JAXB** en Java. Con esta herramienta podrás:

- Leer y procesar archivos XML de manera eficiente mediante el mapeo a clases Java.
- Extraer y deserializar automáticamente la información de los nodos dentro del archivo XML.
- Imprimir los detalles de los elementos de forma clara y organizada en la consola.

### Clases Implementadas

1. **`Main`**: La clase principal que ejecuta el proceso de deserialización del archivo XML utilizando JAXB.
2. **`Llibres`**: Clase que representa la raíz del archivo XML. Contiene una lista de objetos `Llibre`.
3. **`Llibre`**: Clase POJO que representa un libro con atributos como autor, título, año y resumen.

---

## Información sobre el ecosistema de desarrollo

- **Sistema Operativo**: Windows 10 (aunque es compatible con cualquier sistema que soporte Java).
- **IDE Recomendado**: IntelliJ IDEA.
- **SDK de Java**: JDK 17 o superior.
- **Librerías Utilizadas**: 
  - `jakarta.xml.bind` para la implementación de JAXB y la deserialización del XML.
  - `java.io` para la gestión de archivos.

Este proyecto utiliza solo las librerías estándar de Java, específicamente las relacionadas con JAXB, y no requiere dependencias externas adicionales.

---

## Cuaderno de carga

Coloca el archivo XML llamado llibres.xml en la carpeta resources, ajusta la ruta en la clase Main si es necesario, y ejecuta el proyecto haciendo clic en el botón de "play" en el IDE; el programa deserializará el contenido del archivo XML a objetos Java e imprimirá la información en la consola. 
