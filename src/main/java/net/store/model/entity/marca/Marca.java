package net.store.model.entity.marca;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import net.store.model.entity.modelo.Modelo;

@Entity
@Table(name = "MARCA")
@Data
public class Marca {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(nullable = false)
	private String descripcion;

	@OneToMany
	@JoinColumn(name = "marca_id")
	private Set<Modelo> modelos;
}
