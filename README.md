# 🏥 Aplicación de Gestión de Pacientes y Cuidados Médicos

¡Bienvenido a la aplicación de gestión de pacientes y cuidados médicos! 🩺  
Esta aplicación está diseñada para facilitar la administración de pacientes, habitaciones, medicamentos y cuidados médicos en un entorno hospitalario o clínico. A continuación, te explicamos cómo funciona y sus principales características.

---

## 🚀 **Funcionalidades Principales**

1. **Inicio y Autenticación**
- **🌅 Pantalla de carga (SPLASH)**: Al iniciar la aplicación, se muestra una pantalla de carga mientras el sistema se prepara.
- **🔐 Inicio de sesión (LOGIN)**: Los usuarios pueden iniciar sesión con sus credenciales.
- **📝 Registro (REGISTRO)**: Si no tienes una cuenta, puedes registrarte fácilmente para comenzar a usar la aplicación.

2. **Pantalla Principal (HOME)**
- **🏠 HOME**: Una vez autenticado, el usuario es redirigido a la pantalla principal, desde donde puede acceder a todas las funcionalidades.
- **👤 Perfil de Usuario**: Accede a tu perfil para ver y editar tus datos personales.
  - **✏️ Editar Perfil**: Modifica y guarda los cambios en tu información personal.

3. **Gestión de Habitaciones y Pacientes**
- **🚪 Lista de Habitaciones**: Visualiza las habitaciones disponibles.
  - **📄 Información de Habitación**: Al seleccionar una habitación, accede a los detalles del paciente asignado y sus cuidados.
- **👥 Lista de Pacientes**: Visualiza todos los pacientes registrados.
  - **➕ Crear Paciente**: Agrega un nuevo paciente al sistema.
  - **📂 Datos del Paciente**: Accede a la información completa de un paciente seleccionado.

4. **Datos Médicos y Cuidados**
- **💊 Datos Médicos (MEDICAL DATA)**: Visualiza los detalles de los medicamentos prescritos.
  - **📄 Información de Medicamentos**: Revisa la información relevante sobre cada medicamento.
- **🩺 Cuidados (CARE DATA)**: Gestiona los registros de cuidados médicos.
  - **📋 Lista de Cuidados**: Visualiza un listado de las curas realizadas.
  - **➕ Crear Cuidados**: Añade un nuevo registro de cuidados.
  - **📄 Datos de Cuidados**: Accede a la información detallada de un cuidado específico.

---

## 📊 **DIAGRAMA DE GANTT**

```mermaid
gantt
    title PLANIFICACIÓN PROYECTO FINAL | APLICACIÓN HOSPITAL
    dateFormat  YYYY-MM-DD
    axisFormat %W

    section V0 (Planificación)
    Videollamada Córcega          :done, v0a, 2025-02-04, 1d
    Definición del proyecto       :done, v0b, 2025-02-05, 2d
    Investigación                 :done, v0c, 2025-02-08, 7d
    Requisitos del usuario        :done, v0d, 2025-02-15, 3d
    Resolución dudas Córcega      :done, v0e, 2025-02-18, 1d
    Definir mínimos y máximos     :done, v0f, 2025-02-19, 1d
    Diagramas                     :done, v0g, 2025-02-10, 10d
    Redactar documentación        :done, v0h, 2025-02-10, 10d

    section V1 (Desarrollo Mínimos)
    Videollamada seguimiento Córcega    :done,  v1a, 2025-02-21, 1d
    Desarrollo backend mínimos          :active, v1b, after v1a, 20d
    Desarrollo frontend mínimos         :active, v1c, after v1a, 2025-04-05

    section Pruebas V1
    Pruebas unitarias                   : des1, after v1c, 3d
    Pruebas de integración              : 3d
    Corrección de errores               : 3d

    section Despliegue V1
    Implementación en producción        : des4, 2025-04-15, 3d
    Mantenimiento y mejoras             : des5, 2025-04-18, 2025-04-30
    V1 Documentación                    : des6, after des1, 2025-04-30

    section V2 (Desarrollo Máximos)
    Ampliación backend máximos          : v2a, 2025-05-01, 10d
    Ampliación frontend máximos         : v2b, after v2a, 10d

    section Pruebas V2
    Pruebas unitarias                   : des7, after v2b, 2d
    Pruebas de integración              : des8, after des7, 2d
    Corrección de errores               : des9, after des8, 2d

    section Despliegue V2
    Implementación en producción        : des10, 2025-05-25, 3d
    V1 Documentación                    : des6, 2025-05-15, 2025-05-25
```

---

## 📊 **DIAGRAMA DE CASOS DE USO**

```mermaid
graph TD
    A[🌅 SPLASH] --> B[🔐 LOGIN]
    B --> C[📝 REGISTRO]
    B --> D[🏠 HOME]
    C --> D
    D --> E[👤 PERFIL]
    E --> F[✏️ EDITAR PERFIL]
    D --> G[🚪 LISTA HABITACIONES]
    G --> H[📄 INFO HABITACIONES]
    H --> I[👨‍⚕️ MENÚ PACIENTE]
    I --> J[📋 DATOS PERSONALES]
    I --> K[💊 HISTORIAL MEDICAMENTOS]
    I --> L[🩺 REGISTROS DE CUIDADOS]
    D --> M[👥 LISTA PACIENTE]
    M --> N[➕ CREAR PACIENTE]
    M --> O[📂 DATOS PACIENTE]
    D --> P[💊 MEDICAL DATA]
    P --> Q[📄 INFO MEDICINA]
    D --> R[🩺 CARE DATA]
    R --> S[📋 LISTA CURA]
    S --> T[➕ CREAR CURAS]
    S --> U[📄 DATOS CURA]
```

---

## 🎬 **VÍDEO APP**

https://youtu.be/TY8uETNxnJg 




