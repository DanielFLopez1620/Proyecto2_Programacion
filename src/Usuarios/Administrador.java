package Usuarios;

import java.util.Date;

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
    public Persona CrearCuenta(String usuario, int edad, Date creacion, String contrasena, char tipo)
    {
        Persona persona=new Persona(usuario,edad,creacion,contrasena,tipo);
        return persona;
    }
    
}
