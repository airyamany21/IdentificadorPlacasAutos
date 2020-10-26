/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoplacas;

import static autoplacas.AutoPlacas.ANSI_RED;
import static autoplacas.AutoPlacas.ANSI_RESET;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Airyamany21
 */
public class AnalizadorVideoPlacas {

    private String matriculaVideo;
    private String Ubicacion;
    ArrayList<String> listaMatriculaVideo = new ArrayList<>();
    ArrayList<String> buscadorReporte = new ArrayList<>();

    public AnalizadorVideoPlacas() {

    }

    public AnalizadorVideoPlacas(String matriculaVideo) {
        this.matriculaVideo = matriculaVideo;
    }

    public AnalizadorVideoPlacas(String matriculaVideo, String Ubicacion) {
        this.matriculaVideo = matriculaVideo;
        this.Ubicacion = Ubicacion;
    }

    public String getMatriculaVideo() {
        return matriculaVideo;
    }

    public void setMatriculaVideo(String matriculaVideo) {
        this.matriculaVideo = matriculaVideo;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String Ubicacion) {
        this.Ubicacion = Ubicacion;
    }

    @Override
    public String toString() {
        return "matriculaVideo: " + matriculaVideo + " Ubicacion: " + Ubicacion;
    }

    // Simulación
    public void iniciarSimulacion() {
        System.out.println(AutoPlacas.ANSI_GREEN + "Placas" + ANSI_RESET);
        listaMatriculaVideo.add("AS0");
        listaMatriculaVideo.add("BC1");
        listaMatriculaVideo.add("CC2");
        listaMatriculaVideo.add("CL3");
        listaMatriculaVideo.add("CM4");
        listaMatriculaVideo.add("CS5");
        listaMatriculaVideo.add("CH6");
        listaMatriculaVideo.add("CM7");
        listaMatriculaVideo.add("DG8");
        listaMatriculaVideo.add("GT9");
        buscadorReporte.add("Aguascalientes");
        buscadorReporte.add("Campeche");
        buscadorReporte.add("Colima");
        buscadorReporte.add("Chihuaha");
        buscadorReporte.add("Durango");
        Random rand = new Random();
        List<Integer> lista = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int aleatorio = rand.nextInt(lista.size());
        if (0 == aleatorio) {
            System.out.println("Sistema de delitos");
            System.out.println(ANSI_RED + "Auto Robado: " + ANSI_RESET + "Matricula Reportada: " + listaMatriculaVideo.get(0) + " Ubicacion: " + buscadorReporte.get(0));
        } else if (2 == aleatorio) {
            System.out.println("Sistema de delitos");
            System.out.println(ANSI_RED + "Auto Robado: " + ANSI_RESET + "Matricula Reportada: " + listaMatriculaVideo.get(2) + " Ubicacion: " + buscadorReporte.get(2));
        } else if (4 == aleatorio) {
            System.out.println("Sistema de delitos");
            System.out.println(ANSI_RED + "Auto Robado: " + ANSI_RESET + "Matricula Reportada: " + listaMatriculaVideo.get(4) + " Ubicacion: " + buscadorReporte.get(4));
        } else if (6 == aleatorio) {
            System.out.println("Sistema de delitos");
            System.out.println(ANSI_RED + "Auto Robado: " + ANSI_RESET + "Matricula Reportada: " + listaMatriculaVideo.get(6) + " Ubicacion: " + buscadorReporte.get(6));
        } else if (8 == aleatorio) {
            System.out.println("Sistema de delitos");
            System.out.println(ANSI_RED + "Auto Robado: " + ANSI_RESET + "Matricula Reportada: " + listaMatriculaVideo.get(8) + " Ubicacion: " + buscadorReporte.get(8));
        } else if (1 == aleatorio) {
            System.out.println("Matrícula encontrada: " + listaMatriculaVideo.get(1));
        } else if (3 == aleatorio) {
            System.out.println("Matrícula encontrada: " + listaMatriculaVideo.get(3));
        } else if (5 == aleatorio) {
            System.out.println("Matrícula encontrada: " + listaMatriculaVideo.get(5));
        } else if (7 == aleatorio) {
            System.out.println("Matrícula encontrada: " + listaMatriculaVideo.get(7));
        } else if (9 == aleatorio) {
            System.out.println("Matrícula encontrada: " + listaMatriculaVideo.get(9));
        }
    }

}
