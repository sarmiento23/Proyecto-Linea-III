package cundi.edu.co.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cundi.edu.co.demo.entity.Editorial;
import cundi.edu.co.demo.exception.ArgumentRequiredException;
import cundi.edu.co.demo.exception.ConflictException;
import cundi.edu.co.demo.exception.ModelNotFoundException;
import cundi.edu.co.demo.repository.IEstudianteRepo;
import cundi.edu.co.demo.service.IEditorialService;

public class EditorialServiceImpl implements IEditorialService {

	@Autowired
	private IEstudianteRepo repo;
	
	@Override
	public Page<Editorial> retornarPaginado(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Editorial> retornarPaginado(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Editorial retonarPorId(Integer idObj) throws ModelNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardar(Editorial obj) throws ConflictException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editar(Editorial obj) throws ArgumentRequiredException, ModelNotFoundException, ConflictException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(int obj) throws ModelNotFoundException {
		// TODO Auto-generated method stub
		
	}

}
