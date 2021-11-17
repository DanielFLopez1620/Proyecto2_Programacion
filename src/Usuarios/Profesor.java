package Usuarios;

import java.util.Date;
import java.util.Scanner;

import Asignaturas.Asignatura;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
    /**
     * Generar un canal de comunicación entre profesor y estudiante
     * (Canal del profesor)
     * @param nombre
     * @param inp
     * @throws IOException
     */
    public void chatearCon(String nombre, Scanner inp) throws IOException
    {
        String comunicacion = this.getUsuario();
        File chat = new File(comunicacion);
        FileReader  fr = null;
        BufferedReader br = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
        boolean bandera = false;
        boolean inicio = false;
        String mensaje = "P: ";
        String oracion = "";
        if(!chat.isDirectory())
        {
            if(chat.mkdir())
            {
                bandera = true;
            }
        }
        else
        {
            bandera = true;
        }
        if(bandera)
        {
            comunicacion += "\\" + this.usuario + "_" + nombre + ".txt";
            chat = new File(comunicacion);
            if(chat.exists())
            {
                fr = new FileReader(chat);
                br = new BufferedReader(fr);
                while(true)
                {
                    oracion = br.readLine();
                    if(oracion == null)
                    {
                        break;
                    }
                    System.out.println(oracion);
                }
                br.close();
            }
            else
            {
                if(chat.createNewFile())
                {
                    System.out.println("Chat creado con éxtio...");
                    inicio = true;
                }
            }
            chat = new File(comunicacion);
            fw = new FileWriter(chat, true);
            bw = new BufferedWriter(fw);
            if(inicio)
            {
                bw.write("Chat entre el profesor: " + this.usuario + " y el estudiante: " + nombre);
            }
            System.out.println("Digite el mensaje a añadir: ");
            mensaje += inp.nextLine();
            bw.write("\r\n" + mensaje);
            bw.close();
        }
        else
        {
            System.out.println("Ha ocurrido un problema con el directorio");
        }
        return;
    }
    /**
     * Generar un canal de comunicación entre profesor y estudiante
     * (Canal del profesor)
     * @param nombre
     * @param inp
     * @throws IOException
     */
    public void chatearCon(String nombre, String motivacion) throws IOException
    {
        String comunicacion = this.getUsuario();
        File chat = new File(comunicacion);
        FileReader  fr = null;
        BufferedReader br = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
        boolean bandera = false;
        boolean inicio = false;
        String mensaje = "P: Recomendaciones: ";
        String oracion = "";
        if(!chat.isDirectory())
        {
            if(chat.mkdir())
            {
                bandera = true;
            }
        }
        else
        {
            bandera = true;
        }
        if(bandera)
        {
            comunicacion += "\\" + this.usuario + "_" + nombre + ".txt";
            chat = new File(comunicacion);
            if(chat.exists())
            {
                fr = new FileReader(chat);
                br = new BufferedReader(fr);
                while(true)
                {
                    oracion = br.readLine();
                    if(oracion == null)
                    {
                        break;
                    }
                    System.out.println(oracion);
                }
                br.close();
            }
            else
            {
                if(chat.createNewFile())
                {
                    System.out.println("Chat creado con éxtio...");
                    inicio = true;
                }
            }
            chat = new File(comunicacion);
            fw = new FileWriter(chat, true);
            bw = new BufferedWriter(fw);
            if(inicio)
            {
                bw.write("Chat entre el profesor: " + this.usuario + " y el estudiante: " + nombre);
            }
            System.out.println("Digite el mensaje a añadir: ");
            mensaje += motivacion;
            bw.write("\r\n" + mensaje);
            bw.close();
        }
        else
        {
            System.out.println("Ha ocurrido un problema con el directorio");
        }
        return;
    }
    /**
     * Comunicación de una nueva asignación disponible
     * @param nombre
     * @param motivacion
     * @param carpeta
     * @throws IOException
     */
    public void chatearCon(String nombre, String motivacion, String carpeta) throws IOException
    {
        String comunicacion = this.getUsuario();
        File chat = new File(comunicacion);
        FileReader  fr = null;
        BufferedReader br = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
        boolean bandera = false;
        boolean inicio = false;
        String mensaje = "P: ¡IMPORTANTE! Asiganción: ";
        String oracion = "";
        if(!chat.isDirectory())
        {
            if(chat.mkdir())
            {
                bandera = true;
            }
        }
        else
        {
            bandera = true;
        }
        if(bandera)
        {
            comunicacion += "\\" + this.usuario + "_" + nombre + ".txt";
            chat = new File(comunicacion);
            if(chat.exists())
            {
                fr = new FileReader(chat);
                br = new BufferedReader(fr);
                while(true)
                {
                    oracion = br.readLine();
                    if(oracion == null)
                    {
                        break;
                    }
                    System.out.println(oracion);
                }
                br.close();
            }
            else
            {
                if(chat.createNewFile())
                {
                    System.out.println("Chat creado con éxtio...");
                    inicio = true;
                }
            }
            chat = new File(comunicacion);
            fw = new FileWriter(chat, true);
            bw = new BufferedWriter(fw);
            if(inicio)
            {
                bw.write("Chat entre el profesor: " + this.usuario + " y el estudiante: " + nombre);
            }
            System.out.println("Digite el mensaje a añadir: ");
            mensaje += motivacion;
            bw.write("\r\n" + mensaje);
            bw.write("\r\n" + "La tarea debe ser entregada en la carpeta: " + carpeta);
            bw.close();
        }
        else
        {
            System.out.println("Ha ocurrido un problema con el directorio");
        }
        return;
    }
    /**
     * Imprime el listado de estudiantes de una clase
     * @param lista
     */
    public void ListarEstudiante(Asignatura lista)
    {
        int con = lista.ultimoEstudiante();
        Estudiante[] estu=new Estudiante[con];        
        System.out.print("Los de la asignatura "+lista.getNombre()+" son:");
        for(int i=0; i<con;i++)
        {
            estu[i]=lista.getAlumnos()[i];
            System.out.println("El Nombre de Estudiante: "+ i+1 +" "+ estu[i].getUsuario());
        }
        return;
    }
    
}

