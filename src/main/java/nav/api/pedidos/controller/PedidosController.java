package nav.api.pedidos.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nav.api.pedidos.model.PedidoDto;
import nav.api.pedidos.service.IPedidosService;

/**
 * Controller Api Pedidos
 * ***/
@RestController
@RequestMapping("/Pedidos")
public class PedidosController {
	  
	private static final Logger logger = LoggerFactory.getLogger(PedidosController.class);
	  
	  @Autowired
	  private IPedidosService service;
	
	   
	   @PostMapping("/guardar")
       public ResponseEntity<PedidoDto> crearPedido(@Valid @RequestBody PedidoDto pedido) {
		   logger.info("Se recibio peticion ");
		   
		   service.crearPedido(pedido);
		   
    	   return new ResponseEntity<PedidoDto>(pedido, HttpStatus.CREATED);
       }
       
}
