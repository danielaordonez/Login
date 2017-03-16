/*
 * Con esta clase nos conectamos a la base de datos
 */
package iniciosesion.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectar {
    private static Connection conexion;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String usuario="root";
    private static final String clave="1234";
    private static final String url="jdbc:mysql://localhost:3306/prueba_login";

    //constructor
    public Conectar() {
        conexion=null;
        
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url,usuario,clave);
            if(conexion!=null){
                System.out.println("Conexion a la base de datos establecida correctamente");
            }
        } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Ocurrió un error en la conexion a la base de datos");
        }
    }
    
    //este metodo nos retorna la conexion a la base de datos
    public Connection getConnection(){
        return conexion;
    }
    
    
    //con este metodo nos desconectamos de la base de datos
    public void desconectar(){
        conexion=null;
        if(conexion==null){
            System.out.println("Conexion finalizada");
        }
    }   
    
}
