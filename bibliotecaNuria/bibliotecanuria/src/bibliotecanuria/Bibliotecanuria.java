/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bibliotecanuria;

/**
 *
 * @author nuria
 */
public class Bibliotecanuria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //UsuarioDAO.insertUsuario("Kevin Martínez", "usuario");
        //UsuarioDAO.printUsuarioDetails();
        
        //AutorDAO.insertAutor("Mercè Rodoreda", 1908, 1983);
        //AutorDAO.printAutorDetails();
    
        //LibroDAO.insertLibro("La plaça del diamant", "Mercè Rodoreda", true);
        //LibroDAO.printLibroDetails();
    
        //MiembroPremiumDAO.insertMP("Jana Llorent", "miembro premium");
        //MiembroPremiumDAO.printMPDetails();
        //AutorDAO.deleteAutor(5, "Carlos Ruiz Zafón");
        //AutorDAO.printAutorDetails();
        
        //LibroDAO.deleteLibro(10, "La plaça del diamant");
        //LibroDAO.printLibroDetails();
        
         System.out.println("AUTORES Y LIBROS:");
        
            //Lista de libros publicados por el autor ID 1
                //Detalles del autor ID 1
                    AutorDAO.printOneAutorDetails(1);
                           
                //Libros publicados por el autor ID 1 (Se imprime en la consola)
                    AutorDAO.printAutorLibroDetails(1);       
                
        System.out.println("");
        
        //Autor ID 2 - Libros
       
            
                //Lista de libros publicados por el autor ID 2
                //Detalles del autor ID 2
                    AutorDAO.printOneAutorDetails(2);
                           
                //Libros publicados por el autor ID 2 (Se imprime en la consola)
                    AutorDAO.printAutorLibroDetails(2);       
                
        System.out.println("");
        
        //Autor ID 3 - Libros
          
             //Lista de libros publicados por el autor ID 3
                //Detalles del autor ID 3
                    AutorDAO.printOneAutorDetails(3);
                           
                //Libros publicados por el autor ID 3 (Se imprime en la consola)
                    AutorDAO.printAutorLibroDetails(3);       
                
        System.out.println("");
        
        //Autor ID 4 - Libros
            
            
            //Lista de libros publicados por el autor ID 4
                //Detalles del autor ID 4
                    AutorDAO.printOneAutorDetails(4);
                           
                //Libros publicados por el autor ID 4 (Se imprime en la consola)
                    AutorDAO.printAutorLibroDetails(4);
                    
        //Autor ID 6 - Libros
            
            //Lista de libros publicados por el autor ID 6
                //Detalles del autor ID 6
                    AutorDAO.printOneAutorDetails(6);
                           
                //Libros publicados por el autor ID 6 (Se imprime en la consola)
                    AutorDAO.printAutorLibroDetails(6); 
        
        

    }
    
}
