package com.marinho.repositories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.marinho.domain.Cliente;
import com.marinho.domain.Produto;
public interface ProdutoRepository extends CrudRepository <Produto, Long>{
	@Query("select u from Produto u where u.descricao = :descricao")
	Produto findByDescricao(@Param("descricao") String descricao);
	
	@Query("select u from Produto u where u.codigo = :codigo")
	Produto findByCodigo(@Param("codigo") int codigo);
}
