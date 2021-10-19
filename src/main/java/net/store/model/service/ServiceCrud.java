package net.store.model.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract class ServiceCrud<T, ID> {

	protected abstract JpaRepository<T, ID> getRepository();

	public List<T> findAll() {
		return getRepository().findAll();
	}

	public T findById(ID id) {
		return getRepository().findById(id).orElse(null);
	}

	public Boolean deleteById(ID id) {
		if (id == null || !getRepository().existsById(id)) {
			return false;
		}
		getRepository().deleteById(id);
		return true;
	}

	public T save(T entity) {
		return getRepository().save(entity);
	}

	public T update(T entity) {
		return getRepository().save(entity);
	}
}
