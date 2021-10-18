package net.store.model.service.ordenCompra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.store.model.repository.ordenCompra.OrdenCompraRepository;

@Service
public class OrdenCompraService {
	@Autowired
    private OrdenCompraRepository ordenCompraRepository;
}
