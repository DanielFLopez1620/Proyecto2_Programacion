package test;
//_________________________Importación de paquetes de Java________________________
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.Scanner;
//_________________________Importación de paquetes propios________________________
import Asignaturas.Asignatura;
import Funcionalidades.FuncionesPrograma;
import Usuarios.Administrador;
import Usuarios.Estudiante;
import Usuarios.Persona;
import Usuarios.Profesor;

public class Main {

    public static final int ML = 20;
    public static void main(String[] args) 
    {
        //_________________________Variables del programa_______________________________
        String nombre = "";
        String contrasena = "";
        String usuario = "";
        String nombremateria = "";
        String nombreprofe = "";
        String nombreestudiante = "";
        String nombreasig="";
        String planilla = "planillaU.bin";
        String materias = "materiasU.bin";
        int opt = 0, opt2 = 0, ntipo=0, opt3=0, mp = 0;
        int con = 0, cla = 0, estu = 0;
        int edad = 0,tipochar = 0,intentos = 1, creditos=0;
        char tipo = ' ';
        char respuesta=' ';
        boolean validar = false;
        boolean valida = false;
        boolean novalido = true;
        boolean clases = false;
        boolean verific=false;
        boolean encontrado = false;
        //_________________________Objetos del programa_________________________________
        Date creacion = new Date();
        Scanner inp = new Scanner(System.in);
        File miArch = null;
        File miMat = null;
        FileInputStream guia = null;
        ObjectInputStream lector = null;
        FileOutputStream registro = null;
        ObjectOutputStream escritor = null;
        Persona [] miListado  = new Persona [ML];
        Asignatura [] misMaterias = new Asignatura [ML];
        Administrador admin = null;
        Profesor profe = null;
        Estudiante alumno = null;
        Persona miAux = null;
        Asignatura classAux = null;
        Estudiante alaux = null;
        Estudiante [] plan = new Estudiante [Asignatura.MS];
        //_________________________Desarrollo de la funcionalidad_______________________
        try
        {
            //-------------------Archivo de personas y login-----------------------------
            miArch = new File(planilla);
            if(miArch.exists() && miArch.isFile())
            {
                guia = new FileInputStream(miArch);
                lector = new ObjectInputStream(guia);
                validar = true;
                while(true)
                {
                    miAux = (Persona) lector.readObject();
                    if(miAux != null)
                    {
                        miListado[con] = miAux;
                        con++;
                    }
                }
            }
            else
            {
                if(miArch.createNewFile())
                {
                    validar = true;
                    miListado[0] = FuncionesPrograma.getAdmin();
                    con++;
                }
            }
        }
        catch(EOFException eofe)
        {
            System.out.println("Ha finalizado la lectura del archivo");
        }
        catch(ClassNotFoundException cnfe)
        {
            System.out.println("La lectura de clase ha fallado");
            validar = false;
            clases = false;
        }
        catch(IOException ioe)
        {
            System.out.println("Ha ocurrido un problema con el manejo del archivo");
            validar = false;
            clases = false;
        }
        try
        {
            //--------------------Archivo de materias------------------------------------
            miMat = new File(materias);
            if(miMat.exists())
            {
                guia = new FileInputStream(miMat);
                lector = new ObjectInputStream(guia);
                clases = true;
                while(true)
                {
                    classAux = (Asignatura) lector.readObject();
                    if(miAux != null)
                    {
                        misMaterias[cla] = classAux;
                        cla++;
                    }
                }
            }
            else
            {
                clases = miMat.createNewFile();
            }
        }
        catch(EOFException eofe)
        {
            System.out.println("Ha finalizado la lectura del archivo");
        }
        catch(ClassNotFoundException cnfe)
        {
            System.out.println("La lectura de clase ha fallado");
            validar = false;
            clases = false;
        }
        catch(IOException ioe)
        {
            System.out.println("Ha ocurrido un problema con el manejo del archivo");
            validar = false;
            clases = false;
        }
        
        if(validar && clases)
        {
            do
            {
                try
                {
                    FuncionesPrograma.Menu();
                    System.out.println("Digite su opcion: ");
                    mp = inp.nextInt();
                    inp.nextLine();
                    switch(mp)
                    {
                        case 1:
                            System.out.println("Digite el nombre: ");
                            nombre = inp.nextLine();
                            validar = false;
                            for(int i=0;i<con; i++)
                            {
                                if(miListado[i].getUsuario().equals(nombre))
                                {
                                    while(intentos < 3)
                                    {
                                        System.out.println("Digite la constrasena: ");
                                        contrasena = inp.nextLine();
                                        if(miListado[i].getContrasena().equals(contrasena))
                                        {
                                            validar = true;
                                            miAux = miListado[i];
                                            break;
                                        }
                                    }
                                }
                            }
                            
                            intentos = 1;
                            if(validar)
                            {
                                nombre = miAux.getUsuario();
                                contrasena = miAux.getContrasena();
                                tipo = miAux.getTipo();
                                creacion = miAux.getCreacion();
                                edad = miAux.getEdad();
                                if(tipo == 'a')
                                {
                                    opt = 1;
                                }
                                else if(tipo == 'p')
                                {
                                    opt = 2;
                                }
                                else if(tipo == 'e')
                                {
                                    opt = 3;
                                }
                                else 
                                {
                                    opt = 4;
                                }
                                //opt=inp.nextInt();
                                switch(opt)
                                {
                                    case 1://admin
                                        admin = new Administrador(nombre, edad, creacion, contrasena);
                                        do
                                        {    
                                            admin.Menu();
                                            System.out.println("Digite su opcion: ");
                                            ntipo = inp.nextInt();
                                            switch(ntipo)
                                            {
                                                case 1: //Crear cuenta
                                                    System.out.println("Ingrese su nombre de usuario: ");
                                                    usuario=inp.next();
                                                    System.out.println("Ingrese la contraseña: ");
                                                    contrasena=inp.next(); //Lectura de datos de nueva cuenta
                                                    Date dat= new Date();
                                                    System.out.println("Ingrese la edad del usuario: ");
                                                    edad=inp.nextInt();
                                                    do  //Ciclo de validación de tipo a crear
                                                    {
                                                        System.out.println("+-------------------------------------+");
                                                        System.out.println("|         MENÚ Tipo de Persona        |");
                                                        System.out.println("+-------------------------------------+");
                                                        System.out.println("| 1) Administrador                    |");
                                                        System.out.println("| 2) Profesor                         |");
                                                        System.out.println("| 3) Estudiante                       |");
                                                        System.out.println("+-------------------------------------+");
                                                        tipochar=inp.nextInt();
                                                        switch(tipochar)  //Asignación de tipo
                                                        {
                                                            case 1:
                                                                tipo='a';
                                                                novalido = !novalido;
                                                                break;
                                                            case 2:
                                                                tipo='p';
                                                                novalido = !novalido;
                                                                break;
                                                            case 3:
                                                                tipo='e';
                                                                novalido = !novalido;
                                                            break;
                                                            default:
                                                                tipo =' '; 
                                                                System.out.println("Digite un tipo válido: ");
                                                            break;
                                                        }
                                                    }while(novalido);
                                                    miListado[con]=admin.CrearCuenta(usuario, edad, dat, contrasena, tipo);
                                                    con++;
                                                    break;    
                                                case 2: 
                                                    System.out.println("Ingrese el nombre de la asignatura: ");
                                                    nombremateria=inp.next();
                                                    System.out.println("Ingrese el nombre del profesor: ");
                                                    nombreprofe=inp.next();
                                                    valida=false; 
                                                    for(int j=0; j<con; j++)
                                                    {
                                                        if(miListado[j].getUsuario().equals(nombreprofe) && miListado[j].getTipo()=='p')
                                                        {
                                                            valida=true;
                                                        }
                                                    }
                                                    if(valida)
                                                    {
                                                        System.out.println("Poresor siendo guardado...");
                                                        System.out.println("Ingrese los creditos del profesor: ");
                                                        creditos=inp.nextInt();
                                                        inp.nextLine();
                                                        System.out.println("¿Desea digitar algunos estudiantes? (s/n)");
                                                        respuesta= inp.nextLine().charAt(0);
                                                        while(respuesta!='s' && respuesta!='n')
                                                        {
                                                            System.out.println(" Digite otra vez su respuesta ");
                                                            respuesta = inp.nextLine().charAt(0);
                                                        }
                                                        if(respuesta=='s')
                                                        {
                                                            for(int e=0; e<Asignatura.MS; e++)
                                                            {
                                                                plan[e] = null;
                                                            }
                                                            estu = 0;
                                                            for(int i=0; i<Asignatura.MS; i++)
                                                            {
                                                                System.out.println("Digite el nombre del estudiante (-1 para salir):");
                                                                nombre = inp.nextLine();
                                                                if(nombre.equals("-1"))
                                                                {
                                                                    System.out.println("Saliendo....");
                                                                    break;
                                                                }
                                                                for(int j=0; j<con; j++)
                                                                {
                                                                    encontrado = false;
                                                                    if(miListado[j].getUsuario().equals(nombreestudiante) && miListado[j].getTipo()== 'e')
                                                                    {
                                                                        edad = miListado[j].getEdad();
                                                                        creacion = miListado[j].getCreacion();
                                                                        contrasena = miListado[j].getContrasena();
                                                                        alaux = new Estudiante(nombre, edad, creacion, contrasena);
                                                                        plan[estu] = alaux;
                                                                        estu++;
                                                                        encontrado = true;                                                                            
                                                                    }
                                                                }
                                                                if(!encontrado)
                                                                {
                                                                    System.out.println("Estudiante inexistente, digite de nuevo o añado otro estudiante");
                                                                    i--;
                                                                }
                                                            }
                                                            misMaterias[cla] = admin.CrearAsigantura(nombremateria, nombreprofe, creditos, plan);
                                                            cla++;
                                                        }
                                                        else 
                                                        {
                                                            System.out.println("Muchas gracias su asignatura fue creada");
                                                            misMaterias[cla] = admin.CrearAsigantura(nombremateria, nombreprofe, creditos);
                                                            cla++;
                                                        }                                                            
                                                    } 
                                                    else 
                                                    {
                                                    System.out.println("El profesor no existe...");
                                                    }
                                                    break;
                                                case 3: //Eliminar Asignatura
                                                    break;
                                                case 4: //Modificar una asignatura
                                                    break;
                                                case 5:
                                                    System.out.println("Volviendo al menu general");
                                                break;
                                                default:
                                                    System.out.println("Desplegando el menu de nuevo");
                                                break;
                                            }
                                        }while(ntipo!=5);    
                                    break;
                                    case 2:
                                        profe = new Profesor(nombre, edad, creacion, contrasena);
                                        do
                                        {
                                            profe.Menu();
                                            System.out.println("Digite su opción:");
                                            opt2 = inp.nextInt();
                                            switch(opt2){
                                            case 1://    Verificar Proyectos
                                                break; 
                                            case 2:  //Mensaje a Estudiante
                                                System.out.println("Digite el nombre del estudiante para chatear: ");
                                                inp.nextLine();
                                                nombre = inp.nextLine();
                                                validar = false;
                                                for(int i=0; i<con; i++)
                                                {
                                                    if(miListado[i].getUsuario().equals(nombre) && miListado[i].getTipo() == 'e')
                                                    {
                                                        validar = true;
                                                        break;
                                                    }
                                                }
                                                if(validar)
                                                {
                                                    System.out.println("Abriendo chat...");
                                                    profe.chatearCon(nombre, inp);
                                                }
                                                else 
                                                {
                                                    System.out.println("El estudiante no existe...");
                                                }
                                                break; 
                                            case 3:  //Orientacion a Estudiante
                                                break; 
                                            case 4:  //Listar Estudiantes
                                                System.out.println("Digite el nombre de la materia a listar: ");
                                                nombre = inp.nextLine();
                                                for(int i=0; i<cla; i++)
                                                {
                                                    if(misMaterias[i].getNombre().equals(nombre) && misMaterias[i].getProfesor().equals(profe.getUsuario()))
                                                    {
                                                        profe.ListarEstudiante(misMaterias[i]);
                                                    }
                                                }
                                                break; 
                                            case 5:  //Listar Cursos
                                                System.out.println("Mostrando listado de cursos...");
                                                for(int j=0; j<cla; j++)
                                                {
                                                    if(misMaterias[j].getProfesor().equals(profe.getUsuario()))
                                                    {
                                                        System.out.println(misMaterias[j]);
                                                    }
                                                }
                                                break; 
                                            default:
                                                    System.out.println("Desplegando el menu de nuevo");
                                                break;
                                            }
                                            
                                        }while(opt2!=6);
                                    break;    
                                    case 3:
                                        alumno = new Estudiante(nombre, edad, creacion, contrasena);
                                        do
                                        {
                                            alumno.Menu();
                                            System.out.println("Digite su opción:");
                                            opt3 = inp.nextInt();
                                            switch(opt3)    //Estudiamnte
                                            {
                                                case 1: //ver cursos
                                                break;
                                                case 2: //enviar proyectos
                                                break;
                                                case 3: //Buzon de mensajeria
                                                    System.out.println("Digite el nombre del profesor para chatear: ");
                                                    inp.nextLine();
                                                    nombre = inp.nextLine();
                                                    validar = false;
                                                    for(int i=0; i<con; i++)
                                                    {
                                                        if(miListado[i].getUsuario().equals(nombre) && miListado[i].getTipo() == 'p')
                                                        {
                                                            validar = true;
                                                            break;
                                                        }
                                                    }
                                                    if(validar)
                                                    {
                                                        System.out.println("Abriendo chat...");
                                                        alumno.chatearCon(nombre, inp);
                                                    }
                                                    else 
                                                    {
                                                        System.out.println("El profesor no existe...");
                                                    }
                                                    break;
                                                case 4: //Inscribir un curso
                                                
                                                    System.out.print("Ingresa la asignatura que desea ");
                                                    inp.nextLine();
                                                    nombreasig = inp.nextLine();
                                                    for(int i=0; i<cla; i++)
                                                    {
                                                        if(misMaterias[i].getNombre().equals(nombreasig))
                                                        {
                                                            alumno.InscribirCurso(alumno, misMaterias[i]);
                                                        }
                                                        else
                                                        {
                                                            System.out.println("La clase no existe");    
                                                        }
                                                    }
                                                    System.out.print(" Inscribio Materia con exito ");                                                
                                                    break;
                                                case 5: //Cancelar un curso
                                                break;
                                                case 6:
                                                    System.out.println("Saliendo del programa");
                                                default:
                                                    System.out.println("Desplegando el menu de nuevo");
                                                break;
                                            }
                                        }while(opt3!=6);
                                    break;
                                    default:
                                        System.out.println("Desplegando el menu de nuevo");
                                    break;           
                                }//
                            }
                            else 
                            {
                                System.out.println("Login Fallido...");
                            }
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Volviendo a mostrar menu");
                            break;
                    }
                }
                catch (Exception e)
                {
                    System.out.println("Excepción atrapada:" + e.getMessage());
                }
            }while(mp!=4);
            try
            {
                //------------------Guardado de la planilla de usuarios-----------------
                miArch = new File(planilla);
                registro = new FileOutputStream(miArch);
                escritor = new ObjectOutputStream(registro);
                for(int i=0; i<con; i++)
                {
                    miAux = miListado[i];
                    escritor.writeObject(miAux);
                }
                System.out.println("Se ha guardado el archivo con éxito");
                escritor.close();
                //-------------------Guardado de asignaturas-----------------------------
                miMat = new File(materias);
                registro = new FileOutputStream(miMat);
                escritor = new ObjectOutputStream(registro);
                for(int i=0; i<cla; i++)
                {
                    classAux = misMaterias[i];
                    escritor.writeObject(classAux);
                }
            }
            catch(FileNotFoundException fnfe)
            {
                System.out.println("Ha ocurrido un problema con la escritura del archivo");
            }
            catch(IOException ioe)
            {
                System.out.println("No se ha guardado con éxito el archivo");
            }
        }
        else 
        {
            if(!validar)
            {
                System.out.println("Sin validación de lectura no se puede crear el programa");
            }
            if(!clases)
            {
                System.out.println("Fallo en las asignaturas");
            }
        }
        System.out.println("Gracias por usar el programa...\nSaliendo...");
        inp.close();
    }
}
