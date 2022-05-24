package practica4.ejercicio04;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Acta {
    // Atributos
    private String código; // Código de la asignatura
    private int curso; // Curso académico
    private NotaEstudiante[] notas; // Datos de los estudiantes que hay en el acta
                                    // (ordenados de menor a mayor por DNI)

    // Constructor
    public Acta(String código, int curso, NotaEstudiante[] notas) {
        this.código = código;
        this.curso = curso;
        this.notas = notas;
    }

    // Métodos
    public void calificar(String DNI, double nota) {
        boolean existeAlumno = false;
        for (int i = 0; i < notas.length; i++) {
            if (DNI.compareTo(notas[i].getDNI()) < 0) {
                throw new NoSuchElementException();
            } else if (DNI.equals(notas[i].getDNI())) {
                existeAlumno = true;
                notas[i].setNota(nota);
                break;
            }
        }
        if (existeAlumno == false) {
            throw new NoSuchElementException();
        }
    }

    public void enviarSMS(String[] vectorDNI) {
        for (int i = 0, j = 0; i < vectorDNI.length && j < notas.length;) {
            if (vectorDNI[i].equals(notas[j].getDNI()) && notas[j].getNota() != -1) {
                SMS.enviar(vectorDNI[i], notas[j].getNota());
                i++;
                j++;
            } else if (vectorDNI[i].compareTo(notas[j].getDNI()) > 0) {
                j++;  
            } else {
                i++;
            }
        }
    }

    public Acta siguienteConvocatoria() {
        int longVector = 0;
        for (int i = 0; i < this.notas.length; i++) {
            if (this.notas[i].getPresentado() == false || this.notas[i].getNota() < 5) {
                longVector++;
            }
        }
        NotaEstudiante[] nuevoVector = new NotaEstudiante[longVector];
        for (int i = 0, j = 0; i < this.notas.length; i++) {
            if (notas[i].getNota() < 5 || notas[i].getPresentado() == false) {
                if (notas[i].getPresentado() == false) {
                    nuevoVector[j++] = new NotaEstudiante(notas[i].getDNI(), notas[i].getConvocatoria() + 1);
                } else {
                    nuevoVector[j++] = new NotaEstudiante(notas[i].getDNI(), notas[i].getConvocatoria());
                }
            }
        }
        return new Acta(this.código, this.curso, nuevoVector); // Completar
    }

    public String toString() {
        String resultado = String.format("%s -> %d%n", código, curso);
        for (NotaEstudiante n: notas)
            resultado += n;
        return resultado;
    }
}
