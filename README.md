# TPGrupalOO2Hito1Grupo11

Trabajo Práctico Grupal — Objetos 2 — Hito 1

## Grupo

**Número de grupo:** 11

## Integrantes

| Nombre y Apellido | Usuario GitHub |
|---|---|
| Santiago Saitz | [@santiimagine](https://github.com/santiimagine) |
| Francisco Robles Acuña | [@Francisco-Robles](https://github.com/Francisco-Robles) |
| Nicolas Campusano | [@NicoPro03](https://github.com/NicoPro03) |
| Emanuel Sotelo | _(completar)_ |

## Registro de actualizaciones

Cada actualización del repositorio debe registrarse en la siguiente tabla, indicando el caso de uso realizado y el responsable.

| Fecha | Caso de uso | Responsable |
|---|---|---|
| | | |

## Tecnologías

- Java 19 (JDK 19)
- Hibernate ORM 5.6.5.Final
- MySQL + Connector/J
- Eclipse IDE

## Estructura del proyecto

```
src/
├── modelo/     Clases del dominio
├── mapeos/     Archivos de mapeo (.hbm.xml)
├── dao/        Capa de acceso a datos
└── hibernate.cfg.xml
```

## Configuración inicial

1. Crear la base de datos en MySQL antes de ejecutar el proyecto.
2. Verificar usuario y contraseña en `hibernate.cfg.xml`.
3. Agregar al build path los JAR de `hibernate-release-5.6.5.Final/lib/required/` y el Connector/J.
