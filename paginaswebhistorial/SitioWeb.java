public class SitioWeb {

    private String enlace;
    private String nombre;
    private String fecha;

    public SitioWeb() {
    }

    public SitioWeb(String enlace, String nombre, String fecha) {
        this.enlace = enlace;
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
