package com.marinho.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.marinho.domain.Cliente;
import com.marinho.domain.ItemNotaFiscal;

public interface ItemNotaFiscalRepository extends CrudRepository<ItemNotaFiscal,Long> {
	}
