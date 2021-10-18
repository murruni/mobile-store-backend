package net.store.model.repository.modelo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.store.model.entity.modelo.Modelo;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {

}
