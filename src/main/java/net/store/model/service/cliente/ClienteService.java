package net.store.model.service.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import net.store.model.entity.cliente.Cliente;
import net.store.model.repository.cliente.ClienteRepository;
import net.store.model.service.ServiceCrud;

@Service
public class ClienteService extends ServiceCrud<Cliente, Long> {

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	protected JpaRepository<Cliente, Long> getRepository() {
		return clienteRepository;
	}
}
