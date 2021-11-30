package cundi.edu.co.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cundi.edu.co.demo.entity.Autor;

@Repository
public interface IAutorRepo  extends JpaRepository<Autor, Integer> {

	
	
	@Query(value = "SELECT a FROM Autor a", nativeQuery = false)
	Page<Autor> retornarPaginadoConsulta(Pageable pageable);
	
}
