/*******************************************
 * PROYECTO INTEGRADOR FASE 01 / PELICULAS *
 * by @author Fernando Robles              *
 ******************************************/
package main;

import modelos.Pelicula;

import gestores.GestorPeliculas;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


  /*   MAIN    */

public class main {

	public static void main(String[] args) {
		System.out.println("\t PROYECTO PELICULAS  \n");
		
		Scanner scanner = new Scanner(System.in);
		String tituloBuscado;
		int generoBuscado;
		
		// Creamos los objetos generos //
		
		
		
		//Creamos los objetos peliculas//
		
		Pelicula pelicula1 = new Pelicula(1, "Rapido y Furioso", "http://pelicula1.com", "imagen1.jpg",1);
        

        Pelicula pelicula2 = new Pelicula(2, "¿ Que pasó Ayer ?", "http://pelicula2.com", "imagen2.jpg",3);
        
        
        Pelicula pelicula3 = new Pelicula(3, "Masacre En Texas", "http://pelicula3.com", "imagen3.jpg", 4);
        
        
        // Agregamos las Peliculas a lIsta //
        GestorPeliculas.agregarPelicula(pelicula1);
        GestorPeliculas.agregarPelicula(pelicula2);
        GestorPeliculas.agregarPelicula(pelicula3);
        
        // Vemos el listado de peliculas //
        System.out.println("-Listado de Peliculas: ");
        GestorPeliculas.verPeliculas();
        
        
        // buscamos pelicula por titulo//
        
        System.out.println("\nIngrese el nombre de la pelicula: ");
        //tituloBuscado = scanner.nextLine();
        tituloBuscado = "¿ Que pasó Ayer ?";
        List<Pelicula> peliculasPorTitulo = obtenerPeliculasPorTitulo(tituloBuscado, GestorPeliculas.getPeliculas());
        if (peliculasPorTitulo.isEmpty()) {
            System.out.println("No se encontraron películas con el título: " + tituloBuscado);
        } else {
            System.out.println("Peliculas encontradas por título:");
            for (Pelicula pelicula : peliculasPorTitulo) {
                System.out.println("- " + pelicula.getId() + " ; " + pelicula.getTitulo());
            }
        }
        
        
        // buscamos pelicula por genero//
        System.out.println("\nIngrese el genero que busca: ");
        //generoBuscado = scanner.nextLine();
        generoBuscado = 1;
        List<Pelicula> peliculasPorGenero = obtenerPeliculasPorGenero(generoBuscado, GestorPeliculas.getPeliculas());
        if (peliculasPorGenero.isEmpty()) {
            System.out.println("No se encontraron películas del género: " + generoBuscado);
        } else {
            System.out.println("Peliculas encontradas por género:");
            for (Pelicula pelicula : peliculasPorGenero) {
            	System.out.println("- " + pelicula.getId() + " ; " + pelicula.getTitulo() +  " ; " + pelicula.getGeneros());
            }
        }
        
       // OPERACION BUSCA POR ID //
        System.out.println("\n Ingrese el codigo de la pelicula que busca: ");
        int codigoPelicula = scanner.nextInt();  
        Pelicula seleccionPelicula = GestorPeliculas.getPeliculaById(codigoPelicula);

       
        
        if(seleccionPelicula != null)
        {
        	System.out.println("Descripción de la Pelicula: \n");
        	System.out.println("TITULO : " + seleccionPelicula.getTitulo());
        	System.out.println("URL: " + seleccionPelicula.getUrl());
        	System.out.println("IMAGEN PORTADA : " + seleccionPelicula.getImagenPromocional());
        	System.out.println("GENERO : " + seleccionPelicula.getGeneros());
        }
        else
        {
        	System.out.println("No se encontro el codigo de la pelicula...");
        }
        
     
        //OPERACION BUSCA POR GENERO //
        System.out.println("\nIngrese el codigo de genero que busca: ");
        generoBuscado = scanner.nextInt();
        
        Pelicula generoPelicula = GestorPeliculas.getPeliculaByGenero(generoBuscado);
        
        if(generoPelicula != null)
        {
        	System.out.println("Descripción de la Pelicula: \n");
        	System.out.println("TITULO : " + generoPelicula.getTitulo());
        	System.out.println("URL: " + generoPelicula.getUrl());
        	System.out.println("IMAGEN PORTADA : " + generoPelicula.getImagenPromocional());
        	System.out.println("GENERO : " + generoPelicula.getGeneros());
        }
        else
        {
        	System.out.println("No se encontro el codigo de la pelicula...");
        }
        
        
     
	}
	
/***********************************************************************************************************************************************************/
	
	
	/*   FUNCIONES     */
	
	
	
	
	public static List<Pelicula> obtenerPeliculasPorTitulo(String titulo, List<Pelicula> peliculas) {
		
		 List<Pelicula> peliculasCoincidentes = new ArrayList<>();
		
		for (Pelicula pelicula : peliculas) {
            if (pelicula.getTitulo().contains(titulo)) {
                peliculasCoincidentes.add(pelicula);
            }
           
        }
		
        return peliculasCoincidentes;
       
    }
	
	
	
	
	
	
	public static List<Pelicula> obtenerPeliculasPorGenero(int genero, List<Pelicula> peliculas) {
	    List<Pelicula> peliculasPorGenero = new ArrayList<>();
	   
	    for (Pelicula pelicula : peliculas) {
	
	            if (pelicula.getGeneros() == genero) {
	                peliculasPorGenero.add(pelicula);
	                break; // No need to check other genres for this movie
	           
	        }
	    }
	    return peliculasPorGenero;
	}
	


}