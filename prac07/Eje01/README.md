# Ejercicio 01 - Singleton (Configuración)

Descripción

Esta carpeta contiene una implementación sencilla del patrón Singleton en Java.

- `Configuracion.java`: clase que mantiene valores de configuración del sistema (por ejemplo, `idioma` y `zonaHoraria`). Está implementada como Singleton (constructor privado y método estático para obtener la instancia única).
- `Main.java`: ejemplo de uso que obtiene la instancia, modifica valores y muestra en consola que todas las referencias apuntan a la misma instancia.

Propiedades por defecto

- `idioma`: `es`
- `zonaHoraria`: se obtiene desde la zona por defecto del sistema con `ZoneId.systemDefault()`.

Ejecutar el ejemplo (PowerShell)

```powershell
javac Configuracion.java Main.java
java Main
```

Salida (captura de consola)

![Salida del programa](./Consola.jpg)

Notas sobre concurrencia y alternativas

- En esta implementación `getInstance()` está sincronizado para evitar la creación de varias instancias en escenarios multi-hilo. Esto es seguro pero puede tener un coste de rendimiento si se llama con mucha frecuencia.
- Alternativas más eficientes:
  - Double-checked locking con un campo `volatile`.
  - Inicialización temprana (eager): `private static final Configuracion INST = new Configuracion();`.
  - Usar un `enum` como Singleton (`enum Singleton { INSTANCE; }`), que es seguro frente a serialización y reflexión.

Autor: Mikhail Gabino Velasque Arcos
