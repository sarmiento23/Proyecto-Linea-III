package cundi.edu.co.demo.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cundi.edu.co.demo.entity.Autor;
import cundi.edu.co.demo.entity.Libro;
import cundi.edu.co.demo.exception.ArgumentRequiredException;
import cundi.edu.co.demo.exception.ConflictException;
import cundi.edu.co.demo.exception.ModelNotFoundException;
import cundi.edu.co.demo.service.ILibro;

public class LibroServiceImpl implements ILibro {

	@Override
	public Page<Libro> retornarPaginado(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Libro> retornarPaginado(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Libro retonarPorId(Integer idObj) throws ModelNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardar(Libro obj) throws ConflictException {
		// TODO Auto-generated method stub
		//Autor autor =serviceAutor.retonarPorId(id);
		
	}

	@Override
	public void editar(Libro obj) throws ArgumentRequiredException, ModelNotFoundException, ConflictException {
		// TODO Auto-generated method stub
	}

	@Override
	public void eliminar(int obj) throws ModelNotFoundException {
		// TODO Auto-generated method stub
		
	}

}
