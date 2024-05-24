/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bibliotecanuria;
import java.sql.*;
import java.util.*;



/**
 *
 * @author nuria
 */
public class UsuarioDAO {
    //Método para OBTENER Y MOSTRAR los detalles de todos los usuarios.
    public static void printUsuarioDetails(){
        String query = "SELECT * FROM Usuario";
        try(Connection conn = DatabaseConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query)){
            
            while(rs.next()){
                int id_Usuario = rs.getInt("id_Usuario");
                String nombre_Usuario = rs.getString("nombre_Usuario");
                String rol = rs.getString("rol");
            
                System.out.println("  - " + rol + " con  ID " + id_Usuario + " | Nombre: " + nombre_Usuario);
            }
                   
        }catch(SQLException e){
            System.out.println("Oh, oh... Error con el printAutorDetails.");
            e.printStackTrace(); //Ens tornaria el trazo del error, ens diu quin error hi ha al SQL.
        }
    }
    
       
    //Método para INSERTAR los detalles de todos los USUARIOS.
    public static void insertUsuario(String nombre_Usuario, String rol){
        String query = "INSERT INTO Usuario (nombre_Usuario, rol) VALUES (?, ?);";
        try(Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)){
                pstmt.setString(1, nombre_Usuario); // El número es la posició de l'atribut, el nom es el mateix que hem posat als parèntesis de dalt.
                pstmt.setString(2, rol);
                pstmt.executeUpdate();
                
                System.out.println("¡Tenemos un nuevo " + rol + " en nuestra biblioteca! Te damos la bienvenida " + nombre_Usuario + ".");
                
        }catch(SQLException e){
            System.out.println("Oh, oh... Error con el insertUsuario.");
            e.printStackTrace();
        }
    }
    
    //Método para INSERTAR los detalles de todos los USUARIOS.
    public static void insertUsuarioLibroPrestado(int id_Usuario, String nombre_Usuario, int id_Libro, String titulo){
        String query = "INSERT INTO Usuario_LibrosPrestados (id_Usuario, nombre_Usuario, id_Libro, titulo) VALUES (?, ?, ?, ?);";
        try(Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)){
                pstmt.setInt(1, id_Usuario); // El número es la posició de l'atribut, el nom es el mateix que hem posat als parèntesis de dalt.
                pstmt.setString(2, nombre_Usuario);
                pstmt.setInt(3, id_Libro);
                pstmt.setString(4, titulo);
                pstmt.executeUpdate();
                
                System.out.println("   - " + nombre_Usuario + ", has cogido prestado el libro " + titulo); //imprimo información para ver en la terminal y...
                        
        }catch(SQLException e){
            System.out.println("Oh, oh... Error con el insertUsuario.");
            e.printStackTrace();
        }
    }
    
    
    public static void insertUsuarioLibroPrestadoSiExiste(String nombre_Usuario, String titulo){
        String query = "INSERT INTO Usuario_LibrosPrestados (id_Usuario, nombre_Usuario, id_Libro, titulo) SELECT u.id_Usuario, u.nombre_Usuario, l.id_Libro, l.titulo FROM Usuario u, Libro l WHERE u.nombre_Usuario = ? and l.titulo = ?;";
    
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)){
                
            pstmt.setString(1, nombre_Usuario); // El número es la posició de l'atribut, el nom es el mateix que hem posat als parèntesis de dalt.
            pstmt.setString(2, titulo); 
            pstmt.executeUpdate();    
                
        }catch(SQLException e){
            System.out.println("Oh, oh... Error con el insertUsuario.");
            e.printStackTrace();
        }
    }
    
    
    public static List<String> getAllUsersName(){
        List<String> usersName = new ArrayList<>();
        
        String query = "SELECT nombre_usuario from usuario;";
        try(Connection conn = DatabaseConnection.getConnection();
              Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query)){
            
            while(rs.next()){
                usersName.add(rs.getString("nombre_usuario"));
            }
                
         }catch(SQLException e){
            System.out.println("Oh, oh... Error con el insertUsuario.");
            e.printStackTrace();
        }
        return usersName;
    }
    
    
    
 
    
    
    
    
    
    public static void insertUsuarioLibroPrestadoSiExiste3(int id_Usuario, String nombre_Usuario, int id_Libro, String titulo){
        String query = "INSERT INTO Usuario_LibrosPrestados (id_Usuario, nombre_Usuario, id_Libro, titulo) SELECT u.id_Usuario, u.nombre_Usuario, l.id_Libro, l.titulo FROM Usuario u, Libro l WHERE u.nombre_Usuario = ? and l.titulo = ?;";
        try(Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)){
                pstmt.setString(1, nombre_Usuario); // El número es la posició de l'atribut, el nom es el mateix que hem posat als parèntesis de dalt.
                pstmt.setString(2, titulo);
                pstmt.executeUpdate();
                /*if (nombre_Usuario == pstmt.setString(1, nombre_Usuario) && titulo == pstmt.setString(2, titulo)) {
                    System.out.println("   - " + nombre_Usuario + ", has cogido prestado el libro " + titulo);
                }*/
            /*    if (nombre_Usuario == nombre_Usuario){
                    if (titulo == titulo) {
                    System.out.println("   - " + nombre_Usuario + ", has cogido prestado el libro " + titulo);
                } }
                if(nombre_Usuario != nombre_Usuario){
                    System.out.println("El usuario " + nombre_Usuario + " no existe en nuestra base de datos.");
                    if (titulo != titulo){
                        System.out.println("No hemos encontrado el libro " + titulo + " en nuestra biblioteca.");
                    }
                };*/
                       
        }catch(SQLException e){
            System.out.println("Oh, oh... Error con el insertUsuario.");
            e.printStackTrace();
        }
    }
    
    /*public static void insertUsuarioLibroPrestadoSiExiste2(int id_Usuario, String nombre_Usuario, int id_Libro, String titulo){
        String query = "INSERT INTO Usuario_LibrosPrestados (id_Usuario, nombre_Usuario, id_Libro, titulo) "
                     + "SELECT u.id_Usuario, u.nombre_Usuario, l.id_Libro, l.titulo "
                     + "FROM Usuario u, Libro l "
                     + "WHERE u.nombre_Usuario = ? and l.titulo = ? and EXISTS ( "
                     + "SELECT 1 "
                     + "FROM Usuario u, Libro l "
                     + "WHERE u.nombre_Usuario = ? and l.titulo = ?);";
        try(Connection conn = conexionBDD.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)){
                pstmt.setString(1, nombre_Usuario); // El número es la posició de l'atribut, el nom es el mateix que hem posat als parèntesis de dalt.
                pstmt.setString(2, titulo);
                pstmt.getString(3, "u.nombre_Usuario");
                pstmt.setString(4, l.titulo);
                pstmt.executeUpdate();
                
                //Statement stmt = conn.createStatement();
                ResultSet rs = pstmt.executeQuery(query)){
            
            while(rs.next()){
                int id_Usuario = rs.getInt("id_Usuario");
                /*if (nombre_Usuario == pstmt.setString(1, nombre_Usuario) && titulo == pstmt.setString(2, titulo)) {
                    System.out.println("   - " + nombre_Usuario + ", has cogido prestado el libro " + titulo);
                }*/
            /*    if (nombre_Usuario == nombre_Usuario){
                    if (titulo == titulo) {
                    System.out.println("   - " + nombre_Usuario + ", has cogido prestado el libro " + titulo);
                } }
                if(nombre_Usuario != nombre_Usuario){
                    System.out.println("El usuario " + nombre_Usuario + " no existe en nuestra base de datos.");
                    if (titulo != titulo){
                        System.out.println("No hemos encontrado el libro " + titulo + " en nuestra biblioteca.");
                    }
                };
                       
        }catch(SQLException e){
            System.out.println("Oh, oh... Error con el insertUsuario.");
            e.printStackTrace();
        }
    }*/
    
    
    
    
    public static void devolverLibroPrestado(int id_Libro, String titulo){
        String query = "DELETE FROM Usuario_LibrosPrestados WHERE id_Libro = ?;";
        try(Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)){
                pstmt.setInt(1, id_Libro); // El número es la posició de l'atribut, el nom es el mateix que hem posat als parèntesis de dalt.
                //pstmt.setString(2, titulo);
                pstmt.executeUpdate();
                
                System.out.println("   - Se ha devuelto " + titulo + " correctamente.\n"); //imprimo información para ver en la terminal y...
                        
        }catch(SQLException e){
            System.out.println("Oh, oh... Error con el devolverLibroPrestado.");
            e.printStackTrace();
        }
    }
    
    
    //Método para BORRAR los detalles de un USUARIO.
    public static void deleteLibro(int id_Usuario){
        String query = "DELETE FROM Usuario WHERE id_Usuario = ?;";
        try(Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)){
                pstmt.setInt(1, id_Usuario); // El número es la posició de l'atribut, el nom es el mateix que hem posat als parèntesis de dalt.
                pstmt.executeUpdate();
                
        }catch(SQLException e){
            System.out.println("Oh, oh... Error con el deleteUsuario.");
            e.printStackTrace();
        }
    }
    
}
