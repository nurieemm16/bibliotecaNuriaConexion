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
public class Usuario {//Declaro los atributos como privados
        private static String nombre_Usuario;
        private String rol;
        private List<Libro> listaLibrosPrestados; //Creo una lista de libros prestados que añadiré dentro de cada usuario.
    
    /*Creo el constructor público para la clase Usuario y le paso los argumentos (atributos) 
    privados que he declarado anteriormente (ahora serán accesibles con el constructor)*/
        public Usuario(String nombre_Usuario, String rol){
            this.nombre_Usuario = nombre_Usuario;
            this.rol = rol;
            this.listaLibrosPrestados = new ArrayList<>(); //Inicializo la lista que se me creará cada vez que cree un usuario.
            UsuarioDAO.insertUsuario(nombre_Usuario, rol);
        }
    
    //Creo métodos para coger el valor de los diferentes argumentos.
        public static String getNombreUsuario(){ //Método para coger el nombre.
            return nombre_Usuario;
        }
        
        public List<Libro> getListaLibrosPrestados(){ //Método para coger la lista de libros prestados (de cada usuario).
            return listaLibrosPrestados;
        }
        
    //Creo métodos para volver a llamar/cambiar los argumentos.
        public void setNombreUsuario(String nombreUsuarioNuevo){ //Método para llamar/cambiar el nombre.
            this.nombre_Usuario = nombreUsuarioNuevo;
        }
        
    //Otros métodos
        //El usuario coge un libro.     
        
       
        public static void cogerLibroPrestado(String titulo){
            boolean libroExistenteA = false;
            
            for(Libro libroX : Libro.getListaLibrosGenerica()){ //Con el FOR recorro la lista de libros generica, que se encuentra en la clase Libro
                /*if(libroX.getTituloLibro().equals(titulo)){ //Si el título del libro (clase Libro) coincide con el titulo que le he pasado (a través de la clase Usuario)...
                    
                    /*libroExistenteA = true; //... le marco el boolean como TRUE y...
                    /*boolean dispoLibro = libroX.getDisponibilidadLibro(); //... creo e inicializo una variable tipo boolean que referencia a (es la misma que) "disponibilidad" de la clase Libro (la cojo con el get);
                    
                    if(dispoLibro == true){ //si la disponibilidad del libro es TRUE,
                        
                        System.out.println(Usuario.getNombreUsuario() + ", has cogido prestado el libro " + libroX.getTituloLibro() + ".\n          Te recordamos que tendrás que devolverlo en un plazo máximo de 30 días.\n          Puedes consultar todos tus préstamos en el apartado <<Préstamos>> de tu cuenta."); //imprimo información para ver en la terminal y...
                        
                        //listaLibrosPrestados.add(libroX); //...añado el libro a la lista de libros prestados del Usuario que ha cogido prestado el libro.
                        libroX.marcarLibroPrestado(); //implemento el método "marcarLibroPrestado()" de la clase Libro y...
                        
                        System.out.println(""); //Imprimo una línea en blanco.
                        
                    } else { //Si la disponibilidad del libro NO ES TRUE...
                        System.out.println("El libro " + libroX.getTituloLibro() + " no está disponible."); //...imprimo que el libro no está disponible.
                    } break; //Paro el bucle FOR (cuando se encuentra un libro de la lista de libros genérica y ha implementado el resto de métodos, ya no busca m?s).
                }*/
            }
            if (libroExistenteA == false){ //Una vez recorrida la lista de libros genérica, si el título del libro (clase Libro) no coincide con el título que le he pasado, le marco FALSE.
                System.out.println("\nLo sentimos, no hemos encontrado el libro " + titulo + "."); //Imprimimos que no hemos encontrado el libro con el título que le ha pasado el usuario.
            }
        }
        
        //El usuario devuelvo un libro.
        public void devolverLibro (String titulo){
            boolean libroExistenteB = false;
            
            for(Libro libroY : listaLibrosPrestados){ //Con el FOR recorro la lista de libros prestados, que se encuentra en la clase Usuario (como es la clase donde estamos no le digo en qué clase está)
                if(libroY.getTituloLibro().equals(titulo)){ //Si el título del libro (clase Libro) coincide con el titulo que le he pasado (a través de la clase Usuario)...
                    
                    libroExistenteB = true; //... le marco el boolean como TRUE;
                    
                        //No hace falta mirar si está disponible o no el libro porque estamos mirando solo la lista de libros prestados.
                        
                        System.out.println(this.nombre_Usuario + ", has devuelto el libro " + libroY.getTituloLibro() + ".\n  Podrás comprobar que ya no se encuentra en el apartado de <<Préstamos>> de tu cuenta."); //Imprimo información para ver en la terminal.
                        
                        listaLibrosPrestados.remove(libroY); //elimino el libro de la lista de libros prestados del Usuario que ha devuelto el libro e...
                        libroY.marcarLibroDevuelto(); //...implemento el método "marcarLibroDevuelto()" de la clase Libro.
                        
                        System.out.println(""); //Imprimo una l?nea en blanco.
                        
                } break; //Paro el bucle FOR (cuando se encuentra un libro de la lista de libros genérica y ha implementado el resto de métodos, ya no busca más).
            }           
            if (libroExistenteB == false){ //Una vez recorrida la lista de libros prestados, si el título del libro (clase Libro) no coincide con el título que le he pasado, le marco FALSE.
                System.out.println("No hemos encontrado el libro " + titulo + " entre los libros que tienes prestados actualmente."); //Imprimimos que no hemos encontrado el libro con el t?tulo que le ha pasado el usuario.
            }
        }
        
        //Escribir lista libros prestados
        public List<Libro> imprimirListaLibrosPrestados(){
            
            System.out.println("Lista de libros prestados de " + this.nombre_Usuario + ":");
            
            for(Libro libroP : listaLibrosPrestados){ //Con el FOR recorro la lista de libros prestados, que se encuentra en la clase Usuario (como es la clase donde estamos no le digo en qué clase está)
                System.out.println("    - " + libroP.getTituloLibro()); //Imprimo los libros prestados por el usuario. 
            }
            System.out.println("");
            return listaLibrosPrestados;
        }
        
        
        public static List<String> getAllUsersName(){
            return  UsuarioDAO.getAllUsersName();
        }
        
        
        public static boolean isUserInList(String nombre){
            List<String> userName = Usuario.getAllUsersName();
            return userName.contains(nombre); // si contiene el nombre TRUE si no lo tiene FALSE      
        }
        
        
        public static void insertUsuarioLibroPrestadoSiExiste(String nombre_Usuario, String titulo){            
            if(Usuario.isUserInList(nombre_Usuario)){
                if(Libro.isLibroInList(titulo)){
                    if(Libro.getDisponibilidad(titulo)){
                        UsuarioDAO.insertUsuarioLibroPrestadoSiExiste(nombre_Usuario, titulo);
                        Libro.cambiarDisponibilidad(titulo, false);
                    }else{
                        System.out.println("El libro " + titulo + " no se encuentra disponible.");
                    }
                }else {
                    System.out.println("El libro " + titulo + " no existe.");
                }     
            }else{
                System.out.println("El susuario " + nombre_Usuario + " no existe.");
            }       
        }
    
}
