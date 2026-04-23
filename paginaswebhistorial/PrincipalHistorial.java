import java.util.Scanner;

public class PrincipalHistorial {

    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);
        GestorHistorial gestor = new GestorHistorial();

        int opcion = -1;

        while (opcion != 0) {

            System.out.println("\n--- MENU NAVEGADOR ---");
            System.out.println("1. Visitar nueva página");
            System.out.println("2. Retroceder");
            System.out.println("3. Ver historial actual");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = lector.nextInt();
            lector.nextLine();

            switch (opcion) {

                case 1:
                    SitioWeb sitio = new SitioWeb();

                    System.out.print("Ingrese URL: ");
                    sitio.setEnlace(lector.nextLine());

                    System.out.print("Ingrese titulo: ");
                    sitio.setNombre(lector.nextLine());

                    System.out.print("Ingrese fecha de acceso: ");
                    sitio.setFecha(lector.nextLine());

                    gestor.visitarPagina(sitio);
                    break;

                case 2:
                    SitioWeb eliminada = gestor.retrocederPagina();

                    if (eliminada != null) {
                        SitioWeb actual = gestor.verPaginaActual();

                        if (actual != null) {
                            System.out.println("Página actual:");
                            System.out.println(actual.getNombre() + " - " + actual.getEnlace());
                        } else {
                            System.out.println("No hay páginas abiertas.");
                        }
                    } else {
                        System.out.println("No hay páginas para retroceder.");
                    }
                    break;

                case 3:
                    gestor.mostrarHistorial();
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        }

    }
}
