package net.store.model.repository.telefono;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.store.model.entity.marca.Marca;
import net.store.model.entity.telefono.Telefono;

@Repository
public interface TelefonoRepository extends JpaRepository<Telefono, Long> {
	public Telefono getByCodigo(String codigo);
	public List<Telefono> findByCodigo(String codigo);
	public List<Telefono> findByDescripcion(String descripcion);
	public List<Telefono> findByMarca(Marca marca);
}
