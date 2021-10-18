package net.store.controller.rest.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.store.model.service.cliente.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteRestController {
	
//	@Autowired
//	private ClienteService clienteService;
	
	@GetMapping("/")
	public String allClientes() {
		return "asd";
//		return clienteService.findAll();
	}
}
