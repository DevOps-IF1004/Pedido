package br.com.fish.devops.rest.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.fish.devops.domain.pedido.ItemPedido;
import br.com.fish.devops.domain.pedido.Pedido;
import br.com.fish.devops.dto.pedido.ItemPedidoDTO;
import br.com.fish.devops.rest.PedidoRestService;

public class PedidoTest {
	
	Pedido pedidoTest1;
	Pedido pedidoTest2;
	
	ItemPedido itemTest1;
	ItemPedido itemTest2;
	ItemPedido itemTest3;

	PedidoRestService pedidoRest;

	// Carregando os objetos basicos
	@Before
	public void loadPedidoTest(){
		// Criando Itens
		itemTest1 = new ItemPedido();
		itemTest1.setIdProduto(1);
		itemTest1.setQuantidade(2);

		itemTest2 = new ItemPedido();
		itemTest2.setIdProduto(2);
		itemTest2.setQuantidade(3);

		itemTest3 = new ItemPedido();
		itemTest3.setIdProduto(3);
		itemTest3.setQuantidade(4);
		
		// criando lista de item 
		List<ItemPedido> itens1 = new ArrayList<ItemPedido>();
		itens1.add(itemTest1);
		
		List<ItemPedido> itens2 = new ArrayList<ItemPedido>();
		itens2.add(itemTest3);
		
		// criando Pedido para teste
		pedidoTest1 = new Pedido();
		pedidoTest1.setId(1);
		pedidoTest1.setDataPedido(new Date());
		pedidoTest1.setIdCliente(1);
		pedidoTest1.setItems(itens1);
		
		pedidoTest2 = new Pedido();
		pedidoTest2.setId(3);
		pedidoTest2.setDataPedido(new Date());
		pedidoTest2.setIdCliente(1);
		pedidoTest2.setItems(itens2);
		
		pedidoRest = new PedidoRestService();
	}

	@Test
	public void buscarPedidosTest(){
		try {
			pedidoRest.buscarPedidos();
			Assert.assertTrue(true);
		} catch (Exception e) {
			Assert.fail();
		} 
	}

	@Test
	public void adicionaItemPedidoTest(){
		try {
			addPedido(1, 1, itemTest1);			
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void adicionaItemPedidoInexistenteTest(){
		try {
			addPedido(2, 2, itemTest2);		
		} catch (Exception e) {
			Assert.assertEquals("Cliente Não Existe!", e.getMessage());;
		}
	}
	
	@Test
	public void buscaPedidosPorClienteTest(){
		
		try {
			addPedido(1, 3, itemTest3);
		} catch (Exception e) {
			Assert.fail();
		}
		
		List<Pedido> pedidos = pedidoRest.buscarPedidosPorCliente(1);
		
		ArrayList<Pedido> itens = new ArrayList<Pedido>();
		itens.add(pedidoTest1);
		itens.add(pedidoTest2);
		
		Assert.assertEquals(itens, pedidos);
		
	}
	
	public void addPedido(long idCliente, long idPedido, ItemPedido itemPedido){
		ItemPedidoDTO dto = new ItemPedidoDTO();
		dto.setIdCliente(idCliente);
		dto.setIdPedido(idPedido);
		dto.setItem(itemPedido);
		pedidoRest.adicionaItemPedido(dto);	
	}
}
