package net.store.model.entity.cliente;

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
import net.store.model.entity.ordenCompra.OrdenCompra;

@Entity
@Table(name = "CLIENTE")
@Data
public class Cliente {
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
	
	@OneToMany
	@JoinColumn(name = "cliente_id")
	private Set<OrdenCompra> ordenesCompra;
}
