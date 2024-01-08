package beans;

public class GestorAcademico {

    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Curso> cursos;
    private HashMap asignaciones;
    public GestorAcademico() {
        setEstudiantes(new ArrayList());
        cursos =  = new ArrayList();
        asignaciones = HashMap();
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
}
