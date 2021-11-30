package cundi.edu.co.demo;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import cundi.edu.co.demo.entity.Autor;
import cundi.edu.co.demo.exception.ModelNotFoundException;
import cundi.edu.co.demo.service.IAutorService;
import cundi.edu.co.demo.service.IUsuarioService;

@SpringBootTest
class LineaIiiApplicationTests {

	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private IAutorService autorService;
	
	private String conexion;
	
	@AfterAll
	public static void after() {
		System.out.println("AfterAll");
	}
	
	@BeforeAll
	public static void before() {
		System.out.println("before");
	}
	
	@BeforeEach
	public void beforeEach() {
		System.out.println("beforeEach");
	}
	
	
	@Test
	void vaerificarClave() {
		System.out.println("Resultado:--------------------  " + bcrypt.encode("123456"));
		assertTrue(true);
	}
	
	@Test
	void valliarSuma() {
		int resultado =  this.usuarioService.sumar(1, 2, 3, 7);
		assertEquals(13, resultado);
	}
	
	@Test
	void valdiarExistenciaAutor() {
		try {
			Autor autor = this.autorService.retonarPorId(1);
			if(autor.getCedula().equals("123453432"))
				assertTrue(true);
			else
				assertTrue(false);
		} catch (ModelNotFoundException e) {
			assertTrue(false);
		}
	}
		
}
