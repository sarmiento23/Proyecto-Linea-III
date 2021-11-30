package cundi.edu.co.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cundi.edu.co.demo.exception.ArgumentRequiredException;
import cundi.edu.co.demo.exception.ConflictException;
import cundi.edu.co.demo.exception.ModelNotFoundException;

public interface ICrud<T, ID> {
	
	public Page<T> retornarPaginado(int page, int size);
	
	public Page<T> retornarPaginado(Pageable page);
	
	public T retonarPorId(ID idObj) throws ModelNotFoundException;
		
	public void guardar(T obj)  throws ConflictException;
	
	public void editar(T obj)  throws ArgumentRequiredException, ModelNotFoundException, ConflictException;
	
	public void eliminar(int obj) throws ModelNotFoundException;	

}
