/*192405 - 192323 */

package Aguacate;

import java.util.ArrayList;
import java.util.List;

class Materia {
    private String nombre;
    private String codigo;
    private int creditos;
    private List<String> horariosDisponibles;

    public Materia(String nombre, String codigo, int creditos) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.creditos = creditos;
        this.horariosDisponibles = new ArrayList<>();
    }

    public void agregarHorario(String horario) {
        horariosDisponibles.add(horario);
    }

    public void mostrarHorariosDisponibles() {
        for (String horario : horariosDisponibles) {
            System.out.println(horario);
        }
    }

    public String getNombre() { return nombre; }
    public String getCodigo() { return codigo; }
    public int getCreditos() { return creditos; }
}

class Inscripcion {
    private Materia materia;
    private String horario;

    public Inscripcion(Materia materia, String horario) {
        this.materia = materia;
        this.horario = horario;
    }

    public Materia getMateria() { return materia; }
    public String getHorario() { return horario; }
}

class Estudiante {
    private String nombre;
    private String id;
    private List<Inscripcion> materiasInscritas;

    public Estudiante(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
        this.materiasInscritas = new ArrayList<>();
    }

    public void inscribirMateria(Materia materia, String horario) {
        materiasInscritas.add(new Inscripcion(materia, horario));
    }

    public void mostrarHorarioCompleto() {
        for (Inscripcion inscripcion : materiasInscritas) {
            System.out.println(inscripcion.getMateria().getNombre() + " - " + inscripcion.getHorario());
        }
    }
}

class GestionHorarios {
    private List<Materia> materias;
    private List<Estudiante> estudiantes;

    public GestionHorarios() {
        this.materias = new ArrayList<>();
        this.estudiantes = new ArrayList<>();
    }

    public void registrarMateria(Materia materia) {
        materias.add(materia);
    }

    public void inscribirEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public void mostrarMaterias() {
        for (Materia materia : materias) {
            System.out.println(materia.getNombre() + " (" + materia.getCodigo() + ")");
        }
    }

    public void mostrarEstudiantes() {
        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante.getNombre() + " (" + estudiante.getId() + ")");
        }
    }
}

public class AñadirHorario {
    public static void main(String[] args) {
        GestionHorarios gestionHorarios = new GestionHorarios();

        Materia matematicas = new Materia("Matemáticas", "MAT101", 3);
        matematicas.agregarHorario("Lunes 8-10am");
        matematicas.agregarHorario("Miércoles 8-10am");

        Materia historia = new Materia("Historia", "HIS101", 2);
        historia.agregarHorario("Martes 10-12pm");
        historia.agregarHorario("Jueves 10-12pm");

    
        gestionHorarios.registrarMateria(matematicas);
        gestionHorarios.registrarMateria(historia);


        Estudiante juan = new Estudiante("Juan Pérez", "12345");
        Estudiante maria = new Estudiante("María Gómez", "67890");

        gestionHorarios.inscribirEstudiante(juan);
        gestionHorarios.inscribirEstudiante(maria);


        juan.inscribirMateria(matematicas, "Lunes 8-10am");
        juan.inscribirMateria(historia, "Martes 10-12pm");

        maria.inscribirMateria(matematicas, "Miércoles 8-10am");
        maria.inscribirMateria(historia, "Jueves 10-12pm");

   
        System.out.println("Horario de Juan:");
        juan.mostrarHorarioCompleto();

        System.out.println("Horario de María:");
        maria.mostrarHorarioCompleto();
    }
}