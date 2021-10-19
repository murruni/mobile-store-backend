package net.store.model.service.marca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import net.store.model.entity.marca.Marca;
import net.store.model.repository.marca.MarcaRepository;
import net.store.model.service.ServiceCrud;

@Service
public class MarcaService extends ServiceCrud<Marca, Long> {
	@Autowired
	private MarcaRepository marcaRepository;

	@Override
	protected JpaRepository<Marca, Long> getRepository() {
		return marcaRepository;
	}
}
