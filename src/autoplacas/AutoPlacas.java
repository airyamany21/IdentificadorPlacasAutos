/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoplacas;

import static autoplacas.Usuario.listaUsuarios;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Airyamany21
 */
public class AutoPlacas {

    /**
     * @param args the command line arguments
     */
    //Colores
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    //Reset del color
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        String nombre = "";
        String password = "";
        String passwordIngresar = "";
        String rol = "";
        String permiso = "";
        String opcionOtroUsuario = "";
        String opcionOtraSimu = "";
        Usuario usuario = new Usuario(nombre, password, rol, permiso);
        String matricula = "";
        AnalizadorVideoPlacas analizadorVideoPlacas = new AnalizadorVideoPlacas(matricula);
        Scanner leerM1 = new Scanner(System.in);
        Scanner leerM2 = new Scanner(System.in);
        Scanner leerM3 = new Scanner(System.in);
        Scanner ingresar = new Scanner(System.in);
        Scanner posUsuario = new Scanner(System.in);
        Scanner pass = new Scanner(System.in);
        boolean salir = false;
        int opcionM1; //Guardaremos la opcion del usuario
        int opcionM2;
        int opcionM3;

        long TInicio, TFin, tiempo = 0; //Variables para determinar el tiempo de ejecución
        TInicio = System.currentTimeMillis(); //Tomamos la hora en que inicio el algoritmo y la almacenamos en la variable inicio

        while (!salir) {
//            System.out.println("***SISTEMA PARA IDENTIFICAR PLACAS DE AUTOS***");// Muestra en pantalla
            System.out.println("");
            System.out.println(ANSI_BLUE + "SISTEMA PARA IDENTIFICAR PLACAS DE AUTOS" + ANSI_RESET);
            System.out.println("1. Administrar usuarios");
            System.out.println("2. Ingresar al sistema");
            System.out.println("3. Salir");
            System.out.println("");
            try {
                opcionM1 = leerM1.nextInt();
                switch (opcionM1) {
                    case 1:
//                        System.out.println("***ADMINISTRACIÓN DE USUARIOS***");
                        System.out.println("");
                        System.out.println(ANSI_BLUE + "ADMINISTRACIÓN DE USUARIOS" + ANSI_RESET);
                        System.out.println("1. Ingresar usuarios");
                        System.out.println("2. Mostrar usuarios");
                        System.out.println("3. Eliminar usuario");
                        System.out.println("4. Modificar usuario");
                        System.out.println("5. Tiempo de usuario");
                        System.out.println("6. Regresar");
                        System.out.println("");
//                        try {
                        opcionM2 = leerM2.nextInt();
                        switch (opcionM2) {
                            case 1:
                                do {
                                    leerM2.nextLine();//Limpiar el buffer
                                    System.out.println("");
                                    System.out.print("Nombre de usuario: ");
                                    nombre = leerM2.nextLine();
                                    System.out.print("Password: ");
                                    password = leerM2.nextLine();
                                    System.out.print("Rol de usuario: ");
                                    rol = leerM2.nextLine();
                                    System.out.print("Permiso de usuario: ");
                                    permiso = leerM2.nextLine();
                                    usuario = new Usuario(nombre, password, rol, permiso);
                                    listaUsuarios.add(usuario);
                                    System.out.print("Deseas agregar otro usuario s/n: ");
                                    opcionOtroUsuario = leerM2.nextLine();
                                } while (opcionOtroUsuario.equals("s") || opcionOtroUsuario.equals("S"));
                                break;
                            case 2:
                                usuario.mostrarUsuarios(); // si existe usuarios los muestra
                                break;
                            case 3:
                                usuario.eliminarUsuario();// elimina si existe usuario por pos
                                break;
                            case 4:
                                usuario.modificarUsuario(); // modifica usuario por pos
                                break;
                            case 5:
                                System.out.println("Tiempo de ejecución en segundos: " + tiempo); //Mostramos en pantalla el tiempo de ejecución en milisegundos
                            case 6:
                                break; //va al menu principal
                            default:
                                System.err.println("«Solo números entre 1 y 5»");
                        }
//                        } catch (InputMismatchException e) {
//                            System.err.println("«Debes insertar un número»");
//                            leer2.next();
//                        }
                        break;
                    case 2:
                        int pos;
//                        if (listaUsuarios == null || listaUsuarios.isEmpty()) {
//                            System.err.println("LISTA DE USUARIOS: VACIA");
//                        } else {
                        System.out.println("");
                        System.out.println(ANSI_BLUE + "SYSTEMA IDENTIFICACIÓN DE PLACAS" + ANSI_RESET);
                        System.out.println("1. Ingresar");
//                        System.out.println("2. Ingresar como invitado");
                        System.out.println("2. Regresar");
                        System.out.println("");
                        opcionM3 = leerM3.nextInt();
//                            try {
                        switch (opcionM3) {
                            case 1:
                                if (listaUsuarios == null || listaUsuarios.isEmpty()) {
                                    System.err.println("LISTA DE USUARIOS: VACIA");
                                } else {
                                    usuario.mostrarUsuarios();
                                    System.out.println("");
                                    System.out.print("Posición usuario para ingresar: ");
                                    pos = ingresar.nextInt();
                                    System.out.println("");
                                    if (pos != -1 || pos != listaUsuarios.size()) {
                                        System.out.println("");
                                        System.out.print("Usuario: " + listaUsuarios.get(pos).getNombre() + " password: ");
                                        passwordIngresar = pass.nextLine();
                                        System.out.println("");
                                        if (listaUsuarios.get(pos).getPassword().equals(passwordIngresar)) {
                                            do {
                                                System.out.println("");
                                                analizadorVideoPlacas.iniciarSimulacion();
//                                                System.out.println("");
//                                                buscadorReporte.buscarReporteMatricula();
                                                System.out.println("");
                                                System.out.print("Iniciar otra simulación s/n: ");
                                                opcionOtraSimu = leerM2.nextLine();
                                            } while (opcionOtraSimu.equals("s") || opcionOtraSimu.equals("S"));
//                                            System.out.println(ANSI_GREEN + "Iniciando simulacion..." + ANSI_RESET);
                                        } else {
                                            System.out.println(ANSI_RED + "Password incorrecta: " + ANSI_RESET);
                                        }
                                    }
                                }
                                break;
                            case 2:
//                                System.out.println(ANSI_GREEN + "Iniciando simulacion..." + ANSI_RESET);
                                break;
//                            case 3:
//                                break; //va al menu anterior
                            default:
                                System.err.println("«Solo números 1 y 2»");
                        }
                        break;
                    case 3:
                        salir = true;
                        System.out.println("");
                        System.out.println(ANSI_PURPLE + "Hasta luego: " + ANSI_RESET);
                        System.out.println("");
                        break;
                    default:
                        System.err.println("«Solo números entre 1 y 3»");
                }
            } catch (InputMismatchException e) {
                System.err.println("«Debes insertar un número»");
                leerM1.next();
            }
            TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
            tiempo = (TFin - TInicio) / 1000; //Calculamos los milisegundos de diferencia

        }

    }

}
