package org.example;

import beans.Curso;
import beans.Estudiante;
import beans.GestorAcademico;
import exceptions.EstudianteNoInscritoEnCursoException;
import exceptions.EstudianteYaInscritoException;

public class Main {
    public static void main(String[] args) {

        GestorAcademico gestor = GestorAcademico.getInstance();
        Estudiante estudiante = new Estudiante();
        estudiante.setId(1);
        estudiante.setNombre("Luis");
        estudiante.setApellido("Martinez");
        estudiante.setFechaDeNacimiento("26/10/1981");
        estudiante.setEstado("Matriculado");
        gestor.matricularEstudiante(estudiante);

        Estudiante estudiante2 = new Estudiante();
        estudiante2.setId(2);
        estudiante2.setNombre("Carlos");
        estudiante2.setApellido("Leon");
        estudiante2.setFechaDeNacimiento("26/10/1981");
        estudiante2.setEstado("Matriculado");
        gestor.matricularEstudiante(estudiante2);

        Curso curso1 = new Curso();
        curso1.setId(1);
        curso1.setNombre("GIT");
        curso1.setDescripcion("Introduccion a GIT");
        curso1.setVersion(2024);
        curso1.setNumeroCreditos(20);

        gestor.agregarCurso(curso1);

        Curso curso2 = new Curso();
        curso2.setId(2);
        curso2.setNombre("JAVA");
        curso2.setDescripcion("Introduccion a JAVA");
        curso2.setVersion(2024);
        curso2.setNumeroCreditos(30);

        gestor.agregarCurso(curso2);

        try {
            gestor.inscribirEstudianteCurso(estudiante2, curso1.getId());
        } catch (EstudianteYaInscritoException e) {
            System.out.println("Estudiante ya inscrito "+ estudiante2.getId());
        }
        try {
            gestor.desinscribirEstudianteCurso(estudiante.getId(), curso1.getId());
        } catch (EstudianteNoInscritoEnCursoException e) {
            System.out.println("Estudiante no inscrito "+ estudiante.getId());
        }

        try {
            gestor.inscribirEstudianteCurso(estudiante, curso2.getId());
        } catch (EstudianteYaInscritoException e) {
            System.out.println("Estudiante ya inscrito "+ estudiante.getId());
        }

        try {
            gestor.inscribirEstudianteCurso(estudiante2, curso1.getId());
        } catch (EstudianteYaInscritoException e) {
            System.out.println("Estudiante ya inscrito "+ estudiante2.getId());
        }




    }
}