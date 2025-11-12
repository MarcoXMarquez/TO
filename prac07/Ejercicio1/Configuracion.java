public class Configuracion {
    private static Configuracion instancia;
    private String idioma;
    private String zonaHoraria;

    private Configuracion() {
        // valores por defecto
        this.idioma = "es";
        this.zonaHoraria = java.time.ZoneId.systemDefault().toString();
    }

    /**
     * Obtiene la única instancia de Configuracion.
     * Método sincronizado para proteger en escenarios concurrentes.
     */
    public static synchronized Configuracion getInstance() {
        if (instancia == null) {
            instancia = new Configuracion();
        }
        return instancia;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getZonaHoraria() {
        return zonaHoraria;
    }

    public void setZonaHoraria(String zonaHoraria) {
        this.zonaHoraria = zonaHoraria;
    }

    public void mostrar_configuracion() {
        System.out.println("Idioma: " + idioma);
        System.out.println("Zona horaria: " + zonaHoraria);
    }

    @Override
    public String toString() {
        return "Configuracion{idioma='" + idioma + "', zonaHoraria='" + zonaHoraria + "'}";
    }
}
