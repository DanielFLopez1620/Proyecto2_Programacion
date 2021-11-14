package Funcionalidades;

import java.util.Date;

import Usuarios.Persona;

public class FuncionesPrograma 
{
    public static void Menu()
    {
        System.out.println("+-------------------------------------+");
        System.out.println("|            MENÚ DE INICIO           |");
        System.out.println("+-------------------------------------+");
        System.out.println("| 1) Iniciar sesión                   |");
        System.out.println("| 2) Manual de Usuario                |");
        System.out.println("| 3) Créditos                         |");
        System.out.println("| 4) Salir                            |");
        System.out.println("+-------------------------------------+");
        return;
    }
    /**
     * Método de creación del admin original
     * @return master
     */
    public static Persona getAdmin()
    {
        Date creacion = new Date();
        Persona admin = new Persona("master", 15, creacion, "master", 'a');
        return admin;
    }
}
