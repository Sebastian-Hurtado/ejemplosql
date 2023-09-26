
package ejemplomysql;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class EjemploMysql {
    
    private static java.sql.Connection con;
    
    public static String driver  = "com.mysql.jdbc.Driver";
    public static String user = "root";
    public static String pass = "";
    public static String url = "jdbc:mysql://localhost:3306/ejemplosql";
    
    public static void main(String[] args) throws SQLException{
        
        con = null;
        try {

            con =  DriverManager.getConnection(url, user, pass);
            if (con != null) {
                System.out.println("Conexión exitosa");
            }
        } catch (SQLException e) {
            System.out.println("Conexión no exitosa");
        }
           
        Operaciones operacion = new Operaciones();
        
        //operacion.guardar(con);
        //operacion.modificar(con);
        //operacion.borrar(con);
        operacion.consulta(con);
    }
    public void finalizar (Connection conexion){
        if(conexion != null){
            try{
                conexion.close();
                conexion= null;
            }catch(SQLException ex){
                System.out.println(ex.getMessage()+"error");
            } 
        }       
    }
    
    
}
// "jdbc:mysql://localhost:3306/dbtarde";