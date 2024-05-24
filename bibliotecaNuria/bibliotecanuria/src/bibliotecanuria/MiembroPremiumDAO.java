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
public class MiembroPremiumDAO {
    //Método para OBTENER Y MOSTRAR los detalles de todos los miembrosPremium.
    public static void printMPDetails(){
        String query = "SELECT * FROM MiembroPremium";
        try(Connection conn = DatabaseConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query)){
            
            while(rs.next()){
                int id_MP = rs.getInt("id_MP");
                String nombre_MP = rs.getString("nombre_MP");
                String rol = rs.getString("rol");
            
                System.out.println("  - " + rol + " con ID " + id_MP + " | Nombre: " + nombre_MP);
            }
                      
        }catch(SQLException e){
            System.out.println("Oh, oh... Error con el printAutorDetails.");
            e.printStackTrace(); //Ens tornaria el trazo del error, ens diu quin error hi ha al SQL.
        }
    }
    
    //Método para INSERTAR los detalles de todos los MIEMBROS PREMIUM.
    public static void insertMP(String nombre_MP, String rol){
        String query = "INSERT INTO MiembroPremium (nombre_MP, rol) VALUES (?, ?);";
        try(Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)){
                pstmt.setString(1, nombre_MP); // El número es la posició de l'atribut, el nom es el mateix que hem posat als parèntesis de dalt.
                pstmt.setString(2, rol);
                pstmt.executeUpdate();
                
                System.out.println("¡Tenemos un nuevo " + rol + " en nuestra biblioteca! Te damos la bienvenida " + nombre_MP + ".");
                
        }catch(SQLException e){
            System.out.println("Oh, oh... Error con el insertMP.");
            e.printStackTrace();
        }
    }
    
}
