package Usuarios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

import Asignaturas.Asignatura;

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
    /**
     * Función para generar canal de comunicación entre estudiante y profesor
     * (Canal de estudiante)
     * @param nombre
     * @param inp
     * @throws IOException
     */
    public void chatearCon(String nombre, Scanner inp) throws IOException
    {
        String comunicacion = nombre;
        File chat = new File(comunicacion);
        FileReader  fr = null;
        BufferedReader br = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
        boolean bandera = false;
        boolean inicio = false;
        String mensaje = "E: ";
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
            comunicacion += "\\" + nombre + "_" + this.usuario + ".txt";
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
                bw.write("Chat entre el profesor: " + nombre + " y el estudiante: " + this.usuario);
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
    public void InscribirCurso(Estudiante estu,Asignatura asig)
    {
        int pos=asig.ultimoEstudiante();
        asig.setAlumnos(pos, estu);
        return;
    }
    public Asignatura [] EliminarCurso(String nombre, String estudiante,Asignatura listado [], int cla)
    {
        boolean hallado = false;
        for(int i=0;i<cla; i++)
        {
            if(listado[i].getNombre().equals(nombre))
            {
                hallado = true;
                System.out.println("Asignatura encontrada...");
                for(int j=0; j<listado[i].ultimoEstudiante(); j++)
                {
                    if(listado[i].getAlumnos()[j].getUsuario().equals(estudiante))
                    {
                        if(j==listado[i].ultimoEstudiante()-1)
                        {
                            listado[i].setAlumnos(j, null);
                            break;
                        }
                        for(int k=j; k<listado[i].ultimoEstudiante()-1; k++)
                        {
                            listado[i].getAlumnos()[k]=listado[i].getAlumnos()[k+1];
                        }
                    }
                }
                break;
            }
        }
        if(!hallado)
        {
            System.out.println("Clase o estudiante no encontrada");
        }
        return listado;
    }  
}
