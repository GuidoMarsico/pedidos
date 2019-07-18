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
	
	@Override
	public void crearModificarPedido(PedidoDto pedido)  {
		logger.info("<< crearModificarPedido >>");
		PedidoDao.insertOrUpdate(pedido);
		this.actulizarCache(pedido);
	}

	@Override
	public Boolean eliminarPedido(Long pedidoId) {
		logger.info("<< eliminarPedido >>");
		this.cache.delete(String.valueOf(pedidoId));
		PedidoDao.deletePedido(pedidoId.intValue());
		return true;
	}

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
		if(pedido != null) {
			this.cache.set(String.valueOf(pedido.getId()), pedido);
		}
	}
   
}
