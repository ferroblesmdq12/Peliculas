package DAO;

/********************************
 * Esta clase Abstracta es       * 
 * la Buisness Object            *
 ********************************/

import DAO.ConexionMysql;
import modelos.Pelicula;
import DAO.PelisDAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;


public class PeliculasDAOImp implements ConexionMysql, PelisDAO<Pelicula, Integer>{
	
	/******************
	 * BUSCAR POR ID  *
	 *****************/
	
	public Pelicula buscarPorId(Integer key) {
		
		Pelicula peliculaBuscada = null;
		
		Connection conexion = getConexion();
		
		String sentenciaSQL = "SELECT * FROM peliculas WHERE pel_id = ? ";
		
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = conexion.prepareStatement(sentenciaSQL);
			preparedStatement.setInt(1, key);
			ResultSet resultado = preparedStatement.executeQuery();

			while(resultado.next()) {

				int id = resultado.getInt("pel_id");
				String titulo = resultado.getString("pel_titulo");
				String url = resultado.getString("pel_url");
				String imagen = resultado.getString("pel_imagen");
				int generos = resultado.getInt("gen_id");

				peliculaBuscada = new Pelicula(id, titulo, url, imagen,generos);
			}

		}catch (SQLException e) {

			e.printStackTrace();

		}finally {

			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				conexion.close();

			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return peliculaBuscada;
	}
	
	
	
	/**************
	 * INSERTAR   *
	 *************/
	
	public boolean insertar(Pelicula entidad) {
		
		Connection conexion = getConexion();
		String sentenciaSQL = "INSERT INTO peliculas(pel_titulo, pel_url, pel_imagen, gen_id) VALUES (?, ?, ?,?)";
		PreparedStatement preparedStatement = null;



		try {

			preparedStatement = conexion.prepareStatement(sentenciaSQL);
			preparedStatement.setString(1, entidad.getTitulo());
			preparedStatement.setString(2, entidad.getUrl());
			preparedStatement.setString(3, entidad.getImagenPromocional());
			preparedStatement.setInt(4, entidad.getGeneros());
			preparedStatement.executeUpdate();
			

			return true;

		}catch(SQLException e) {

			e.printStackTrace();

		}finally {

			try {

				if (preparedStatement != null) {

					preparedStatement.close();

				}
				conexion.close();

			}catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return false;

	}
	
	
	
	/********************************
	 *                              *
	 *        MODIFICAR             *
	 *                              *
	 *******************************/
	
	public boolean modificar(Pelicula entidad) {

		Connection conexion = getConexion();

		String sentenciaSQL = "UPDATE peliculas SET pel_titulo=?, pel_url=?, pel_imagen=?, gen_id=?   WHERE pel_id=?";


		PreparedStatement preparedStatement = null;

		try {

			preparedStatement = conexion.prepareStatement(sentenciaSQL);
			
			preparedStatement.setString(1, entidad.getTitulo());
			preparedStatement.setString(2, entidad.getUrl());
			preparedStatement.setString(3, entidad.getImagenPromocional());
			preparedStatement.setInt(4, entidad.getGeneros());
			preparedStatement.setInt(5, entidad.getId());
			
			preparedStatement.executeUpdate();
			return true;      	
		} catch(SQLException e) {
			e.printStackTrace();
		}finally {

			try {

				if (preparedStatement != null) {

					preparedStatement.close();

				}
				conexion.close();

			}catch (SQLException e) {
				e.printStackTrace();

			}

		}

		return false;
	}

	
	
	 /*************************
     *                        *
	 *        ELIMINAR        *
	 *                        *
	 *************************/
	
	public boolean eliminar(Pelicula entidad) {

		Connection conexion = getConexion();
		String sentenciaSQL = "DELETE FROM peliculas WHERE pel_id = ?";
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = conexion.prepareStatement(sentenciaSQL);
			preparedStatement.setInt(1, entidad.getId());
			preparedStatement.executeUpdate();
			return true;

		}catch (SQLException e) {

			e.printStackTrace();

		}finally {
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				conexion.close();
			}catch (SQLException e) {

				e.printStackTrace();

			}

		}
		
		return false;
	}
	
	
	
	/******************************************************
	 *                                                    *
	 *    OBTENER TODOS  LAS REGISTROS  DE PELICULAS      *
	 *                                                    *
	 *****************************************************/
	
	public List<Pelicula> obtenerTodosRegistros(){

		List<Pelicula> peliculas = new ArrayList<Pelicula>();

		Connection conexion = getConexion();
		String sentenciaSQL = "SELECT * FROM peliculas";
		Statement objetoSentenciaSQL = null;

		try {

			objetoSentenciaSQL = conexion.createStatement();
			ResultSet resultado = objetoSentenciaSQL.executeQuery(sentenciaSQL);

			while(resultado.next()) {
				
				int id = resultado.getInt("pel_id");
				String titulo = resultado.getString("pel_titulo");
				String url = resultado.getString("pel_url");
				String imagenPromocional = resultado.getString("pel_imagen");
				int generos = resultado.getInt("gen_id");
				

				Pelicula peliculaBuscada = new Pelicula(id, titulo, url, imagenPromocional,generos);
				peliculas.add(peliculaBuscada);

			}

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {

			try {
				objetoSentenciaSQL.close();
				conexion.close();
			}catch(SQLException e) {

				e.printStackTrace();
			}

			
		}
		
		return peliculas;

	}
}



	

	
	
	
