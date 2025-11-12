// Logger.java
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    // Formato de fecha/hora para los mensajes
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // Nombre del archivo de log (en el directorio de trabajo)
    private final File logfile;

    // Constructor privado — nadie fuera puede instanciar Logger
    private Logger() {
        this.logfile = new File("bitacora.log");
        // Si quieres, creamos el archivo si no existe (no obligado)
        try {
            if (!logfile.exists()) {
                logfile.createNewFile();
            }
        } catch (IOException e) {
            // Si hay problema creando el archivo, lanzamos una RuntimeException
            throw new RuntimeException("No se pudo crear el archivo de log", e);
        }
    }

    // Holder idiom: lazy + seguro en entornos multi-hilo
    private static class Holder {
        private static final Logger INSTANCE = new Logger();
    }

    // Método público para obtener la única instancia
    public static Logger getInstance() {
        return Holder.INSTANCE;
    }

    // Método para escribir un mensaje en el archivo con timestamp.
    // Síncrono para evitar intercalado entre hilos.
    public synchronized void log(String mensaje) {
        String timestamp = LocalDateTime.now().format(FORMATTER);
        String linea = String.format("%s - %s%n", timestamp, mensaje);

        // try-with-resources abre FileWriter en modo append y lo cierra automáticamente
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(logfile, true))) {
            bw.write(linea);
            bw.flush();
        } catch (IOException e) {
            // No queremos que el logger lance checked exceptions al usarlo,
            // por eso convertimos a RuntimeException o simplemente lo registramos por otro medio.
            System.err.println("ERROR al escribir en el log: " + e.getMessage());
        }
    }

    // Método opcional para obtener la ruta del archivo de log (útil en pruebas)
    public File getLogFile() {
        return logfile;
    }
}
