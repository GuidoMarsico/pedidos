package nav.api.pedidos.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import nav.api.pedidos.model.PedidoDto;
import nav.api.pedidos.service.IPedidosService;

/**
 * Controller Api Pedidos
 * ***/
@RestController
@RequestMapping("/pedidos")
public class PedidosController {
	  
	  private static final Logger logger = LoggerFactory.getLogger(PedidosController.class);
	  
	  @Autowired
	  private IPedidosService service;
	
	   @PostMapping("/guardar")
       public  @ResponseBody ResponseEntity<PedidoDto> crearModificarPedido(@Valid @RequestBody PedidoDto pedido)   {
		   logger.info("Se recibio una peticion de un nuevo pedido ");
		   service.crearModificarPedido(pedido);
    	   return ResponseEntity.ok(pedido);
       }
       
	   @GetMapping("/{pedidoId}")
	   public ResponseEntity<PedidoDto> get(@PathVariable Long pedidoId){
		   logger.info("Se recibio una peticion para obtener un pedido ");
		   PedidoDto pedido = service.buscarPedido(pedidoId);
		   return ResponseEntity.ok(pedido);
	   }
	   
	   @DeleteMapping("/{pedidoId}")
	   public ResponseEntity<Boolean> delete(@PathVariable Long pedidoId){
		    logger.info("Se recibio una peticion para elimiar un pedido ");
		   	service.eliminarPedido(pedidoId);
		   	return ResponseEntity.ok(true);
	   }
}
