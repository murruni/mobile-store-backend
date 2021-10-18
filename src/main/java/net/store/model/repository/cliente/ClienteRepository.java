package net.store.model.repository.cliente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.store.model.entity.cliente.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	List<Cliente> findByApellido(String apellido);
}
