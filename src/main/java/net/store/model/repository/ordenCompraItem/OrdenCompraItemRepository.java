package net.store.model.repository.ordenCompraItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.store.model.entity.ordenCompraItem.OrdenCompraItem;

@Repository
public interface OrdenCompraItemRepository extends JpaRepository<OrdenCompraItem, Long> {

}
