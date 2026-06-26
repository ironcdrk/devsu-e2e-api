# Devsu E2E + API Automation

Proyecto de automatización que contiene pruebas **E2E Web** sobre SauceDemo y pruebas **API** sobre DemoBlaze, manteniendo ambas suites dentro de un mismo repositorio Gradle.

## Tecnologías utilizadas

* Java 17
* Gradle
* Serenity BDD
* Cucumber
* Screenplay Pattern
* Selenium WebDriver
* Karate DSL
* JUnit 5

## Estructura del proyecto

```text
src
├── main
│   └── java
│       └── devsu
│           └── e2e
│               ├── pages
│               │   └── Localizadores de las páginas web
│               │
│               ├── tasks
│               │   └── Acciones que realiza el actor durante el flujo E2E
│               │
│               └── questions
│                   └── Validaciones del estado de la aplicación
│
└── test
    ├── java
    │   ├── runners
    │   │   ├── E2ERunner.java
    │   │   └── DemoBlazeApiRunner.java
    │   │
    │   └── stepdefinitions
    │       └── Definición de pasos para los escenarios Cucumber
    │
    └── resources
        ├── features
        │   ├── Escenarios E2E de SauceDemo
        │   └── Escenarios API de DemoBlaze
        │
        ├── karate-config.js
        └── serenity.conf
```

## Automatización E2E

La automatización E2E se realiza sobre el sitio:

```text
https://www.saucedemo.com/
```

El flujo automatizado cubre:

* Acceso al sitio
* Inicio de sesión
* Agregar productos al carrito
* Abrir carrito de compras
* Iniciar checkout
* Completar formulario de compra
* Finalizar compra
* Validar mensaje de confirmación

El proyecto usa el patrón **Screenplay**, separando responsabilidades de la siguiente forma:

* `pages`: contiene los `Target` o localizadores de la interfaz.
* `tasks`: contiene las acciones que ejecuta el actor.
* `questions`: contiene validaciones sobre la información visible en pantalla.
* `stepdefinitions`: conecta los pasos escritos en Gherkin con la lógica de automatización.

## Automatización API

La automatización API se realiza sobre DemoBlaze:

```text
https://api.demoblaze.com
```

Los escenarios API están implementados con **Karate DSL** y cubren:

* Registro de usuario
* Registro de usuario ya existente
* Login con credenciales correctas
* Login con credenciales incorrectas

La configuración base de Karate se encuentra en:

```text
src/test/resources/karate-config.js
```

## Requisitos previos

Antes de ejecutar el proyecto, se debe tener instalado:

* Java 17
* Gradle o Gradle Wrapper incluido en el proyecto
* Navegador compatible para la ejecución E2E

Para validar la versión de Java:

```bash
java -version
```

## Ejecución del proyecto

Para ejecutar todas las pruebas del proyecto:

```bash
./gradlew clean test
```

En Windows:

```bash
.\gradlew.bat clean test
```

## Ejecutar solo pruebas E2E

```bash
./gradlew test --tests runners.E2ERunner
```

En Windows:

```bash
.\gradlew.bat test --tests runners.E2ERunner
```

## Ejecutar solo pruebas API

```bash
./gradlew test --tests runners.DemoBlazeApiRunner
```

En Windows:

```bash
.\gradlew.bat test --tests runners.DemoBlazeApiRunner
```

## Reportes

Al finalizar la ejecución, los reportes de Gradle se generan en:

```text
build/reports/tests/test/index.html
```

Los reportes de Serenity se generan en:

```text
target/site/serenity/index.html
```

## Comando recomendado para la revisión

Para una ejecución completa de la prueba técnica, usar:

```bash
./gradlew clean test
```

En Windows:

```bash
.\gradlew.bat clean test
```

## Notas del proyecto

* Las pruebas E2E están organizadas usando Screenplay para separar acciones, localizadores y validaciones.
* Las pruebas API están implementadas con Karate, sin necesidad de Step Definitions en Java.
* El proyecto mantiene separadas las responsabilidades de E2E y API, pero ambas automatizaciones conviven dentro del mismo repositorio.
