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
    public static void FuncionalidadA()
    {
        System.out.println("+-------------------------------------+");
        System.out.println("|   FUNCIONALIDADES DE Administrador  |");
        System.out.println("+-------------------------------------+");
        System.out.println("+ Admin es un tipo de usuario del porgrama capaz de hacer diferentes funcionalidades en este podras +");
        System.out.println("+ hacer algunas de las siguientes funciones que tambien podras encontrar en su menu: +");
        System.out.println("| 1) Crear una nueva cuenta           |");
        System.out.println("| 2) Crear una asignatura             |");
        System.out.println("| 3) Eliminar una asignatura          |");
        System.out.println("| 4) Modificar una asignatura         |");
        System.out.println("| 5) Salir                            |");
        System.out.println("+ En estas funciones lo que podras realizar es como su nombre lo idica, en el primero hacer el registro de +");
        System.out.println("+ los usuarios que quieres en tú universidad lo cual te da un control como Administrador, siguiente de esto +");
        System.out.println("+ podras encontrar con la creacion y eliminacion de las asignaturas en los cuales podras asignar el profesor,+");
        System.out.println("+ los estudiantes, numero de creditos de la asignatura, en el modificar se podra modificar la cantidad de los+");
        System.out.println("+ creditos y ademas al profesor que dicta esta materia, finalmente tendra la oportunidad de salirse del menu.+");
        System.out.println("+-------------------------------------+");
    }
    public static void FuncionalidadE()
    {
        System.out.println("+-------------------------------------+");
        System.out.println("|   FUNCIONALIDADES DE ESTUDIANTE     |");
        System.out.println("+-------------------------------------+");
        System.out.println("+ Estudiante es un tipo de usuario del porgrama capaz de hacer diferentes funcionalidades en este +");
        System.out.println("+ podras hacer algunas de las siguientes funciones que tambien podras encontrar en su menu: +");
        System.out.println("| 1) Ver cursos                       |");
        System.out.println("| 2) Enviar proyectos                 |");
        System.out.println("| 3) Buzón de mensajería              |");
        System.out.println("| 4) Inscribir un curso               |");
        System.out.println("| 5) Cancelar un curso                |");
        System.out.println("| 6) Salir                            |");
        System.out.println("+ En estas funciones lo que podras realizar es como su nombre lo idica, en el primero poder ver los que +");
        System.out.println("+ el como estudinate tiene, ademas este tendra la posibilidad de comunicarse con el profesor de alguna  +");
        System.out.println("+ materia y podra enviar proyectos, siguiente de esto podras encontrar con la inscripcion de cursos y  la +");
        System.out.println("+ cancelacion de esta asignatura en sus cursos, finalmente tendra la oportunidad de salirse del menu. +");
        System.out.println("+-------------------------------------+");
    }
    public static void FuncionalidadP()
    {
        System.out.println("+-------------------------------------+");
        System.out.println("|     FUNCIONALIDADES DE PROFESOR     |");
        System.out.println("+-------------------------------------+");
        System.out.println("+ Profesor es un tipo de usuario del porgrama capaz de hacer diferentes funcionalidades en este +");
        System.out.println("+ podras hacer algunas de las siguientes funciones que tambien podras encontrar en su menu: +");
        System.out.println("| 1) Verificar proyectos              |");
        System.out.println("| 2) Mensaje a estudiantes            |");
        System.out.println("| 3) Orientación a estudiantes        |");
        System.out.println("| 4) Listar estudiantes               |");
        System.out.println("| 5) Listar cursos                    |");
        System.out.println("| 6) Salir                            |");
        System.out.println("+ En estas funciones lo que podras realizar es como su nombre lo idica, en el primero poder ver y +");
        System.out.println("+ verificar los proyectos de los estudiantes, en la segunda podra comunicarse con todo un salon, ademas +");
        System.out.println("+ por medio de la orientación se podra comunicar directamente a un estudiante que este en sus clases, +");
        System.out.println("+ siguiente de esto tendra la posibilidad de listar sus estudiantes y adem,as los cursos que esta a cargo, +");
        System.out.println("+ finalmente tendra la oportunidad de salirse del menu. +");
        System.out.println("+-------------------------------------+");
    }
    public static void MenudeManuales()
    {
        System.out.println("+-------------------------------------+");
        System.out.println("|          MENÚ DE MANUALES           |");
        System.out.println("+-------------------------------------+");
        System.out.println("| 1) Manual de Administrador          |");
        System.out.println("| 2) Manual de Profesor               |");
        System.out.println("| 2) Manual de Estudiante             |");
        System.out.println("| 4) Salir                            |");
        System.out.println("+-------------------------------------+");
    }
}
