package net.store.model.entity.ordenCompra;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.store.model.entity.EntityBase;
import net.store.model.entity.cliente.Cliente;
import net.store.model.entity.ordenCompraItem.OrdenCompraItem;

@Entity
@Table(name = "ORDEN_COMPRA")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrdenCompra extends EntityBase<Long>{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column
	private Integer nurmeoCompra;
	
	@Column
	private Date fechaCompra;
	
	@Column
	private BigDecimal importeTotal;
	
	@ManyToOne
	private Cliente cliente;
	
	@OneToMany(mappedBy = "ordenCompra")
	private Set<OrdenCompraItem> items;
	
}
