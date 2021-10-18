package net.store.model.service.ordeCompraItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.store.model.repository.ordenCompraItem.OrdenCompraItemRepository;

@Service
public class OrdenCompraItemService {
	@Autowired
    private OrdenCompraItemRepository ordenCompraItemRepository;

}
