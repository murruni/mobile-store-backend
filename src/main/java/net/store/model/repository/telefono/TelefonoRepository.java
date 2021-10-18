package net.store.model.repository.telefono;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.store.model.entity.telefono.Telefono;

@Repository
public interface TelefonoRepository extends JpaRepository<Telefono, Long>{

}
