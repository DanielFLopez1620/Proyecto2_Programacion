package Usuarios;

import java.util.Date;

public class Profesor extends Persona 
{
    /**
     * Constructor único de un profesor
     * @param usuario
     * @param edad
     * @param creacion
     * @param contrasena
     */
    public Profesor(String usuario, int edad, Date creacion, String contrasena)
    {
        super(usuario, edad, creacion, contrasena);
        super.tipo = 'p';
    }
    /**
     * Menu de las funcionalidades del profesor
     */
    public void Menu()
    {
        System.out.println("+-------------------------------------+");
        System.out.println("|          MENÚ DE PROFESOR           |");
        System.out.println("+-------------------------------------+");
        System.out.println("| 1) Verificar proyectos              |");
        System.out.println("| 2) Mensaje a estudiantes            |");
        System.out.println("| 3) Orientación a estudiantes        |");
        System.out.println("| 4) Listar estudiantes               |");
        System.out.println("| 5) Listar cursos                    |");
        System.out.println("| 6) Salir                            |");
        System.out.println("+-------------------------------------+");
        return;
    }
}

