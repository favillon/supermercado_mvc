/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermercado.Models;

import supermercado.Config.DataConfig;
/**
 *
 * @author user
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {      
    
    // Configuración de conexión
    private static final String StringCon = DataConfig.STRING_URL_BD;
    private static final String UserDB = DataConfig.USER_DB;
    private static final String PassDB = DataConfig.PASS_DB;
     private static final String  Driver = DataConfig.STRING_DRIVER;//"com.mysql.cj.jdbc.Driver"
    private static Connection conexion = null;

    // Método para obtener la conexión
    public static Connection getConnection() {
        if (conexion == null) {
            try {
                // Registrar el driver de MySQL
                Class.forName(Driver);

                // Crear la conexión
                conexion = DriverManager.getConnection(StringCon, UserDB, PassDB);
                System.out.println("Conexión exitosa a MySQL.");
            } catch (ClassNotFoundException e) {
                System.err.println("Error: Driver MySQL no encontrado.");
                e.printStackTrace();
            } catch (SQLException e) {
                System.err.println("Error: No se pudo conectar a la base de datos.");
                e.printStackTrace();
            }
        }
        return conexion;
    }

    // Método para cerrar la conexión
    public static void closeConnection() {
        if (conexion != null) {
            try {
                conexion.close();
                conexion = null; // Evitar reusos de conexiones cerradas
                System.out.println("Conexión cerrada correctamente.");
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión.");
                e.printStackTrace();
            }
        }
    }
}