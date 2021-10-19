package net.store.controller.rest.marca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.store.controller.rest.RestControllerCrud;
import net.store.model.entity.marca.Marca;
import net.store.model.service.ServiceCrud;
import net.store.model.service.marca.MarcaService;

@RestController
@RequestMapping("/api/marcas")
@CrossOrigin(origins = "*")
public class MarcaRestController extends RestControllerCrud<Marca, Long> {
	@Autowired
	private MarcaService marcaService;

	@Override
	protected ServiceCrud<Marca, Long> getService() {
		return marcaService;
	}

	@Override
	protected void mapEntitiesFields(Marca entityPersist, Marca newEntity) {
		entityPersist.setDescripcion(newEntity.getDescripcion());
	}

	@Override
	protected Marca createNewFromEntity(Marca newEntity) {
		Marca marca = new Marca();
		mapEntitiesFields(marca, newEntity);
		return marca;
	}

	@Override
	protected boolean validateDelete(Long id) {
		Marca marca = marcaService.findById(id);
		return marca != null && marca.getTelefonos().isEmpty();
	}

}
