package Usuarios;

import java.util.Date;
import Asignaturas.Asignatura;

public class Administrador extends Persona
{
    
    /**
     * Constructor único de la clase constructor
     * @param usuario
     * @param edad
     * @param creacion
     * @param contrasena
     */
    public Administrador(String usuario, int edad, Date creacion, String contrasena)
    {
        super(usuario, edad, creacion, contrasena);
        super.tipo = 'a';
    }
    /** 
     * Menu con las funcionalidades del administrador
     */
    public void Menu()
    {
        System.out.println("+-------------------------------------+");
        System.out.println("|         MENÚ DE ADMINISTRADOR       |");
        System.out.println("+-------------------------------------+");
        System.out.println("| 1) Crear una nueva cuenta           |");
        System.out.println("| 2) Crear una asignatura             |");
        System.out.println("| 3) Eliminar una asignatura          |");
        System.out.println("| 4) Modificar una asignatura         |");
        System.out.println("| 5) Salir                            |");
        System.out.println("+-------------------------------------+");
        return;
    }
    /**
     * Creacion de un objeto
     * @param usuario
     * @param edad
     * @param creacion
     * @param contrasena
     * @param tipo
     * @return
     */
    public Persona CrearCuenta(String usuario, int edad, Date creacion, String contrasena, char tipo)
    {
        Persona persona=new Persona(usuario,edad,creacion,contrasena,tipo);
        return persona;
    }
    /**
     * Crear asignatura con lsitado de estudiante
     * @param nombremateria
     * @param nombreprofe
     * @param creditos
     * @param plan
     * @return
     */
    public Asignatura CrearAsigantura(String nombremateria, String nombreprofe, int creditos, Estudiante[] plan)
    {
        Asignatura classAux = new Asignatura(nombremateria, nombreprofe, creditos, plan);
        return classAux;
    }
    /**
     * Creación de asignatura
     * @param nombremateria
     * @param nombreprofe
     * @param creditos
     * @return
     */
    public Asignatura CrearAsigantura(String nombremateria, String nombreprofe, int creditos)
    {
        Asignatura classAux = new Asignatura(nombremateria, nombreprofe, creditos);
        return classAux;
    }
    
}
