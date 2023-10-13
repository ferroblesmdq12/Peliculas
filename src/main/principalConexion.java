package main;

/*******************************
 * Aqui se hace la inyeccion   *
 * a la Base de Datos "films". *
 *                             *
 ******************************/

import modelos.Pelicula;

import gestores.GestorPeliculas;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.sql.ResultSet;
import DAO.ConexionMysql;
import DAO.PelisDAO;
import DAO.PeliculasDAOImp;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class principalConexion {

	public static void main(String[] args) {
		
		Pelicula pelicula = new Pelicula();
		PelisDAO<Pelicula, Integer> peliculaDAO = new PeliculasDAOImp();
		Scanner scanner = new Scanner(System.in);
        int opcion;
        
		
		// LLAMADO DE FUNCIONES //
	
		/*MENU*/
        
       
        
        do {
        	
        	 Menu();
           
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                	buscarPorId(peliculaDAO, scanner);
                    pausar();
                    break;
                case 2:
                	insertarPelicula(peliculaDAO, scanner);
                	pausar();
                    break;
                case 3:
                	modificarPelicula(peliculaDAO, scanner);
                	break;
                case 4:
                	eliminarPelicula(peliculaDAO,scanner);
                	pausar();
                	break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 0); // si opcion = 0, termina el programa
        

        scanner.close();
    }
		
		

	
	
	/*********************************************************
	 *                                                       *
	 *                 FUNCIONES A UTILIZAR                  *
	 *                                                       * 
	 *********************************************************/
	
	/***************
	 *    MENU     *
	 *             *
	 **************/
	
	public static void Menu() {
		
            System.out.println("\n\t MENU DE PELICULAS: \n");
            System.out.println("¿Que desea realizar?");
            System.out.println("1. Buscar pelicula por ID.");
            System.out.println("2. Insertar pelicula a BBDD.");
            System.out.println("3. Modificar datos de una pelicula.");
            System.out.println("4. Eliminar una pelicula de la BBDD.");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

    }
	
	 /*************************
	  *                        *
	  *        PAUSAR          *
	  *                        *
	  *************************/


	 public static void pausar() {
		 System.out.print("Presione Enter para continuar...");
		 try {
			 System.in.read();
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
	 }
	

	/*******************
	 *                 *
	 * BUSCAR POR ID   *
	 *                 *
	 ******************/
	
	private static void buscarPorId(PelisDAO<Pelicula, Integer> PeliculasDAO, Scanner scanner) {
		
		System.out.println("Ingrese el codigo de la pelicula: ");
		int codigoId = scanner.nextInt();
		Pelicula pelicula = PeliculasDAO.buscarPorId(codigoId);
		if(pelicula != null)
		{
			System.out.println("<La pelicula encontrada> es: " + pelicula);
		}else
		{
			System.out.println("No se encontro ninguna pelicula con ese codigo.");
		}
		
	}
	
	
	

	/**************
	 * INSERTAR   *
	 *************/
	


	
	private static void insertarPelicula(PelisDAO<Pelicula, Integer> PeliculasDAO, Scanner scanner) {
		int Id = 2;
		System.out.println("Ingrese el nombre de la pelicula: ");
		String titulo = scanner.next();
		
		System.out.println("Ingrese la pagina de la pelicula: ");
		String url = scanner.next();
		
		System.out.println("Ingrese la imagen: ");
		String imagenPromocional = scanner.next();
		
		Integer generos = 0;
		
		do {
			System.out.println("Ingrese el codigo del genero: ");
			generos = scanner.nextInt();
			
			if(generos <=0) {
				
				System.err.println("¡Debe ingresar un numero positivo válido");
			}
			
		}while(generos <= 0);
		
	
		
		Pelicula pelicula = new Pelicula(0,titulo,url,imagenPromocional, generos);
		
		PeliculasDAO.insertar(pelicula);
		
		System.out.println("Se <Insertó> registro en BBDD.");

	}
	
	
	
	 /*******************************
	 *                              *
	 *         MODIFICAR            *
	 *                              *
	 *******************************/
	
	public static void modificarPelicula(PelisDAO<Pelicula, Integer> PeliculasDAO, Scanner scanner) {
		
		
		System.out.println("Ingrese el codigo de la pelicula a actualizar: ");
		 
		int codigoId = scanner.nextInt();
		
		Pelicula pelicula = PeliculasDAO.buscarPorId(codigoId);
		
	
		if(pelicula != null)
		{
			System.out.println(pelicula);
			

			
		;

			Scanner scanner1 = new Scanner(System.in);
			Scanner scanner2 = new Scanner(System.in);
			Scanner scanner3 = new Scanner(System.in);
			Scanner scanner4 = new Scanner(System.in);

			
			
			String nuevoTitulo = obtenerTituloNuevo(scanner1);
			pelicula.setTitulo(nuevoTitulo);
			
			String nuevaURL = obtenerUrlNueva(scanner1);
			pelicula.setUrl(nuevaURL);
			
			String nuevaImagen = obtenerImagenNueva(scanner1);
			pelicula.setImagenPromocional(nuevaImagen);
			
			int nuevoCodigoGenero = obtenerCodigoNuevoGenero(scanner1);
			pelicula.setGeneros(nuevoCodigoGenero);
			
			
			System.out.println(nuevoTitulo);
			System.out.println(nuevaURL);
			System.out.println(nuevaImagen);
			System.out.println(nuevoCodigoGenero);
			
			
			
			
			
			
			if(PeliculasDAO.modificar(pelicula)) {
				System.out.println("Datos de la pelicula <modificado correctamente>. \n");
			}
			else {
				System.out.println("No se pudo <Modificar> la pelicula...\n");
			}
	
		}else {
			System.out.println("No se encontro el Id de la pelicula proporcionada! \n");
		}
	
	}
	
		/*Subfunciones de MODIFICAR */
	
		/* Subfuncion para cambiar el titulo de la pelicula */
	
	
		private static String obtenerTituloNuevo(Scanner scanner) {
			System.out.println("Ingrese nuevo titulo a la pelicula: ");
			return scanner.nextLine().trim();
		
		}
		
		/* Subfuncion para cambiar la URL de la pelicula */
		
		private static String obtenerUrlNueva(Scanner scanner) {
			System.out.println("Ingrese nueva URL a la pelicula: \n");
			return scanner.nextLine().trim();
		}
		
		/* Subfuncion para cambiar la imagen de la pelicula */
		
		private static String obtenerImagenNueva(Scanner scanner) {
			System.out.println("Ingrese una imagen de portada nueva: \n");
			return scanner.nextLine().trim();
		}
		
		
		/* Subfuncion cambiar codigo de genero de la pelicula*/
		
		private static int obtenerCodigoNuevoGenero(Scanner scanner) {
			while(true) {

				System.out.println("Ingrese nuevo codigo de genero: \n");
				String nuevoCodigoGeneroString = scanner.nextLine().trim();	

				if(nuevoCodigoGeneroString.isEmpty()) {
					return -1; //En caso de que no se proporcione ningun codigo, retornará -1. //
				}

				try {
					int nuevoCodigoGenero = Integer.parseInt(nuevoCodigoGeneroString);
					if(nuevoCodigoGenero <= 0) {
						System.out.println("El codigo del genero debe ser un numero MAYOR a <0>.\n");
						
					}else
					{
						return nuevoCodigoGenero;
					}
	
				}catch(NumberFormatException e) {

					System.out.println("Formato de codigo de genero inválido, intente nuevamente.\n");
				}
			}
		}
		
		
	         /*************************
		     *                        *
			 *        ELIMINAR        *
			 *                        *
			 *************************/
		
		private static void eliminarPelicula(PelisDAO<Pelicula,Integer> PeliculasDAO, Scanner scanner) {
			
			System.out.println("Ingrese el <Id> de la pelicula que desea <eliminar>: ");
			int codigoId = scanner.nextInt();
			Pelicula pelicula = PeliculasDAO.buscarPorId(codigoId);
			
			if(pelicula != null) {
				
				System.out.println("Pelicula encontrada: " + pelicula);
				System.out.println("¿Realmente quieres <Eliminar> esta pelicula? (S/N)");
				String confirmacion = scanner.next().toUpperCase();
				
				if(confirmacion.equals("S")) {
					
					if(PeliculasDAO.eliminar(pelicula)) {
						System.out.println("Pelicula eliminada correctamente.");
						
					}else {
						
						System.out.println("No se pudo eliminar la pelicula.");
					}
				}else {
					
					System.out.println("Eliminación de pelicula Cancelada.");
				}
				
			}else {
				
				System.out.println("No se encontró el ID de la pelicula deseada.");
			}
			
		}


		
		
		

}
