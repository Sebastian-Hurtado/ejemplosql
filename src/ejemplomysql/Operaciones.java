
package ejemplomysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.ResultSet;

public class Operaciones {
    
    final String  tabla = "ejemplo1";
    
    public void guardar(Connection conexion){
        try {
 
        PreparedStatement consulta;
        
        consulta = conexion.prepareStatement("INSERT INTO " + this.tabla + 
                "(CEDULA,NACIONALIDAD,NOMBRE) VALUES(?,?,?)");
        
        consulta.setInt(1, 1234567);
        consulta.setString(2, "BOGOTANO");
        consulta.setString(3, "NESTOR");
        
        
        
        consulta.executeUpdate();
        
        System.out.println("Escritura exitosa");
        
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public void borrar(Connection conexion){
        try  {
           PreparedStatement borrar;
           
           borrar= conexion.prepareStatement("DELETE FROM ejemplo1 WHERE CEDULA =?");
           
           borrar.setInt(1,1012449193);
           borrar.executeUpdate();
           System.out.println("los datos fueron borrados ");
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void modificar(Connection conexion){
        try  {
            PreparedStatement modificar;
            int x;
            modificar = conexion.prepareStatement("UPDATE ejemplo1 SET CEDULA = ?, NACIONALIDAD = ?, NOMBRE = ? WHERE CEDULA = ?");
           
            
            modificar.setInt(1, 1012377980);
            modificar.setString(2, "irlandes");
            modificar.setString(3,"Daniel");
            modificar.setInt(4, 28177497);// Cambia 1 por el valor de la clave primaria que desees modificar

            // Ejecuta la actualización de datos
            int filasActualizadas = modificar.executeUpdate();

            // Verifica cuántas filas se actualizaron
            System.out.println("Se actualizaron " + filasActualizadas + " filas.");
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void consulta(Connection conexion){
        try  {
           PreparedStatement consulta;
           
           consulta= conexion.prepareStatement("SELECT * FROM ejemplo1 WHERE CEDULA = ?");
           consulta.setInt(1, 1012377980);
           
           ResultSet resultSet = consulta.executeQuery();
           while (resultSet.next()) {
                // Recupera los valores de las columnas
                int columna1 = resultSet.getInt("CEDULA");
                String columna2 = resultSet.getString("NACIONALIDAD");
                String columna3 = resultSet.getString("NOMBRE");
                // Realiza alguna acción con los resultados
                System.out.println("Columna1: " + columna1 + ", Columna2: " + columna2+" Columna3: "+columna3);
            }
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static String capturarDatos(String mensaje){
        Scanner scanner = new Scanner(System.in);
        System.out.println(mensaje);
        String tomadeDatos;
        tomadeDatos = scanner.nextLine();
        
        return tomadeDatos;
    }
    
}
