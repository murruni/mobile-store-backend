package net.store.config;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

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
			loadEntitiesOrdenCompra();

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
		Random rand = new Random();

		Marca motorola = marcaRepository.findByDescripcion("Motorola").get(0);
		Marca samsung = marcaRepository.findByDescripcion("Samsung").get(0);
		Marca iphone = marcaRepository.findByDescripcion("Iphone").get(0);
		List<String> telefonosMotorola = List.of("G3", "G5", "G9");
		List<String> telefonosSamsung = List.of("Galaxy 6", "Galaxy 10", "Galaxy Note");
		List<String> telefonosIphone = List.of("6", "Xr", "13");

		telefonosMotorola.forEach(mod -> {
			Telefono telefono = new Telefono();
			telefono.setDescripcion(mod);
			telefono.setMarca(motorola);
			telefono.setCodigo("m" + rand.nextInt());
			telefono.setPrecio(new BigDecimal(rand.nextDouble() * 1000));
			telefonoRepository.save(telefono);
		});

		telefonosSamsung.forEach(mod -> {
			Telefono telefono = new Telefono();
			telefono.setDescripcion(mod);
			telefono.setMarca(samsung);
			telefono.setCodigo("s" + rand.nextInt());
			telefono.setPrecio(new BigDecimal(rand.nextDouble() * 1000));
			telefonoRepository.save(telefono);
		});
		telefonosIphone.forEach(mod -> {
			Telefono telefono = new Telefono();
			telefono.setDescripcion(mod);
			telefono.setMarca(iphone);
			telefono.setCodigo("i" + rand.nextInt());
			telefono.setPrecio(new BigDecimal(rand.nextDouble() * 1000));
			telefonoRepository.save(telefono);
		});
	}

	private void loadEntitiesOrdenCompra() {
		// TODO Auto-generated method stub

	}

}
