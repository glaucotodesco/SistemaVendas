package services;

import java.util.ArrayList;
import java.util.List;

import DAO.ItemPedidoDAO;

import entity.ItemPedido;
import entity.Pedido;

public class ItemPedidoService extends Service{
	ItemPedidoDAO dao = new ItemPedidoDAO();

	public List<ItemPedido> getItensPedido() {
		List<ItemPedido> itens = dao.getAll(ItemPedido.class);
		dao.closeEntityManager();
		return itens;

	}
	
	public List<ItemPedido> getItensPedido(Pedido pedido) {
		List<ItemPedido> itens = new ArrayList<>();
		for (ItemPedido ip : dao.getAll(ItemPedido.class)){
			if (ip.getPedido().equals(pedido)){
				itens.add(ip);
			}
		}
		dao.closeEntityManager();
		return itens;

	}

	public ItemPedido salvar(ItemPedido item) {
		item = dao.save(item);
		dao.closeEntityManager();
		return item;
	}

	public void excluir(ItemPedido item) {
		item = dao.getById(ItemPedido.class, item.getId());
		dao.remove(item);
		dao.closeEntityManager();
	}

	public void atualizar(ItemPedido item) {
		dao.save(item);
		dao.closeEntityManager();
	}
}
