package DAO;

/******************
 *                *
 * DATA OBJECT    *
 *                *
 *****************/

import java.util.List;

public interface PelisDAO<E,K> {
	
	
	E buscarPorId(K key);
	boolean insertar(E entidad);
	boolean modificar(E entidad);
	boolean eliminar(E entidad);
	List<E> obtenerTodosRegistros();
	

}