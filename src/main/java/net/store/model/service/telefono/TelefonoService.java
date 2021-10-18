package net.store.model.service.telefono;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.store.model.repository.telefono.TelefonoRepository;

@Service
public class TelefonoService {
	@Autowired
    private TelefonoRepository telefonoRepository;
}
