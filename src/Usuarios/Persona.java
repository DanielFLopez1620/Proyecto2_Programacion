package Usuarios;

import java.io.Serializable;
import java.util.Date;


public class Persona implements Serializable
{
    protected String usuario;
    protected String contrasena;
    protected int edad;
    protected Date creacion;
    protected char tipo;
    /**
     * Constructor único de la clase Persona
     * @param usuario
     * @param edad
     * @param creacion
     * @param contrasena
     */
    public Persona(String usuario, int edad, Date creacion, String contrasena)
    {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.edad = edad;
        this.creacion = creacion;
    }
    public Persona(String usuario, int edad, Date creacion, String contrasena, char tipo)
    {
        this(usuario, edad, creacion, contrasena);
        this.tipo = tipo;
    }
    public String getUsuario() 
    {
        return usuario;
    }
    /**
     * Set para fijar el nombre del usuario
     * @param usuario
     */
    public void setUsuario(String usuario) 
    {
        this.usuario = usuario;
    }
    /**
     * Obtener el nombre del usuario
     * @return contrasena
     */
    public String getContrasena() 
    {
        return contrasena;
    }
    /**
     * Set para modificar las contraseñas del usuario
     * @param contrasena
     */
    public void setContrasena(String contrasena) 
    {
        this.contrasena = contrasena;
    }
    /**
     * Obtener la edad del usuario
     * @return
     */
    public int getEdad() 
    {
        return edad;
    }
    /**
     * Set para modificar la edad del usuario
     * @param edad
     */
    public void setEdad(int edad) 
    {
        this.edad = edad;
    }
    /**
     * Obtener la fecha cuando fue creada la cuenta del usuario
     * @return
     */
    public Date getCreacion() 
    {
        return creacion;
    }
    /**
     * Set para modificar la fecha de cracion de la cuenta del usuario
     * @param creacion
     */
    public void setCreacion(Date creacion) 
    {
        this.creacion = creacion;
    }
    /**
     * Obtener el tipo de cuenta del usuario
     * @return 
     */
    public char getTipo() 
    {
        return tipo;
    }
    //public abstract void Menu();

    @Override
    public String toString() 
    {
        String cadena = "";
        cadena = "Usuario: " + this.usuario + "\nContraseña: " + this.contrasena;
        cadena += "\nCreacion: " + this.creacion + "\nTipo: " + this.tipo;
        return cadena;
    }
}
