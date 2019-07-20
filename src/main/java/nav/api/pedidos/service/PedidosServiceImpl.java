package nav.api.pedidos.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import nav.api.pedidos.cache.BumexMemcached;
import nav.api.pedidos.dao.PedidoDao;
import nav.api.pedidos.model.PedidoDto;

@Service
public class PedidosServiceImpl implements IPedidosService {
	
	private static final Logger logger = LoggerFactory.getLogger(PedidosServiceImpl.class);
	
	private BumexMemcached cache = BumexMemcached.getInstance();
	
	/***@param PedidoDto pedido
	 *  @return Boolean -> Nos indica si fue ok o no ***/
	@Override
	public Boolean crearModificarPedido(PedidoDto pedido)  {
		logger.info("<< crearModificarPedido >>");
		try {
			PedidoDao.insertOrUpdate(pedido);
			this.actulizarCache(pedido);
			logger.info("<< Se logro crear o modificar el pedido >>");
			return true;
		} catch (Exception e) {
			logger.error("<< No se pudo crear o modificar un pedido >>");
			logger.error(e.getMessage());
		}
		
		return false;
	}
	
	/***@param Long pedidoId
	 *  @return Boolean -> Nos indica si fue ok o no ***/
	@Override
	public Boolean eliminarPedido(Long pedidoId) {
		logger.info("<< eliminarPedido >>");
		try {
			this.cache.delete(String.valueOf(pedidoId));
			PedidoDao.deletePedido(pedidoId.intValue());
			logger.info("Se pudo eliminar el pedido");
			return true;
		} catch (Exception e) {
			logger.error("No se pudo eliminar el pedido");
			logger.error(e.getMessage());
		}
		return false;
	}
	
	/***@param Long pedidoId
	 *  @return PedidoDto pedido  ***/
	@Override
	public PedidoDto buscarPedido(Long pedidoId) {
		logger.info("<< buscarPedido >>");
		PedidoDto pedido = (PedidoDto) cache.get(String.valueOf( pedidoId));
		if(pedido == null) {
			pedido = PedidoDao.select(pedidoId.intValue());
		}
		this.actulizarCache(pedido);
		return pedido;
	}
	
	private void actulizarCache(PedidoDto pedido) {
		logger.info("<< actulizarCache >>");
		pedido.getId().ifPresent( id -> this.cache.set(String.valueOf(id), pedido));

	}
   
}
