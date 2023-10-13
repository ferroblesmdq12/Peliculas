package modelos;



import java.util.ArrayList;
import java.util.List;

public class Pelicula {
	
	// ATRIBUTOS //
	
		private int Id;
	    private String titulo;
	    private String url;
	    private String imagenPromocional;
	    private int generos;
	    
	 // CONSTRUCTOR POR DEFECTO //
	    
	    public Pelicula() {
	    	
	    	
	    }
		
	   
	// CONSTRUCTOR PARAMETRIZADO //

		public Pelicula(int Id, String titulo,String url, String imagenPromocional, int generos) {
			
			this.Id = Id;
			this.titulo = titulo;
			this.url = url;
			this.imagenPromocional = imagenPromocional;
			this.generos = generos;
				
		}
		
		
		
	// METODOS //
		
		@Override
		public String toString() {
			return "Pelicula [Id=" + Id + ", titulo=" + titulo + ", url=" + url + ", imagenPromocional=" + imagenPromocional
					+ ", generos=" + generos + "]";
		}
		

		public void setId(int id) {
			Id = id;
		}


		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}


		public void setUrl(String url) {
			this.url = url;
		}


		public void setImagenPromocional(String imagenPromocional) {
			this.imagenPromocional = imagenPromocional;
		}


		public void setGeneros(int generos) {
			this.generos = generos;
		}


		public int getId() {
			return Id;
		}


		public String getTitulo() {
			return titulo;
		}


		public String getUrl() {
			return url;
		}


		public String getImagenPromocional() {
			return imagenPromocional;
		}


		public int getGeneros() {
			return generos;
		}
		
		
		

}