package com.marinho.controlles;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marinho.domain.Cliente;
import com.marinho.domain.ItemNotaFiscal;
import com.marinho.domain.NotaFiscalVenda;
import com.marinho.domain.Produto;
import com.marinho.domain.TipoCliente;
import com.marinho.repositories.ClienteRepository;
import com.marinho.repositories.ItemNotaFiscalRepository;
import com.marinho.repositories.NotaFiscalVendaRepository;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/nota") // This means URL's start with /demo (after Application path)
public class NotaFiscalVendaController {
	@Autowired // This means to get the bean called userRepository
	           // Which is auto-generated by Spring, we will use it to handle the data
	private NotaFiscalVendaRepository nfrepository;
	@Autowired
	private ItemNotaFiscalRepository repository;
	@Autowired
	private ClienteRepository crepository;
	
	@GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addNewNota (@RequestParam String data,
			@RequestParam long id) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		
		NotaFiscalVenda nt = new NotaFiscalVenda();
		nt.setData(data);
		nt.setCliente(crepository.findById(id).get());
		nfrepository.save(nt);
		return "Saved";
	}
	
	@GetMapping(path="/additem")
	public @ResponseBody String additem(@RequestParam long id,@RequestParam long id2) {
		NotaFiscalVenda n = nfrepository.findById(id).get();
		ItemNotaFiscal i = repository.findById(id2).get();
		n.criarItemNotaFiscal(i);
		n.calcularValorNota();
		nfrepository.save(n);
		return "Adicionado";
		
	}
	
	@PostMapping(path="/deleteitem")
	public @ResponseBody String remove(@RequestParam long id,@RequestParam long id2) {
		NotaFiscalVenda n = nfrepository.findById(id).get();
		n.removerItemNotaFiscal(repository.findById(id2).get());
		n.calcularValorNota();
		nfrepository.save(n);
		return "Removido";
	
	}
	@GetMapping(path="/all")
	public @ResponseBody Iterable<NotaFiscalVenda> getAllUsers() {
		// This returns a JSON or XML with the users
		return nfrepository.findAll();
	}
	@GetMapping(path="/allid")
	public @ResponseBody Optional<NotaFiscalVenda> codigo(@RequestParam long id) {
		// This returns a JSON or XML with the users
		return nfrepository.findById(id);
	}
	@GetMapping(path="/delete")
	public @ResponseBody Iterable<NotaFiscalVenda> deleteuser(@RequestParam long id) {
		nfrepository.deleteById(id);
		return nfrepository.findAll();
		
	}
	@GetMapping(path="/mostraritem")
	public @ResponseBody String mostrar(@RequestParam long id) {
		NotaFiscalVenda n = nfrepository.findById(id).get();
		
		return n.tString() ;
		
	
	}
	@GetMapping(path="/update")
	public @ResponseBody String update(@RequestParam long id, @RequestParam String data,@RequestParam String id2){
		NotaFiscalVenda record = nfrepository.findById(id).get();
			if(id2 !="") record.setCliente(crepository.findById(Long.parseLong(id2)).get());
			if(data !="") record.setData(data);
			nfrepository.save(record);
			return "Updated";
	}
	@GetMapping(path="/procurar")
	public @ResponseBody NotaFiscalVenda p(@RequestParam int id,@RequestParam long l, @RequestParam int id2,@RequestParam String nome,@RequestParam int numero) {
		NotaFiscalVenda p = null;
		if (id == 1)return nfrepository.findByCliente(l);
		else if (id == 2)return nfrepository.findByNomeCliente(nome);
		else if(id == 3 )return nfrepository.findByItem(numero);
		else return  p;
		
	}
}