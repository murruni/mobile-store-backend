package net.store.model.entity.marca;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.store.model.entity.EntityBase;
import net.store.model.entity.telefono.Telefono;

@Entity
@Table(name = "MARCA")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Marca extends EntityBase<Long>{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(nullable = false)
	private String descripcion;

	@JsonIgnore	
	@OneToMany(mappedBy = "marca")
	private Set<Telefono> telefonos;
}
