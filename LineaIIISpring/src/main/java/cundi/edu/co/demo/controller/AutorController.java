package cundi.edu.co.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cundi.edu.co.demo.entity.Autor;
import cundi.edu.co.demo.entity.AutorEditorial;
import cundi.edu.co.demo.exception.ArgumentRequiredException;
import cundi.edu.co.demo.exception.ConflictException;
import cundi.edu.co.demo.exception.ModelNotFoundException;
import cundi.edu.co.demo.service.IAutorEditorialService;
import cundi.edu.co.demo.service.IAutorService;


//@PreAuthorize("hasAuthority('Administrador')")
@RestController
@RequestMapping("/autores")
//@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class AutorController {
	
	@Autowired
	private IAutorService service;
	
	@Autowired
	private IAutorEditorialService serviceAE;
	
	//@PreAuthorize("hasAuthority('Administrador')  OR hasAuthority(' ') ")
	@GetMapping(value = "/obtenerPaginado" ,produces = "application/json")
	public ResponseEntity<?> retonarPaginado(Pageable page) {
		Page<Autor> listaAutor = service.retornarPaginado(page);
		return new ResponseEntity<Page<Autor>>(listaAutor, HttpStatus.OK);	
	}	
	
	//@PreAuthorize("hasAuthority('Administrador')  OR hasAuthority('Vendedor') ")
	@GetMapping(value = "/obtenerPaginadoConsulta" ,produces = "application/json")
	public ResponseEntity<?> retonarPaginadoConsulta(Pageable page) {
		Page<Autor> listaAutor = service.retornarPaginadoConsulta(page);
		return new ResponseEntity<Page<Autor>>(listaAutor, HttpStatus.OK);	
	}	
	
	//@PreAuthorize("hasAuthority('Administrador')  OR hasAuthority('Vendedor') ")
	@GetMapping(value = "/obtenerProrId/{idAutor}" ,produces = "application/json")
	public ResponseEntity<?> retornarPorId(@PathVariable Integer idAutor) throws ModelNotFoundException {
		Autor autor = service.retonarPorId(idAutor);
		return new ResponseEntity<Autor>(autor, HttpStatus.OK);	
	}		

	@PostMapping(value = "/insertar", consumes = "application/json")
	public ResponseEntity<?> guardar(@Valid @RequestBody Autor autor) throws ConflictException {
		service.guardar(autor);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/editar", consumes = "application/json")
	public ResponseEntity<?> editar(@Valid @RequestBody Autor autor) throws ArgumentRequiredException, ModelNotFoundException, ConflictException  {
		service.editar(autor);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}	
	
	@DeleteMapping(value = "/eliminar/{idAutor}" ,produces = "application/json")
	public ResponseEntity<?> eliminar(@PathVariable Integer idAutor) throws ModelNotFoundException {
		service.eliminar(idAutor);
		return new ResponseEntity<Autor>(HttpStatus.NO_CONTENT);	
	}
	
	@PostMapping(value = "/asociarEditorial", consumes = "application/json")
	public ResponseEntity<?> asociarEditorail(@Valid @RequestBody AutorEditorial autorEditorial) throws ConflictException {
		serviceAE.guardar(autorEditorial);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	
	
	
}
