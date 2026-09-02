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
| Emanuel Sotelo | [@EmaNicoSotelo](https://github.com/EmaNicoSotelo) |
| Juan Cruz Cusato | [@JuanchiCusato](https://github.com/JuanchiCusato) |

## Registro de actualizaciones

Cada actualización del repositorio debe registrarse en la siguiente tabla, indicando el caso de uso realizado y el responsable.

| Fecha | Caso de uso | Responsable |
|---|---|---|
| 1-9-2026 | Festival con sus Unidades de venta Habilitadas | Nicolas Campusano |
| 1-9-2026 | Unidad de venta con su menu de platos | Nicolas Campusano |
| 1-9-2026 | Empleado:Cocinero (búsqueda por Especialidad) | Santiago Saitz | 
| 1-9-2026 | Empleado:Cocinero (búsqueda por PlusCategoria) | Santiago Saitz | 
| 1-9-2026 | Cantidad total vendida de un Plato | Emanuel Sotelo |
| 1-9-2026 | Pedidos realizados en un Festival (con sus items) | Emanuel Sotelo |

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
├── negocio/    Capa de negocio (con filtros y lógica)
├── sql/        Scripts sql a ejecutar
└── hibernate.cfg.xml
```

## Configuración inicial

1. Crear la base de datos en MySQL antes de ejecutar el proyecto con el archivo create.sql.
2. Verificar usuario y contraseña en `hibernate.cfg.xml`.
3. Agregar al build path los JAR de `hibernate-release-5.6.5.Final/lib/required/` y el Connector/J.
4. Ejecutar el proyecto para que se creen las tablas en la base de datos.
5. Ejecutar el archivo inserts.sql para agregar los registros en la BD.
