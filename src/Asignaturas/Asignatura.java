package Asignaturas;

import java.io.Serializable;

import Usuarios.Estudiante;

public class Asignatura implements Serializable
{
    protected String nombre;
    protected String profesor;
    protected int creditos;
    public static final int MS = 15;
    protected Estudiante [] alumnos = new Estudiante [MS];
    /**
     * Constructor de asignatura con los siguientes parámetros:
     * @param Nombre
     * @param Profesor
     * @param Creditos
     */
    public Asignatura(String Nombre, String Profesor, int Creditos)
    {
        this.nombre = Nombre;
        this.profesor = Profesor;
        this.creditos = Creditos;
    }

    public Asignatura(String nombre, String profesor, int creditos, Estudiante[] alumnos) 
    {
        this(nombre, profesor, creditos);
        this.alumnos = alumnos;
    }

    /**
     * setter de estudiantes por posición
     * @param pos
     * @param siguiente
     */
    public void setAlumnos(int pos, Estudiante siguiente) 
    {
        this.alumnos[pos] = siguiente;
        return;
    }
    /**
     * Getter del arreglo de alumnos
     * @return
     */
    public Estudiante[] getAlumnos() 
    {
        return alumnos;
    }
    /**
     * Getter del nombre
     * @return
     */
    public String getNombre()
    {
        return nombre;
    }
    /**
     * Setter del nombre
     * @param nombre
     */
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
        return;
    }
    /**
     * Getter del profesor
     * @return
     */
    public String getProfesor()
    {
        return profesor;
    }
    /**
     * Setter del profesor
     * @param profesor
     */
    public void setProfesor(String profesor)
    {
        this.profesor = profesor;
        return;
    }
    /**
     * Getter del numero de créditos
     * @return
     */
    public int getCreditos()
    {
        return creditos;
    }
    /**
     * Setter de créditos
     * @param creditos
     */
    public void setCreditos(int creditos)
    {
        this.creditos = creditos;
        return;
    }
    /**
     * Verifica la cantidad de estudiantes en la materia
     * @return num estudiantes
     */
    public int ultimoEstudiante()
    {
        int num = Asignatura.MS;
        for(int i=0; i<num; i++)
        {
            if(this.alumnos[i]== null)
            {
                return i;
            }
        }
        return num - 1;
    }
    @Override
    public String toString() 
    {
        String cadena = "";
        cadena += "Asignaturas{\n";
        cadena += "\nNombre= " + nombre + "\nprofesor= " + profesor + "\ncreditos= " + creditos;
        cadena += "\nAlumnos= "; 
        for(int i=0;i<15;i++)
        { 
            if(alumnos [i]==null)
            {
                cadena += "\n" + alumnos[i];
            }
        }
        return cadena;
    }
}
