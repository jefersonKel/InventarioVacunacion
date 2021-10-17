<!-- AMBIENTE DE TRABAJO -->
## Requisitos
* [jdk-11.0.11](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)
* [postgresql-14.0-1](https://www.postgresql.org/download/)

## Instalación
1. Clonar el repositorio o descargar desde https://github.com/jefersonKel/InventarioVacunacion
  ```sh
  git clone git@github.com:jefersonKel/InventarioVacunacion.git
  ```
2. Configurar conexión de base de datos en el archivo .properties: inventariovacunacion\src\main\resources\application.properties
  ```
  spring.datasource.url=jdbc:postgresql://localhost:5432/NombreBaseDatos
  spring.datasource.username=postgres
  spring.datasource.password=postgres
  ```
3. Ejecutar script de base de datos en el archivo .sql: inventariovacunacion\src\main\resources\Sql\postgres.sql

4. Por el terminal ir a la carpera raiz inventariovacunacion\ y ejecutamos la aplicación con el comando:
  ```
  .\mvnw.cmd spring-boot:run
  ```
5. Comprobar la aplicación en el navegador con la url: http://localhost:8080/usuarios debe retornar un json con la información que se ingreso desde el archivo postgres.sql
 ```
 [{"id":1,"identificacion":"ADMIN","contrasena":"ADMIN","nombres":"ADMINISTRADOR","rol":"ADMINISTRADOR"}]
 ```
## Documentación de la API
Se uso la Swagger-OpenAPI para documentar la API. para ingresar debera ir a: http://localhost:8080/swagger-ui/index.html?configUrl=/api-docs/swagger-config/

