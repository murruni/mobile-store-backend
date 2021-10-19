package net.store.model.entity.cliente;

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
import net.store.model.entity.ordenCompra.OrdenCompra;

@Entity
@Table(name = "CLIENTE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente extends EntityBase<Long>{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(nullable = false)
	private String nombres;

	@Column(nullable = false)
	private String apellido;

	@Column(nullable = false)
	private String dni;
	
	@Column
	private String direccion;

	@Column
	private String telefono;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cliente")
	private Set<OrdenCompra> ordenesCompra;
}
