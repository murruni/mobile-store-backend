package net.store.model.repository.marca;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.store.model.entity.marca.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long>{

}
