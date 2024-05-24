/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bibliotecanuria;
import java.util.*;

/**
 *
 * @author nuria
 */
public class Autor {
    //Declaro los atributos como privados
        //private int id_Autor;
        private String nombre_Autor;
        private int anoNacimiento;
        private int anoMuerte;
        private List<Libro> listaLibrosAutor; //Creo una lista de libros que añadiré dentro de cada autor.
    
    /*Creo el constructor público para la clase Autor y le paso los argumentos (atributos) 
    privados que he declarado anteriormente (ahora serán accesibles con el constructor)*/
        public Autor(String nombre){
            //this.id_Autor = id_Autor;
            this.nombre_Autor = nombre_Autor;
            this.anoNacimiento = anoNacimiento;
            this.anoMuerte = anoMuerte;
            this.listaLibrosAutor = new ArrayList<>(); //Inicializo la lista que se me creará cada vez que cree un autor.
            AutorDAO.insertAutor(nombre_Autor, anoNacimiento, anoMuerte);
        }           
    
    //Creo métodos para coger el valor de los diferentes argumentos.
        public String getNombreAutor(){ //Método para coger el nombre.
            return nombre_Autor;
        }
        
        /*public List<Libro> getListaLibrosAutor(){ //Método para coger la lista de libros de cada autor.
            return listaLibrosAutor;
        }
        
    //Creo métodos para volver a llamar/cambiar los argumentos.
        public void setNombreAutor(String nombreAutorNuevo){ //Método para llamar/cambiar el nombre.
            this.nombre_Autor = nombreAutorNuevo;
        }*/
        
    //Otros métodos
        //El autor publica (y por lo tanto crea) un libro.
        public void publicarLibro(String titulo, String autor){
            /*Libro nuevoLibro = new Libro(titulo, autor); //El "this" hace referencia al autor (como estamos en la clase Autor) ya queda implícito.
            System.out.println("¡" + this.nombre_Autor + " ha publicado " + titulo + "!");
                //Añado un libro dentro de la lista de libros de cada autor.
                listaLibrosAutor.add(nuevoLibro);
                System.out.println("Se ha añadido el libro a la lista de libros de " + this.nombre_Autor + ".\n");
                
            return nuevoLibro;*/
            LibroDAO.insertLibro(titulo, autor, true);
            System.out.println(this.nombre_Autor + "ha publicado" + titulo + " y se ha añadido a su lista de libros.\n");
        }
        
        //Imprimir lista libros Autor
        public void imprimirListaLibrosAutor(){
            
            System.out.println("Lista de libros de " + this.nombre_Autor + ":");
            //AutorDAO1.printAutorLibroDetails(id_Autor);
            /*for(Libro libroA : listaLibrosAutor){ //Con el FOR recorro la lista de libros del autor, que se encuentra en la clase Autor (como es la clase donde estamos no le digo en qué clase está)
                System.out.println("    - " + libroA.getTituloLibro()); //Imprimo los libros del autor.
            }
            System.out.println("");
            return listaLibrosAutor;*/
        }
    
}
