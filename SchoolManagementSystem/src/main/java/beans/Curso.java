package beans;

public class Curso {

    private int id;
    private String nombre;
    private String descripcion;
    private int numeroCreditos;
    private int version;
    public Curso() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public java.lang.String getNombre() {
        return nombre;
    }

    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }

    public java.lang.String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNumeroCreditos() {
        return numeroCreditos;
    }

    public void setNumeroCreditos(int numeroCreditos) {
        this.numeroCreditos = numeroCreditos;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
