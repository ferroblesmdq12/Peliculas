package DAO;

/*******************************************
 *                                         *
 * Esta Interface "ConexionMySQL" es solo  *
 *  para establecer la conexion.           *
 *  Esto Es parte del patron de diseño DAO *
 *                                         *
 ******************************************/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public interface ConexionMysql {
	
	default Connection getConexion() {
		
		//Definimos un String que representa la ubicacion del DRIVER JDBC //
		String driver = "com.mysql.cj.jdbc.Driver";
		
		String url = "jdbc:mysql://localhost:3306/films"; // Para saber donde esta ubicada el motor de la base (mi caso es local) //
		
		/* CONSTRUCTOR DE CONEXION */
		Connection conexion = null; // Interfaz con la que iniciamos la conexion //
		
		try {
			  Class.forName(driver);
			  conexion = DriverManager.getConnection(url, "root", "");
		}catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		return conexion;
	}

}
