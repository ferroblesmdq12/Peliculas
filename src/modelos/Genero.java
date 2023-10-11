package modelos;

public class Genero {
	
	// ATRIBUTO //
		private String nombre;

		
	// METODO //
		
		public Genero(String nombre) {
			this.nombre = nombre;
		}
		
		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		@Override
		public String toString() {
			return "Genero [nombre=" + nombre + "]";
		}

}