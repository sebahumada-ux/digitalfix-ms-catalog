# DigitalFix - Microservicio Catalog

Microservicio encargado de la gestión del catálogo técnico del proyecto **DigitalFix**.

## Integrantes

- Sebastián Ahumada
- Benjamín Gutiérrez

## Tecnologías utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- Jakarta Validation
- Maven
- Oracle Database
- Oracle JDBC
- Docker

## Funcionalidades implementadas

El microservicio permite:

- Listar servicios técnicos.
- Consultar un servicio por su identificador.
- Crear nuevos servicios.
- Actualizar servicios existentes.
- Gestionar nombre, descripción, tarifa y stock.
- Definir si un servicio se encuentra activo.
- Persistir la información en Oracle Database.

## Datos de un servicio

Cada servicio del catálogo contiene:

```text
id
nombre
descripcion
tarifa
stock
activo
````

## Puerto

El microservicio utiliza el puerto:

```text
8082
```

## Endpoints

Ruta base:

```text
/api/catalog/services
```

Operaciones disponibles:

```text
GET  /api/catalog/services
GET  /api/catalog/services/{id}
POST /api/catalog/services
PUT  /api/catalog/services/{id}
```

## Persistencia

El microservicio utiliza Oracle Database para almacenar los servicios técnicos.

La entidad principal se almacena en:

```text
CATALOG_SERVICES
```

Los datos administrados incluyen:

* Nombre.
* Descripción.
* Tarifa.
* Stock.
* Estado activo/inactivo.

Las credenciales de base de datos no se almacenan directamente en el repositorio.

## Arquitectura

El flujo utilizado por DigitalFix es:

```text
Angular
   |
   v
AWS API Gateway
   |
   v
DigitalFix BFF
   |
   v
Catalog :8082
   |
   v
Oracle Database
```

El frontend no consume directamente este microservicio.

Las solicitudes pasan primero por el BFF de DigitalFix.

## Seguridad

El acceso externo al catálogo se controla mediante:

```text
Microsoft Entra ID
→ JWT
→ AWS API Gateway
→ BFF
→ Catalog
```

Los permisos son validados en el BFF.

El catálogo está disponible para:

```text
Admin
Supervisor
```

El rol Cliente no posee acceso al catálogo técnico.

## Docker

El proyecto incluye un:

```text
Dockerfile
```

El microservicio se ejecuta como contenedor Docker dentro de la infraestructura de DigitalFix.

Nombre del contenedor utilizado:

```text
digitalfix-catalog
```

## Compilación

En Windows:

```powershell
.\mvnw.cmd clean package
```

También puede utilizarse:

```powershell
.\mvnw.cmd compile
```

## Ejecución local

En Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

En Linux:

```bash
./mvnw spring-boot:run
```

## Flujo de trabajo Git

El proyecto utiliza las ramas:

```text
main
development
feature/*
```

Flujo utilizado:

```text
feature/*
   ↓
Pull Request
   ↓
development
   ↓
Pull Request de release
   ↓
main
```

Cada funcionalidad se desarrolla en una rama independiente y posteriormente se integra mediante Pull Request.

## Estado del proyecto

Actualmente se encuentran implementados y validados:

* Consulta del catálogo.
* Consulta de servicios por ID.
* Creación de servicios.
* Actualización de servicios.
* Persistencia en Oracle Database.
* Comunicación con el BFF.
* Ejecución mediante Docker.
* Despliegue en AWS EC2.
