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

public class MiembroPremium extends Usuario {
    //Declaro los atributos como privados
        private List<Libro> listaLibrosReservados; //Creo una lista de libros reservados que añadiré dentro de cada miembro premium.
    
    /*Creo el constructor público para la clase Usuario y le paso los argumentos (atributos) 
    privados que he declarado anteriormente (ahora serán accesibles con el constructor)*/
        public MiembroPremium(String nombre_MP, String rol){
            super(nombre_MP, rol);
            this.listaLibrosReservados = new ArrayList<>(); //Inicializo la lista que se me creará cada vez que cree un miembro premium.
            MiembroPremiumDAO.insertMP(nombre_MP, rol);
        }
        
    //Creo métodos para coger el valor de los diferentes argumentos.     
        public List<Libro> getListaLibrosReservados(){ //Método para coger la lista de libros reservados (de cada miembro premium).
            return listaLibrosReservados;
        }
        
        public String getNombreMiembroPremium(){ //Método para coger el nombre de la clase padre (Usuario)
            return super.getNombreUsuario();
        }
    
    //Otros métodos
        //El miembro Premium reserva un libro
        public void reservarLibro(String titulo){
            boolean libroExistenteC = false;
            
            for(Libro libroZ : Libro.getListaLibrosGenerica()){ //Con el FOR recorro la lista de libros generica, que se encuentra en la clase Libro
                if(libroZ.getTituloLibro().equals(titulo)){ //Si el título del libro (clase Libro) coincide con el titulo que le he pasado (a través de la clase MiembroPremium)...
                    
                    libroExistenteC = true; //... le marco el boolean como TRUE y...
                    boolean dispoLibro = libroZ.getDisponibilidadLibro(); //... creo e inicializo una variable tipo boolean que referencia a (es la misma que) "disponibilidad" de la clase Libro (la cojo con el get);
                    
                    if(dispoLibro == false){ //si la disponibilidad del libro es FALSE,
                        System.out.println(this.getNombreMiembroPremium() + ", has reservado el libro " + libroZ.getTituloLibro() + " porque actualmente no está disponible.\n  Cuando esté disponible te llegará un mensaje al correo.\n  Puedes consultar todas tus reservas en el apartado <<Reservas>> de tu cuenta."); //imprimo que el libro no está disponible y le digo que lo ha reservado...
                       
                        listaLibrosReservados.add(libroZ); //...añado el libro a la lista de libros reservados del Miembro Premium que ha reservado el libro.
                        
                        System.out.println(""); //Imprimo una línea en blanco.
                        
                    } else { //Si la disponibilidad del libro NO ES FALSE...
                        System.out.println(this.getNombreMiembroPremium() + ", el libro que quieres reservar (" + libroZ.getTituloLibro() + ") está disponible, así que...\n   ¡puedes ir a buscarlo cuando quieras!\n"); //...imprimo que el libro está disponible y que lo puede tomar prestado.
                        super.cogerLibroPrestado(titulo); //Implementa el método para coger un libro prestado (este método está en la clase Usuarios; ponemos super para que el programador que lea el código pueda ver más fácilmente que se trata de la clase padre de MiembroPremium).
                        
                    } break; //Paro el bucle FOR (cuando se encuentra un libro de la lista de libros genérica y ha implementado el resto de métodos, ya no busca más).
                }
            }
            if (libroExistenteC == false){ //Una vez recorrida la lista de libros genérica, si el título del libro (clase Libro) no coincide con el título que le he pasado, le marco FALSE.
                System.out.println("No hemos encontrado el libro " + titulo); //Imprimimos que no hemos encontrado el libro con el título que le ha pasado el usuario.
            }
        }
        
        public List<Libro> imprimirListaLibrosReservados(){
            
            System.out.println("Lista de libros reservados de " + this.getNombreMiembroPremium() + ":");

            for(Libro libroP : listaLibrosReservados){ //Con el FOR recorro la lista de libros reservados, que se encuentra en la clase MiembroPremium (como es la clase donde estamos no le digo en qué clase está)
                System.out.println("    - " + libroP.getTituloLibro()); //Imprimo los libros reservados por el usuario.
            }
            System.out.println("");
            return listaLibrosReservados;
        }
}