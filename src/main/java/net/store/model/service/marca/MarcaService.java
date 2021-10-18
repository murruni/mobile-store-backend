package net.store.model.service.marca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.store.model.repository.marca.MarcaRepository;

@Service
public class MarcaService {
	@Autowired
    private MarcaRepository marcaRepository;
}
