# ms-pedidos

## Descripción

Microservicio desarrollado con Spring Boot para la gestión de pedidos.

Permite:

* Registrar pedidos
* Listar pedidos
* Obtener pedidos por ID
* Actualizar estado del pedido
* Cancelación lógica de pedidos

El sistema calcula automáticamente el total del pedido utilizando:

* cantidad
* precio unitario

El proyecto utiliza PostgreSQL como base de datos y sigue una arquitectura basada en capas:

* Controller
* Service
* Repository
* Entity
* DTO
* Exception Handler

---

# Tecnologías utilizadas

* Java 17
* Spring Boot 4
* Spring Web
* Spring Data JPA
* PostgreSQL
* Hibernate
* Maven
* Lombok
* Docker
* Render
* Neon

---

# Endpoints disponibles

## Crear pedido

POST `/api/pedidos`

### Body

```json
{
  "cliente": "Juan Perez",
  "correoCliente": "juan@gmail.com",
  "productoId": 1,
  "nombreProducto": "Laptop Lenovo",
  "cantidad": 2,
  "precioUnitario": 3500
}
```

---

## Listar pedidos

GET `/api/pedidos`

---

## Obtener pedido por ID

GET `/api/pedidos/{id}`

---

## Actualizar estado del pedido

PATCH `/api/pedidos/{id}/estado`

### Body

```json
{
  "estado": "ENTREGADO"
}
```

---

## Eliminar pedido (cancelación lógica)

DELETE `/api/pedidos/{id}`

---

# Variables de entorno necesarias

```properties
DB_URL=
DB_USERNAME=
DB_PASSWORD=
PORT=
```

---

# application.properties

```properties
spring.application.name=ms-pedidos

server.port=${PORT:8082}

spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

---

# Instrucciones para ejecutar en local

## 1. Clonar repositorio

```bash
git clone URL_DEL_REPOSITORIO
```

---

## 2. Ingresar al proyecto

```bash
cd ms-pedidos
```

---

## 3. Configurar variables de entorno

Ejemplo:

```properties
DB_URL=jdbc:postgresql://localhost:5432/bdproductos
DB_USERNAME=postgres
DB_PASSWORD=123456
```

---

## 4. Ejecutar proyecto

```bash
mvn spring-boot:run
```

---

# Docker

## Construir imagen

```bash
docker build -t ms-pedidos .
```

---

# Instrucciones básicas de despliegue

## Render

1. Crear nuevo Web Service
2. Conectar repositorio GitHub
3. Configurar variables de entorno
4. Deploy automático

---

## Neon

1. Crear proyecto PostgreSQL
2. Copiar credenciales de conexión
3. Configurar variables DB_URL, DB_USERNAME y DB_PASSWORD en Render

---

# URL del servicio desplegado

```text
PENDIENTE
```
