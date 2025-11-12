Ejercicio 03 – Singleton: Conexión simulada a base de datos

1. Salida y cumplimiento de cada punto del ejercicio ![Ejecucuion del Main - simulacion de una BD](imagenes/ejercicio3_TO.png)

| Requisito del ejercicio                                                       | Cómo se cumple en el código                                                                                                          |
| ----------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------ |
| **“Solo debe haber una conexión activa (Singleton)”**                         | Se logra con la variable `private static ConexionBD instancia;` y el método `getInstancia()` que crea una sola vez la conexión.      |
| **“Incluye métodos conectar(), desconectar() y estado()”**                    | Están implementados dentro de la clase, simulando las acciones reales de conexión.                                                   |
| **“Si alguien intenta crear otra conexión, debe devolverse la ya existente”** | El método `getInstancia()` devuelve siempre la misma instancia si ya existe.                                                         |
| **“Aplicar Singleton cuando se requiere un recurso global compartido”**       | La conexión a base de datos es un recurso global, accesible desde cualquier parte del programa mediante `ConexionBD.getInstancia()`. |
| **“Manejar un recurso crítico que no debe duplicarse”**                       | Gracias al constructor privado, nadie puede hacer `new ConexionBD()`, evitando múltiples conexiones.                                 |
| **“Proteger el Singleton en escenarios concurrentes”**                        | La palabra clave `synchronized` en `getInstancia()` evita que varios hilos creen instancias al mismo tiempo.                         |

2. Descripción del ejercicio

El objetivo es crear una clase llamada ConexionBD que simule una conexión a base de datos.
Solo debe existir una conexión activa durante toda la ejecución del programa.

La clase debe incluir los métodos:

conectar()

desconectar()

estado()

Y garantizar que si alguien intenta crear otra conexión, se devuelva la misma instancia existente (no una nueva).

3. Uso del patrón Singleton

El patrón Singleton se utiliza cuando se necesita que solo exista una única instancia de una clase en todo el sistema.
En este caso, esa clase es ConexionBD, que representa una conexión global a la base de datos.

4. Explicación detallada

El programa define la clase ConexionBD, que representa una simulación de conexión a una base de datos y utiliza el patrón Singleton para garantizar que solo exista una instancia activa.

a. Variable estática (instancia)
Guarda la única referencia de tipo ConexionBD que puede existir.
Esto asegura que, incluso si el método se llama varias veces, siempre se devuelva la misma conexión.

b. Constructor privado
Evita que se puedan crear nuevas instancias con new ConexionBD() desde otras clases.
De esta forma, el único modo de obtener la conexión es mediante el método getInstancia().

c. Método estático getInstancia()
Es el corazón del patrón Singleton.
Si no existe una instancia, la crea y muestra un mensaje de nueva conexión.
Si ya existe, devuelve la misma instancia y avisa que la conexión está activa.
El uso de synchronized evita problemas cuando varios hilos intentan crear la conexión al mismo tiempo.

d. Métodos conectar(), desconectar() y estado()
Simulan las operaciones de una base de datos real:

conectar() cambia el estado a activo.

desconectar() cierra la conexión.

estado() muestra si la conexión está activa o no.
Como todas las llamadas usan la misma instancia, cualquier cambio en una afecta a todas.

e. Clase Main
Crea dos variables (c1 y c2) que apuntan a la misma conexión.
Esto demuestra que solo hay una instancia compartida y que el patrón Singleton cumple su función de controlar el acceso global al recurso.

5. Conclusión

El ejercicio demuestra la aplicación práctica del patrón Singleton, asegurando que solo exista una única conexión activa en el sistema.
La clase ConexionBD controla el acceso al recurso mediante un constructor privado, una instancia estática única y un método sincronizado que gestiona la creación de la conexión.

De esta manera, el patrón garantiza un comportamiento seguro, eficiente y centralizado, evitando duplicación de recursos y posibles conflictos en escenarios concurrentes.
