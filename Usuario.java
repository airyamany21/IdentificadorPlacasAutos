/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoplacas;

import static autoplacas.AutoPlacas.ANSI_BLUE;
import static autoplacas.AutoPlacas.ANSI_GREEN;
import static autoplacas.AutoPlacas.ANSI_RED;
import static autoplacas.AutoPlacas.ANSI_RESET;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Airyamany21
 */
public class Usuario {

    //variables
    protected String nombre;
//    private String nombre;
    private String password;
    private String rol;
    private String permiso;
    //Se crea un ArrayList para guardar objetos de tipo Usuario.
    static ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
    //leer del teclado
    static Scanner nameNew = new Scanner(System.in);
    static Scanner passNew = new Scanner(System.in);
    static Scanner passAct = new Scanner(System.in);
    static Scanner newRol = new Scanner(System.in);
    static Scanner newPermiso = new Scanner(System.in);
    static Scanner eliminar = new Scanner(System.in);
    static Scanner modificar = new Scanner(System.in);
    static Scanner menu = new Scanner(System.in);

    public Usuario() { //constructor defalut

    }

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    //constructor con parámetros
    public Usuario(String nombre, String password, String rol, String permiso) {
        this.nombre = nombre;
        this.password = password;
        this.rol = rol;
        this.permiso = permiso;
    }

    // getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getPermiso() {
        return permiso;
    }

    public void setPermiso(String permiso) {
        this.permiso = permiso;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " Rol: " + rol + " Permiso: " + permiso;
    }

    //mostrar todos los usuarios
    public void mostrarUsuarios() {
        if (listaUsuarios == null || listaUsuarios.isEmpty()) {
            System.err.println("LISTA DE USUARIOS: VACIA");
        } else {
            System.out.println("");
            System.out.println(ANSI_GREEN + "LISTA DE USUARIOS" + ANSI_RESET);
            System.out.println("Pos");
            for (int i = 0; i < listaUsuarios.size(); i++) {
                System.out.println("[" + i + "] " + listaUsuarios.get(i));
            }
        }
    }

    //mostrar usuarios por nombre
    public void eliminarUsuario() {
        int pos;
        if (listaUsuarios == null || listaUsuarios.isEmpty()) {
            System.err.println("LISTA DE USUARIOS: VACIA");
        } else {
            mostrarUsuarios();
            System.out.println("");
            System.out.print("Posición del usuario a eliminar: ");
            pos = eliminar.nextInt();
            System.out.println("");
            try {
                if (pos != -1 || pos != listaUsuarios.size()) {
                    System.out.println(ANSI_RED + "Se elimino el usuario: " + ANSI_RESET + listaUsuarios.get(pos).getNombre());
                    listaUsuarios.remove(listaUsuarios.get(pos));
                }
            } catch (Exception e) {
                System.out.println(ANSI_RED + "No se encontro posición del usuario: " + ANSI_RESET + e.getMessage());
            }
        }
    }

    //modificar usuarios
    public void modificarUsuario() {
        String nombreNuevo;
        String passwordNuevo;
        String passwordActual;
        String rolNuevo;
        String permisoNuevo;
        int pos;
        int opc;
        if (listaUsuarios == null || listaUsuarios.isEmpty()) {
            System.err.println("LISTA DE USUARIOS: VACIA");
        } else {
            mostrarUsuarios();
            System.out.println("");
            System.out.print("Posición del usuario a modificar: ");
            pos = modificar.nextInt();
            System.out.println("");
            try {
                if (pos != -1 || pos != listaUsuarios.size()) {
                    System.out.println(ANSI_BLUE + "Campo a modificar del usuario: " + ANSI_RESET + listaUsuarios.get(pos).getNombre());
                    System.out.println("1. Nombre");
                    System.out.println("2. Password");
                    System.out.println("3. Rol");
                    System.out.println("4. Permiso");
                    System.out.println("5. Regresar");
                    System.out.println("");
                    opc = menu.nextInt();
                    switch (opc) {
                        case 1:
                            System.out.println("");
                            System.out.print("Introduce nuevo nombre: ");
                            nombreNuevo = nameNew.nextLine();
                            System.out.println("");
                            listaUsuarios.get(pos).setNombre(nombreNuevo);
                            System.out.println(ANSI_GREEN + "Se cambio nombre: " + ANSI_RESET + nombreNuevo);
                            break;
                        case 2:
                            System.out.println("");
                            System.out.print("Introduce actual password: ");
                            passwordActual = passAct.nextLine();
                            System.out.println("");
                            if (listaUsuarios.get(pos).getPassword().equals(passwordActual)) {
                                System.out.print("Introduce nuevo password: ");
                                passwordNuevo = passNew.nextLine();
                                listaUsuarios.get(pos).setPassword(passwordNuevo);
                                System.out.println(ANSI_GREEN + "Se cambio password: " + ANSI_RESET + passwordNuevo);
                            } else {
                                System.out.println(ANSI_RED + "Password actual incorrecta: " + ANSI_RESET);
                            }
                            break;
                        case 3:
                            System.out.println("");
                            System.out.print("Introduce nuevo rol: ");
                            rolNuevo = newRol.nextLine();
                            System.out.println("");
                            listaUsuarios.get(pos).setRol(rolNuevo);
                            System.out.println(ANSI_GREEN + "Se cambio rol: " + ANSI_RESET + rolNuevo);
                            break;
                        case 4:
                            System.out.println("");
                            System.out.print("Introduce nuevo permiso: ");
                            permisoNuevo = newPermiso.nextLine();
                            System.out.println("");
                            listaUsuarios.get(pos).setPermiso(permisoNuevo);
                            System.out.println(ANSI_GREEN + "Se cambio permiso: " + ANSI_RESET + permisoNuevo);
                            break;
                        case 5:
                            break; //va al menu anterior
                        default:
                            System.err.println("«Solo números entre 1 y 5»");
                    }
                }
            } catch (Exception e) {
                System.out.println(ANSI_RED + "No se encontro posición del usuario: " + ANSI_RESET + e.getMessage());
            }
        }
    }

}
