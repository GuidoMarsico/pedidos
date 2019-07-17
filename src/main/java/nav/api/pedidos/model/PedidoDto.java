package nav.api.pedidos.model;

import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*** 
 * @author GuidoMars
 * 
 *  ***/
public class PedidoDto {
	
	private Long id;

	@NotNull(message = "El campo nombre es obligatorio.")
	@Size(max = 20, message = "El campo nombre no puede superar los 100 caracteres.")
	private String nombre;

	@NotNull(message = "El campo monto es obligatorio.")
	private BigDecimal monto;

	
	public PedidoDto() {
	
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}
	
	
}
