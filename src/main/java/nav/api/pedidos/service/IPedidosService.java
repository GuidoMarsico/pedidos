package nav.api.pedidos.service;

import nav.api.pedidos.model.PedidoDto;

public interface IPedidosService {

	Boolean crearModificarPedido(PedidoDto pedido);
    Boolean eliminarPedido(Long pedidoId);
    PedidoDto buscarPedido(Long pedidoId);


}
