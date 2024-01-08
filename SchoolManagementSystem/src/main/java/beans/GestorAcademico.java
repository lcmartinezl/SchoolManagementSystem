package beans;

import exceptions.EstudianteNoInscritoEnCursoException;
import exceptions.EstudianteYaInscritoException;

import java.util.ArrayList;
import java.util.HashMap;

public class GestorAcademico implements ServiciosAcademicosI{

    private static GestorAcademico instance;
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Curso> cursos;
    private HashMap asignaciones;
    private GestorAcademico() {
        estudiantes = new ArrayList();
        cursos  = new ArrayList();
        asignaciones = new HashMap();
    }

    public static synchronized GestorAcademico getInstance() {
        if (instance == null) {
            instance = new GestorAcademico();
        }
        return instance;
    }

    @java.lang.Override
    public void matricularEstudiante(Estudiante estudiante) {
        boolean existe = false;
        for (Estudiante e:estudiantes) {
            if (e.getId() == estudiante.getId()) {
                existe = true;
            }
        }
        if (!existe) {
            this.estudiantes.add(estudiante);
        }
    }

    @java.lang.Override
    public void agregarCurso(Curso curso) {
        boolean existe = false;
        for (Curso c:cursos) {
            if (c.getId() == curso.getId()) {
                existe = true;
            }
        }
        if (!existe) {
            this.cursos.add(curso);
            ArrayList<Estudiante> lest = new ArrayList();
            this.asignaciones.put(curso.getId(), lest);
        }
    }

    @java.lang.Override
    public void inscribirEstudianteCurso(Estudiante estudiante, int idCurso) throws EstudianteYaInscritoException {
        if (this.asignaciones.containsKey(idCurso)) {
            ArrayList<Estudiante> lest = (ArrayList<Estudiante>) asignaciones.get(idCurso);
            boolean existe = false;
            for (Estudiante e: lest) {
                if (e.getId() == estudiante.getId()) {
                    existe = true;
                    throw new EstudianteYaInscritoException("El Estudiante " + estudiante.getNombre() +" ya esta inscrito en curso ID "+ idCurso);
                }
            }
            if (!existe) {
                lest.add(estudiante);
                System.out.println("Se inscribio a "+ estudiante.getNombre());
            }
        } else {
            ArrayList<Estudiante> lest = new ArrayList();
            lest.add(estudiante);
            this.asignaciones.put(idCurso, lest);
            System.out.println("Se inscribio a "+ estudiante.getNombre());
        }
    }

    @java.lang.Override
    public void desinscribirEstudianteCurso(int idEstudiante, int idCurso) throws EstudianteNoInscritoEnCursoException {
        if (this.asignaciones.containsKey(idCurso)) {
            ArrayList<Estudiante> lest = (ArrayList<Estudiante>) asignaciones.get(idCurso);
            Estudiante est = null;
            for (Estudiante e: lest) {
                if (idEstudiante==e.getId()) {
                    est = e;
                }
            }
            if (est == null) {
                throw new EstudianteNoInscritoEnCursoException("Estudiante no ha sido inscrito");
            } else {
                lest.remove(est);
                System.out.println("Se desasigno a "+ est.getNombre());
            }
        }
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }


}
