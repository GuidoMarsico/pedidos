package nav.api.pedidos.model;

import java.math.BigDecimal;
import java.util.Optional;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*** 
 * @author GuidoMars
 * 
 *  ***/
public class PedidoDto {
	
	private Optional<Long> id;

	@NotNull(message = "El campo nombre es obligatorio.")
	@Size(max = 100, message = "El campo nombre no puede superar los 100 caracteres.")
	private String nombre;

	@NotNull(message = "El campo monto es obligatorio.")
	private BigDecimal monto;
	
	private Optional<Integer> descuento;

	public PedidoDto() {
	
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Optional<Long> getId() {
		return id;
	}

	public void setId(Optional<Long> id) {
		this.id = id;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}
	
	public Optional<Integer> getDescuento() {
		return descuento;
	}

	public void setDescuento(Optional<Integer> descuento) {
		this.descuento = descuento;
	}

	@Override
	public boolean equals(Object obj) {
	    if (obj == null) return false;

	    if (!(obj instanceof PedidoDto))

	        return false;

	    if (obj == this)

	        return true;

	    return this.getId() == ((PedidoDto) obj).getId();
	}
	
	
	@Override
	public int hashCode() {
		return this.id.get().intValue();
	}
	
}
