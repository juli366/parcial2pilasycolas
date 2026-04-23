import java.util.LinkedList;
import java.util.Queue;

public class SistemaTurnos {

    private Queue<Usuario> fila;
    private Queue<Usuario> historial;

    public SistemaTurnos() {
        fila = new LinkedList<>();
        historial = new LinkedList<>();
    }
    public boolean registrarUsuario(Usuario usuario) {
        return fila.offer(usuario);
    }

    public Usuario atenderUsuario() {
        if (!fila.isEmpty()) {
            Usuario usuario = fila.poll();
            usuario.setAtendido(true);
            historial.offer(usuario);
            return usuario;
        } else {
            return null;
        }
    }

    public Usuario verSiguiente() {
        if (!fila.isEmpty()) {
            return fila.peek();
        } else {
            return null;
        }
    }

    public void mostrarFila() {
        if (fila.isEmpty()) {
            System.out.println("No hay clientes en fila.");
        } else {
            for (Usuario u : fila) {
                System.out.println("Turno: " + u.getId());
                System.out.println("Nombre: " + u.getNombre());
                System.out.println("Servicio: " + u.getTipoServicio());
                System.out.println("Hora: " + u.getHoraLlegada());
                System.out.println("--------------------");
            }
        }
    }

    public void mostrarHistorial() {

    System.out.println("ATENDIDOS:");

    if (historial.isEmpty()) {
        System.out.println("Ninguno.");
    } else {
        for (Usuario u : historial) {
            System.out.println("Turno: " + u.getId());
            System.out.println("Nombre: " + u.getNombre());
            System.out.println("Hora: " + u.getHoraLlegada()); 
            System.out.println("--------------------");
        }
    }

    System.out.println("EN ESPERA:");

    if (fila.isEmpty()) {
        System.out.println("Ninguno.");
    } else {
        for (Usuario u : fila) {
            System.out.println("Turno: " + u.getId());
            System.out.println("Nombre: " + u.getNombre());
            System.out.println("Hora: " + u.getHoraLlegada()); 
            System.out.println("--------------------");
        }
    }
}
}