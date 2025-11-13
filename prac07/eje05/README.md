Ejercicio 05 – Singleton con subprocesos (Thread-Safe)
1. Descripción

En este ejercicio se modifica la clase ConexionBD del Ejercicio 03 para hacerla segura en entornos multihilo (thread-safe).
Esto significa que, aunque varios hilos intenten obtener la instancia al mismo tiempo, solo se creará una única instancia de la conexión a la base de datos.

Para lograrlo, se aplica el patrón Singleton con verificación doble (Double-Checked Locking), combinando el uso de volatile y synchronized.

2. Explicación

volatile garantiza que todos los hilos vean la misma instancia en memoria.

synchronized asegura que solo un hilo pueda crear la instancia al mismo tiempo.

La verificación doble (if (instancia == null)) evita bloqueos innecesarios una vez que la instancia ya existe.

3. Salida Esperada

(El orden puede variar según el sistema operativo y la ejecución de los hilos)![Ejecución del ejercicio 05](imagenes/ejercicio5_TO.png)
- Observación:
Aunque varios hilos ejecuten el método getInstancia(), solo uno crea la instancia; los demás la reutilizan.

4. Explicacion técnica

| Elemento                          | Descripción                                                                                    |
| --------------------------------- | ---------------------------------------------------------------------------------------------- |
| `volatile ConexionBD instancia;`  | Evita que los hilos vean versiones distintas de la instancia (problema de *cache visibility*). |
| `if (instancia == null)`          | Primera verificación (rápida, sin bloqueo).                                                    |
| `synchronized (ConexionBD.class)` | Bloquea la sección para que solo un hilo cree la instancia.                                    |
| Segunda verificación interna      | Se asegura que mientras un hilo esperaba el bloqueo, otro no haya creado ya la instancia.      |
| Resultado                         | Solo **un objeto** `ConexionBD` será creado, sin importar cuántos hilos lo soliciten.          |
