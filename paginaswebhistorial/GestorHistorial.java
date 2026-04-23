import java.util.Stack;

public class GestorHistorial {

    private Stack<SitioWeb> historial;

    public GestorHistorial() {
        historial = new Stack<>();
    }

    public boolean visitarPagina(SitioWeb sitio) {
        historial.push(sitio);
        return true;
    }

    // RETROCEDER (pop)
    public SitioWeb retrocederPagina() {
        if (!historial.isEmpty()) {
            return historial.pop();
        } else {
            return null;
        }
    }

    public SitioWeb verPaginaActual() {
        if (!historial.isEmpty()) {
            return historial.peek();
        } else {
            return null;
        }
    }

    public void mostrarHistorial() {
        if (historial.isEmpty()) {
            System.out.println("Historial vacío.");
        } else {
            for (int i = historial.size() - 1; i >= 0; i--) {
                System.out.println("Titulo: " + historial.get(i).getNombre());
                System.out.println("URL: " + historial.get(i).getEnlace());
                System.out.println("Fecha: " + historial.get(i).getFecha());
                System.out.println("----------------------");
            }
        }
    }
}