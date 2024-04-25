# Parte I Bases de datos

En la carpeta scripts hay 4 archivos numerados de 1 a 4. En 1 se crean las tablas y en 2 se cargan los datos iniciales de cada tabla, en 3 se realizan distintas consultas basicas(Insert, Select, Update y Delete) y en 4 se realizan consultas mas complejas usando join, union y case.

Para ejecutar los scripts, primero crear un esquema llamado universidad en MySQL Workbench

## Diagrama relacional de la base de datos

![alt text](./Parte-I-Bases-de-datos/diagrama-base-datos.png)

# Parte II API - Academic History

Se crea al API para cada tabla, tomando en cuenta sus relaciones, se uso MySql como gestor de base de datos, Java 21 y springboot como framework.

Para ejecutar el proyecto abrir en Intellij o VS Code la carpeta: Parte-II-API-academic-history. Luego abrir el aplication.properties, que se encuentra en la ruta src/main/resources, se va a colocar el usuario y contraseña que se tenga configurado en MySqlWorkbench, el puerto no se modifica se deja en 8083, en MySqlWorkbench se crea el esquema universidad para que al ejecutar el proyecto springboot se pueda conectar a este:

## application.properties

```
server.port:8083
spring.datasource.url = jdbc:mysql://127.0.0.1:3306/universidad
spring.datasource.username=usuario
spring.datasource.password=contresenia
# Show or not log for each sql query
spring.jpa.show-sql=true
# Hibernate ddl auto (create, create-drop, update): with "create-drop" the database
# schema will be automatically created afresh for every start of application
spring.jpa.hibernate.ddl-auto=update
# Allows Hibernate to generate SQL optimized for a particular DBMS
spring.user.datasource.driver-class-name=com.mysql.jdbc.driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.properties.hibernate.format_sql=true
```

## Link colección de endpoinst API parte III: 
## https://documenter.getpostman.com/view/23052515/2sA3BrZAjT

