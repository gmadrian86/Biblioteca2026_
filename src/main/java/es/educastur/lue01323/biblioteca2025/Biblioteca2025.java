/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package es.educastur.lue01323.biblioteca2025;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.ArrayList;
import javax.swing.text.Position;

/**
 *
 * @author 1dawd12
 */
public class Biblioteca2025 {

    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Libro> libros = new ArrayList();//Declaración del ArrayList
    private static ArrayList<Usuario> usuarios = new ArrayList();
    private static ArrayList<Prestamo> prestamos = new ArrayList();
    private static final ArrayList<Prestamo> prestamosHist = new ArrayList();

    public static void main(String[] args) {
        //cargaDatos();                                                           //si nos da otro cargaDatos comentamos este o le ponemos cargaDatosExam y lo ponemos aqui
        menuOpciones();  
        //pal examen comentar menuOpciones ();
//uno();
cargaDatosExam ();
//MODIFICACION GITHUB

       
        //usuarioConMasPrestamos();
        //listarPrestamosPorAño();
        //listarPrestamosPorAño();
    }

    public static void cargaDatos() {

        libros.add(new Libro("1-11", "El Hobbit", "JRR Tolkien", "Aventuras", 3));
        libros.add(new Libro("1-22", "El Silmarillon", "JRR Tolkien", "Aventuras", 3));
        libros.add(new Libro("1-33", "El Medico", "N. Gordon", "Aventuras", 4));
        libros.add(new Libro("1-44", "Chaman", "N. Gordon", "Aventuras", 3));
        libros.add(new Libro("1-55", "Momo", "M. Ende", "Aventuras", 2));
        libros.add(new Libro("1-66", "Paraiso inhabitado", "A.M.Matute", "Aventuras", 2));
        libros.add(new Libro("1-77", "Olvidado Rey Gudu", "A.M.Matute", "Aventuras", 0));
        libros.add(new Libro("1-88", "El ultimo barco", "D.Villar", "Novela Negra", 3));
        libros.add(new Libro("1-99", "Ojos de agua", "D.Villar", "Novela Negra", 0));

        usuarios.add(new Usuario("11", "Ana", "ana@email.com", "621111111"));
        usuarios.add(new Usuario("22", "David", "david@email.com", "622222222"));
        usuarios.add(new Usuario("33", "Bea", "bea@email.com", "623333333"));
        usuarios.add(new Usuario("44", "Lucas", "lucas@email.com", "624444444"));
        usuarios.add(new Usuario("55", "Carlota", "carlota@email.com", "625555555"));
        usuarios.add(new Usuario("66", "Juan", "juan@email.com", "626666666"));

        LocalDate hoy = LocalDate.now(); //OBTENEMOS LA FECHA DE HOY CON EL MÉTODO now()

        //PRESTAMOS "NORMALES" REALIZADOS HOY Y QUE SE HAN DE DEVOLVER EN 15 DÍAS
        prestamos.add(new Prestamo(libros.get(0), usuarios.get(0), hoy, hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(1), usuarios.get(0), hoy, hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(5), usuarios.get(0), hoy, hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(6), usuarios.get(4), hoy, hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(6), usuarios.get(1), hoy, hoy.plusDays(15)));
        //PRESTAMOS QUE YA TENIAN QUE HABER SIDO DEVUELTOS PORQUE SU FECHA DE DEVOLUCIÓN ES ANTERIOR A HOY
        prestamos.add(new Prestamo(libros.get(5), usuarios.get(1), hoy.minusDays(17), hoy.minusDays(2)));
        prestamos.add(new Prestamo(libros.get(1), usuarios.get(4), hoy.minusDays(18), hoy.minusDays(3)));
        prestamos.add(new Prestamo(libros.get(2), usuarios.get(4), hoy.minusDays(20), hoy.minusDays(5)));
        prestamos.add(new Prestamo(libros.get(3), usuarios.get(4), hoy.minusDays(20), hoy.minusDays(5)));

        //PRESTAMOS HISTORICOS QUE YA HAN SIDO DEVUELTOS Y POR TANTO ESTÁN EN LA COLECCION prestamosHist
        prestamosHist.add(new Prestamo(libros.get(0), usuarios.get(0), hoy.minusDays(20), hoy.minusDays(5)));
        prestamosHist.add(new Prestamo(libros.get(2), usuarios.get(0), hoy.minusDays(20), hoy.minusDays(5)));
        prestamosHist.add(new Prestamo(libros.get(7), usuarios.get(4), hoy.minusDays(20), hoy.minusDays(5)));
        prestamosHist.add(new Prestamo(libros.get(5), usuarios.get(4), hoy.minusDays(20), hoy.minusDays(5)));
        prestamosHist.add(new Prestamo(libros.get(1), usuarios.get(1), hoy.minusDays(20), hoy.minusDays(5)));
        prestamosHist.add(new Prestamo(libros.get(7), usuarios.get(2), hoy.minusDays(15), hoy));
        prestamosHist.add(new Prestamo(libros.get(6), usuarios.get(3), hoy.minusDays(15), hoy));

    }

    public static void menuOpciones() {

        int opcion;
        do {
            System.out.println("\n\n\n\n\n\t\t\t\tMENU DE OPCIONES");
            System.out.println("\t\t\t\t1 - GESTION DE LIBROS");
            System.out.println("\t\t\t\t2 - GESTION DE USUARIOS");
            System.out.println("\t\t\t\t3 - GESTION DE PRESTAMOS");
            System.out.println("\t\t\t\t4 - LISTAR COLECCIONES");
            System.out.println("\t\t\t\t9 - SALIR");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1: {
                    gestionLibros();
                    break;
                }
                case 2: {
                    gestionUsuarios();
                    break;
                }
                case 3: {
                    gestionPrestamos();
                    break;
                }
                case 4: {
                    listarColecciones();
                    break;
                }

            }

        } while (opcion != 9);

    }

    public static void gestionLibros() {

        int opcion;
        do {
            System.out.println("\n\n\n\n\n\t\t\t\tMENU DE OPCIONES");
            System.out.println("\t\t\t\t1 - NUEVO LIBRO");
            System.out.println("\t\t\t\t2 - LISTAR LIBROS");
            System.out.println("\t\t\t\t3 - MODIFICAR LIBRO");
            System.out.println("\t\t\t\t4 - ELIMINAR LIBRO");
            System.out.println("\t\t\t\t9 - SALIR");
            System.out.println("\t\t\t\t¿Qué opción quieres ejecurtar?");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1: {
                    nuevoLibro();
                    break;
                }
                case 2: {
                    listarLibros();
                    break;
                }
                case 3: {
                    modificarLibro();
                    break;
                }
                case 4: {
                    eliminarLibro();
                    break;
                }

            }

        } while (opcion != 9);

    }

    public static void nuevoLibro() {
        System.out.println("\n\nVamos a introducir un nuevo LIBRO mediante el teclado");//Las variables que vamos a declarar es mejor llamarlas igual que los atributos de la clase para evitar la confusión
        System.out.println("\n\nISBN del nuevo LIBRO: ");
        String isbn = sc.next();
        System.out.println("Título: ");
        String titulo = sc.next();
        System.out.println("Autor: ");
        String autor = sc.next();
        System.out.println("Genero: ");
        String genero = sc.next();
        System.out.println("Ejemplares: ");
        int ejemplares = sc.nextInt();
        libros.add(new Libro(isbn, titulo, autor, genero, ejemplares));//Solo se usa add para añadir un nuevo objeto
        System.out.println("Se ha añadido un nuevo Libro");
    }

    public static void listarLibros() {
        System.out.println("\nVamos a listar los LIBROS actuales");
        for (Libro l : libros) {
            System.out.println(l);
        }
    }

    public static int buscaLibro(String isbn) {
        int pos = -1;// ponemos -1 por si no lo encontramos
        int i = 0;
        for (Libro l : libros) {//Nos estamos moviendo por todos los contactos hasta encontrar el String nombre que hemos teclado
            if (l.getIsbn().equalsIgnoreCase(isbn)) {//Busca el contacto ignorando la diferencia de mayúsculas y minúsculas
                pos = i;//Nos devuelve la posición dónde está el String nombre
                break;// Paramos cuando encontramos la posición de ese String nombre
            }
            i++;//Quiere decir que va seguir buscando entre todas las i hasta encontrar el nombre
        }
        return pos;//Nos regresa la posición del nombre
        /*for (int i = 0; i < contactoss.size(); i++) {
            if (contactoss.get(i).getNombre.equalsIgnoreCase(nombre)) {
               pos=i;//Nos devuelve la posición dónde está el String nombre
               break;// Paramos cuando encontramos la posición de ese String nombre
            }
        }
        return pos;
         */

        //SI BUSCAMOS EL LIBRO POR TITULO DEBEMOS USAR titulo = sc.nextLine(); PORQUE RECOGE LA FRASE ENTERA, next(); SOLO RECOGE UNA PALABRA
    }

    public static void modificarLibro() {
        System.out.println("\nTeclea el ISBN del LIBRO a MODIFICAR: ");

        //Declaramos los atributos que vamos a utulizar, nombre para buscarlo y los demás para ser modificados
        String isbn = sc.next();

        //Declaramos variables para llamar al método de buscaContacto asociado a los atributos para simplificar el código y poder modificarlos
        int n = buscaLibro(isbn);

        if (n == -1) {//Buscamos la posición del contacto del que queremos modificar un atributo, empezamos desde -1 por si el contacto no existe
            System.out.println("Este LIBRO no existe en la biblioteca");
        } else {

            System.out.println("\nVamos a MODIFICAR un LIBRO mediante el teclado");//Las variables que vamos a declarar es mejor llamarlas igual que los atributos de la clase para evitar la confusión
            System.out.print("\n\nEJEMPLARES nuevos del LIBRO: ");
            int ejemplares = sc.nextInt();
            libros.get(n).setEjemplares(ejemplares);
            System.out.println("Los EJEMPLARES del libro se han actualizado");

        }
    }

    public static void eliminarLibro() {
        System.out.print("\nTeclea el ISBN del LIBRO a borrar: ");
        String isbn = sc.next();
        int p = buscaLibro(isbn);
        if (p == -1) {
            System.out.println("Este LIBRO no existe en la BIBLIOTECA");
        } else {
            libros.remove(p);
            System.out.println("El LIBRO ha sido eliminado");
        }
    }

    public static void gestionUsuarios() {
        //<editor-fold defaultstate="collapsed" desc="Menú Usuarios">

        int opcion;
        do {
            System.out.println("\n\n\n\n\n\t\t\t\tMENU DE OPCIONES");
            System.out.println("\t\t\t\t1 - NUEVO USUARIO");
            System.out.println("\t\t\t\t2 - LISTAR USUARIOS");
            System.out.println("\t\t\t\t3 - MODIFICAR USUARIO");
            System.out.println("\t\t\t\t4 - ELIMINAR USUARIO");
            System.out.println("\t\t\t\t12 - SALIR");
            System.out.println("\t\t\t\t¿Qué opción quieres ejecurtar?");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1: {
                    nuevoUsuario();
                    break;
                }
                case 2: {
                    listarUsuarios();
                    break;
                }
                case 3: {
                    modificarUsuario();
                    break;
                }
                case 4: {
                    eliminarUsuario();
                    break;
                }

            }

        } while (opcion != 12);
        //</editor-fold>
    }

    public static void nuevoUsuario() {
        System.out.println("\n\nVamos a introducir un nuevo USUARIO mediante el teclado");//Las variables que vamos a declarar es mejor llamarlas igual que los atributos de la clase para evitar la confusión
        System.out.println("\n\nDNI del nuevo USUARIO: ");
        String dni = sc.next();
        System.out.println("Nombre: ");
        String nombre = sc.next();
        System.out.println("email: ");
        String email = sc.next();
        System.out.println("Telefono: ");
        String telefono = sc.next();
        usuarios.add(new Usuario(dni, nombre, email, telefono));//Solo se usa add para añadir un nuevo objeto

        System.out.println("Se ha añadino un nuevo usuario");
    }

    public static void listarUsuarios() {
        System.out.println("\nVamos a listar los USUARIOS actuales");
        for (Usuario u : usuarios) {
            System.out.println(u);
        }
    }

    public static int buscaUsuario(String dni) {//Enviamos el String nombre introducido por teclado y devuelve un entero
        //ES MEJOR BUSCARLO CON UN BUCLE FOR

        //Primero debemos saber qué contacto hay que modificar (sus coordenadas)
        int pos = -1;// ponemos -1 por si no lo encontramos
        int i = 0;// Primera posición del ArrayList para empezar a buscar, va recorrer todas las posiciones hasta encontrar el nombre
        for (Usuario u : usuarios) {//Nos estamos moviendo por todos los contactos hasta encontrar el String nombre que hemos teclado
            if (u.getDni().equalsIgnoreCase(dni)) {//Busca el contacto ignorando la diferencia de mayúsculas y minúsculas
                pos = i;//Nos devuelve la posición dónde está el String nombre
                break;// Paramos cuando encontramos la posición de ese String nombre
            }
            i++;//Quiere decir que va seguir buscando entre todas las i hasta encontrar el nombre
        }
        return pos;//Nos regresa la posición del nombre
        /*for (int i = 0; i < contactoss.size(); i++) {
            if (contactoss.get(i).getNombre.equalsIgnoreCase(nombre)) {
               pos=i;//Nos devuelve la posición dónde está el String nombre
               break;// Paramos cuando encontramos la posición de ese String nombre
            }
        }
        return pos;
         */

        //SI BUSCAMOS EL LIBRO POR TITULO DEBEMOS USAR titulo = sc.nextLine(); PORQUE RECOGE LA FRASE ENTERA, next(); SOLO RECOGE UNA PALABRA
        // ES MEJOR HAVER CON UN BUCLE FOR PORQUE NOS CONTROLA MEJOR LA DIRECCIÓN DE MEMORIA EXACTA COMO HIZO EDU, BUSCAMOS UNA POSICIÓN i
    }

    public static void modificarUsuario() {
        System.out.println("\nTeclea el DNI del USUARIO a MODIFICAR: ");

        //Declaramos los atributos que vamos a utulizar, nombre para buscarlo y los demás para ser modificados
        String dni = sc.next();

        //Declaramos variables para llamar al método de buscaContacto asociado a los atributos para simplificar el código y poder modificarlos
        int n = buscaUsuario(dni);

        if (n == -1) {//Buscamos la posición del contacto del que queremos modificar un atributo, empezamos desde -1 por si el contacto no existe
            System.out.println("Este USUARIO no existe en la biblioteca");
        } else {

            System.out.println("\nVamos a MODIFICAR un USUARIO mediante el teclado");//Las variables que vamos a declarar es mejor llamarlas igual que los atributos de la clase para evitar la confusión
            System.out.print("\n\nNombre nuevo del Usuario: ");
            String nombre = sc.next();
            System.out.print("email nuevo: ");
            String email = sc.next();
            System.out.print("Teléfono nuevo: ");
            String telefono = sc.next();
            usuarios.get(n).setNombre(nombre);
            usuarios.get(n).setEmail(email);
            usuarios.get(n).setTelefono(telefono);
            System.out.println("El contacto ha sido actualizado");

        }
    }

    public static void eliminarUsuario() {
        System.out.print("\nTeclea el DNI del USUARIO a borrar: ");
        String dni = sc.next();
        int p = buscaUsuario(dni);
        if (p == -1) {
            System.out.println("Este USUARIO no existe en la BIBLIOTECA");
        } else {
            usuarios.remove(p);
            System.out.println("El USUARIO ha sido eliminado");
        }
    }

    public static void gestionPrestamos() {
        int opcion;
        do {
            System.out.println("\n\n\n\n\n\t\t\t\tMENU DE OPCIONES");
            System.out.println("\t\t\t\t1 - NUEVO PRESTAMO");
            System.out.println("\t\t\t\t2 - LISTAR PRESTAMOS");
            System.out.println("\t\t\t\t3 - PRORROGA");
            System.out.println("\t\t\t\t4 - DEVOLUCION");
            System.out.println("\t\t\t\t9 - SALIR");
            System.out.println("\t\t\t\t¿Qué opción quieres ejecurtar?");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1: {
                    nuevoPrestamo();
                    break;
                }
                case 2: {
                    listarPrestamos();
                    break;
                }
                case 3: {
                    prorroga();
                    break;
                }
                case 4: {
                    devolucion();
                }

            }

        } while (opcion != 9);
    }

    public static void listarPrestamos() {

        System.out.println("Préstamos fuera de plazo");
        for (Prestamo p : prestamos) {
            if (p.getFechaDevDate().isBefore(LocalDate.now())) {
                System.out.println("El libro está fuera de plazo");
                System.out.println(p);
            }
        }

        System.out.println("Préstamos activos y en plazo");
        for (Prestamo p : prestamos) {
            if (!p.getFechaDevDate().isBefore(LocalDate.now())) {                   //EL ! ES PA DECIR QUE NO
                System.out.println(p);
            }
        }
        System.out.println("");
        System.out.println("Listado de prestamos históricos");
        for (Prestamo p : prestamosHist) {
            System.out.println(p);

        }
    }

    public static void nuevoPrestamo() {

        System.out.print("Identificación del usuario (DNI): ");
        String dni = sc.next();

        int posUsuario = buscaUsuario(dni);

        if (posUsuario == -1) {
            System.out.println("No es usuario de la biblioteca");
            return;
        }

        System.out.print("Identificación del libro (ISBN): ");
        String isbn = sc.next();

        try {
            int posLibro = stockLibro(isbn); // comprueba existencia y stock

            LocalDate hoy = LocalDate.now();
            LocalDate devolucion = hoy.plusDays(15);

            prestamos.add(
                    new Prestamo(libros.get(posLibro),usuarios.get(posUsuario),hoy,devolucion));

            // Restar ejemplar
            libros.get(posLibro).setEjemplares(libros.get(posLibro).getEjemplares() - 1);

            System.out.println("Préstamo realizado correctamente");

        } catch (LibroNoExiste e) {
            System.out.println(e.getMessage());

        } catch (LibroNoDisponible e) {
            System.out.println(e.getMessage());
        }
    }

    public static int buscaPrestamo(String dni, String isbn) {
        int pos = -1;
        for (int i = 0; i < prestamos.size(); i++) {
            if (prestamos.get(i).getUsuarioPrest().getDni().equals(dni) && prestamos.get(i).getLibroPrest().getIsbn().equals(isbn)) {
                pos = i;
                break;

            }
        }
        return pos;

    }

    public static void prorroga() {
        //Hay que tener en cuenta qué atributo se pide primero para evitar errores
        System.out.println("DNI  del usuario: ");
        String dni = sc.next();
        System.out.println("ISBN  del libro: ");
        String isbn = sc.next();
        int posPrestamo = buscaPrestamo(dni, isbn);
        if (posPrestamo == -1) {
            System.out.println("No hay ningún préstamo con estos datos");
        } else {
            prestamos.get(posPrestamo).setFechaDev(prestamos.get(posPrestamo).getFechaDevDate().plusDays(15));
            System.out.println("Se amplia el plazo a");
        }
    }

    public static void devolucion() {

        //Debemos declarar un nuevo arrayList de historial de prestamos
        /*
        -Lo más importante es saber la posición del prestamo para poder cambiar sus atributos según la prorroga y devoluciones*/
        System.out.println("DNI  del usuario: ");
        String dni = sc.next();
        System.out.println("ISBN  del libro: ");
        String isbn = sc.next();
        int posPrestamo = buscaPrestamo(dni, isbn);
        if (posPrestamo == -1) {
            System.out.println("No hay ningún préstamo con estos datos");
        } else {//Estas instrucciones no pueden cambiar de orden para evitar errores

            prestamos.get(posPrestamo).setFechaDev(LocalDate.now());//Aquí estamos cambiando la fecha de devolución
            libros.get(buscaLibro(isbn)).setEjemplares(libros.get(buscaLibro(isbn)).getEjemplares() + 1);//Sumamos de nuevo el ejemplrar al ArrayList de libros 
            prestamosHist.add(prestamos.get(posPrestamo));//Añadimos este prestamo al historico para posteriormente quitarlo de los prestamos pendientes qu aún no están devueltos
            prestamos.remove(posPrestamo);
            System.out.println("Se ha realizado la devolución, se elimina el prestamo para pasarlo al historial de prestamos");
        }
    }

    public static int buscaDni(String dni) {
        int pos = -1;
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getDni().equals(dni)) {
                pos = i;
                break;
            }
        }
        return pos;
    }

    /**
     * Método para buscar un libro en la colección libros
     *
     * @param isbn (String) del libro a buscar en la colección
     * @return posición (int) del libro el Arraylist, valor -1 si no se
     * encuentra
     */
    public static int buscaIsbn(String isbn) {
        int pos = -1;
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getIsbn().equals(isbn)) {
                pos = i;
                break;
            }
        }
        return pos;
    }

    /**
     * Método para buscar un préstamo en la colección préstamos
     *
     * @param dni (String) del usuario que realizó el préstamo
     * @param isbn (String) del libro prestado
     * @return posición (int) del préstamo en el Arraylist, valor -1 si no se
     * encuentra un préstamo con esos datos
     */
    public static void listarColecciones() {
        System.out.println("Vamos a mostrar todos los libros de la biblioteca: ");
        for (Libro l : libros) {
            System.out.println(l);
            //System.out.print("\n" + l.getIsbn() + "/" + l.getTitulo() + "/" + l.getAutor() + "/" + l.getGenero());
        }
        System.out.println("");

        System.out.println("Vamos a mostrar los usuarios de la biblioteca: ");
        for (Usuario u : usuarios) {
            System.out.println(u);
            //System.out.print("\n" + u.getDni() + "/" + u.getNombre() + "/" + u.getEmail() + "/" + u.getTelefono());
        }
        System.out.println("");

        System.out.println("Vamos a mostrar los prestamos de la biblioteca: ");
        for (Prestamo p : prestamos) {
            System.out.println(p);
        }
    }

    private static void supuestoClase1() {

        System.out.println("DNI usuario para consultar prestamos: ");
        String dni = sc.next();
        int pos = buscaDni(dni);

        if (pos == -1) {
            System.out.println("Ese DNI no existe en la biblioteca");
        } else {

            System.out.println("Prestamos activos de: " + usuarios.get(pos).getNombre());
            int cuentaActivos = 0;
            for (Prestamo p : prestamos) {
                if (p.getUsuarioPrest().getDni().equalsIgnoreCase(dni)) {
                    System.out.println(p);
                    cuentaActivos++;

                }

            }

            System.out.println("Prestamos historicos de: " + usuarios.get(pos).getNombre());
            int cuentaHistoricos = 0;
            for (Prestamo p : prestamosHist) {
                if (p.getUsuarioPrest().getDni().equalsIgnoreCase(dni)) {
                    System.out.println(p);
                    cuentaHistoricos++;
                }
            }
            System.out.println(usuarios.get(pos).getNombre() + " tiene " + cuentaHistoricos + " prestamos historicamente");
            int totalpres = cuentaActivos + cuentaHistoricos;
            System.out.println(usuarios.get(pos).getNombre() + " tiene " + totalpres + " prestamos");
        }
    }

    private static void supuestoClase2() {
        System.out.println("Usuarios con préstamos fuera de plazo:");

        for (Prestamo p : prestamos) {
            // Si la fecha de devolución es anterior a hoy entonces fuera de plazo
            if (p.getFechaDevDate().isBefore(LocalDate.now())) {

                Usuario u = p.getUsuarioPrest();
                System.out.println("• " + u.getNombre() + " (" + u.getDni() + ")");
                System.out.println("   Libro: " + p.getLibroPrest().getTitulo());
                System.out.println("   Fecha prevista devolución: " + p.getFechaDevDate());
                System.out.println();
            }
        }

    }

    private static void supuestoClase3() {
        System.out.println("ISBN del libro a eliminar: ");
        String isbn = sc.next();

        int pos = buscaIsbn(isbn);

        if (pos == -1) {
            System.out.println("Ese libro no existe");
            return;
        }

        // Comprobar si está prestado
        for (Prestamo p : prestamos) {
            if (p.getLibroPrest().getIsbn().equalsIgnoreCase(isbn)) {
                System.out.println("No se puede eliminar: el libro tiene préstamos activos.");
                return;
            }
        }

        // Si no tiene préstamos se borra
        libros.remove(pos);
        System.out.println("Libro eliminado correctamente");

    }

    private static void supuestoClase4() {

        System.out.println("Libros sin ejemplares disponibles:");

        for (Libro l : libros) {
            if (l.getEjemplares() == 0) {
                System.out.println(l.getTitulo() + " (ISBN: " + l.getIsbn() + ")");
            }
        }
    }

    private static void usuarioConMasPrestamos() {

        int maxPrestamos = -1;
        int indiceMejor = -1;

        for (int i = 0; i < usuarios.size(); i++) {

            Usuario u = usuarios.get(i);
            int cuenta = 0;

            for (Prestamo p : prestamos) {
                if (p.getUsuarioPrest().getDni().equalsIgnoreCase(u.getDni())) {
                    cuenta++;
                }
            }

            for (Prestamo p : prestamosHist) {
                if (p.getUsuarioPrest().getDni().equalsIgnoreCase(u.getDni())) {
                    cuenta++;
                }
            }

            if (cuenta > maxPrestamos) {
                maxPrestamos = cuenta;
                indiceMejor = i;
            }
        }

        if (indiceMejor == -1) {
            System.out.println("No hay prestamos.");
        } else {
            Usuario mejor = usuarios.get(indiceMejor);
            System.out.println("El usuario con mas prestamos: " + mejor.getNombre());
            System.out.println("Dni: " + mejor.getDni());
            System.out.println("Prestamos totales: " + maxPrestamos);
        }
    }

    /*private static void listarPrestamosPorAño() {

    System.out.println("Introduce el año:");
    int año = sc.nextInt();

    int contador = 0;

    System.out.println("\nPrestamos por año " + año + "-");

    for (Prestamo p : prestamos) {
        if (p.getFecha().getYear() == año) {
            System.out.println(p);
            contador++;
        }
    }

    for (Prestamo p : prestamosHist) {
        if (p.getFecha().getYear() == año) {
            System.out.println(p);
            contador++;
        }
    }

    System.out.println("\nTotal Prestamos en " + año + ": " + contador);
}
     */
    private static void listarPrestamosPorUsuario() {

        System.out.println("Introduce DNI del usuario:");
        String dni = sc.next();
        int pos = buscaDni(dni);

        if (pos == -1) {
            System.out.println("Ese DNI no existe.");
            return;
        }

        Usuario u = usuarios.get(pos);
        int contador = 0;

        System.out.println("\n Prestamos de " + u.getNombre() + "-");

        for (Prestamo p : prestamos) {
            if (p.getUsuarioPrest().getDni().equalsIgnoreCase(dni)) {
                System.out.println(p);
                contador++;
            }
        }

        for (Prestamo p : prestamosHist) {
            if (p.getUsuarioPrest().getDni().equalsIgnoreCase(dni)) {
                System.out.println(p);
                contador++;
            }
        }

        System.out.println("\nTotal: " + contador);
    }

    //EXAMEN CORREGIDO
    public static void cargaDatosExam () {
        libros.add(new Libro("1-11", "El Hobbit", "JRR Tolkien", "Aventuras", 3));
        libros.add(new Libro("1-22", "El Silmarillon", "JRR Tolkien", "Aventuras", 3));
        libros.add(new Libro("1-33", "El Medico", "N. Gordon", "Aventuras", 4));
        libros.add(new Libro("1-44", "Chaman", "N. Gordon", "Aventuras", 3));
        libros.add(new Libro("1-55", "Momo", "M. Ende", "Aventuras", 2));
        libros.add(new Libro("1-66", "Paraiso inhabitado", "A.M.Matute", "Aventuras", 2));
        libros.add(new Libro("1-77", "Olvidado Rey Gudu", "A.M.Matute", "Aventuras", 0));
        libros.add(new Libro("1-88", "El ultimo barco", "D.Villar", "Novela Negra", 3));
        libros.add(new Libro("1-99", "Ojos de agua", "D.Villar", "Novela Negra", 0));

        usuarios.add(new Usuario("11", "Ana", "ana@email.com", "621111111"));
        usuarios.add(new Usuario("22", "David", "david@email.com", "622222222"));
        usuarios.add(new Usuario("33", "Bea", "bea@email.com", "623333333"));
        usuarios.add(new Usuario("44", "Lucas", "lucas@email.com", "624444444"));
        usuarios.add(new Usuario("55", "Carlota", "carlota@email.com", "625555555"));
        usuarios.add(new Usuario("66", "Juan", "juan@email.com", "626666666"));

        LocalDate hoy = LocalDate.now(); //OBTENEMOS LA FECHA DE HOY CON EL MÉTODO now()

        //PRESTAMOS "NORMALES" REALIZADOS HOY Y QUE SE HAN DE DEVOLVER EN 15 DÍAS
        prestamos.add(new Prestamo(libros.get(0), usuarios.get(0), hoy, hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(1), usuarios.get(0), hoy, hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(5), usuarios.get(0), hoy, hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(0), usuarios.get(4), hoy, hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(0), usuarios.get(1), hoy, hoy.plusDays(15)));
        //PRESTAMOS QUE YA TENIAN QUE HABER SIDO DEVUELTOS PORQUE SU FECHA DE DEVOLUCIÓN ES ANTERIOR A HOY
        prestamos.add(new Prestamo(libros.get(5), usuarios.get(1), hoy.minusDays(17), hoy.minusDays(2)));
        prestamos.add(new Prestamo(libros.get(1), usuarios.get(4), hoy.minusDays(18), hoy.minusDays(3)));
        prestamos.add(new Prestamo(libros.get(2), usuarios.get(4), hoy.minusDays(20), hoy.minusDays(5)));
        prestamos.add(new Prestamo(libros.get(3), usuarios.get(4), hoy.minusDays(20), hoy.minusDays(5)));

        //PRESTAMOS HISTORICOS QUE YA HAN SIDO DEVUELTOS Y POR TANTO ESTÁN EN LA COLECCION prestamosHist
        prestamosHist.add(new Prestamo(libros.get(0), usuarios.get(0), hoy.minusDays(30), hoy.minusDays(15)));
        prestamosHist.add(new Prestamo(libros.get(2), usuarios.get(0), hoy.minusDays(30), hoy.minusDays(15)));
        prestamosHist.add(new Prestamo(libros.get(7), usuarios.get(4), hoy.minusDays(30), hoy.minusDays(15)));
        prestamosHist.add(new Prestamo(libros.get(5), usuarios.get(4), hoy.minusDays(20), hoy.minusDays(15)));
        prestamosHist.add(new Prestamo(libros.get(1), usuarios.get(1), hoy.minusDays(20), hoy.minusDays(5)));
        prestamosHist.add(new Prestamo(libros.get(7), usuarios.get(2), hoy.minusDays(10), hoy));
        prestamosHist.add(new Prestamo(libros.get(6), usuarios.get(3), hoy.minusDays(10), hoy));
    }
     

 /*public static void uno() {
        System.out.print("ISBN LIBRO para consultar prestamos: ");
        String isbn = sc.next();
        int pos = buscaIsbn(isbn);
        if (pos == -1) {
            System.out.println("Ese ISBN no existe en la biblioteca");
        } else {
            System.out.println("Prestamos activos de el libro:  " + libros.get(pos).getTitulo());
            int contador = 0;
            for (Prestamo p : prestamos) {
                if (p.getLibroPrest().equals(libros.get(pos))) {
                    System.out.println(p);
                    contador++;
                }
            }
            System.out.println("\n" + libros.get(pos).getTitulo() + " tiene " + contador + " prestamos actualmente");
        }
    }
     */
 /* public static void dos() {
        System.out.println("\nLibros NUNCA prestados:\n");
        for (Libro l : libros) {
            int cont=0;
            for (Prestamo p : prestamos) {
                if (p.getLibroPrest() == l) {
                    cont++;
                    break;
                }
            }
            if (cont==0){
                for (Prestamo p : prestamosHist) {
                    if (p.getLibroPrest() == l) {
                        cont++;
                        break;
                    }
                }
            }
            if (cont==0) {
                System.out.println(l);
            }
        }
    }

    public static void tres() {
        System.out.println("Usuarios que tiene al menos 1 prestamo ACTIVO:\n"); 
        for(Usuario u : usuarios) {
            int cont=0;
            for(Prestamo p : prestamos) {
                    if(p.getUsuarioPrest() == u) {
                        cont++;
                        //break;
                    }
            }
            if (cont>0){
               System.out.println(u.getNombre());
            }
	}
    }

    public static void cuatro() {
         /* Se podría resolver con un contador (cont) al igual que los ejercicios
            anteriores, pero en este caso utilizamos una variable booleana (true/false).
            Es otra forma de resolver la lógica de este tipo de ejercicios         
        System.out.println("Usuarios que tiene PRESTAMOS FUERA DE PLAZO:\n"); 
        for(Usuario u : usuarios) {
            boolean tieneFueraPlazo = false;
            for(Prestamo p : prestamos) {
                    if(p.getUsuarioPrest().equals(u) && p.getFechaDev().isBefore(LocalDate.now())) {
                        tieneFueraPlazo = true;
                        break;
                    }
            }
            if(tieneFueraPlazo == true) {
                    System.out.println(u);
            }
	}
    }

    public static void cinco() {
        System.out.println("PRESTAMOS realizados en el mes de NOVIEMBRE:\n"); 
        for(Prestamo p : prestamos) {
            if(p.getFechaPrest().getMonthValue()==11) {
                System.out.println(p);
            }
        }
        for(Prestamo p : prestamosHist) {
            if(p.getFechaPrest().getMonthValue()==11) {
                System.out.println(p);
            }
        }
    }
     */
    public static int stockLibro(String isbn) throws LibroNoExiste, LibroNoDisponible {
        int pos = buscaIsbn(isbn);

        if (pos == -1) {
            throw new LibroNoExiste(
                    "No existe en esta biblioteca la referencia: " + isbn
            );
        } else if (libros.get(pos).getEjemplares() == 0) {

            /*/String cadena = "No hay unidades del libro" + libros.get (pos.getTitulo ()
                + "disponibles actualmente"
                + "\Fechas de devolución previstas: ";
                
        for (Prestamo p : prestamos ){
            if (p.getLibroPrest ().getIsbn().equals (isbn)){
                caden  = cadena + "\n * " + p.getFechaDev ();
        }
    }
             */
            throw new LibroNoDisponible("Existe el libro pero todas las unidades están en préstamo");

        }

        return pos;
    }
}
