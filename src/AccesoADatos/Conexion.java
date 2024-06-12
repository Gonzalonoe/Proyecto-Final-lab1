/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatos;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {
    
    private static final String URL="jdbc:mariadb://localhost:3306/";
    private static final String DB="solbuslinealapunta";
    private static final String USUARIO = "root";
    private static final String PASSWORD= "";
    private static Connection connection;
    
    private Conexion() {}
    
    public static Connection getConnection() {
        if (connection == null) {
            try {

                Class.forName("org.mariadb.jdbc.Driver");

                connection = DriverManager.getConnection(URL + DB, USUARIO, PASSWORD);

            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "error a cargar driver " + ex.getMessage());

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "error de conexion" + ex.getMessage());

            }
        }
        return connection;
    }
    
}
