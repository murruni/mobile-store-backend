package net.store.model.entity.telefono;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.store.model.entity.EntityBase;
import net.store.model.entity.marca.Marca;

@Entity
@Table(name = "TELEFONO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Telefono extends EntityBase<Long>{
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

	@JsonIgnore
	@ManyToOne
	private Marca marca;
}
