package lecturaEscritura.modelos;

public class Alumno {
    private String nombre;
    private int id;
    private double nota;

    public Alumno(String nombre, int id, double nota) {
        this.nombre = nombre;
        this.id = id;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                ", nota=" + nota +
                '}';
    }
}
