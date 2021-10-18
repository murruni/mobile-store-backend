package net.store.model.service.modelo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.store.model.repository.modelo.ModeloRepository;

@Service
public class Modelo {
	@Autowired
    private ModeloRepository modeloRepository;
}
