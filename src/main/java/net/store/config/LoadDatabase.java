package net.store.config;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.store.model.entity.cliente.Cliente;
import net.store.model.entity.marca.Marca;
import net.store.model.entity.telefono.Telefono;
import net.store.model.repository.cliente.ClienteRepository;
import net.store.model.repository.marca.MarcaRepository;
import net.store.model.repository.ordenCompra.OrdenCompraRepository;
import net.store.model.repository.telefono.TelefonoRepository;

@Configuration
public class LoadDatabase {

	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	TelefonoRepository telefonoRepository;
	@Autowired
	MarcaRepository marcaRepository;
	@Autowired
	OrdenCompraRepository ordenCompraRepository;

	@Bean
	CommandLineRunner initDatabase() {
		return args -> {
			loadEntitiesMarca();
			loadEntitiesTelefono();
			loadEntitiesCliente();
		};
	}

	private void loadEntitiesMarca() {
		List<String> marcas = List.of("Motorola", "Samsung", "Iphone");
		marcas.stream().forEach(m -> {
			Marca marca = new Marca();
			marca.setDescripcion(m);
			marcaRepository.save(marca);
		});
	}

	private void loadEntitiesCliente() {
		Cliente cliente;

		cliente = new Cliente();
		cliente.setApellido("Gomez");
		cliente.setNombres("Juan");
		cliente.setDni("23321654");
		clienteRepository.save(cliente);

		cliente = new Cliente();
		cliente.setApellido("Gonzalez");
		cliente.setNombres("Ana");
		cliente.setDni("23321654");
		clienteRepository.save(cliente);
	}

	private void loadEntitiesTelefono() {
		Marca marca;
		
		marca = marcaRepository.findByDescripcion("Motorola").get(0);
		newTelefono(marca, "G3", "0001", new BigDecimal("20512.23"));
		newTelefono(marca, "G5", "0002", new BigDecimal("20112.23"));
		newTelefono(marca, "G9", "0003", new BigDecimal("20512.23"));

		marca = marcaRepository.findByDescripcion("Samsung").get(0);
		newTelefono(marca, "Galaxy 6", "0004", new BigDecimal("20512.23"));
		newTelefono(marca, "Galaxy 6", "0005", new BigDecimal("20512.23"));
		newTelefono(marca, "Galaxy 6", "0006", new BigDecimal("30512.23"));

		marca = marcaRepository.findByDescripcion("Iphone").get(0);
		newTelefono(marca, "Galaxy 6", "0007", new BigDecimal("70512.23"));
		newTelefono(marca, "Galaxy Xr", "0008", new BigDecimal("140512.23"));
		newTelefono(marca, "Galaxy 13", "0009", new BigDecimal("253512.23"));
	}

	private void newTelefono(Marca marca, String descripcion, String codigo, BigDecimal precio) {
		Telefono telefono = new Telefono();
		telefono.setDescripcion(descripcion);
		telefono.setMarca(marca);
		telefono.setCodigo(codigo);
		telefono.setPrecio(precio);
		telefonoRepository.save(telefono);
	}
}
