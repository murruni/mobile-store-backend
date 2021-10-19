package net.store.model.entity.telefono;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import net.store.model.entity.marca.Marca;

@Entity
@Table(name = "TELEFONO")
@Data
public class Telefono {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(nullable = false)
	private String descripcion;

	@Column(nullable = false)
	private BigDecimal precio;

	@Column(nullable = false, unique = true)
	private String codigo;

	@ManyToOne
	private Marca marca;
}
