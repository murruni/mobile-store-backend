package net.store.controller.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import net.store.model.service.ServiceCrud;

public abstract class RestControllerCrud<T, ID> {

	protected abstract ServiceCrud<T, ID> getService();

	// -------------------------------------------------------------------------
	// Getters
	// -------------------------------------------------------------------------
	@GetMapping("")
	public ResponseEntity<List<T>> findAll() {
		List<T> entities = getService().findAll();
		return ResponseEntity.ok(entities);
	}

	@GetMapping("/{id}")
	public ResponseEntity<T> findById(@PathVariable("id") ID id) {
		T entity = (T) getService().findById(id);
		if (entity == null)
			return ResponseEntity.unprocessableEntity().build();
		return ResponseEntity.ok(entity);
	}

	// -------------------------------------------------------------------------
	// Delete
	// -------------------------------------------------------------------------
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") ID id) {
		if (validateDelete(id) && getService().deleteById(id)) {
			return ResponseEntity.ok(null);
		}
		return ResponseEntity.unprocessableEntity().build();
	}

	protected abstract boolean validateDelete(ID id);

	// -------------------------------------------------------------------------
	// SaveAndUpdate
	// -------------------------------------------------------------------------
	@PostMapping("")
	public ResponseEntity<T> save(@RequestBody T newEntity) {
		T entity = createNewFromEntity(newEntity);
		entity = getService().save(entity);
		return ResponseEntity.ok(entity);
	}

	@PutMapping("/{id}")
	public ResponseEntity<T> update(@PathVariable("id") ID id, @RequestBody T newEntity) {
		T entityPersist = getService().findById(id);
		if (entityPersist == null)
			return ResponseEntity.unprocessableEntity().build();
		mapEntitiesFields(entityPersist, newEntity);
		entityPersist = getService().update(entityPersist);
		return ResponseEntity.ok(entityPersist);
	}

	/**
	 * Este mapeo debe hacerse en una clase maper y utilizando DTOs. Utilizar DTOs permite controlar los datos que viajan por la red para obetener mejor rendimiento, controlar la información que se envía,
	 * manipular tipos de datos que puedan dar problemas y poder implementar HETOAS
	 */
	protected abstract void mapEntitiesFields(T entityPersist, T newEntity);

	protected abstract T createNewFromEntity(T newEntity);
}
