package gestores;

import java.util.ArrayList;
import java.util.List;
import modelos.Pelicula;

public class GestorPeliculas {
	
	/*****************************
	 * Simula registro de prendas*
	 *                           *          
	 ****************************/
	
	private static List<Pelicula> peliculas;
	
	static {
		peliculas = new ArrayList<>();
	}
	
	/************************
	 * Agrega una pelicula. *
	 * @param pelicula.     *
	 ***********************/
	
	public static void agregarPelicula(Pelicula pelicula)
	{
		peliculas.add(pelicula);
	}
	
	
	/***************************************************
	 * Busca una pelicula en el registro.              *
	 * @param Id   codigo de la pelicula.              *
	 * @return pelicua,  si existe, sino devuelve null.*
	 **************************************************/
	public static Pelicula getPelicula(int codigoPelicula) {
		Pelicula pelicula = null;
		for(Pelicula p: peliculas)
		{
			if(p.getId() == codigoPelicula)
			{
				pelicula = p;
			}
		}
		
		return pelicula;
	}
	
	
	/**********************************
	 * Se ven el listado de peliculas *
	 * por pantalla.                  *
	 *********************************/
	public static void verPeliculas() {
		
		for(Pelicula p: peliculas)
		{
			System.out.println(p);
		}
	}


	public static List<Pelicula> getPeliculas() {
		return peliculas;
	}
	
	public static Pelicula getPeliculaById(int codigoPelicula) {
		for(Pelicula p: peliculas) {
			if(p.getId() == codigoPelicula) {
				return p;
			}
		}
		return null; // retorna nullo si el id no se encuentra.
	}

}