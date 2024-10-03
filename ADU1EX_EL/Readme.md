# Sistema de Gestión de Archivos - Java

## Descripción de la funcionalidad desarrollada

Este proyecto implementa un sistema de gestión de archivos en Java que permite:
- Leer archivos de texto y binarios (como imágenes).
- Copiar archivos de texto y binarios desde un archivo fuente a un archivo de destino.
- Gestionar los permisos de escritura de los archivos para añadir o eliminar permisos.
- Diferenciar automáticamente entre archivos `.txt` y `.jpg` para realizar la operación adecuada según la extensión.

### Clases Implementadas
1. **`AccesFileInputX8157779R`**: Lee archivos utilizando `FileInputStream`, mostrando el contenido byte a byte en la consola.
2. **`AccesFileOutputX8157779R`**: Copia archivos binarios o de otros tipos utilizando `FileInputStream` y `FileOutputStream`.
3. **`AccesFileReaderX8157779R`**: Lee archivos de texto utilizando `FileReader`, mostrando el contenido carácter por carácter.
4. **`AccesFileWriterX8157779R`**: Copia archivos de texto desde un archivo fuente a un archivo de destino utilizando `FileReader` y `FileWriter`.
5. **`FileX8157779R`**: Gestiona los permisos de escritura de los archivos, permitiendo añadir o eliminar permisos de escritura.

---

## Información sobre el ecosistema de desarrollo

- **Sistema Operativo Utilizado**: Windows 10.
- **IDE Utilizado**: El IDE principal utilizado para el desarrollo es **IntelliJ IDEA**.
- **SDK de Java Utilizado**: Java SE Development Kit (JDK) 23.
- **Versión de Java**: Java SE 17 o superior.
- **Librería Utilizada**: Librería `java.io` para la gestión de archivos.
- **Compatibilidad**: El proyecto hace uso exclusivo de librerías estándar de Java, y no tiene dependencias externas.

---

## Cuaderno de carga

### Modificación para manejar archivos .jpg

En un principio, para iniciar la ejecución del programa basta con darle click al botón de play que acciona el run java.

Para manejar el caso de los archivos con extensión `.jpg`, es necesario cambiar la variable path asignada en la función getFileExtension, que se encuentra en la línea 21 del código. Esta función es la encargada de detectar la extensión del archivo y, en función de esta, se ejecutarán las operaciones adecuadas.
