package net.store.controller.rest.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.store.controller.rest.RestControllerCrud;
import net.store.model.entity.cliente.Cliente;
import net.store.model.service.ServiceCrud;
import net.store.model.service.cliente.ClienteService;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*")
public class ClienteRestController extends RestControllerCrud<Cliente, Long> {

	@Autowired
	private ClienteService clienteService;

	@Override
	protected ServiceCrud<Cliente, Long> getService() {
		return clienteService;
	}

	@Override
	protected Cliente createNewFromEntity(Cliente clienteNew) {
		Cliente cliente = new Cliente();
		mapEntitiesFields(cliente, clienteNew);
		return cliente;
	}

	@Override
	protected void mapEntitiesFields(Cliente c1, Cliente c2) {
		c1.setApellido(c2.getApellido());
		c1.setApellido(c2.getApellido());
		c1.setNombres(c2.getNombres());
		c1.setDireccion(c2.getDireccion());
		c1.setDni(c2.getDni());
		c1.setTelefono(c2.getTelefono());
	}

	@Override
	protected boolean validateDelete(Long id) {
		Cliente cliente = clienteService.findById(id);
		return cliente != null;
	}

}
