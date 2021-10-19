package net.store.model.repository.marca;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.store.model.entity.marca.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {
	public List<Marca> findByDescripcion(String descripcion);
}
