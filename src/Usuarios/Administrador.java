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
    /**
     * Borra una materia especificada por nombre previamente, solo puede ser realizado por
     * un administrador
     * @param listado
     * @param cla
     * @param nombre
     * @return nuevo listado de materias
     */
    public Asignatura [] eliminarAsignatura(Asignatura listado[], int cla, String  nombre)
    {
        boolean hallado = false;
        for(int i=0;i<cla; i++)
        {
            if(listado[i].getNombre().equals(nombre))
            {
                hallado = true;
                System.out.println("Eliminando la asignatura encontrada...");
                for(int j=i; j<cla-1; j++) //Ciclo de sobreescritura
                {
                    listado[j] = listado[j+1];
                }
                break;
            }
        }
        if(!hallado)
        {
            System.out.println("Clase no encontrada");
        }
        return listado;
    }
    /**
     * Actualiza el número de créditos de una asignatura mediante su nombre
     * @param listado
     * @param cla
     * @param nombre
     * @param creditos
     * @return listado actualizado
     */
    public Asignatura [] modificarAsignatura(Asignatura listado[], int cla, String nombre, int creditos)
    {
        boolean hallado = false;
        for(int i=0;i<cla; i++)
        {
            if(listado[i].getNombre().equals(nombre))
            {
                hallado = true;
                System.out.println("Numero de créditos modificado");
                listado[i].setCreditos(creditos);
            }
        }
        if(!hallado)
        {
            System.out.println("Asignatura no encontrada");
        }
        return listado;
    }
    /**
     * Actualiza el profesor a cargo de una asignatura mediante su nombre
     * @param listado
     * @param cla
     * @param nombre
     * @param profe
     * @return listado actualizado
     */
    public Asignatura [] modificarAsignatura(Asignatura listado[], int cla, String nombre, String profe)
    {
        boolean hallado = false;
        for(int i=0;i<cla; i++)
        {
            if(listado[i].getNombre().equals(nombre))
            {
                hallado = true;
                System.out.println("Numero de créditos modificado");
                listado[i].setProfesor(profe);
            }
        }
        if(!hallado)
        {
            System.out.println("Asignatura no encontrada");
        }
        return listado;
    }
    /**
     * Método para conocer las clases habilitadas
     * @param listado
     * @return numero de clases
     */
    public int numClases(Asignatura [] listado)
    {
        for(int i=0; i<Asignatura.MS; i++)
        {
            if(listado[i] == null)
            {
                return i;
            }
        }
        return Asignatura.MS;
    } 
}
