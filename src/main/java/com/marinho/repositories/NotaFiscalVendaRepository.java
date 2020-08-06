package com.marinho.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.marinho.domain.NotaFiscalVenda;
public interface NotaFiscalVendaRepository extends CrudRepository <NotaFiscalVenda, Long> {
	@Query(value = "select * from nota_fiscal_venda u where u.clientecod = :clientecod",nativeQuery = true)
	NotaFiscalVenda findByCliente(@Param("clientecod") Long clientecod);
	
	@Query(value = "select * from nota_fisca_venda u , cliente a where u.clientecod = a.clientecod and a.nome = :nome GROUP BY u.data",nativeQuery = true)
	NotaFiscalVenda findByNomeCliente(@Param("nome") String nome);
	
	@Query(value = "select * from nota_fiscal_venda v, item_nota_fiscal	i where v.codigo = i.notaid and i.numero = :numero",nativeQuery = true)
	NotaFiscalVenda findByItem(@Param("numero") int numero);
}
