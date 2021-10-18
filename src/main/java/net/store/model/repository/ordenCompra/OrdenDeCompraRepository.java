package net.store.model.repository.ordenCompra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenDeCompraRepository extends JpaRepository<OrdenCompra, Long>{

}
