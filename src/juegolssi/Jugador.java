package juegolssi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import juegolssi.Archivos.Historia;
import juegolssi.Archivos.Historia.Animaciones;
import juegolssi.Archivos.Historia.Dibujos;

public class Jugador {

    Sonidointro son = new Sonidointro();
    Animaciones anime = new Animaciones();
    Historia historia = new Historia();
    Dibujos dibu = new Dibujos();

    public static String nombreJugador;

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        Jugador.nombreJugador = nombreJugador;
    }

    int opcion;
    boolean repetirmenu = true;

    public void menuPrincipal() throws InterruptedException, IOException {

         son.start();
         anime.animacionInicio();
         System.out.println("----------------------------------------------------------------------------");
        dibu.leerdibujo("0.txt");
        historia.leerDatos(0);

        System.out.println("");
        System.out.println((char) 27 + "[37m" + "Opciones del juego"
                + "\n Pulse 1 para Crear nuevo Jugador."
                + "\n Pulse 2 para Cargar partida."
                + "\n Pulse 3 para Salir del Juego."
                + "\n");

        System.out.println((char) 27 + "[37m" + "Ingrese la opción elegida: ");

        do {
            try {
                Scanner teclado = new Scanner(System.in);

                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        repetirmenu = false;
                        nuevoJugador();

                        son.stop();

                        break;
                    case 2:
                        repetirmenu = false;
                        cargarPartida();

                        break;

                    case 3:
                        int msj = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas salir?");
                        if (msj == JOptionPane.YES_OPTION) {
                            son.stop();
                            repetirmenu = false;
                            System.out.println("Has salido del juego");
                            break;
                        }
                        if (msj == JOptionPane.NO_OPTION) {
                            repetirmenu = true;
                            System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                            
                        }
                        if (msj == JOptionPane.CANCEL_OPTION) {
                            repetirmenu = true;
                            System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        }
                        break;

                    default:
                        System.out.println((char) 31 + "Elija solamente entre 1 - 3");
                        break;
                }
            } catch (Exception e) {

                System.out.println((char) 31 + "Opción inválida: no se pueden escoger carácteres");
                System.out.println((char) 31 + "Intentalo nuevamente");
                System.out.println("Presiona Enter para continuar y a continuación elija su opcióm");

            }
        } while (repetirmenu == true);
    }

    public void nuevoJugador() throws FileNotFoundException, IOException, InterruptedException {

        Scanner leer = new Scanner(System.in);

        System.out.println("nombre jugador");

        setNombreJugador(leer.nextLine());

        try (FileWriter crear = new FileWriter("./partidasguardadas/" + getNombreJugador())) {
            crear.write(nombreJugador);
            System.out.println("Se ha creado el jugador " + nombreJugador + " exitosamente");
            System.out.println("");
            System.out.println("");
            System.out.println("Bienvenido " + nombreJugador + "  has recibido el siguiente Telegrama... ");
            System.out.println("");
            Menus menuu = new Menus();
            crear.close();
            son.stop();
            menuu.menujuegoinicio();
        }

    }
// Este método se basa en escribir en el archivo del jugador el último nombre del menú guardado, para después hacer la comparación con la variable
    // menuactual de los menú, mediante equals, y en caso de corresponder arroja el menú que contiene la escena

    public void guardarPartida(String menuAct) {
        try {
            Menus menuactual = new Menus();
            menuAct = menuactual.menuactual;
            FileWriter guardar = null;
            try {
                guardar = new FileWriter("./partidasguardadas/" + getNombreJugador());
            } catch (IOException ex) {
                Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                guardar.write(menuAct);
            } catch (IOException ex) {
                Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
            }
            guardar.close();

        } catch (IOException ex) {
            Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void cargarPartida() throws FileNotFoundException, InterruptedException {

        Scanner leer = new Scanner(System.in);
        int seleccion;

        File carpeta = new File("./partidasguardadas/");
        File[] archivos = carpeta.listFiles();
        int i = 0;

        for (File listado : archivos) {

            if (listado.isFile()) {
                i++;
                System.out.println(i + " Partida " + listado.getName());
            } else if (listado.isDirectory()) {
                System.out.println("Subdirectorio " + listado.getName());
            }
        }
        System.out.println("");
        System.out.println("Seleccione el numero correspondiente a su juego");
        seleccion = leer.nextInt();
        System.out.println("");
        System.out.println("Bienvenido " + archivos[seleccion - 1].getName() + " Puedes volver el juego donde quedaste");
        System.out.println("");
        son.stop();
        Menus menuud = new Menus();
        menuud.menujuegoinicio();
    }

}
