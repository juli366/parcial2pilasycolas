import java.util.Scanner;

public class MainBanco {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SistemaTurnos banco = new SistemaTurnos();

        int opcion = -1;

        while (opcion != 0) {

            System.out.println("\n--- MENU BANCO ---");
            System.out.println("1. Llegada de cliente");
            System.out.println("2. Atender cliente");
            System.out.println("3. Ver siguiente cliente");
            System.out.println("4. Ver fila actual");
            System.out.println("5. Mostrar turnos");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    Usuario cliente = new Usuario();

                    System.out.print("Ingrese turno: ");
                    cliente.setId(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Ingrese nombre: ");
                    cliente.setNombre(sc.nextLine());

                    System.out.print("Ingrese tipo servicio: ");
                    cliente.setTipoServicio(sc.nextLine());

                    System.out.print("Ingrese hora llegada: ");
                    cliente.setHoraLlegada(sc.nextLine());

                    cliente.setAtendido(false);

                    boolean registrado = banco.registrarUsuario(cliente);

                    if (registrado) {
                        System.out.println("Cliente agregado a la fila.");
                    }
                    break;

                case 2:
                    Usuario atendido = banco.atenderUsuario();

                    if (atendido != null) {
                        System.out.println("Cliente atendido:");
                        System.out.println("Turno: " + atendido.getId());
                        System.out.println("Nombre: " + atendido.getNombre());
                        System.out.println("Servicio: " + atendido.getTipoServicio());
                        System.out.println("Hora: " + atendido.getHoraLlegada());
                    } else {
                        System.out.println("No hay clientes en espera.");
                    }
                    break;

                case 3:
                    Usuario siguiente = banco.verSiguiente();

                    if (siguiente != null) {
                        System.out.println("Siguiente cliente:");
                        System.out.println("Turno: " + siguiente.getId());
                        System.out.println("Nombre: " + siguiente.getNombre());
                        System.out.println("Servicio: " + siguiente.getTipoServicio());
                        System.out.println("Hora: " + siguiente.getHoraLlegada());
                    } else {
                        System.out.println("Cola vacía.");
                    }
                    break;

                case 4:
                    banco.mostrarFila();
                    break;

                case 5:
                    banco.mostrarHistorial();
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }

        }

    }
}