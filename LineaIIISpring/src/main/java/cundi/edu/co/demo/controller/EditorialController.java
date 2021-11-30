package cundi.edu.co.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cundi.edu.co.demo.service.IAutorEditorialService;


@RestController
@RequestMapping("/editoriales")
public class EditorialController {
	
	@Autowired
	private IAutorEditorialService serviceAutorEditorial;

	
	@PostMapping(value = "/asociarAutores")
	public ResponseEntity<?> guardar() {
		serviceAutorEditorial.asociarAutorEditoial();
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	
	
}
