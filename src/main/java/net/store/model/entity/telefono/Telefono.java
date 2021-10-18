package net.store.model.entity.telefono;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import net.store.model.entity.modelo.Modelo;

@Entity
@Table(name = "TELEFONO")
@Data
public class Telefono {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(nullable = false)
	private BigDecimal precio;
	
	@Column(nullable = false)
	private String codigo;
	
	@ManyToOne
	@JoinColumn(name = "modelo_id", insertable = false, updatable = false)
	private Modelo modelo;
}
