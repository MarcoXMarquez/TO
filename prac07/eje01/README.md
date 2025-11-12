# Ejercicio 01 - Singleton (Configuracion)

Descripción del ejercicio:

Se ha creado la clase `Configuracion` implementando el patrón Singleton. Esta clase almacena dos propiedades básicas:

- `idioma` (por defecto: `es`).
- `zonaHoraria` (por defecto: la zona del sistema obtenida por `ZoneId.systemDefault()`).

La clase ofrece el método `mostrar_configuracion()` que imprime los valores actuales.

Implementación principal:

- `Configuracion.java`: clase Singleton con constructor privado, campo estático `instancia` y método `public static synchronized Configuracion getInstance()` para obtener la única instancia. Incluye getters/setters y `mostrar_configuracion()`.
- `Main.java`: programa de ejemplo que obtiene la instancia, modifica valores y demuestra que varias "referencias" apuntan a la misma instancia (ver comparación y `identityHashCode`).

Compilar y ejecutar (PowerShell en Windows):

```powershell
# Moverse a la carpeta Ejercicio1
cd 'c:\Users\Mikha\OneDrive\Desktop\Practica7_TEo\TO\prac07\Ejercicio1'

# Compilar
javac Configuracion.java Main.java

# Ejecutar
java Main
```

Salida esperada (ejemplo):

```
--- Desde c1 ---
Idioma: es
Zona horaria: America/Mexico_City

--- Desde c2 (debe ser la misma instancia) ---
Idioma: es
Zona horaria: America/Mexico_City

c1 == c2 ? true
identityHashCode c1: 366712642
identityHashCode c2: 366712642
```

Notas sobre concurrencia y alternativas:

- En esta implementación `getInstance()` es `synchronized`, lo cual garantiza que no se creen dos instancias en entornos multi-hilo, pero puede tener impacto en rendimiento si se llama frecuentemente.
- Alternativas más eficientes:
  - Doble verificación (double-checked locking) con campo `volatile`.
  - Inicialización temprana (eager): `private static final Configuracion INST = new Configuracion();` — simple y segura si la creación no es costosa.
  - Usar un `enum` para Singleton en Java (`enum Singleton { INSTANCE; }`) — forma recomendada por Joshua Bloch por ser segura contra serialización y reflexión.

Qué hice exactamente:

- Implementé `Configuracion` como Singleton (lazy + `synchronized`).
- Implementé `Main` para demostrar la unicidad de la instancia.
- Añadí este `README.md` con instrucciones de compilación/ejecución y notas sobre concurrencia.

Si quieres, puedo:

- Ajustar la implementación para usar "double-checked locking".
- Añadir pruebas unitarias (JUnit) que verifiquen la unicidad bajo concurrencia.
- Empaquetar el ejemplo en un pequeño `build.gradle` o `pom.xml`.

---

Autor: Ejercicio implementado por GitHub Copilot (asistente). Si quieres que lo adapte a un paquete Java (`package ...`) dímelo.
