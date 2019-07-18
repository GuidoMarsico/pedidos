package nav.api.pedidos.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


	
/*** Clase que tendra el mapeo contra la db
 *   Deberia ser usada por el PedidosDao
 *  ***/
@Entity
@Table(name="pedido")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="costo")
	private BigDecimal costo;
	
	@Column(name="descuento")
	private Integer descuento;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getCosto() {
		return costo;
	}

	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}

	public Integer getDescuento() {
		return descuento;
	}

	public void setDescuento(Integer descuento) {
		this.descuento = descuento;
	}
	
}
