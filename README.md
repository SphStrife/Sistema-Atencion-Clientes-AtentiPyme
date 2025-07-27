# AtentiPyme – Sistema de Registro de Solicitudes

Sistema de consola en Java que permite registrar, guardar y consultar solicitudes de atención al cliente para pequeñas empresas.

## Descripción
Solución ligera, persistente y funcional que simula el flujo de un sistema de tickets de soporte. Guarda la información en un archivo local (`solicitudes.txt`) y genera un número de ticket automático por cada registro.

## Tecnologías
- Java 17
- GitHub
- GitHub Actions
- Consola (CLI)
- Archivo `.txt` como sistema de persistencia

## Instalación
1. Instala Java 17
2. Clona el repositorio
3. Ejecuta:
```bash
javac RegistroSolicitudes.java
java RegistroSolicitudes
```

## Uso
Opción 1: registrar una nueva solicitud

Opción 2: consultar todas las solicitudes

Opción 3: salir del sistema

## Datos persistidos
Todas las solicitudes se almacenan en un archivo de texto con este formato:

1;Juan Perez;Soporte;Alta;No puedo acceder a mi cuenta

## Contribución
Haz fork del repositorio

Crea una nueva rama con tu feature (git checkout -b feature/NuevaFuncionalidad)

Haz commit (git commit -m "Agrego nueva funcionalidad")

Sube los cambios (git push origin feature/NuevaFuncionalidad)

Abre un pull request

## Roadmap futuro
 Panel web con interfaz visual

 Login de usuarios (cliente y administrador)

 Exportación de reportes en PDF

 Filtros por estado, prioridad, fecha

 Integración con base de datos real (MySQL, PostgreSQL)
