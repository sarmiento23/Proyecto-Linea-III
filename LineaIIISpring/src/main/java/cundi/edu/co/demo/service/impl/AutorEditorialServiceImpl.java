package cundi.edu.co.demo.service.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cundi.edu.co.demo.entity.Autor;
import cundi.edu.co.demo.entity.AutorEditorial;
import cundi.edu.co.demo.entity.Editorial;
import cundi.edu.co.demo.exception.ArgumentRequiredException;
import cundi.edu.co.demo.exception.ConflictException;
import cundi.edu.co.demo.exception.ModelNotFoundException;
import cundi.edu.co.demo.repository.IAutorEditorialRepo;
import cundi.edu.co.demo.service.IAutorEditorialService;

@Service
public class AutorEditorialServiceImpl implements IAutorEditorialService{

	@Autowired
	private IAutorEditorialRepo repo;
	
	@Override
	public Page<AutorEditorial> retornarPaginado(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<AutorEditorial> retornarPaginado(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AutorEditorial retonarPorId(Integer idObj) throws ModelNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardar(AutorEditorial obj) throws ConflictException {
		// TODO Auto-generated method stub
		
		//No se puede realizar por que no tenemos la doble referencia
		//this.repo.save(aux);
		
		//Se podria hacer el find de autor y de editorial y asociar pero traeria  mucha informacion solo para usar dos ID's
		
		//Agregar validaciones respectivas
		this.repo.guardarNativo(obj.getAutor().getId(), obj.getEditorial().getId(), obj.getFecha());
	}

	@Override
	public void editar(AutorEditorial obj) throws ArgumentRequiredException, ModelNotFoundException, ConflictException {
		// TODO Auto-generated method stub
		//Generalmente no se utiliza el editar en una table intermedia 
	}

	@Override
	public void eliminar(int obj) throws ModelNotFoundException {
		// TODO Auto-generated method stub
	}

	@Override
	public void eliminarNativo(Integer idAutor, Integer idEditorial) throws ModelNotFoundException {
		// TODO Auto-generated method stub
		//Validaciones pertinentes
		this.repo.eliminarNativa(idAutor, idEditorial);
	}

	@Transactional
	@Override
	public void asociarAutorEditoial() {
		this.repo.guardarNativo(1, 1, LocalDate.now());
		this.repo.guardarNativo(2, 1, LocalDate.now());
		this.repo.guardarNativo(3, 1, LocalDate.now());
		this.repo.guardarNativo(6, 1, LocalDate.now());
	}

}
