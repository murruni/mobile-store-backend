package net.store.model.entity;

import java.util.Objects;

public abstract class EntityBase<ID> {

	public int hashCode() {
		return Objects.hash(getId());
	}

	protected abstract ID getId();
}
