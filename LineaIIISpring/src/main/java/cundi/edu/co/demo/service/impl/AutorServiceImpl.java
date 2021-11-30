package cundi.edu.co.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cundi.edu.co.demo.entity.Autor;
import cundi.edu.co.demo.exception.ArgumentRequiredException;
import cundi.edu.co.demo.exception.ConflictException;
import cundi.edu.co.demo.exception.ModelNotFoundException;
import cundi.edu.co.demo.repository.IAutorRepo;
import cundi.edu.co.demo.service.IAutorService;
import cundi.edu.co.demo.service.ILibro;

@Service
public class AutorServiceImpl implements IAutorService {
	
	@Autowired
	private IAutorRepo repo;

	@Override
	public Page<Autor> retornarPaginado(int page, int size) {
		Page<Autor> pageAutor = repo.findAll(PageRequest.of(page,size));
		pageAutor.getContent().forEach(aut ->{
			     aut.setLibro(null);
		});
		return pageAutor;
	}

	@Override
	public Page<Autor> retornarPaginado(Pageable page) {
		Page<Autor> pageAutor = repo.findAll(page);
		pageAutor.getContent().forEach(aut ->{
			     aut.setLibro(null);
		});
		
		return pageAutor;
	}
	
	@Override
	public Page<Autor> retornarPaginadoConsulta(Pageable page) {
		Page<Autor> pageAutor = repo.retornarPaginadoConsulta(page);
		pageAutor.getContent().forEach(aut ->{
			     aut.setLibro(null);
		});
		return pageAutor;
	}

	@Override
	public Autor retonarPorId(Integer idAutor) throws ModelNotFoundException {
		Optional<Autor> autor = repo.findById(idAutor);
		if(autor.isPresent()) {
			return autor.get();
			/*Autor autorAux = autor.get(); Si no quiero los libros
			autorAux.setLibro(null);
			return autorAux;*/
		} else {
			throw new ModelNotFoundException("Autor no encontrado");
		}
	}

	@Transactional
	@Override
	public void guardar(Autor autor) throws ConflictException {
		
		
		// TODO Auto-generated method stub
		//autor.setLibro(null); En caso que solo se quiera guardar el autor sin libros
		if(autor.getLibro() != null) {
			autor.getLibro().forEach(libro ->{
				libro.setAutor(autor);
			});
		}
		this.repo.save(autor);
	}

	@Override
	public void editar(Autor autor) throws ArgumentRequiredException, ModelNotFoundException, ConflictException {
		Autor autorAux = this.retonarPorId(autor.getId());
		autorAux.setApellido(autor.getApellido());
		autorAux.setNombre(autor.getNombre());
		autorAux.setCedula(autor.getCedula());
		autorAux.setCorreo(autor.getCorreo());
		//autorAux.getLibro().get(0).setNombre("Cien años de soledad"); No se recomieda
		this.repo.save(autorAux);
	}

	//Tener cuidado no se recomienda a no ser que la logica lo requiera
	@Override
	public void eliminar(int idAutor) throws ModelNotFoundException {
		// TODO Auto-generated method stub
		this.repo.deleteById(idAutor);
	}


}
