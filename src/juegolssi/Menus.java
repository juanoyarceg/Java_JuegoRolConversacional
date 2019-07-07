package juegolssi;

import java.awt.HeadlessException;
import java.io.IOException;
import java.text.DecimalFormat;
import juegolssi.Archivos.Historia;
import javax.swing.*;
import java.util.*;
import juegolssi.Archivos.Historia.Animaciones;
import juegolssi.Archivos.Historia.Dibujos;

public class Menus {

    Archivos.Historia historia = new Archivos.Historia("Juan");
    protected String menuactual = null;
    int opcion;
    Dibujos escena = new Dibujos();
    Animaciones anime = new Animaciones();
    Sonidointro son = new Sonidointro();
    Sonidojuego sonjuego = new Sonidojuego();
    Sonidopersecusion sonperse = new Sonidopersecusion();
    Sonidotension sonten = new Sonidotension();
    Sonidofinal sonfin = new Sonidofinal();
    Sonidofinaldisparo sondis = new Sonidofinaldisparo();
    Sonidofinalconfrontacion soncon = new Sonidofinalconfrontacion();
    Sonidofinalsuicidio sonsui = new Sonidofinalsuicidio();
    Jugador jugadorazo = new Jugador();
    boolean repetirmenu = true;

    public Menus() {

    }

    // Los menús siguen una estructura lógica similar, mediante el desplazamiento de menús
    // es posible generar caminos no líneales según el árbol de decisiones del juego
    // moviendose fluídamente entre escenas, mediante las alternativas binarias
    public void menujuegoinicio() throws InterruptedException {
        menuactual = "menujuegoinicio";
        sonjuego.start();
        escena.leerdibujo("1.txt");
        historia.leerDatos(1);

        System.out.println("");
        System.out.println((char) 27 + "[37m" + "Opciones del juego"
                + "\n Pulse 3 para mostrar Avance del Juego."
                + "\n Pulse 4 para Retroceder una Escena, si es posible."
                + "\n Pulse 5 para Guardar la Partida, si es posible."
                + "\n Pulse 6 para Volver al Menu Principal"
                + "\n Pulse 7 para Salir del Juego "
                + "\n");

        System.out.println((char) 27 + "[37m" + "Ingrese la opción elegida: ");

        do {
            try {
                Scanner teclado = new Scanner(System.in);
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        //sonjuego.stop();
                        repetirmenu = false;
                        menujuego4();
                        break;
                    case 2:
                        // sonjuego.stop();
                        repetirmenu = false;
                        menujuego2();
                        break;
                    case 3:
                        double avance = (1 * (100) / 40);
                        DecimalFormat df = new DecimalFormat("#.0");
                        System.out.println("Ud lleva un avance del = " + df.format(avance) + "% del total del Juego" + "\n");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 4:
                        System.out.println("No es posible retroceder en esta escena");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 5:
                        //jugadorazo.guardarPartida(menuactual); (cooming son xd)
                        System.out.println("Partida guardada correctamente");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 6:
                        sonjuego.stop();
                        repetirmenu = false;
                        jugadorazo.menuPrincipal();
                        break;
                    case 7:
                        int msj = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas salir sin guardar?");
                        if (msj == JOptionPane.YES_OPTION) {
                            sonjuego.stop();
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
                        System.out.println((char) 31 + "Elija solamente entre 1 y 7");
                        break;
                }
            } catch (Exception e) {

                System.out.println((char) 31 + "Opción inválida: no se pueden escoger carácteres");
                System.out.println((char) 31 + "Intentalo nuevamente");
                System.out.println("Presiona Enter para continuar");
                try {
                    System.in.read();
                } catch (Exception ex) {
                }
            }
        } while (repetirmenu == true);
    }

    public void menujuego2() throws InterruptedException {
        menuactual = "menujuego2";
        //sonjuego.start();
        escena.leerdibujo("2.txt");
        historia.leerDatos(2);

        System.out.println("");
        System.out.println((char) 27 + "[37m" + "Opciones del juego"
                + "\n Pulse 3 para mostrar Avance del Juego."
                + "\n Pulse 4 para Retroceder una Escena, si es posible."
                + "\n Pulse 5 para Guardar la Partida, si es posible."
                + "\n Pulse 6 para Volver al Menu Principal"
                + "\n Pulse 7 para Salir del Juego "
                + "\n");

        System.out.println((char) 27 + "[37m" + "Ingrese la opción elegida: ");

        do {
            try {
                Scanner teclado = new Scanner(System.in);
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        repetirmenu = false;
                        menujuego4();
                        break;
                    case 2:
                        repetirmenu = false;
                        menujuego3();
                        break;
                    case 3:
                        double avance = (2 * (100) / 40);
                        DecimalFormat df = new DecimalFormat("#.00");
                        System.out.println("Ud lleva un avance del = " + df.format(avance) + "% del total del Juego" + "\n");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 4:
                        System.out.println("No es posible retroceder en esta escena");
                       
                        repetirmenu = true;

                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 5:
                        //jugadorazo.guardarPartida(menuactual); (cooming son xd)
                        System.out.println("Partida guardada correctamente");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 6:
                        sonjuego.stop();
                        repetirmenu = false;
                        jugadorazo.menuPrincipal();
                        break;
                    case 7:
                        int msj = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas salir sin guardar?");
                        if (msj == JOptionPane.YES_OPTION) {
                            sonjuego.stop();
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
                        System.out.println((char) 31 + "Elija solamente entre 1 y 7");
                        break;
                }
            } catch (Exception e) {

                System.out.println((char) 31 + "Opción inválida: no se pueden escoger carácteres");
                System.out.println((char) 31 + "Intentalo nuevamente");
                System.out.println("Presiona Enter para continuar");
                try {
                    System.in.read();
                } catch (Exception ex) {
                }
            }
        } while (repetirmenu == true);
    }

    public void menujuego3() throws InterruptedException {
        menuactual = "menujuego3";
        //sonjuego.start();
        escena.leerdibujo("2.txt");
        historia.leerDatos(3);

        System.out.println("");
        System.out.println((char) 27 + "[37m" + "Opciones del juego"
                + "\n Pulse 3 para mostrar Avance del Juego."
                + "\n Pulse 4 para Retroceder una Escena, si es posible."
                + "\n Pulse 5 para Guardar la Partida, si es posible."
                + "\n Pulse 6 para Volver al Menu Principal"
                + "\n Pulse 7 para Salir del Juego "
                + "\n");

        System.out.println((char) 27 + "[37m" + "Ingrese la opción elegida: ");

        do {
            try {
                Scanner teclado = new Scanner(System.in);
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        repetirmenu = false;
                        menujuego4();
                        break;
                    case 2:
                        int msjm = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas continuar con está opcion-cualquier cosa es posible-?");
                        if (msjm == JOptionPane.YES_OPTION) {
                            repetirmenu = false;
                            JOptionPane.showMessageDialog(null, "Esta vez Has tenido suerte lográs avanzar en el juego hasta Innsmouth");
                            menujuego8();
                            break;

                        }
                        if (msjm == JOptionPane.NO_OPTION) {
                            repetirmenu = true;
                            System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        }
                        if (msjm == JOptionPane.CANCEL_OPTION) {
                            repetirmenu = true;
                            System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        }
                        break;

                    case 3:
                        double avance = (3 * (100) / 40);
                        DecimalFormat df = new DecimalFormat("#.00");
                        System.out.println("Ud lleva un avance del = " + df.format(avance) + "% del total del Juego" + "\n");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 4:
                       // System.out.println("No es posible retroceder en esta escena");
                        menujuego2();
                        repetirmenu = true;

                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 5:
                        //jugadorazo.guardarPartida(menuactual); (cooming son xd)
                        System.out.println("Partida guardada correctamente");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 6:
                        sonjuego.stop();
                        repetirmenu = false;
                        jugadorazo.menuPrincipal();
                        break;
                    case 7:
                        int msj = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas salir sin guardar?");
                        if (msj == JOptionPane.YES_OPTION) {
                            sonjuego.stop();
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
                        System.out.println((char) 31 + "Elija solamente entre 1 y 7");
                        break;
                }
            } catch (Exception e) {

                System.out.println((char) 31 + "Opción inválida: no se pueden escoger carácteres");
                System.out.println((char) 31 + "Intentalo nuevamente");
                System.out.println("Presiona Enter para continuar");
                try {
                    System.in.read();
                } catch (Exception ex) {
                }
            }
        } while (repetirmenu == true);
    }

    public void menujuego4() throws InterruptedException {
        menuactual = "menujuego4";
        //sonjuego.start();
        anime.animacionPaso();
        escena.leerdibujo("3.txt");
        historia.leerDatos(4);

        System.out.println("");
        System.out.println((char) 27 + "[37m" + "Opciones del juego"
                + "\n Pulse 3 para mostrar Avance del Juego."
                + "\n Pulse 4 para Retroceder una Escena, si es posible."
                + "\n Pulse 5 para Guardar la Partida, si es posible."
                + "\n Pulse 6 para Volver al Menu Principal"
                + "\n Pulse 7 para Salir del Juego "
                + "\n");

        System.out.println((char) 27 + "[37m" + "Ingrese la opción elegida: ");

        do {
            try {
                Scanner teclado = new Scanner(System.in);
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        repetirmenu = false;
                        menujuego5();
                        break;
                    case 2:
                        repetirmenu = false;
                        menujuego6();
                        break;

                    case 3:
                        double avance = (4 * (100) / 40);
                        DecimalFormat df = new DecimalFormat("#.00");
                        System.out.println("Ud lleva un avance del = " + df.format(avance) + "% del total del Juego" + "\n");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 4:
                        System.out.println("No es posible retroceder en esta escena");
                        repetirmenu = true;

                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 5:
                        //jugadorazo.guardarPartida(menuactual); (cooming son xd)
                        System.out.println("Partida guardada correctamente");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 6:
                        sonjuego.stop();
                        repetirmenu = false;
                        jugadorazo.menuPrincipal();
                        break;
                    case 7:
                        int msj = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas salir sin guardar?");
                        if (msj == JOptionPane.YES_OPTION) {
                            sonjuego.stop();
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
                        System.out.println((char) 31 + "Elija solamente entre 1 y 7");
                        break;
                }
            } catch (Exception e) {

                System.out.println((char) 31 + "Opción inválida: no se pueden escoger carácteres");
                System.out.println((char) 31 + "Intentalo nuevamente");
                System.out.println("Presiona Enter para continuar");
                try {
                    System.in.read();
                } catch (Exception ex) {
                }
            }
        } while (repetirmenu == true);
    }

    public void menujuego5() throws InterruptedException {
        menuactual = "menujuego5";
        //sonjuego.start();
        //anime.animacionPaso();
        //escena.leerdibujo("3.txt");
        historia.leerDatos(5);

        System.out.println("");
        System.out.println((char) 27 + "[37m" + "Opciones del juego"
                + "\n Pulse 3 para mostrar Avance del Juego."
                + "\n Pulse 4 para Retroceder una Escena, si es posible."
                + "\n Pulse 5 para Guardar la Partida, si es posible."
                + "\n Pulse 6 para Volver al Menu Principal"
                + "\n Pulse 7 para Salir del Juego "
                + "\n");

        System.out.println((char) 27 + "[37m" + "Ingrese la opción elegida: ");

        do {
            try {
                Scanner teclado = new Scanner(System.in);
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        repetirmenu = false;
                        menujuego7();
                        break;
                    case 2:
                        repetirmenu = false;
                        menujuego6();
                        break;

                    case 3:
                        double avance = (5 * (100) / 40);
                        DecimalFormat df = new DecimalFormat("#.00");
                        System.out.println("Ud lleva un avance del = " + df.format(avance) + "% del total del Juego" + "\n");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 4:
                        System.out.println("No es posible retroceder en esta escena");
                        repetirmenu = true;

                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 5:
                        //jugadorazo.guardarPartida(menuactual); (cooming son xd)
                        System.out.println("Partida guardada correctamente");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 6:
                        sonjuego.stop();
                        repetirmenu = false;
                        jugadorazo.menuPrincipal();
                        break;
                    case 7:
                        int msj = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas salir sin guardar?");
                        if (msj == JOptionPane.YES_OPTION) {
                            sonjuego.stop();
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
                        System.out.println((char) 31 + "Elija solamente entre 1 y 7");
                        break;
                }
            } catch (Exception e) {

                System.out.println((char) 31 + "Opción inválida: no se pueden escoger carácteres");
                System.out.println((char) 31 + "Intentalo nuevamente");
                System.out.println("Presiona Enter para continuar");
                try {
                    System.in.read();
                } catch (Exception ex) {
                }
            }
        } while (repetirmenu == true);
    }

    public void menujuego6() throws InterruptedException {
        menuactual = "menujuego6";
        //sonjuego.start();
        //anime.animacionPaso();
        //escena.leerdibujo("3.txt");
        historia.leerDatos(6);

        System.out.println("");
        System.out.println((char) 27 + "[37m" + "Opciones del juego"
                + "\n Pulse 3 para mostrar Avance del Juego."
                + "\n Pulse 4 para Retroceder una Escena, si es posible."
                + "\n Pulse 5 para Guardar la Partida, si es posible."
                + "\n Pulse 6 para Volver al Menu Principal"
                + "\n Pulse 7 para Salir del Juego "
                + "\n");

        System.out.println((char) 27 + "[37m" + "Ingrese la opción elegida: ");

        do {
            try {
                Scanner teclado = new Scanner(System.in);
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        repetirmenu = false;
                        menujuego7();
                        break;
                    case 2:
                        repetirmenu = false;
                        menujuego7();
                        break;

                    case 3:
                        double avance = (6 * (100) / 40);
                        DecimalFormat df = new DecimalFormat("#.00");
                        System.out.println("Ud lleva un avance del = " + df.format(avance) + "% del total del Juego" + "\n");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 4:
                        System.out.println("No es posible retroceder en esta escena");
                        repetirmenu = true;

                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 5:
                        //jugadorazo.guardarPartida(menuactual); (cooming son xd)
                        System.out.println("Partida guardada correctamente");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 6:
                        sonjuego.stop();
                        repetirmenu = false;
                        jugadorazo.menuPrincipal();
                        break;
                    case 7:
                        int msj = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas salir sin guardar?");
                        if (msj == JOptionPane.YES_OPTION) {
                            sonjuego.stop();
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
                        System.out.println((char) 31 + "Elija solamente entre 1 y 7");
                        break;
                }
            } catch (Exception e) {

                System.out.println((char) 31 + "Opción inválida: no se pueden escoger carácteres");
                System.out.println((char) 31 + "Intentalo nuevamente");
                System.out.println("Presiona Enter para continuar");
                try {
                    System.in.read();
                } catch (Exception ex) {
                }
            }
        } while (repetirmenu == true);
    }

    public void menujuego7() throws InterruptedException {
        menuactual = "menujuego7";
        //sonjuego.start();
        anime.animacionPaso();
        //escena.leerdibujo("3.txt");
        historia.leerDatos(7);

        System.out.println("");
        System.out.println((char) 27 + "[37m" + "Opciones del juego"
                + "\n Pulse 3 para mostrar Avance del Juego."
                + "\n Pulse 4 para Retroceder una Escena, si es posible."
                + "\n Pulse 5 para Guardar la Partida, si es posible."
                + "\n Pulse 6 para Volver al Menu Principal"
                + "\n Pulse 7 para Salir del Juego "
                + "\n");

        System.out.println((char) 27 + "[37m" + "Ingrese la opción elegida: ");

        do {
            try {
                Scanner teclado = new Scanner(System.in);
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        repetirmenu = false;
                        menujuego8();
                        break;
                    case 2:
                        repetirmenu = false;
                        menujuego8();
                        break;

                    case 3:
                        double avance = (7 * (100) / 40);
                        DecimalFormat df = new DecimalFormat("#.00");
                        System.out.println("Ud lleva un avance del = " + df.format(avance) + "% del total del Juego" + "\n");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 4:
                        System.out.println("No es posible retroceder en esta escena");
                        repetirmenu = true;

                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 5:
                        //jugadorazo.guardarPartida(menuactual); (cooming son xd)
                        System.out.println("Partida guardada correctamente");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 6:
                        sonjuego.stop();
                        repetirmenu = false;
                        jugadorazo.menuPrincipal();
                        break;
                    case 7:
                        int msj = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas salir sin guardar?");
                        if (msj == JOptionPane.YES_OPTION) {
                            sonjuego.stop();
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
                        System.out.println((char) 31 + "Elija solamente entre 1 y 7");
                        break;
                }
            } catch (Exception e) {

                System.out.println((char) 31 + "Opción inválida: no se pueden escoger carácteres");
                System.out.println((char) 31 + "Intentalo nuevamente");
                System.out.println("Presiona Enter para continuar");
                try {
                    System.in.read();
                } catch (Exception ex) {
                }
            }
        } while (repetirmenu == true);
    }

    public void menujuego8() throws InterruptedException {
        menuactual = "menujuego8";
        //sonjuego.start();
        anime.animacionBus();
        escena.leerdibujo("4.txt");
        historia.leerDatos(8);

        System.out.println("");
        System.out.println((char) 27 + "[37m" + "Opciones del juego"
                + "\n Pulse 3 para mostrar Avance del Juego."
                + "\n Pulse 4 para Retroceder una Escena, si es posible."
                + "\n Pulse 5 para Guardar la Partida, si es posible."
                + "\n Pulse 6 para Volver al Menu Principal"
                + "\n Pulse 7 para Salir del Juego "
                + "\n");

        System.out.println((char) 27 + "[37m" + "Ingrese la opción elegida: ");

        do {
            try {
                Scanner teclado = new Scanner(System.in);
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        repetirmenu = false;
                        menujuego9();
                        break;
                    case 2:
                        repetirmenu = false;
                        menujuego10();
                        break;

                    case 3:
                        double avance = (8 * (100) / 40);
                        DecimalFormat df = new DecimalFormat("#.00");
                        System.out.println("Ud lleva un avance del = " + df.format(avance) + "% del total del Juego" + "\n");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 4:
                        System.out.println("No es posible retroceder en esta escena");
                        repetirmenu = true;

                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 5:
                        //jugadorazo.guardarPartida(menuactual); (cooming son xd)
                        System.out.println("Partida guardada correctamente");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 6:
                        sonjuego.stop();
                        repetirmenu = false;
                        jugadorazo.menuPrincipal();
                        break;
                    case 7:
                        int msj = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas salir sin guardar?");
                        if (msj == JOptionPane.YES_OPTION) {
                            sonjuego.stop();
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
                        System.out.println((char) 31 + "Elija solamente entre 1 y 7");
                        break;
                }
            } catch (Exception e) {

                System.out.println((char) 31 + "Opción inválida: no se pueden escoger carácteres");
                System.out.println((char) 31 + "Intentalo nuevamente");
                System.out.println("Presiona Enter para continuar");
                try {
                    System.in.read();
                } catch (Exception ex) {
                }
            }
        } while (repetirmenu == true);
    }

    public void menujuego9() throws InterruptedException {
        menuactual = "menujuego9";
        //sonjuego.start();
        //anime.animacionBus();
        escena.leerdibujo("4.txt");
        historia.leerDatos(9);

        System.out.println("");
        System.out.println((char) 27 + "[37m" + "Opciones del juego"
                + "\n Pulse 3 para mostrar Avance del Juego."
                + "\n Pulse 4 para Retroceder una Escena, si es posible."
                + "\n Pulse 5 para Guardar la Partida, si es posible."
                + "\n Pulse 6 para Volver al Menu Principal"
                + "\n Pulse 7 para Salir del Juego "
                + "\n");

        System.out.println((char) 27 + "[37m" + "Ingrese la opción elegida: ");

        do {
            try {
                Scanner teclado = new Scanner(System.in);
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        repetirmenu = false;
                        menujuego10();
                        break;
                    case 2:
                        repetirmenu = false;
                        JOptionPane.showMessageDialog(null, "¿Dónde quedaron tus buenos modales? Retrocedes a Arkham por agresivo");
                        menujuego4();
                        break;

                    case 3:
                        double avance = (9 * (100) / 40);
                        DecimalFormat df = new DecimalFormat("#.00");
                        System.out.println("Ud lleva un avance del = " + df.format(avance) + "% del total del Juego" + "\n");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 4:
                        System.out.println("No es posible retroceder en esta escena");
                        repetirmenu = true;

                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 5:
                        //jugadorazo.guardarPartida(menuactual); (cooming son xd)
                        System.out.println("Partida guardada correctamente");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 6:
                        sonjuego.stop();
                        repetirmenu = false;
                        jugadorazo.menuPrincipal();
                        break;
                    case 7:
                        int msj = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas salir sin guardar?");
                        if (msj == JOptionPane.YES_OPTION) {
                            sonjuego.stop();
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
                        System.out.println((char) 31 + "Elija solamente entre 1 y 7");
                        break;
                }
            } catch (Exception e) {

                System.out.println((char) 31 + "Opción inválida: no se pueden escoger carácteres");
                System.out.println((char) 31 + "Intentalo nuevamente");
                System.out.println("Presiona Enter para continuar");
                try {
                    System.in.read();
                } catch (Exception ex) {
                }
            }
        } while (repetirmenu == true);
    }

    public void menujuego10() throws InterruptedException {
        menuactual = "menujuego10";
        //sonjuego.start();
        anime.animacionBus();
        escena.leerdibujo("6.txt");
        historia.leerDatos(10);

        System.out.println("");
        System.out.println((char) 27 + "[37m" + "Opciones del juego"
                + "\n Pulse 3 para mostrar Avance del Juego."
                + "\n Pulse 4 para Retroceder una Escena, si es posible."
                + "\n Pulse 5 para Guardar la Partida, si es posible."
                + "\n Pulse 6 para Volver al Menu Principal"
                + "\n Pulse 7 para Salir del Juego "
                + "\n");

        System.out.println((char) 27 + "[37m" + "Ingrese la opción elegida: ");

        do {
            try {
                Scanner teclado = new Scanner(System.in);
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        repetirmenu = false;
                        menujuego12();
                        break;
                    case 2:
                        repetirmenu = false;
                        //JOptionPane.showMessageDialog(null, "¿Dónde quedaron tus buenos modales? Retrocedes a Arkham por agresivo");
                        menujuego11();
                        break;

                    case 3:
                        double avance = (10 * (100) / 40);
                        DecimalFormat df = new DecimalFormat("#.00");
                        System.out.println("Ud lleva un avance del = " + df.format(avance) + "% del total del Juego" + "\n");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 4:
                        System.out.println("No es posible retroceder en esta escena");
                        repetirmenu = true;

                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 5:
                        //jugadorazo.guardarPartida(menuactual); (cooming son xd)
                        System.out.println("Partida guardada correctamente");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 6:
                        sonjuego.stop();
                        repetirmenu = false;
                        jugadorazo.menuPrincipal();
                        break;
                    case 7:
                        int msj = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas salir sin guardar?");
                        if (msj == JOptionPane.YES_OPTION) {
                            sonjuego.stop();
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
                        System.out.println((char) 31 + "Elija solamente entre 1 y 7");
                        break;
                }
            } catch (Exception e) {

                System.out.println((char) 31 + "Opción inválida: no se pueden escoger carácteres");
                System.out.println((char) 31 + "Intentalo nuevamente");
                System.out.println("Presiona Enter para continuar");
                try {
                    System.in.read();
                } catch (Exception ex) {
                }
            }
        } while (repetirmenu == true);
    }

    public void menujuego11() throws InterruptedException {
        menuactual = "menujuego11";
        //sonjuego.start();
        // anime.animacionBus();
        escena.leerdibujo("6.txt");
        historia.leerDatos(11);

        System.out.println("");
        System.out.println((char) 27 + "[37m" + "Opciones del juego"
                + "\n Pulse 3 para mostrar Avance del Juego."
                + "\n Pulse 4 para Retroceder una Escena, si es posible."
                + "\n Pulse 5 para Guardar la Partida, si es posible."
                + "\n Pulse 6 para Volver al Menu Principal"
                + "\n Pulse 7 para Salir del Juego "
                + "\n");

        System.out.println((char) 27 + "[37m" + "Ingrese la opción elegida: ");

        do {
            try {
                Scanner teclado = new Scanner(System.in);
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        repetirmenu = false;
                        menujuego13();
                        break;
                    case 2:
                        repetirmenu = false;
                        //JOptionPane.showMessageDialog(null, "¿Dónde quedaron tus buenos modales? Retrocedes a Arkham por agresivo");
                        menujuego12();
                        break;

                    case 3:
                        double avance = (11 * (100) / 40);
                        DecimalFormat df = new DecimalFormat("#.00");
                        System.out.println("Ud lleva un avance del = " + df.format(avance) + "% del total del Juego" + "\n");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 4:
                        System.out.println("No es posible retroceder en esta escena");
                        repetirmenu = true;

                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 5:
                        //jugadorazo.guardarPartida(menuactual); (cooming son xd)
                        System.out.println("Partida guardada correctamente");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 6:
                        sonjuego.stop();
                        repetirmenu = false;
                        jugadorazo.menuPrincipal();
                        break;
                    case 7:
                        int msj = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas salir sin guardar?");
                        if (msj == JOptionPane.YES_OPTION) {
                            sonjuego.stop();
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
                        System.out.println((char) 31 + "Elija solamente entre 1 y 7");
                        break;
                }
            } catch (Exception e) {

                System.out.println((char) 31 + "Opción inválida: no se pueden escoger carácteres");
                System.out.println((char) 31 + "Intentalo nuevamente");
                System.out.println("Presiona Enter para continuar");
                try {
                    System.in.read();
                } catch (Exception ex) {
                }
            }
        } while (repetirmenu == true);
    }

    public void menujuego12() throws InterruptedException {
        menuactual = "menujuego12";
        //sonjuego.start();
        anime.animacionPaso();
        escena.leerdibujo("5.txt");
        historia.leerDatos(12);

        System.out.println("");
        System.out.println((char) 27 + "[37m" + "Opciones del juego"
                + "\n Pulse 3 para mostrar Avance del Juego."
                + "\n Pulse 4 para Retroceder una Escena, si es posible."
                + "\n Pulse 5 para Guardar la Partida, si es posible."
                + "\n Pulse 6 para Volver al Menu Principal"
                + "\n Pulse 7 para Salir del Juego "
                + "\n");

        System.out.println((char) 27 + "[37m" + "Ingrese la opción elegida: ");

        do {
            try {
                Scanner teclado = new Scanner(System.in);
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        repetirmenu = false;
                        menujuego15();
                        break;
                    case 2:
                        repetirmenu = false;
                        //JOptionPane.showMessageDialog(null, "¿Dónde quedaron tus buenos modales? Retrocedes a Arkham por agresivo");
                        menujuego16();
                        break;

                    case 3:
                        double avance = (12 * (100) / 40);
                        DecimalFormat df = new DecimalFormat("#.00");
                        System.out.println("Ud lleva un avance del = " + df.format(avance) + "% del total del Juego" + "\n");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 4:
                        System.out.println("No es posible retroceder en esta escena");
                        repetirmenu = true;

                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 5:
                        //jugadorazo.guardarPartida(menuactual); (cooming son xd)
                        System.out.println("Partida guardada correctamente");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 6:
                        sonjuego.stop();
                        repetirmenu = false;
                        jugadorazo.menuPrincipal();
                        break;
                    case 7:
                        int msj = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas salir sin guardar?");
                        if (msj == JOptionPane.YES_OPTION) {
                            sonjuego.stop();
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
                        System.out.println((char) 31 + "Elija solamente entre 1 y 7");
                        break;
                }
            } catch (Exception e) {

                System.out.println((char) 31 + "Opción inválida: no se pueden escoger carácteres");
                System.out.println((char) 31 + "Intentalo nuevamente");
                System.out.println("Presiona Enter para continuar");
                try {
                    System.in.read();
                } catch (Exception ex) {
                }
            }
        } while (repetirmenu == true);
    }

    public void menujuego13() throws InterruptedException {
        menuactual = "menujuego13";
        //sonjuego.start();
        anime.animacionPaso();
        escena.leerdibujo("7.txt");
        historia.leerDatos(13);

        System.out.println("");
        System.out.println((char) 27 + "[37m" + "Opciones del juego"
                + "\n Pulse 3 para mostrar Avance del Juego."
                + "\n Pulse 4 para Retroceder una Escena, si es posible."
                + "\n Pulse 5 para Guardar la Partida, si es posible."
                + "\n Pulse 6 para Volver al Menu Principal"
                + "\n Pulse 7 para Salir del Juego "
                + "\n");

        System.out.println((char) 27 + "[37m" + "Ingrese la opción elegida: ");

        do {
            try {
                Scanner teclado = new Scanner(System.in);
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        repetirmenu = false;
                        menujuego14();
                        break;
                    case 2:
                        repetirmenu = false;
                        JOptionPane.showMessageDialog(null, "A veces los misterios son aburridos, esta vez quedas donde mismo");
                        menujuego13();
                        break;

                    case 3:
                        double avance = (13 * (100) / 40);
                        DecimalFormat df = new DecimalFormat("#.00");
                        System.out.println("Ud lleva un avance del = " + df.format(avance) + "% del total del Juego" + "\n");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 4:
                        System.out.println("No es posible retroceder en esta escena");
                        repetirmenu = true;

                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 5:
                        //jugadorazo.guardarPartida(menuactual); (cooming son xd)
                        System.out.println("Partida guardada correctamente");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 6:
                        sonjuego.stop();
                        repetirmenu = false;
                        jugadorazo.menuPrincipal();
                        break;
                    case 7:
                        int msj = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas salir sin guardar?");
                        if (msj == JOptionPane.YES_OPTION) {
                            sonjuego.stop();
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
                        System.out.println((char) 31 + "Elija solamente entre 1 y 7");
                        break;
                }
            } catch (Exception e) {

                System.out.println((char) 31 + "Opción inválida: no se pueden escoger carácteres");
                System.out.println((char) 31 + "Intentalo nuevamente");
                System.out.println("Presiona Enter para continuar");
                try {
                    System.in.read();
                } catch (Exception ex) {
                }
            }
        } while (repetirmenu == true);
    }

    public void menujuego14() throws InterruptedException {
        menuactual = "menujuego14";
        //sonjuego.start();
        //anime.animacionPaso();
        escena.leerdibujo("5.txt");
        historia.leerDatos(14);

        System.out.println("");
        System.out.println((char) 27 + "[37m" + "Opciones del juego"
                + "\n Pulse 3 para mostrar Avance del Juego."
                + "\n Pulse 4 para Retroceder una Escena, si es posible."
                + "\n Pulse 5 para Guardar la Partida, si es posible."
                + "\n Pulse 6 para Volver al Menu Principal"
                + "\n Pulse 7 para Salir del Juego "
                + "\n");

        System.out.println((char) 27 + "[37m" + "Ingrese la opción elegida: ");

        do {
            try {
                Scanner teclado = new Scanner(System.in);
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        repetirmenu = false;
                        sonjuego.stop();
                        menujuego17();
                        break;
                    case 2:
                        repetirmenu = false;
                        JOptionPane.showMessageDialog(null, "Estás de suerte, nuevamente avanzas");
                        sonjuego.stop();
                        menujuego17();
                        break;

                    case 3:
                        double avance = (14 * (100) / 40);
                        DecimalFormat df = new DecimalFormat("#.00");
                        System.out.println("Ud lleva un avance del = " + df.format(avance) + "% del total del Juego" + "\n");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 4:
                        System.out.println("No es posible retroceder en esta escena");
                        repetirmenu = true;

                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 5:
                        //jugadorazo.guardarPartida(menuactual); (cooming son xd)
                        System.out.println("Partida guardada correctamente");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 6:
                        sonjuego.stop();
                        repetirmenu = false;
                        jugadorazo.menuPrincipal();
                        break;
                    case 7:
                        int msj = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas salir sin guardar?");
                        if (msj == JOptionPane.YES_OPTION) {
                            sonjuego.stop();
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
                        System.out.println((char) 31 + "Elija solamente entre 1 y 7");
                        break;
                }
            } catch (Exception e) {

                System.out.println((char) 31 + "Opción inválida: no se pueden escoger carácteres");
                System.out.println((char) 31 + "Intentalo nuevamente");
                System.out.println("Presiona Enter para continuar");
                try {
                    System.in.read();
                } catch (Exception ex) {
                }
            }
        } while (repetirmenu == true);
    }

    public void menujuego15() throws InterruptedException {
        menuactual = "menujuego15";
        //sonjuego.start();
        anime.animacionPaso();
        escena.leerdibujo("5.txt");
        historia.leerDatos(15);

        System.out.println("");
        System.out.println((char) 27 + "[37m" + "Opciones del juego"
                + "\n Pulse 3 para mostrar Avance del Juego."
                + "\n Pulse 4 para Retroceder una Escena, si es posible."
                + "\n Pulse 5 para Guardar la Partida, si es posible."
                + "\n Pulse 6 para Volver al Menu Principal"
                + "\n Pulse 7 para Salir del Juego "
                + "\n");

        System.out.println((char) 27 + "[37m" + "Ingrese la opción elegida: ");

        do {
            try {
                Scanner teclado = new Scanner(System.in);
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        repetirmenu = false;
                        sonjuego.stop();
                        menujuego17();
                        break;
                    case 2:
                        repetirmenu = false;
                        JOptionPane.showMessageDialog(null, "Estás de suerte, nuevamente avanzas");
                        menujuego16();
                        break;

                    case 3:
                        double avance = (15 * (100) / 40);
                        DecimalFormat df = new DecimalFormat("#.00");
                        System.out.println("Ud lleva un avance del = " + df.format(avance) + "% del total del Juego" + "\n");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 4:
                        System.out.println("No es posible retroceder en esta escena");
                        repetirmenu = true;

                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 5:
                        //jugadorazo.guardarPartida(menuactual); (cooming son xd)
                        System.out.println("Partida guardada correctamente");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 6:
                        sonjuego.stop();
                        repetirmenu = false;
                        jugadorazo.menuPrincipal();
                        break;
                    case 7:
                        int msj = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas salir sin guardar?");
                        if (msj == JOptionPane.YES_OPTION) {
                            sonjuego.stop();
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
                        System.out.println((char) 31 + "Elija solamente entre 1 y 7");
                        break;
                }
            } catch (Exception e) {

                System.out.println((char) 31 + "Opción inválida: no se pueden escoger carácteres");
                System.out.println((char) 31 + "Intentalo nuevamente");
                System.out.println("Presiona Enter para continuar");
                try {
                    System.in.read();
                } catch (Exception ex) {
                }
            }
        } while (repetirmenu == true);
    }

    public void menujuego16() throws InterruptedException {
        menuactual = "menujuego16";
        //sonjuego.start();
        //  anime.animacionPaso();
        // escena.leerdibujo("5.txt");
        historia.leerDatos(16);

        System.out.println("");
        System.out.println((char) 27 + "[37m" + "Opciones del juego"
                + "\n Pulse 3 para mostrar Avance del Juego."
                + "\n Pulse 4 para Retroceder una Escena, si es posible."
                + "\n Pulse 5 para Guardar la Partida, si es posible."
                + "\n Pulse 6 para Volver al Menu Principal"
                + "\n Pulse 7 para Salir del Juego "
                + "\n");

        System.out.println((char) 27 + "[37m" + "Ingrese la opción elegida: ");

        do {
            try {
                Scanner teclado = new Scanner(System.in);
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        repetirmenu = false;
                        sonjuego.stop();
                        menujuego17();
                        break;
                    case 2:
                        repetirmenu = false;
                        JOptionPane.showMessageDialog(null, "mala suerte, vuelves al arribo a Innsmouth");
                        menujuego10();
                        break;

                    case 3:
                        double avance = (16 * (100) / 40);
                        DecimalFormat df = new DecimalFormat("#.00");
                        System.out.println("Ud lleva un avance del = " + df.format(avance) + "% del total del Juego" + "\n");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 4:
                        System.out.println("No es posible retroceder en esta escena");
                        repetirmenu = true;

                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 5:
                        //jugadorazo.guardarPartida(menuactual); (cooming son xd)
                        System.out.println("Partida guardada correctamente");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 6:
                        sonjuego.stop();
                        repetirmenu = false;
                        jugadorazo.menuPrincipal();
                        break;
                    case 7:
                        int msj = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas salir sin guardar?");
                        if (msj == JOptionPane.YES_OPTION) {
                            sonjuego.stop();
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
                        System.out.println((char) 31 + "Elija solamente entre 1 y 7");
                        break;
                }
            } catch (Exception e) {

                System.out.println((char) 31 + "Opción inválida: no se pueden escoger carácteres");
                System.out.println((char) 31 + "Intentalo nuevamente");
                System.out.println("Presiona Enter para continuar");
                try {
                    System.in.read();
                } catch (Exception ex) {
                }
            }
        } while (repetirmenu == true);
    }

    public void menujuego17() throws InterruptedException {
        menuactual = "menujuego17";
        sonperse.start();
        //  anime.animacionPaso();
        escena.leerdibujo("8.txt");
        Thread.sleep(3000);
        escena.leerdibujo("9.txt");
        historia.leerDatos(17);

        System.out.println("");
        System.out.println((char) 27 + "[37m" + "Opciones del juego"
                + "\n Pulse 3 para mostrar Avance del Juego."
                + "\n Pulse 4 para Retroceder una Escena, si es posible."
                + "\n Pulse 5 para Guardar la Partida, si es posible."
                + "\n Pulse 6 para Volver al Menu Principal"
                + "\n Pulse 7 para Salir del Juego "
                + "\n");

        System.out.println((char) 27 + "[37m" + "Ingrese la opción elegida: ");

        do {
            try {
                Scanner teclado = new Scanner(System.in);
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        repetirmenu = false;
                        son.stop();
                        menujuego18();
                        break;
                    case 2:
                        repetirmenu = false;
                        menujuego24();
                        break;

                    case 3:
                        double avance = (17 * (100) / 40);
                        DecimalFormat df = new DecimalFormat("#.00");
                        System.out.println("Ud lleva un avance del = " + df.format(avance) + "% del total del Juego" + "\n");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 4:
                        System.out.println("No es posible retroceder en esta escena");
                        repetirmenu = true;

                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 5:
                        //jugadorazo.guardarPartida(menuactual); (cooming son xd)
                        System.out.println("Partida guardada correctamente");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 6:
                        sonperse.stop();
                        repetirmenu = false;
                        jugadorazo.menuPrincipal();
                        break;
                    case 7:
                        int msj = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas salir sin guardar?");
                        if (msj == JOptionPane.YES_OPTION) {
                            sonjuego.stop();
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
                        System.out.println((char) 31 + "Elija solamente entre 1 y 7");
                        break;
                }
            } catch (Exception e) {

                System.out.println((char) 31 + "Opción inválida: no se pueden escoger carácteres");
                System.out.println((char) 31 + "Intentalo nuevamente");
                System.out.println("Presiona Enter para continuar");
                try {
                    System.in.read();
                } catch (Exception ex) {
                }
            }
        } while (repetirmenu == true);
    }

    public void menujuego18() throws InterruptedException {
        menuactual = "menujuego18";
        //sonperse.start();
        //  anime.animacionPaso();
        escena.leerdibujo("9.txt");
        historia.leerDatos(18);

        System.out.println("");
        System.out.println((char) 27 + "[37m" + "Opciones del juego"
                + "\n Pulse 3 para mostrar Avance del Juego."
                + "\n Pulse 4 para Retroceder una Escena, si es posible."
                + "\n Pulse 5 para Guardar la Partida, si es posible."
                + "\n Pulse 6 para Volver al Menu Principal"
                + "\n Pulse 7 para Salir del Juego "
                + "\n");

        System.out.println((char) 27 + "[37m" + "Ingrese la opción elegida: ");

        do {
            try {
                Scanner teclado = new Scanner(System.in);
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        repetirmenu = false;
                        menujuego19();
                        break;
                    case 2:
                        repetirmenu = false;
                        sonperse.stop();
                        menujuego24();
                        break;

                    case 3:
                        double avance = (18 * (100) / 40);
                        DecimalFormat df = new DecimalFormat("#.00");
                        System.out.println("Ud lleva un avance del = " + df.format(avance) + "% del total del Juego" + "\n");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 4:
                        System.out.println("No es posible retroceder en esta escena");
                        repetirmenu = true;

                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 5:
                        //jugadorazo.guardarPartida(menuactual); (cooming son xd)
                        System.out.println("Partida guardada correctamente");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 6:
                        sonjuego.stop();
                        repetirmenu = false;
                        jugadorazo.menuPrincipal();
                        break;
                    case 7:
                        int msj = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas salir sin guardar?");
                        if (msj == JOptionPane.YES_OPTION) {
                            sonjuego.stop();
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
                        System.out.println((char) 31 + "Elija solamente entre 1 y 7");
                        break;
                }
            } catch (Exception e) {

                System.out.println((char) 31 + "Opción inválida: no se pueden escoger carácteres");
                System.out.println((char) 31 + "Intentalo nuevamente");
                System.out.println("Presiona Enter para continuar");
                try {
                    System.in.read();
                } catch (Exception ex) {
                }
            }
        } while (repetirmenu == true);
    }

    public void menujuego19() throws InterruptedException {
        menuactual = "menujuego19";
        //  sonperse.start();
        anime.animacionPaso();
        // escena.leerdibujo("9.txt");
        historia.leerDatos(19);

        System.out.println("");
        System.out.println((char) 27 + "[37m" + "Opciones del juego"
                + "\n Pulse 3 para mostrar Avance del Juego."
                + "\n Pulse 4 para Retroceder una Escena, si es posible."
                + "\n Pulse 5 para Guardar la Partida, si es posible."
                + "\n Pulse 6 para Volver al Menu Principal"
                + "\n Pulse 7 para Salir del Juego "
                + "\n");

        System.out.println((char) 27 + "[37m" + "Ingrese la opción elegida: ");

        do {
            try {
                Scanner teclado = new Scanner(System.in);
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:

                        repetirmenu = false;
                        sonperse.stop();
                        menujuego21C();
                        break;
                    case 2:
                        repetirmenu = false;
                        menujuego20();
                        break;

                    case 3:
                        double avance = (19 * (100) / 40);
                        DecimalFormat df = new DecimalFormat("#.00");
                        System.out.println("Ud lleva un avance del = " + df.format(avance) + "% del total del Juego" + "\n");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 4:
                        System.out.println("No es posible retroceder en esta escena");
                        repetirmenu = true;

                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 5:
                        //jugadorazo.guardarPartida(menuactual); (cooming son xd)
                        System.out.println("Partida guardada correctamente");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 6:
                        sonjuego.stop();
                        repetirmenu = false;
                        jugadorazo.menuPrincipal();
                        break;
                    case 7:
                        int msj = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas salir sin guardar?");
                        if (msj == JOptionPane.YES_OPTION) {
                            sonjuego.stop();
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
                        System.out.println((char) 31 + "Elija solamente entre 1 y 7");
                        break;
                }
            } catch (Exception e) {

                System.out.println((char) 31 + "Opción inválida: no se pueden escoger carácteres");
                System.out.println((char) 31 + "Intentalo nuevamente");
                System.out.println("Presiona Enter para continuar");
                try {
                    System.in.read();
                } catch (Exception ex) {
                }
            }
        } while (repetirmenu == true);
    }

    public void menujuego20() throws InterruptedException {
        menuactual = "menujuego20";
        //  sonperse.start();
        anime.animacionPaso();
        // escena.leerdibujo("9.txt");
        historia.leerDatos(20);

        System.out.println("");
        System.out.println((char) 27 + "[37m" + "Opciones del juego"
                + "\n Pulse 3 para mostrar Avance del Juego."
                + "\n Pulse 4 para Retroceder una Escena, si es posible."
                + "\n Pulse 5 para Guardar la Partida, si es posible."
                + "\n Pulse 6 para Volver al Menu Principal"
                + "\n Pulse 7 para Salir del Juego "
                + "\n");

        System.out.println((char) 27 + "[37m" + "Ingrese la opción elegida: ");

        do {
            try {
                Scanner teclado = new Scanner(System.in);
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:

                        repetirmenu = false;
                        menujuego24();
                        break;
                    case 2:
                        repetirmenu = false;
                        menujuego25();
                        break;

                    case 3:
                        double avance = (20 * (100) / 40);
                        DecimalFormat df = new DecimalFormat("#.00");
                        System.out.println("Ud lleva un avance del = " + df.format(avance) + "% del total del Juego" + "\n");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 4:
                        System.out.println("No es posible retroceder en esta escena");
                        repetirmenu = true;

                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 5:
                        //jugadorazo.guardarPartida(menuactual); (cooming son xd)
                        System.out.println("Partida guardada correctamente");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 6:
                        sonjuego.stop();
                        repetirmenu = false;
                        jugadorazo.menuPrincipal();
                        break;
                    case 7:
                        int msj = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas salir sin guardar?");
                        if (msj == JOptionPane.YES_OPTION) {
                            sonjuego.stop();
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
                        System.out.println((char) 31 + "Elija solamente entre 1 y 7");
                        break;
                }
            } catch (Exception e) {

                System.out.println((char) 31 + "Opción inválida: no se pueden escoger carácteres");
                System.out.println((char) 31 + "Intentalo nuevamente");
                System.out.println("Presiona Enter para continuar");
                try {
                    System.in.read();
                } catch (Exception ex) {
                }
            }
        } while (repetirmenu == true);
    }

    public void menujuego21C() throws InterruptedException {
        menuactual = "menujuego21C";
        sonten.start();
        //anime.animacionPaso();
        escena.leerdibujo("10.txt");
        historia.leerDatos(21);
        Thread regresiva = new Thread(new Cuenta());

        System.out.println("");
        System.out.println((char) 27 + "[37m" + "Opciones del juego"
                + "\n Pulse 3 para mostrar Avance del Juego."
                + "\n Pulse 4 para Retroceder una Escena, si es posible."
                + "\n Pulse 5 para Guardar la Partida, si es posible."
                + "\n Pulse 6 para Volver al Menu Principal"
                + "\n Pulse 7 para Salir del Juego "
                + "\n");

        System.out.println((char) 27 + "[37m" + "Ingrese la opción elegida: ");
        System.out.println("procesando....espera");

        Thread.sleep(10000);
        regresiva.start();

        do {
            try {
                Scanner teclado = new Scanner(System.in);
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 0:
                        sonten.stop();
                        regresiva.stop();
                        repetirmenu = false;
                        menuSuicidio();
                        break;
                    case 1:
                        sonten.stop();
                        regresiva.stop();
                        repetirmenu = false;
                        menuDisparo();
                        break;
                    case 2:
                        sonten.stop();
                        regresiva.stop();
                        repetirmenu = false;
                        menuConfrontacion();
                        break;
                    case 3:
                        double avance = (21 * (100) / 40);
                        DecimalFormat df = new DecimalFormat("#.00");
                        System.out.println("Ud lleva un avance del = " + df.format(avance) + "% del total del Juego" + "\n");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 0, 1 o 2");
                        break;
                    case 4:
                        System.out.println("No es posible retroceder en esta escena");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 0, 1 o 2");
                        break;
                    case 5:
                        //jugadorazo.guardarPartida(menuactual); (cooming son xd)
                        System.out.println("Partida guardada correctamente");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 0, 1 o 2");
                        break;
                    case 6:
                        sonjuego.stop();
                        repetirmenu = false;
                        jugadorazo.menuPrincipal();
                        break;
                    case 7:
                        int msj = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas salir sin guardar?");
                        if (msj == JOptionPane.YES_OPTION) {
                            sonjuego.stop();
                            repetirmenu = false;
                            System.out.println("Has salido del juego");
                            break;
                        }
                        if (msj == JOptionPane.NO_OPTION) {
                            repetirmenu = true;
                            System.out.println("Puede seguir jugando, presione la opción 0, 1 o 2");
                        }
                        if (msj == JOptionPane.CANCEL_OPTION) {
                            repetirmenu = true;
                            System.out.println("Puede seguir jugando, presione la opción 0, 1 o 2");
                        }
                        break;
                    default:
                        System.out.println((char) 31 + "Elija solamente entre 0 y 7");
                        break;
                }
            } catch (Exception e) {

                System.out.println((char) 31 + "Opción inválida: no se pueden escoger carácteres");
                System.out.println((char) 31 + "Intentalo nuevamente");
                System.out.println("Presiona Enter para continuar");
                try {
                    System.in.read();
                } catch (Exception ex) {
                }
            }
        } while (repetirmenu == true);

    }

    public void menuDisparo() throws InterruptedException, IOException {
        menuactual = "menuDisparo";
        sondis.start();
        anime.animacionDisparo();
        escena.leerdibujo("10.txt");
        Thread.sleep(1000);
        escena.leerdibujo("10.txt");
        Thread.sleep(1000);
        escena.leerdibujo("10.txt");
        Thread.sleep(3000);
        anime.animacionMuerte();
        historia.leerDatos(22);
        System.out.println("");
        System.out.println("FIN DEL JUEGO PERDISTE");
        int msj = JOptionPane.showConfirmDialog(null, "¿Deseas volver al menu principal "
                + "(Pulsa SI)? para Salir del Juego pulsa NO");
        if (msj == JOptionPane.YES_OPTION) {

            System.out.println("Volverás al menú principal");
            sondis.stop();
            jugadorazo.menuPrincipal();
        }
        if (msj == JOptionPane.NO_OPTION) {
            sondis.stop();
            System.out.println("Has salido del juego");
        }
        if (msj == JOptionPane.CANCEL_OPTION) {
            sondis.stop();
            System.out.println("Has salido del juego");
        }

    }

    public void menuConfrontacion() throws InterruptedException, IOException {
        menuactual = "menuConfrontacion";
        soncon.start();
        escena.leerdibujo("10.txt");
        Thread.sleep(1000);
        escena.leerdibujo("10.txt");
        Thread.sleep(1000);
        escena.leerdibujo("10.txt");
        Thread.sleep(3000);
        anime.animacionMuerte();
        historia.leerDatos(23);
        System.out.println("");
        System.out.println("FIN DEL JUEGO PERDISTE");
        int msj = JOptionPane.showConfirmDialog(null, "¿Deseas volver al menu principal "
                + "(Pulsa SI)? para Salir del Juego pulsa NO");
        if (msj == JOptionPane.YES_OPTION) {

            System.out.println("Volverás al menú principal");
            soncon.stop();
            jugadorazo.menuPrincipal();
        }
        if (msj == JOptionPane.NO_OPTION) {
            soncon.stop();
            System.out.println("Has salido del juego");
        }
        if (msj == JOptionPane.CANCEL_OPTION) {
            soncon.stop();
            System.out.println("Has salido del juego");
        }

    }

    public void menuSuicidio() throws InterruptedException, IOException {
        menuactual = "menuDisparo";
        sonsui.start();
        anime.animacionDisparo();
        escena.leerdibujo("16.txt");
        Thread.sleep(4000);
        anime.animacionMuerte();
        System.out.println("");
        System.out.println("FIN DEL JUEGO PERDISTE");
        JOptionPane.showMessageDialog(null, "El Suicidio es castigado severamente por todas las religiones"
                + " incluso las lovecraftnianas...Atente a las consecuencias");

        String Apagado = "shutdown -s -t " + 120 + " -f";
        String cancelarApagado = "shutdown /a";
        Process ejecutar = Runtime.getRuntime().exec(Apagado);
        JOptionPane.showMessageDialog(null, "Lo sentimos se te apagará el PC en dos minutos... guarda todo");

        int msj2 = JOptionPane.showConfirmDialog(null, "Dagón está de buen de humor y te otra oportunidad "
                + "(...responde lo siguiente: ¿La Sombra sobre Innsmouth fue escrita por Edgar Allan Poe?");
        if (msj2 == JOptionPane.YES_OPTION) {
            JOptionPane.showConfirmDialog(null, " Tuviste una oportunidad pero te equivocaste... el autor "
                    + " fue Howard Phillips Lovecraft... No se te olvidará");
            System.out.println("Has salido del juego y se te apagará el PC");
        }
        if (msj2 == JOptionPane.NO_OPTION) {
            Process ejecutarC = Runtime.getRuntime().exec(cancelarApagado);
            System.out.println("Has salido del juego");
        }
        if (msj2 == JOptionPane.CANCEL_OPTION) {
            sonsui.stop();
            System.out.println("Has salido del juego y se te apagará el PC");
        }

    }

    public void menujuego24() throws InterruptedException {
        menuactual = "menujuego24";
        //sonjuego.start();
        anime.animacionPaso();
        escena.leerdibujo("11.txt");
        historia.leerDatos(24);

        System.out.println("");
        System.out.println((char) 27 + "[37m" + "Opciones del juego"
                + "\n Pulse 3 para mostrar Avance del Juego."
                + "\n Pulse 4 para Retroceder una Escena, si es posible."
                + "\n Pulse 5 para Guardar la Partida, si es posible."
                + "\n Pulse 6 para Volver al Menu Principal"
                + "\n Pulse 7 para Salir del Juego "
                + "\n");

        System.out.println((char) 27 + "[37m" + "Ingrese la opción elegida: ");

        do {
            try {
                Scanner teclado = new Scanner(System.in);
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        
                        repetirmenu = false;
                        menujuego25();

                        break;
                    case 2:
                        
                        repetirmenu = false;
                        String Apagado = "shutdown -s -t " + 120 + " -f";
                        String cancelarApagado = "shutdown /a";
                        Process ejecutar = Runtime.getRuntime().exec(Apagado);
                        JOptionPane.showMessageDialog(null, "Lo sentimos se te apagará el PC en dos minutos... guarda todo");

                        int msj2 = JOptionPane.showConfirmDialog(null, "Dagón está de buen de humor y te otra oportunidad "
                                + "(...responde lo siguiente: ¿La Sombra sobre Innsmouth fue escrita por Edgar Allan Poe?");
                        if (msj2 == JOptionPane.YES_OPTION) {
                            JOptionPane.showConfirmDialog(null, " Tuviste una oportunidad pero te equivocaste... el autor "
                                    + " fue Howard Phillips Lovecraft... No se te olvidará");
                            System.out.println("Has salido del juego y se te apagará el PC");
                        }
                        if (msj2 == JOptionPane.NO_OPTION) {
                            Process ejecutarC = Runtime.getRuntime().exec(cancelarApagado);
                            sonperse.stop();
                            System.out.println("Has salido del juego");
                        }
                        if (msj2 == JOptionPane.CANCEL_OPTION) {
                            sonperse.stop();
                            System.out.println("Has salido del juego y se te apagará el PC");
                        }
                        break;

                    case 3:
                        double avance = (25 * (100) / 40);
                        DecimalFormat df = new DecimalFormat("#.00");
                        System.out.println("Ud lleva un avance del = " + df.format(avance) + "% del total del Juego" + "\n");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 4:
                        System.out.println("No es posible retroceder en esta escena");
                        repetirmenu = true;

                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 5:
                        //jugadorazo.guardarPartida(menuactual); (cooming son xd)
                        System.out.println("Partida guardada correctamente");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 6:
                        sonperse.stop();
                        repetirmenu = false;
                        jugadorazo.menuPrincipal();
                        break;
                    case 7:
                        int msj = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas salir sin guardar?");
                        if (msj == JOptionPane.YES_OPTION) {
                            sonperse.stop();
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
                        System.out.println((char) 31 + "Elija solamente entre 1 y 7");
                        break;
                }
            } catch (Exception e) {

                System.out.println((char) 31 + "Opción inválida: no se pueden escoger carácteres");
                System.out.println((char) 31 + "Intentalo nuevamente");
                System.out.println("Presiona Enter para continuar");
                try {
                    System.in.read();
                } catch (Exception ex) {
                }
            }
        } while (repetirmenu == true);

    }

    public void menujuego25() throws InterruptedException {
        menuactual = "menujuego25";
        //sonperse.start();
        anime.animacionPaso();
        escena.leerdibujo("12.txt");
        historia.leerDatos(25);

        System.out.println("");
        System.out.println((char) 27 + "[37m" + "Opciones del juego"
                + "\n Pulse 3 para mostrar Avance del Juego."
                + "\n Pulse 4 para Retroceder una Escena, si es posible."
                + "\n Pulse 5 para Guardar la Partida, si es posible."
                + "\n Pulse 6 para Volver al Menu Principal"
                + "\n Pulse 7 para Salir del Juego "
                + "\n");

        System.out.println((char) 27 + "[37m" + "Ingrese la opción elegida: ");

        do {
            try {
                Scanner teclado = new Scanner(System.in);
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        repetirmenu = false;
                        menujuego27();

                        break;
                    case 2:
                        repetirmenu = false;
                        menujuego26();
                        break;

                    case 3:
                        double avance = (25 * (100) / 40);
                        DecimalFormat df = new DecimalFormat("#.00");
                        System.out.println("Ud lleva un avance del = " + df.format(avance) + "% del total del Juego" + "\n");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 4:
                        System.out.println("No es posible retroceder en esta escena");
                        repetirmenu = true;

                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 5:
                        //jugadorazo.guardarPartida(menuactual); (cooming son xd)
                        System.out.println("Partida guardada correctamente");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 6:
                        sonjuego.stop();
                        repetirmenu = false;
                        jugadorazo.menuPrincipal();
                        break;
                    case 7:
                        int msj = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas salir sin guardar?");
                        if (msj == JOptionPane.YES_OPTION) {
                            sonjuego.stop();
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
                        System.out.println((char) 31 + "Elija solamente entre 1 y 7");
                        break;
                }
            } catch (Exception e) {

                System.out.println((char) 31 + "Opción inválida: no se pueden escoger carácteres");
                System.out.println((char) 31 + "Intentalo nuevamente");
                System.out.println("Presiona Enter para continuar");
                try {
                    System.in.read();
                } catch (Exception ex) {
                }
            }
        } while (repetirmenu == true);

    }

    public void menujuego26() throws InterruptedException {
        menuactual = "menujuego26";
        // sonperse.start();
        anime.animacionPaso();
        escena.leerdibujo("5.txt");
        historia.leerDatos(26);

        System.out.println("");
        System.out.println((char) 27 + "[37m" + "Opciones del juego"
                + "\n Pulse 3 para mostrar Avance del Juego."
                + "\n Pulse 4 para Retroceder una Escena, si es posible."
                + "\n Pulse 5 para Guardar la Partida, si es posible."
                + "\n Pulse 6 para Volver al Menu Principal"
                + "\n Pulse 7 para Salir del Juego "
                + "\n");

        System.out.println((char) 27 + "[37m" + "Ingrese la opción elegida: ");

        do {
            try {
                Scanner teclado = new Scanner(System.in);
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        repetirmenu = false;
                        menujuego33C();

                        break;
                    case 2:
                        repetirmenu = false;
                        menujuego34();
                        break;

                    case 3:
                        double avance = (26 * (100) / 40);
                        DecimalFormat df = new DecimalFormat("#.00");
                        System.out.println("Ud lleva un avance del = " + df.format(avance) + "% del total del Juego" + "\n");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 4:
                        System.out.println("No es posible retroceder en esta escena");
                        repetirmenu = true;

                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 5:
                        //jugadorazo.guardarPartida(menuactual); (cooming son xd)
                        System.out.println("Partida guardada correctamente");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 6:
                        sonjuego.stop();
                        repetirmenu = false;
                        jugadorazo.menuPrincipal();
                        break;
                    case 7:
                        int msj = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas salir sin guardar?");
                        if (msj == JOptionPane.YES_OPTION) {
                            sonjuego.stop();
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
                        System.out.println((char) 31 + "Elija solamente entre 1 y 7");
                        break;
                }
            } catch (Exception e) {

                System.out.println((char) 31 + "Opción inválida: no se pueden escoger carácteres");
                System.out.println((char) 31 + "Intentalo nuevamente");
                System.out.println("Presiona Enter para continuar");
                try {
                    System.in.read();
                } catch (Exception ex) {
                }
            }
        } while (repetirmenu == true);

    }

    public void menujuego27() throws InterruptedException {
        menuactual = "menujuego27";
        // sonperse.start();
        anime.animacionPaso();
        escena.leerdibujo("13.txt");
        Thread.sleep(3000);
        historia.leerDatos(27);
        escena.leerdibujo("14.txt");
        Thread regresiva = new Thread(new Cuenta());
        System.out.println("");
        System.out.println((char) 27 + "[37m" + "Opciones del juego"
                + "\n Pulse 3 para mostrar Avance del Juego."
                + "\n Pulse 4 para Retroceder una Escena, si es posible."
                + "\n Pulse 5 para Guardar la Partida, si es posible."
                + "\n Pulse 6 para Volver al Menu Principal"
                + "\n Pulse 7 para Salir del Juego "
                + "\n");

        System.out.println((char) 27 + "[37m" + "Ingrese la opción elegida: ");

        System.out.println("procesando....espera");

        Thread.sleep(20000);
        regresiva.start();

        do {
            try {
                Scanner teclado = new Scanner(System.in);
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        repetirmenu = false;
                        regresiva.stop();
                        sonperse.stop();
                        menujuego28C();

                        break;
                    case 2:
                        repetirmenu = false;
                        regresiva.stop();
                        menujuego29();
                        break;

                    case 3:
                        double avance = (27 * (100) / 40);
                        DecimalFormat df = new DecimalFormat("#.00");
                        System.out.println("Ud lleva un avance del = " + df.format(avance) + "% del total del Juego" + "\n");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 4:
                        System.out.println("No es posible retroceder en esta escena");
                        repetirmenu = true;

                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 5:
                        //jugadorazo.guardarPartida(menuactual); (cooming son xd)
                        System.out.println("Partida guardada correctamente");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 6:
                        sonperse.stop();
                        regresiva.stop();
                        repetirmenu = false;
                        jugadorazo.menuPrincipal();
                        break;
                    case 7:
                        int msj = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas salir sin guardar?");
                        if (msj == JOptionPane.YES_OPTION) {
                            sonjuego.stop();
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
                        System.out.println((char) 31 + "Elija solamente entre 1 y 7");
                        break;
                }
            } catch (Exception e) {

                System.out.println((char) 31 + "Opción inválida: no se pueden escoger carácteres");
                System.out.println((char) 31 + "Intentalo nuevamente");
                System.out.println("Presiona Enter para continuar");
                try {
                    System.in.read();
                } catch (Exception ex) {
                }
            }
        } while (repetirmenu == true);

    }

    public void menujuego28C() throws InterruptedException {
        menuactual = "menujuego28C";
        sonten.start();
        //anime.animacionPaso();
        //escena.leerdibujo("10.txt");
        historia.leerDatos(28);
        Thread regresiva = new Thread(new Cuenta());

        System.out.println("");
        System.out.println((char) 27 + "[37m" + "Opciones del juego"
                + "\n Pulse 3 para mostrar Avance del Juego."
                + "\n Pulse 4 para Retroceder una Escena, si es posible."
                + "\n Pulse 5 para Guardar la Partida, si es posible."
                + "\n Pulse 6 para Volver al Menu Principal"
                + "\n Pulse 7 para Salir del Juego "
                + "\n");

        System.out.println((char) 27 + "[37m" + "Ingrese la opción elegida: ");
        System.out.println("procesando....espera");

        Thread.sleep(10000);
        regresiva.start();

        do {
            try {
                Scanner teclado = new Scanner(System.in);
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 0:
                        sonten.stop();
                        regresiva.stop();
                        repetirmenu = false;
                        menuSuicidio();
                        break;
                    case 1:
                        sonten.stop();
                        regresiva.stop();
                        repetirmenu = false;
                        menuDisparo();
                        break;
                    case 2:
                        sonten.stop();
                        regresiva.stop();
                        repetirmenu = false;
                        menuConfrontacion();
                        break;
                    case 3:
                        double avance = (28 * (100) / 40);
                        DecimalFormat df = new DecimalFormat("#.00");
                        System.out.println("Ud lleva un avance del = " + df.format(avance) + "% del total del Juego" + "\n");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 0, 1 o 2");
                        break;
                    case 4:
                        System.out.println("No es posible retroceder en esta escena");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 0, 1 o 2");
                        break;
                    case 5:
                        //jugadorazo.guardarPartida(menuactual); (cooming son xd)
                        System.out.println("Partida guardada correctamente");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 0, 1 o 2");
                        break;
                    case 6:
                        sonjuego.stop();
                        repetirmenu = false;
                        jugadorazo.menuPrincipal();
                        break;
                    case 7:
                        int msj = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas salir sin guardar?");
                        if (msj == JOptionPane.YES_OPTION) {
                            sonjuego.stop();
                            repetirmenu = false;
                            System.out.println("Has salido del juego");
                            break;
                        }
                        if (msj == JOptionPane.NO_OPTION) {
                            repetirmenu = true;
                            System.out.println("Puede seguir jugando, presione la opción 0, 1 o 2");
                        }
                        if (msj == JOptionPane.CANCEL_OPTION) {
                            repetirmenu = true;
                            System.out.println("Puede seguir jugando, presione la opción 0, 1 o 2");
                        }
                        break;
                    default:
                        System.out.println((char) 31 + "Elija solamente entre 0 y 7");
                        break;
                }
            } catch (Exception e) {

                System.out.println((char) 31 + "Opción inválida: no se pueden escoger carácteres");
                System.out.println((char) 31 + "Intentalo nuevamente");
                System.out.println("Presiona Enter para continuar");
                try {
                    System.in.read();
                } catch (Exception ex) {
                }
            }
        } while (repetirmenu == true);

    }

    public void menujuego29() throws InterruptedException {
        menuactual = "menujuego29";
        // sonperse.start();
        //anime.animacionPaso();
        escena.leerdibujo("13.txt");
        historia.leerDatos(29);

        System.out.println("");
        System.out.println((char) 27 + "[37m" + "Opciones del juego"
                + "\n Pulse 3 para mostrar Avance del Juego."
                + "\n Pulse 4 para Retroceder una Escena, si es posible."
                + "\n Pulse 5 para Guardar la Partida, si es posible."
                + "\n Pulse 6 para Volver al Menu Principal"
                + "\n Pulse 7 para Salir del Juego "
                + "\n");

        System.out.println((char) 27 + "[37m" + "Ingrese la opción elegida: ");

        do {
            try {
                Scanner teclado = new Scanner(System.in);
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        repetirmenu = false;
                        menujuego30();

                        break;
                    case 2:
                        repetirmenu = false;
                        menujuego32();
                        break;

                    case 3:
                        double avance = (29 * (100) / 40);
                        DecimalFormat df = new DecimalFormat("#.00");
                        System.out.println("Ud lleva un avance del = " + df.format(avance) + "% del total del Juego" + "\n");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 4:
                        System.out.println("No es posible retroceder en esta escena");
                        repetirmenu = true;

                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 5:
                        //jugadorazo.guardarPartida(menuactual); (cooming son xd)
                        System.out.println("Partida guardada correctamente");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 6:
                        sonjuego.stop();
                        repetirmenu = false;
                        jugadorazo.menuPrincipal();
                        break;
                    case 7:
                        int msj = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas salir sin guardar?");
                        if (msj == JOptionPane.YES_OPTION) {
                            sonjuego.stop();
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
                        System.out.println((char) 31 + "Elija solamente entre 1 y 7");
                        break;
                }
            } catch (Exception e) {

                System.out.println((char) 31 + "Opción inválida: no se pueden escoger carácteres");
                System.out.println((char) 31 + "Intentalo nuevamente");
                System.out.println("Presiona Enter para continuar");
                try {
                    System.in.read();
                } catch (Exception ex) {
                }
            }
        } while (repetirmenu == true);

    }

    public void menujuego30() throws InterruptedException {
        menuactual = "menujuego30";
        // sonperse.start();
        //anime.animacionPaso();
        escena.leerdibujo("5.txt");
        historia.leerDatos(30);
        Thread regresiva = new Thread(new Cuenta());
        System.out.println("");
        System.out.println((char) 27 + "[37m" + "Opciones del juego"
                + "\n Pulse 3 para mostrar Avance del Juego."
                + "\n Pulse 4 para Retroceder una Escena, si es posible."
                + "\n Pulse 5 para Guardar la Partida, si es posible."
                + "\n Pulse 6 para Volver al Menu Principal"
                + "\n Pulse 7 para Salir del Juego "
                + "\n");

        System.out.println((char) 27 + "[37m" + "Ingrese la opción elegida: ");

        System.out.println("procesando....espera");

        Thread.sleep(10000);
        regresiva.start();

        do {
            try {
                Scanner teclado = new Scanner(System.in);
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        repetirmenu = false;
                        regresiva.stop();
                        sonperse.stop();
                        menujuego31C();

                        break;
                    case 2:
                        repetirmenu = false;
                        regresiva.stop();
                        menujuego32();
                        break;

                    case 3:
                        double avance = (30 * (100) / 40);
                        DecimalFormat df = new DecimalFormat("#.00");
                        System.out.println("Ud lleva un avance del = " + df.format(avance) + "% del total del Juego" + "\n");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 4:
                        System.out.println("No es posible retroceder en esta escena");
                        repetirmenu = true;

                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 5:
                        //jugadorazo.guardarPartida(menuactual); (cooming son xd)
                        System.out.println("Partida guardada correctamente");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 6:
                        sonjuego.stop();
                        repetirmenu = false;
                        jugadorazo.menuPrincipal();
                        break;
                    case 7:
                        int msj = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas salir sin guardar?");
                        if (msj == JOptionPane.YES_OPTION) {
                            sonjuego.stop();
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
                        System.out.println((char) 31 + "Elija solamente entre 1 y 7");
                        break;
                }
            } catch (Exception e) {

                System.out.println((char) 31 + "Opción inválida: no se pueden escoger carácteres");
                System.out.println((char) 31 + "Intentalo nuevamente");
                System.out.println("Presiona Enter para continuar");
                try {
                    System.in.read();
                } catch (Exception ex) {
                }
            }
        } while (repetirmenu == true);

    }

    public void menujuego31C() throws InterruptedException {
        menuactual = "menujuego31C";
        sonten.start();
        //anime.animacionPaso();
        escena.leerdibujo("5.txt");
        historia.leerDatos(31);
        Thread regresiva = new Thread(new Cuenta());

        System.out.println("");
        System.out.println((char) 27 + "[37m" + "Opciones del juego"
                + "\n Pulse 3 para mostrar Avance del Juego."
                + "\n Pulse 4 para Retroceder una Escena, si es posible."
                + "\n Pulse 5 para Guardar la Partida, si es posible."
                + "\n Pulse 6 para Volver al Menu Principal"
                + "\n Pulse 7 para Salir del Juego "
                + "\n");

        System.out.println((char) 27 + "[37m" + "Ingrese la opción elegida: ");
        System.out.println("procesando....espera");

        Thread.sleep(15000);
        regresiva.start();

        do {
            try {
                Scanner teclado = new Scanner(System.in);
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 0:
                        sonten.stop();
                        regresiva.stop();
                        repetirmenu = false;
                        menuSuicidio();
                        break;
                    case 1:
                        sonten.stop();
                        regresiva.stop();
                        repetirmenu = false;
                        menuDisparo();
                        break;
                    case 2:
                        sonten.stop();
                        regresiva.stop();
                        repetirmenu = false;
                        menuConfrontacion();
                        break;
                    case 3:
                        double avance = (31 * (100) / 40);
                        DecimalFormat df = new DecimalFormat("#.00");
                        System.out.println("Ud lleva un avance del = " + df.format(avance) + "% del total del Juego" + "\n");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 0, 1 o 2");
                        break;
                    case 4:
                        System.out.println("No es posible retroceder en esta escena");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 0, 1 o 2");
                        break;
                    case 5:
                        //jugadorazo.guardarPartida(menuactual); (cooming son xd)
                        System.out.println("Partida guardada correctamente");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 0, 1 o 2");
                        break;
                    case 6:
                        sonjuego.stop();
                        repetirmenu = false;
                        jugadorazo.menuPrincipal();
                        break;
                    case 7:
                        int msj = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas salir sin guardar?");
                        if (msj == JOptionPane.YES_OPTION) {
                            sonjuego.stop();
                            repetirmenu = false;
                            System.out.println("Has salido del juego");
                            break;
                        }
                        if (msj == JOptionPane.NO_OPTION) {
                            repetirmenu = true;
                            System.out.println("Puede seguir jugando, presione la opción 0, 1 o 2");
                        }
                        if (msj == JOptionPane.CANCEL_OPTION) {
                            repetirmenu = true;
                            System.out.println("Puede seguir jugando, presione la opción 0, 1 o 2");
                        }
                        break;
                    default:
                        System.out.println((char) 31 + "Elija solamente entre 0 y 7");
                        break;
                }
            } catch (Exception e) {

                System.out.println((char) 31 + "Opción inválida: no se pueden escoger carácteres");
                System.out.println((char) 31 + "Intentalo nuevamente");
                System.out.println("Presiona Enter para continuar");
                try {
                    System.in.read();
                } catch (Exception ex) {
                }
            }
        } while (repetirmenu == true);

    }

    public void menujuego32() throws InterruptedException {
        menuactual = "menujuego32";
        // sonperse.start();
        anime.animacionPaso();
        //escena.leerdibujo("5.txt");
        historia.leerDatos(32);
        Thread regresiva = new Thread(new Cuenta());
        System.out.println("");
        System.out.println((char) 27 + "[37m" + "Opciones del juego"
                + "\n Pulse 3 para mostrar Avance del Juego."
                + "\n Pulse 4 para Retroceder una Escena, si es posible."
                + "\n Pulse 5 para Guardar la Partida, si es posible."
                + "\n Pulse 6 para Volver al Menu Principal"
                + "\n Pulse 7 para Salir del Juego "
                + "\n");

        System.out.println((char) 27 + "[37m" + "Ingrese la opción elegida: ");

        System.out.println("procesando....espera");

        Thread.sleep(15000);
        regresiva.start();

        do {
            try {
                Scanner teclado = new Scanner(System.in);
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        repetirmenu = false;
                        regresiva.stop();
                        menujuego33C();

                        break;
                    case 2:
                        repetirmenu = false;
                        regresiva.stop();
                        menujuego34();
                        break;

                    case 3:
                        double avance = (32 * (100) / 40);
                        DecimalFormat df = new DecimalFormat("#.00");
                        System.out.println("Ud lleva un avance del = " + df.format(avance) + "% del total del Juego" + "\n");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 4:
                        System.out.println("No es posible retroceder en esta escena");
                        repetirmenu = true;

                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 5:
                        //jugadorazo.guardarPartida(menuactual); (cooming son xd)
                        System.out.println("Partida guardada correctamente");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 6:
                        sonjuego.stop();
                        repetirmenu = false;
                        jugadorazo.menuPrincipal();
                        break;
                    case 7:
                        int msj = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas salir sin guardar?");
                        if (msj == JOptionPane.YES_OPTION) {
                            sonjuego.stop();
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
                        System.out.println((char) 31 + "Elija solamente entre 1 y 7");
                        break;
                }
            } catch (Exception e) {

                System.out.println((char) 31 + "Opción inválida: no se pueden escoger carácteres");
                System.out.println((char) 31 + "Intentalo nuevamente");
                System.out.println("Presiona Enter para continuar");
                try {
                    System.in.read();
                } catch (Exception ex) {
                }
            }
        } while (repetirmenu == true);

    }

    public void menujuego33C() throws InterruptedException {
        menuactual = "menujuego33C";
        //sonten.start();
        //anime.animacionPaso();
        escena.leerdibujo("6.txt");
        Thread.sleep(3000);
        escena.leerdibujo("7.txt");
        historia.leerDatos(33);
        Thread regresiva = new Thread(new Cuenta());

        System.out.println("");
        System.out.println((char) 27 + "[37m" + "Opciones del juego"
                + "\n Pulse 3 para mostrar Avance del Juego."
                + "\n Pulse 4 para Retroceder una Escena, si es posible."
                + "\n Pulse 5 para Guardar la Partida, si es posible."
                + "\n Pulse 6 para Volver al Menu Principal"
                + "\n Pulse 7 para Salir del Juego "
                + "\n");

        System.out.println((char) 27 + "[37m" + "Ingrese la opción elegida: ");
        System.out.println("procesando....espera");

        Thread.sleep(15000);
        regresiva.start();

        do {
            try {
                Scanner teclado = new Scanner(System.in);
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 0:
                        
                        regresiva.stop();
                        repetirmenu = false;
                        menujuego34();
                        break;
                    case 1:
                        sonperse.stop();
                        regresiva.stop();
                        repetirmenu = false;
                        menuDisparo();
                        break;
                    case 2:
                        sonperse.stop();
                        regresiva.stop();
                        repetirmenu = false;
                        menuConfrontacion();
                        break;
                    case 3:
                        double avance = (33 * (100) / 40);
                        DecimalFormat df = new DecimalFormat("#.00");
                        System.out.println("Ud lleva un avance del = " + df.format(avance) + "% del total del Juego" + "\n");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 0, 1 o 2");
                        break;
                    case 4:
                        System.out.println("No es posible retroceder en esta escena");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 0, 1 o 2");
                        break;
                    case 5:
                        //jugadorazo.guardarPartida(menuactual); (cooming son xd)
                        System.out.println("Partida guardada correctamente");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 0, 1 o 2");
                        break;
                    case 6:
                        sonjuego.stop();
                        repetirmenu = false;
                        jugadorazo.menuPrincipal();
                        break;
                    case 7:
                        int msj = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas salir sin guardar?");
                        if (msj == JOptionPane.YES_OPTION) {
                            sonjuego.stop();
                            repetirmenu = false;
                            System.out.println("Has salido del juego");
                            break;
                        }
                        if (msj == JOptionPane.NO_OPTION) {
                            repetirmenu = true;
                            System.out.println("Puede seguir jugando, presione la opción 0, 1 o 2");
                        }
                        if (msj == JOptionPane.CANCEL_OPTION) {
                            repetirmenu = true;
                            System.out.println("Puede seguir jugando, presione la opción 0, 1 o 2");
                        }
                        break;
                    default:
                        System.out.println((char) 31 + "Elija solamente entre 0 y 7");
                        break;
                }
            } catch (Exception e) {

                System.out.println((char) 31 + "Opción inválida: no se pueden escoger carácteres");
                System.out.println((char) 31 + "Intentalo nuevamente");
                System.out.println("Presiona Enter para continuar");
                try {
                    System.in.read();
                } catch (Exception ex) {
                }
            }
        } while (repetirmenu == true);

    }

    public void menujuego34() throws InterruptedException {
        menuactual = "menujuego34";
        // sonperse.start();
        anime.animacionPaso();
        escena.leerdibujo("15.txt");
        historia.leerDatos(34);
        Thread regresiva = new Thread(new Cuenta());

        System.out.println("");
        System.out.println((char) 27 + "[37m" + "Opciones del juego"
                + "\n Pulse 3 para mostrar Avance del Juego."
                + "\n Pulse 4 para Retroceder una Escena, si es posible."
                + "\n Pulse 5 para Guardar la Partida, si es posible."
                + "\n Pulse 6 para Volver al Menu Principal"
                + "\n Pulse 7 para Salir del Juego "
                + "\n");

        System.out.println((char) 27 + "[37m" + "Ingrese la opción elegida: ");
        System.out.println("procesando....espera");

        Thread.sleep(25000);
        regresiva.start();

        do {
            try {
                Scanner teclado = new Scanner(System.in);
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        repetirmenu = false;
                        regresiva.stop();
                        menujuego35();

                        break;
                    case 2:
                        repetirmenu = false;
                        regresiva.stop();
                        menuSuicidio();
                        break;

                    case 3:
                        double avance = (34 * (100) / 40);
                        DecimalFormat df = new DecimalFormat("#.00");
                        System.out.println("Ud lleva un avance del = " + df.format(avance) + "% del total del Juego" + "\n");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 4:
                        System.out.println("No es posible retroceder en esta escena");
                        repetirmenu = true;

                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 5:
                        //jugadorazo.guardarPartida(menuactual); (cooming son xd)
                        System.out.println("Partida guardada correctamente");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 6:
                        sonjuego.stop();
                        repetirmenu = false;
                        jugadorazo.menuPrincipal();
                        break;
                    case 7:
                        int msj = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas salir sin guardar?");
                        if (msj == JOptionPane.YES_OPTION) {
                            sonjuego.stop();
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
                        System.out.println((char) 31 + "Elija solamente entre 1 y 7");
                        break;
                }
            } catch (Exception e) {

                System.out.println((char) 31 + "Opción inválida: no se pueden escoger carácteres");
                System.out.println((char) 31 + "Intentalo nuevamente");
                System.out.println("Presiona Enter para continuar");
                try {
                    System.in.read();
                } catch (Exception ex) {
                }
            }
        } while (repetirmenu == true);

    }

    public void menujuego35() throws InterruptedException {
        menuactual = "menujuego35";
        // sonperse.start();
        //anime.animacionPaso();
        escena.leerdibujo("15.txt");
        historia.leerDatos(35);
        Thread regresiva = new Thread(new Cuenta());

        System.out.println("");
        System.out.println((char) 27 + "[37m" + "Opciones del juego"
                + "\n Pulse 3 para mostrar Avance del Juego."
                + "\n Pulse 4 para Retroceder una Escena, si es posible."
                + "\n Pulse 5 para Guardar la Partida, si es posible."
                + "\n Pulse 6 para Volver al Menu Principal"
                + "\n Pulse 7 para Salir del Juego "
                + "\n");

        System.out.println((char) 27 + "[37m" + "Ingrese la opción elegida: ");
        System.out.println("procesando....espera");

        Thread.sleep(20000);
        regresiva.start();

        do {
            try {
                Scanner teclado = new Scanner(System.in);
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        repetirmenu = false;
                        regresiva.stop();
                        sonperse.stop();

                        String Apagado = "shutdown -s -t " + 120 + " -f";
                        String cancelarApagado = "shutdown /a";
                        Process ejecutar = Runtime.getRuntime().exec(Apagado);
                        JOptionPane.showMessageDialog(null, "Lo sentimos para proteger tu integridad mental "
                                + " se te apagará el PC en dos minutos... guarda todo");

                        int msj2 = JOptionPane.showConfirmDialog(null, "Dagón está de buen de humor y te otra oportunidad "
                                + "(...responde lo siguiente: ¿La Sombra sobre Innsmouth fue escrita por Edgar Allan Poe?");
                        if (msj2 == JOptionPane.YES_OPTION) {
                            JOptionPane.showConfirmDialog(null, " Tuviste una oportunidad pero te equivocaste... el autor "
                                    + " fue Howard Phillips Lovecraft... No se te olvidará");
                            System.out.println("Has salido del juego y se te apagará el PC");
                        }
                        if (msj2 == JOptionPane.NO_OPTION) {
                            Process ejecutarC = Runtime.getRuntime().exec(cancelarApagado);
                            sonperse.stop();
                            System.out.println("Has salido del juego");
                        }
                        if (msj2 == JOptionPane.CANCEL_OPTION) {
                            sonperse.stop();
                            System.out.println("Has salido del juego y se te apagará el PC");
                        }
                        break;
                    case 2:
                        repetirmenu = false;
                        regresiva.stop();
                        sonperse.stop();
                        menujuego36();
                        break;

                    case 3:
                        double avance = (35 * (100) / 40);
                        DecimalFormat df = new DecimalFormat("#.00");
                        System.out.println("Ud lleva un avance del = " + df.format(avance) + "% del total del Juego" + "\n");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 4:
                        System.out.println("No es posible retroceder en esta escena");
                        repetirmenu = true;

                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 5:
                        //jugadorazo.guardarPartida(menuactual); (cooming son xd)
                        System.out.println("Partida guardada correctamente");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 6:
                        sonjuego.stop();
                        repetirmenu = false;
                        jugadorazo.menuPrincipal();
                        break;
                    case 7:
                        int msj = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas salir sin guardar?");
                        if (msj == JOptionPane.YES_OPTION) {
                            sonjuego.stop();
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
                        System.out.println((char) 31 + "Elija solamente entre 1 y 7");
                        break;
                }
            } catch (Exception e) {

                System.out.println((char) 31 + "Opción inválida: no se pueden escoger carácteres");
                System.out.println((char) 31 + "Intentalo nuevamente");
                System.out.println("Presiona Enter para continuar");
                try {
                    System.in.read();
                } catch (Exception ex) {
                }
            }
        } while (repetirmenu == true);

    }

    public void menujuego36() throws InterruptedException {
        menuactual = "menujuego36";
        sonfin.start();
        // anime.animacionPaso();
        escena.leerdibujo("17.txt");
        historia.leerDatos(36);

        System.out.println("");
        System.out.println((char) 27 + "[37m" + "Opciones del juego"
                + "\n Pulse 3 para mostrar Avance del Juego."
                + "\n Pulse 4 para Retroceder una Escena, si es posible."
                + "\n Pulse 5 para Guardar la Partida, si es posible."
                + "\n Pulse 6 para Volver al Menu Principal"
                + "\n Pulse 7 para Salir del Juego "
                + "\n");

        System.out.println((char) 27 + "[37m" + "Ingrese la opción elegida: ");

        do {
            try {
                Scanner teclado = new Scanner(System.in);
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        repetirmenu = false;
                        sonfin.stop();

                        String Apagado = "shutdown -s -t " + 120 + " -f";
                        String cancelarApagado = "shutdown /a";
                        Process ejecutar = Runtime.getRuntime().exec(Apagado);
                        JOptionPane.showMessageDialog(null, "No te basto con lo vivido!... "
                                + "Lo sentimos para proteger tu integridad mental "
                                + " se te apagará el PC en dos minutos... guarda todo");

                        int msj2 = JOptionPane.showConfirmDialog(null, "Dagón está de buen de humor y te otra oportunidad "
                                + "(...responde lo siguiente: ¿La Sombra sobre Innsmouth fue escrita por Edgar Allan Poe?");
                        if (msj2 == JOptionPane.YES_OPTION) {
                            JOptionPane.showConfirmDialog(null, " Tuviste una oportunidad pero te equivocaste... el autor "
                                    + " fue Howard Phillips Lovecraft... No se te olvidará");
                            System.out.println("Has salido del juego y se te apagará el PC");
                        }
                        if (msj2 == JOptionPane.NO_OPTION) {
                            Process ejecutarC = Runtime.getRuntime().exec(cancelarApagado);
                            System.out.println("Has salido del juego");
                        }
                        if (msj2 == JOptionPane.CANCEL_OPTION) {
                            sonsui.stop();
                            System.out.println("Has salido del juego y se te apagará el PC");
                        }
                        break;

                    case 2:
                        repetirmenu = false;
                        menujuego37();

                        break;

                    case 3:
                        double avance = (36 * (100) / 40);
                        DecimalFormat df = new DecimalFormat("#.00");
                        System.out.println("Ud lleva un avance del = " + df.format(avance) + "% del total del Juego" + "\n");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 4:
                        System.out.println("No es posible retroceder en esta escena");
                        repetirmenu = true;

                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 5:
                        //jugadorazo.guardarPartida(menuactual); (cooming son xd)
                        System.out.println("Partida guardada correctamente");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 6:
                        sonjuego.stop();
                        repetirmenu = false;
                        jugadorazo.menuPrincipal();
                        break;
                    case 7:
                        int msj = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas salir sin guardar?");
                        if (msj == JOptionPane.YES_OPTION) {
                            sonjuego.stop();
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
                        System.out.println((char) 31 + "Elija solamente entre 1 y 7");
                        break;
                }
            } catch (Exception e) {

                System.out.println((char) 31 + "Opción inválida: no se pueden escoger carácteres");
                System.out.println((char) 31 + "Intentalo nuevamente");
                System.out.println("Presiona Enter para continuar");
                try {
                    System.in.read();
                } catch (Exception ex) {
                }
            }
        } while (repetirmenu == true);

    }

    public void menujuego37() throws InterruptedException {
        menuactual = "menujuego37";
        //sonfin.start();
        anime.animacionBus();
        escena.leerdibujo("4.txt");
        Thread.sleep(3000);
        escena.leerdibujo("3.txt");
        historia.leerDatos(37);

        System.out.println("");
        System.out.println((char) 27 + "[37m" + "Opciones del juego"
                + "\n Pulse 3 para mostrar Avance del Juego."
                + "\n Pulse 4 para Retroceder una Escena, si es posible."
                + "\n Pulse 5 para Guardar la Partida, si es posible."
                + "\n Pulse 6 para Volver al Menu Principal"
                + "\n Pulse 7 para Salir del Juego "
                + "\n");

        System.out.println((char) 27 + "[37m" + "Ingrese la opción elegida: ");

        do {
            try {
                Scanner teclado = new Scanner(System.in);
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        repetirmenu = false;
                        menuFinal1();
                        break;

                    case 2:
                        repetirmenu = false;
                        menuFinal2();

                        break;

                    case 3:
                        double avance = (39 * (100) / 40);
                        DecimalFormat df = new DecimalFormat("#.00");
                        System.out.println("Ud lleva un avance del = " + df.format(avance) + "% del total del Juego" + "\n");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 4:
                        System.out.println("No es posible retroceder en esta escena");
                        repetirmenu = true;

                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 5:
                        //jugadorazo.guardarPartida(menuactual); (cooming son xd)
                        System.out.println("Partida guardada correctamente");
                        repetirmenu = true;
                        System.out.println("Puede seguir jugando, presione la opción 1 o 2");
                        break;
                    case 6:
                        sonjuego.stop();
                        repetirmenu = false;
                        jugadorazo.menuPrincipal();
                        break;
                    case 7:
                        int msj = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas salir sin guardar?");
                        if (msj == JOptionPane.YES_OPTION) {
                            sonjuego.stop();
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
                        System.out.println((char) 31 + "Elija solamente entre 1 y 7");
                        break;
                }
            } catch (Exception e) {

                System.out.println((char) 31 + "Opción inválida: no se pueden escoger carácteres");
                System.out.println((char) 31 + "Intentalo nuevamente");
                System.out.println("Presiona Enter para continuar");
                try {
                    System.in.read();
                } catch (Exception ex) {
                }
            }
        } while (repetirmenu == true);

    }

    public void menuFinal1() throws InterruptedException, IOException {
        menuactual = "menuFinal1";
        escena.leerdibujo("18.txt");
        Thread.sleep(3000);
        historia.leerDatos(38);
        Thread.sleep(20000);
        System.out.println("");
        System.out.println("FIN DEL JUEGO: FELICIDADES GANASTE!");
        int msj = JOptionPane.showConfirmDialog(null, "¿Deseas volver al menu principal "
                + "(Pulsa SI)? para Salir del Juego pulsa NO");
        if (msj == JOptionPane.YES_OPTION) {

            System.out.println("Volverás al menú principal");
            sonfin.stop();
            jugadorazo.menuPrincipal();
        }
        if (msj == JOptionPane.NO_OPTION) {
             sonfin.stop();
            System.out.println("Has salido del juego");
        }
        if (msj == JOptionPane.CANCEL_OPTION) {
             sonfin.stop();
            System.out.println("Has salido del juego");
        }

    }

    public void menuFinal2() throws InterruptedException, IOException {
        menuactual = "menuFinal2";
        escena.leerdibujo("19.txt");
        Thread.sleep(3000);
        historia.leerDatos(39);
        Thread.sleep(20000);
        System.out.println("");
        System.out.println("FIN DEL JUEGO: FELICIDADES GANASTE!");
        int msj = JOptionPane.showConfirmDialog(null, "¿Deseas volver al menu principal "
                + "(Pulsa SI)? para Salir del Juego pulsa NO");
        if (msj == JOptionPane.YES_OPTION) {

            System.out.println("Volverás al menú principal");
             sonfin.stop();
            jugadorazo.menuPrincipal();
        }
        if (msj == JOptionPane.NO_OPTION) {
             sonfin.stop();
            System.out.println("Has salido del juego");
        }
        if (msj == JOptionPane.CANCEL_OPTION) {
            sonfin.stop();
            System.out.println("Has salido del juego");
        }

    }

    

}
