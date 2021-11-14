package Usuarios;

import java.util.Date;

public class Estudiante extends Persona
{
    /**
     * Constructor único de la clase persona
     * @param usuario
     * @param edad
     * @param creacion
     * @param carrera
     */
    public Estudiante(String usuario, int edad, Date creacion, String contrasena)
    {
        super(usuario, edad, creacion, contrasena);
        super.tipo = 'e';
    }
    /**
     * Menú con las funciones a las que puede acceder un estudiante
     */
    public void Menu()
    {
        System.out.println("+-------------------------------------+");
        System.out.println("|           MENÚ DE ESTUDIANTE        |");
        System.out.println("+-------------------------------------+");
        System.out.println("| 1) Ver cursos                       |");
        System.out.println("| 2) Enviar proyectos                 |");
        System.out.println("| 3) Buzón de mensajería              |");
        System.out.println("| 4) Inscribir un curso               |");
        System.out.println("| 5) Cancelar un curso                |");
        System.out.println("| 6) Salir                            |");
        System.out.println("+-------------------------------------+");
        return;
    }
}
