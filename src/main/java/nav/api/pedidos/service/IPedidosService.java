package nav.api.pedidos.service;

import nav.api.pedidos.model.PedidoDto;

public interface IPedidosService {

    void crearPedido(PedidoDto pedido);
    void modificarPedido(PedidoDto pedido);
    Boolean eliminarPedido(Long pedidoId);
    PedidoDto buscarPedido(Long pedidoId);


}
