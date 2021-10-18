package net.store.model.entity.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import net.store.model.entity.marca.Marca;

@Entity
@Table(name = "MODELO")
@Data
public class Modelo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(nullable = false)
	private String descripcion;

	@ManyToOne
	@JoinColumn(name = "marca_id", insertable = false, updatable = false)
	private Marca marca;
}
