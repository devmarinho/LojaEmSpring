package com.marinho.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.marinho.domain.Cliente;
public interface ClienteRepository extends CrudRepository <Cliente,Long> {
	@Query("select u from Cliente u where u.nome = :nome")
	Cliente findByName(@Param("nome") String nome);
}

